package com.ctseducare.dao;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ctseducare.hibernate.HibernateUtils;
import com.ctseducare.model.Student;

public class StudentDAO extends DAO<Student> {

  public StudentDAO() {
    super(Student.class);
  }
  
  //----------------------------------------------------------------------------------------------------
  // Find student by name
  //----------------------------------------------------------------------------------------------------
  // HQL version
  public Student findByName(String name) {
    String hql = "FROM Student WHERE name = :name";
    
    Session session = HibernateUtils.getSessionFactory().openSession();
    
    TypedQuery<Student> typedQuery = session.createQuery(hql, Student.class);
    typedQuery.setParameter("name", name);
    
    Student aluno = typedQuery.getSingleResult();
    
    session.close();
    
    return aluno;
  }
  
  // SQL version
  public Student findByNameSQLVersion(String name) {
    String sql = "SELECT * FROM students WHERE name = :name";
    
    Session session = HibernateUtils.getSessionFactory().openSession();
    
    TypedQuery<Student> typedQuery = session.createNativeQuery(sql, Student.class);
    typedQuery.setParameter("name", name);
    
    Student aluno = typedQuery.getSingleResult();
    
    session.close();
    
    return aluno;
  }

  //----------------------------------------------------------------------------------------------------
  // Remove all students
  //----------------------------------------------------------------------------------------------------
  // Criteria version
  public void removeAll() throws Exception {
    Session session = HibernateUtils.getSessionFactory().openSession();
    Transaction transaction = null;
    try {
      transaction = session.beginTransaction();

      CriteriaBuilder cb = session.getCriteriaBuilder();
      CriteriaDelete<Student> delete = cb.createCriteriaDelete(Student.class);
      delete.from(Student.class);

      Query query = session.createQuery(delete);
      query.executeUpdate();

      transaction.commit();
    } catch (Exception e) {
      if (transaction != null) {
        transaction.rollback();
      }
      throw new Exception(e);
    } finally {
      session.close();
    }
  }
  
  //----------------------------------------------------------------------------------------------------
  // Total of students
  //----------------------------------------------------------------------------------------------------
  // HQL version
  public long getTotal() {
    Session session = HibernateUtils.getSessionFactory().openSession();

    String hql = "SELECT COUNT(id) FROM Student";
    long total = (Long)session.createQuery(hql).getSingleResult();
    
    session.close();
    
    return total; 
  }
  
  // SQL version
  public long getTotalSQLVersion() {
    Session session = HibernateUtils.getSessionFactory().openSession();
    
    String sql = "SELECT COUNT(id) FROM students";
    BigInteger total = (BigInteger)session.createNativeQuery(sql).getSingleResult();

    session.close();
    
    return total.longValue();
  }
  
  // Criteria version
  public long getTotalCriteriaVersion() {
    Session session = HibernateUtils.getSessionFactory().openSession();
     
    CriteriaBuilder cb = session.getCriteriaBuilder();
    CriteriaQuery<Long> cq = cb.createQuery(Long.class);
    cq.select(cb.count(cq.from(Student.class)));
      
    Long total = session.createQuery(cq).getSingleResult();

    session.close();
    
    return total;
  }
  
  //----------------------------------------------------------------------------------------------------
  // Students with initial letter equals to 'B'
  //----------------------------------------------------------------------------------------------------
  // HQL version
  public List<Student> findByInitialLetter(String letter) {
    Session session = HibernateUtils.getSessionFactory().openSession();

    String hql = String.format("FROM Student WHERE name LIKE '%s%%'", letter);
    TypedQuery<Student> typedQuery = session.createQuery(hql, Student.class);
    List<Student> students = typedQuery.getResultList();
    
    session.close();
    
    return students;
  }

  // SQL version
  public List<Student> findByInitialLetterSQLVersion(String letter) {
    Session session = HibernateUtils.getSessionFactory().openSession();

    String sql = String.format("SELECT * FROM students WHERE name LIKE '%s%%'", letter);
    TypedQuery<Student> typedQuery = session.createNativeQuery(sql, Student.class);
    List<Student> students = typedQuery.getResultList();
    
    session.close();
    
    return students;
  }

  // Criteria version
  public List<Student> findByInitialLetterCriteriaVersion(String letter) {
    Session session = HibernateUtils.getSessionFactory().openSession();

    CriteriaBuilder cb = session.getCriteriaBuilder();
    CriteriaQuery<Student> cq = cb.createQuery(Student.class);
    Root<Student> root = cq.from(Student.class);
    cq.select(root).where(cb.like(root.get("name"), String.format("%s%%", letter)));
 
    List<Student> students = session.createQuery(cq).getResultList();
    
    session.close();
    
    return students;
  }

}