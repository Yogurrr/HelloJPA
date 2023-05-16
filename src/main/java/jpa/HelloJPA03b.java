package jpa;

import model.Zipcode;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class HelloJPA03b {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();

        try {
            // 전체 조회
            String jpql = "select z from Zipcode as z";
//            List<Zipcode> zips = em.createQuery(jpql, Zipcode.class).getResultList();
//            for (Zipcode zip : zips) System.out.println(zip);


            // 일부 조회
            jpql = "select zipcode, bunji, seq from Zipcode z";
//            List<Object[]> items = em.createQuery(jpql).getResultList();
//            for (Object[] item : items) System.out.println(item[0] + "/" + item[1] + "/" + item[2]);


            // 조건 조회
            jpql = "select z from Zipcode z where gugun = :gugun";
            TypedQuery<Zipcode> query = em.createQuery(jpql, Zipcode.class);
//            query.setParameter("gugun", "당진시");
//            zips = query.getResultList();

//            for(Zipcode zip : zips) System.out.println(zip);


            // 갯수 조회
            jpql = "select count(distinct gugun) from Zipcode z";
//            Long cntjob = em.createQuery(jpql, Long.class).getSingleResult();
//            System.out.println(cntjob);


            // 페이징
            jpql = "select z from Zipcode z order by seq";
//            List<Zipcode> zips = em.createQuery(jpql, Zipcode.class).setFirstResult(30).setMaxResults(15).getResultList();
//            for(Zipcode zip : zips) System.out.println(zip);


            // group by
            jpql = "select dong, count(seq) from Zipcode z group by dong";
            List<Object[]> items = em.createQuery(jpql).getResultList();

            for(Object[] item : items) System.out.println(item[0] + "/" + item[1]);


        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}
