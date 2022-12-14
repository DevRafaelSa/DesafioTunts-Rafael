package br.com.rafael.desafiotunts.service;

import br.com.rafael.desafiotunts.entity.Student;
import br.com.rafael.desafiotunts.entity.enums.SituationEnum;
import br.com.rafael.desafiotunts.google.SpreadsheetManipulatorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.GeneralSecurityException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class AttendanceAnalyzerService {

    private final SpreadsheetManipulatorService sheetsReader;

    /**
     * Verifies the student's absences and if over the threshold then fail them based on that.
     * @param students
     * @return
     * @throws IOException
     * @throws GeneralSecurityException
     */
    public List<Student> analyzeAttendances(List<Student> students) throws IOException, GeneralSecurityException {

        Long numOfClasses = this.sheetsReader.readNumberOfClasses();

        Long maxAbsences = new BigDecimal(numOfClasses).multiply(new BigDecimal(0.25)).setScale(0, RoundingMode.CEILING).longValue();

        log.info("The maximum number of absences allowed is :: {}", maxAbsences);

        return students.stream().map(student -> this.analyzeAttendance(student,maxAbsences)).collect(Collectors.toList());

    }

    private Student analyzeAttendance(Student student, Long maxAbsences) {

        if (student.getAbsences() > maxAbsences) {
            log.info("Student {} - Enrollment {} - has flunked due to absences", student.getName(), student.getEnrollmentId());
            student.setSituation(SituationEnum.REPROVADO_POR_FALTA);
        }

        return student;

    }
}
