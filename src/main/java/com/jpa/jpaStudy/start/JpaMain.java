package com.jpa.jpaStudy.start;

import javax.persistence.*;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        System.out.println("STARTTTTT");
        // [엔티티 매니저 팩토리] - 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaStudy");
        // [엔티티 매니저] - 생성
        // JPA 의 기능 대부분을 제공, CRUD
        // 내부에 데이터 베이스를 유지하면서 데이터베이스와 통신
        EntityManager em = emf.createEntityManager();
        // [트랜잭션] - 획득
        // JPA 를 사용하면 항상 트랜잭션 안에서 데이터를 변경해야 함
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();     // [트랜잭션] - 시작
            logic(em);      // 비즈니스 로직 실행
            tx.commit();    // [트랜잭션] - 커밋
        } catch (Exception e) {
            tx.rollback();  // [트랜잭션] - 롤백
        } finally {
            em.close();     // [엔티티 매니저] - 종료
        }
        emf.close();        // [엔티티 매니저 팩토리] - 종료
    }

    public static void logic(EntityManager em) {
        String id = "inteca";
        Member member = new Member();
        member.setId(id);
        member.setUsername("승석");
        member.setAge(28);

        // 등록
        em.persist(member);

        // 수정
        member.setAge(18);

        // 1건 조회
        Member findMember = em.find(Member.class, id);
        System.out.println("findMember = " + findMember.getUsername() + ", age = " + findMember.getAge());

        // 목록 조회
        List<Member> members = em.createQuery("select m from Member m", Member.class)
                .getResultList();
        System.out.println("member size = " + members.size());

        // 삭제
        em.remove(member);
    }

}
