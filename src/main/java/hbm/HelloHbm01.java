package hbm;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class HelloHbm01 {
    public static void main(String[] args) {
        // SessionFactory 초기화
        String fpath = "src/main/resources/mapping/sungjuk.hbm.xml";
        Configuration cfg = new Configuration().configure();
        SessionFactory sf = cfg.addFile(fpath).buildSessionFactory();
        Session sess = sf.openSession();

        try {
            // hql을 이용한 조회 1
            /*Query query = sess.createQuery("from SungJuk ");
            List sjs = query.list();

            System.out.println(sjs);*/


            // hql을 이용한 조회 2
            Query query = sess.createQuery("from SungJuk where name = ?1");
            query.setParameter(1, "홍길동");
            List sjs = query.list();

            System.out.println(sjs);

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            sess.close();
            sf.close();
        }
    }
}
