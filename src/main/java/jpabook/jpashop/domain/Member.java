package jpabook.jpashop.domain;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id") // id로 사용할 수 있지만 관례상 구분하기 편하게 하기 위해 컬럼명을 이렇게 정의했다, 관례상 테이블명 + id 를 사용한다.
    private Long id;

    private String name;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "member") // 일대다 구조 정의
    private List<Order> orders = new ArrayList<>();
}
