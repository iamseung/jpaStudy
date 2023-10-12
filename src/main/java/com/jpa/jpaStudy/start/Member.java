package com.jpa.jpaStudy.start;

import javax.persistence.*;

// 엔티티 임을 의미, 테이블과 매핑한다고 JPA에게 전달
@Entity
// 매핑할 테이블 정보를 의미
@Table(name = "MEMBER")
public class Member {
    // PK 임을 의미, 식별자 필
    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "NAME")
    private String username;

    // 매핑 정보가 없는 필드
    private Integer age;

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public Integer getAge() {
        return age;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
