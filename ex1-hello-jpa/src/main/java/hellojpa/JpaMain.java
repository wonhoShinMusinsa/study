package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

    public static void main(String[] args) {
        // 어플리케이션 로딩 시점에 하나만 있어야 한다.
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        // 트랜잭션 단위 별로 하나씩 있어야 한다.
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Member member = new Member();
        
        member.setId(2L);
        member.setName("원호");

        em.persist(member);

        Member member1 = em.find(Member.class, 1L);

        member1.setName("바뀐이름");

        tx.commit();

        em.close();
        emf.close();
    }
}
