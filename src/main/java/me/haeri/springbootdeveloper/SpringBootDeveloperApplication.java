package me.haeri.springbootdeveloper;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing // 생성시간, 수정시간 자동 업데이트
@SpringBootApplication
public class SpringBootDeveloperApplication {
  public static void main(String[] args) {
    SpringApplication.run(SpringBootDeveloperApplication.class, args);
  }
}
