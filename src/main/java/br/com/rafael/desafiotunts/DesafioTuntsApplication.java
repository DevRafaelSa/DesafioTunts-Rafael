package br.com.rafael.desafiotunts;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Slf4j
@SpringBootApplication
public class DesafioTuntsApplication {

    @PostConstruct
    public void onCreate() {
        log.info("### DesafioTuntsApplication started ###");
    }

    @PreDestroy
    public void onDestroy() {
        log.info("### DesafioTuntsApplication ended ###");
    }

    public static void main(String[] args) {
        SpringApplication.run(DesafioTuntsApplication.class, args);
    }

}
