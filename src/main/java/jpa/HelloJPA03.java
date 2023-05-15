package jpa;

import model.Employees;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class HelloJPA03 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();

        try {
            // 사원 데이터 조회 - TypedQuery
            // createQuery(질의문, 리턴될객체종류)
            String jpql = "select e from Employees as e";
//            List<Employees> emps = em.createQuery(jpql, Employees.class).getResultList();
//            for (Employees emp : emps) System.out.println(emp);

            // 사원 데이터 조회 - Query : 이름, 부서번호, 입사일
            // createQuery(질의문)
            jpql = "select fname, deptid, hdate from Employees e";
//            List<Object[]> items = em.createQuery(jpql).getResultList();
//            for (Object[] item : items) System.out.println(item[0] + "/" + item[1] + "/" + item[2]);

            // 사원 직책 조회 - jobid가 IT_PROG인 사원
            // 파라메터 바인딩 - :파라메터명, ?순번
            jpql = "select e from Employees e where jobid = :jobid";   // 이름 기반
            // jpql = "select e from Employees e where jobid = ?1";   // 위치 기반
            TypedQuery<Employees> query = em.createQuery(jpql, Employees.class);
            query.setParameter("jobid", "IT_PROG");
            // query.setParameter(1, "IT_PROG");
//            emps = query.getResultList();

//            for(Employees emp : emps) System.out.println(emp);

            // 사원 평균 연봉 조회 - TypedQuery
            jpql = "select avg(sal) from Employees e";
//            Double avgsal = em.createQuery(jpql, Double.class).getSingleResult();

//            System.out.println(avgsal);

            // 사원 직책 수 조회
            // jpql = "select distinct count(jobid) from Employees e";
            jpql = "select distinct count(distinct jobid) from Employees e";
//            Long cntjob = em.createQuery(jpql, Long.class).getSingleResult();

//            System.out.println(cntjob);

            // jobid로 정렬 후 3페이지 조회 : 페이징 (페이지당 출력건수 : 15)
            // setFirstResult(startpos) : 페이징 시작 위치
            // setMaxResult(getdatacnt) : 조회할 데이터 수
            jpql = "select e from Employees e order by jobid";
//            List<Employees> pemps = em.createQuery(jpql, Employees.class).setFirstResult(30).setMaxResults(15).getResultList();

//            for(Employees pemp : pemps) System.out.println(pemp);

            // 직책별 평균 연봉 조회
            jpql = "select jobid, avg(sal), count(jobid) from Employees e group by jobid";
//            List<Object[]> items = em.createQuery(jpql).getResultList();

//            for(Object[] item : items) System.out.println(item[0] + "/" + item[1] + "/" + item[2]);

            // 사원이름, 직책, 부서명 조회 : join
//            jpql = "select e.fname, e.jobid, d.dname from Employees e inner join e.deptid d";
//            List<Object[]> items = em.createQuery(jpql).getResultList();
//
//            for(Object[] item : items) System.out.println(item[0] + "/" + item[1] + "/" + item[2]);

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}