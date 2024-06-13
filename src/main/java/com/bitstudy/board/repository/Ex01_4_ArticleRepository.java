package com.bitstudy.board.repository;


import com.bitstudy.board.domain.Ex00_1_Article_엔티티로_등록;
import org.springframework.data.jpa.repository.JpaRepository;

//TDD 할떄 사용할 임시 파일임(이거 이용해서 DB 접근할거임)
public interface Ex01_4_ArticleRepository extends JpaRepository<Ex00_1_Article_엔티티로_등록, Long> {

}

//레포가 dao같은것

/* TDD 하러가기
 - ctrl shift t 해서 하기
 - Junit5 버전 확인하기
*/
