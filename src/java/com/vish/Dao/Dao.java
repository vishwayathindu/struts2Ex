/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vish.Dao;

import com.vish.entity.Student;
import java.util.List;
import com.vish.model.User;
import com.vish.userBean.userDataBean;
import com.vish.userBean.userInputBean;
import java.util.ArrayList;
import java.util.Iterator;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author vishwa_p
 */
public class Dao {

    public static String loginCheck(User user) {

        System.out.println("----------------------------------------------check---------------------------");

        List<User> userroleList = new ArrayList<>();

        SessionFactory se = new Configuration().configure().buildSessionFactory();
        Session s = se.openSession();

        String sql = "from Student as s where s.studentName=:user_name and s.password=:password";
        Query query = s.createQuery(sql).setString("user_name", user.getUserName()).setString("password", user.getPassword());

        java.util.List list = query.list();

        s.close();
        se.close();
        System.out.println("List size : " + list.size());
        if (list.size() > 0) {
            return "success";
        } else {
            return "fail";
        }
    }

    public static List<userDataBean> selectAll() {

        System.out.println("----------------------------------------------selecting---------------------------");

        SessionFactory se = new Configuration().configure().buildSessionFactory();
        String hql = "from Student";
        Session session = se.openSession();
        Query query = session.createQuery(hql);
        List<userDataBean> userData = new ArrayList();

        Iterator itRe = query.iterate();
        while (itRe.hasNext()) {
            userDataBean dataBean = new userDataBean();
            Student agenttmp = (Student) itRe.next();

            dataBean.setUserName(agenttmp.getStudentName());
            dataBean.setUserId(agenttmp.getStudentId());
            dataBean.setNic(agenttmp.getNic());
            dataBean.setGender(agenttmp.getGender());
            userData.add(dataBean);
        }
        session.close();
        se.close();

        return userData;
    }

    public static List<userDataBean> selectUser(int id) {

        System.out.println("----------------------------------------------selecting Recoards---------------------------");

        SessionFactory se = new Configuration().configure().buildSessionFactory();
        List<userDataBean> userData = new ArrayList();

        Session session = se.openSession();
        Student agenttmp = (Student) session.get(Student.class, id);
        userDataBean dataBean = new userDataBean();
        dataBean.setUserName(agenttmp.getStudentName());
        dataBean.setUserId(agenttmp.getStudentId());
        dataBean.setNic(agenttmp.getNic());
        dataBean.setGender(agenttmp.getGender());
        session.close();
        se.close();
        userData.add(dataBean);

        return userData;
    }
    public static Student selectUserj(int id) {

        System.out.println("----------------------------------------------selecting Recoards---------------------------");

        SessionFactory se = new Configuration().configure().buildSessionFactory();
//        List<userDataBean> userData = new ArrayList();

        Session session = se.openSession();
        Student agenttmp = (Student) session.get(Student.class, id);
//        System.out.println("--------- object-------------" + agenttmp);
//        userDataBean dataBean = new userDataBean();
//        dataBean.setUserName(agenttmp.getStudentName());
//        dataBean.setUserId(agenttmp.getStudentId());
//        dataBean.setNic(agenttmp.getNic());
//        dataBean.setGender(agenttmp.getGender());
//        session.close();
//        se.close();
//        userData.add(dataBean);

        return agenttmp;
    }

    public static String editUser(userInputBean inputBean) {

        SessionFactory next = new Configuration().configure().buildSessionFactory();
        Session session = next.openSession();
        session.beginTransaction();
        Student s = (Student) session.get(Student.class, inputBean.getUserId());
        s.setStudentName(inputBean.getUserName());
        s.setGender(inputBean.getGender());
        s.setNic(inputBean.getNic());
        session.getTransaction().commit();
        session.close();
        next.close();
        System.out.println("success update");
        return "success";

    }

    public static String deleteUser(int id) {

        SessionFactory se = new Configuration().configure().buildSessionFactory();
        Session session = se.openSession();
        Query query = session.createQuery("delete Student where studentId = :userId");
        query.setParameter("userId", id);
        int result = query.executeUpdate();
        session.close();
        se.close();

        if (result > 0) {
            System.out.println("Expensive products was removed");
        }

        return "Deleted";

    }

    public static String registerUser(Student s) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        //getting session object from session factory
        Session session = sessionFactory.openSession();
        //getting transaction object from session object
        session.beginTransaction();

        session.save(s);
        System.out.println("Inserted Successfully");
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();

        return "Registerd";

    }

}
