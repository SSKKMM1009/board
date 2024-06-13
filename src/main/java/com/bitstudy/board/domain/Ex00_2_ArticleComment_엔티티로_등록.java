package com.bitstudy.board.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Objects;


@Getter
@ToString
@Entity
@Table(indexes = {
        @Index(columnList = "content"),
        @Index( columnList = "createdAt"),
        @Index( columnList = "createdBy")
})
public class Ex00_2_ArticleComment_엔티티로_등록 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //고유번호

    @Setter
    @ManyToOne(optional = false)
    private Ex00_1_Article_엔티티로_등록 article; // 연관관계 매핑
    /*연관관계 없이 코드를 짤거라면
    * private Long FK_id 이런식으로 그냥 하면 됨
    * Article과 관계를 맺고 있는 필드 라는 걸 객체지향형적으로 표현한 것
    * 아이클컨맨드와 아티클의 관계 댓글은 여러개 게시물은 한개 우리가 지금 댓글쪽에서 작업하니까 매니투원 // 너 이건 필수야 없어서는 안돼
    * 댓글은 여러개 게시글 1개 이걸 단방향 바인딩이기 때문에 Article에서도 바인딩을 해서 양방향 바인딩으로 만들어줘야함*/

    @Setter
    @Column(nullable = false, length = 500)
    private String content; // 본문

    //메타 데이터
    @Column(nullable = false) private LocalDateTime createdAt; // 생성일시
    @Column(nullable = false, length = 100) private String createdBy; // 생성자
    @Column(nullable = false) private LocalDateTime modifiedAt; // 수정일시
    @Column(nullable = false, length = 100) private String modifiedBy; // 수정자


    protected Ex00_2_ArticleComment_엔티티로_등록() {
    }

    private Ex00_2_ArticleComment_엔티티로_등록(Ex00_1_Article_엔티티로_등록 article, String content) {
        this.article = article;
        this.content = content;
    }

    public static Ex00_2_ArticleComment_엔티티로_등록 of(Ex00_1_Article_엔티티로_등록 article, String content) {
        return new Ex00_2_ArticleComment_엔티티로_등록(article, content);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ex00_2_ArticleComment_엔티티로_등록 that = (Ex00_2_ArticleComment_엔티티로_등록) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    /*Ex01_1 Ex01_2 Ex01_3 다 하고 어플리케이션(BoardApplicaion.java) 실행해보기
    * 그냥 실행하면 Run 탭에서 동작함(원래방식)
    * 그런데 이걸 Service 탭에서 실행시킬수도 있음
    *
    * 방법:
    * 1)서비스탭 열고(alt + 8)
    * 2)좌측 상단 + 버튼 누르기
    * 3)Run configration 선택
    * 4)스크롤 맨 아래쯤 Spring boot 있음 그거 클릭
    *
    * 이거 하는 이유 : Run 탭에서 별도 작업을 하거나 테스트를 하게 되면 실행 로그랑 서브시 로그를 분리해서 볼수있음*/
}
