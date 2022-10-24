package br.com.rafael.desafiotunts.config;

import br.com.rafael.desafiotunts.service.GradeAnalyzerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Slf4j @RequiredArgsConstructor
@Component
public class StartupApplicationListener implements ApplicationListener<ContextRefreshedEvent> {

    private final GradeAnalyzerService gradeAnalyzerService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        log.info("Starting spreadsheet analysis...");

        gradeAnalyzerService.doAnalysis();

        log.info("Analysis completed...");


    }
}
