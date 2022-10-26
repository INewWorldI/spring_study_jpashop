package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders") // 테이블 이름이 order가 되는데 예약어라서 바꿔준다.
@Getter @Setter // 이론적으로 Getter와 Setter는 모두 제공하는게 아닌 필요한 부분에만 제공해야 하지만 실무에서 데이터 조회의 경우가 많아서
// Getter는 열어두는게 편하다 하지만 Setter는 호출 시 데이터 변경이 되기 때문에 막 사용해서는 안된다 나중에 로직을 분석할 때 추적하기 어려워진다.
public class Order {

    @Id @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    @ManyToOne // 다대일 구조 정의
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status; // 주문상태 [ORDER, CANCEL]

}
