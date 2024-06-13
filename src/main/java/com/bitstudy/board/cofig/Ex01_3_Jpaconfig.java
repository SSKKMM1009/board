package com.bitstudy.board.cofig;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

/* @Configuration 이라고 하면 JPA가 '이건 설정파일' 이라고 인식해서 Configuration Bean으로 등록함*/
@Configuration
@EnableJpaAuditing //이거 달아주면 JPA에서 auditing을 가능하게 하는 어노테이션
                   //jpa auditing : 감시 감사 즉 Spring Data Jpa에서 자동으로 값 넣어주는것
public class Ex01_3_Jpaconfig {
    @Bean
    public AuditorAware<String> auditorAware() {
        //람다식(자바스크립에서 화살표 함수 같은것)
        return ()-> Optional.of("bitstudy");
        //이렇게 하면 앞으로 JPA Auditing 할때마다 사람 이름은 bitdtudy
        //TODO : 나중에 스프링 시큐리티로 인증 기능 붙일때 수정할거임




    }
}
