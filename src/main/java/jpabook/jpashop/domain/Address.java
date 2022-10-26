package jpabook.jpashop.domain;

import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
public class Address {

    private String city;
    private String street;
    private String zipcode;

    protected Address() { // 값 타입을 변경할 수 없게 설계된 클래스로 @Setter를 제거하고 생성자로 값을 초기화한다.
                          // 임베디드 타입은 자바 생성자를 public/protected 로 가능한데 protected로 설정하는게 안전하다.
    }

    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
}
