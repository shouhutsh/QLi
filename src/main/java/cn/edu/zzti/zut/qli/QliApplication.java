package cn.edu.zzti.zut.qli;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class QliApplication {

    public static void main(String[] args) {
        SpringApplication.run(QliApplication.class, args);
    }
}
