package com.ctseducare.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ctseducare.hibernate.HibernateUtils;

public abstract class DAO<T> {

  private Class<T> persistedClass;

  public DAO(Class<T> persistedClass) {
    this.persistedClass = persistedClass;
  }

  public T insert(T entity) throws Exception {
    Session session = HibernateUtils.getSessionFactory().openSession();
    Transaction transaction = null;
    try {
      transaction = session.beginTransaction();
      
      session.save(entity);
      
      transaction.commit();
      
      return entity;
    } catch (Exception e) {
      if (transaction != null) {
        transaction.rollback();
      }
      throw new Exception(e);
    } finally {
      session.close();
    }
  }

  public List<T> findAll() throws Exception {
    Session session = HibernateUtils.getSessionFactory().openSession();
    List<T> entities = null;
    try {
      CriteriaBuilder cb = session.getCriteriaBuilder();
      
      CriteriaQuery<T> query = cb.createQuery(persistedClass);
      query.from(persistedClass);
      
      entities = session.createQuery(query).getResultList();
      
      return entities;
    } catch (Exception e) {
      throw new Exception(e);
    } finally {
      session.close();
    }
  }

  public T findById(int id) throws Exception {
    Session session = HibernateUtils.getSessionFactory().openSession();
    T entity = null;
    try {
      entity = session.find(persistedClass, id);
      return entity;
    } catch (Exception e) {
      throw new Exception(e);
    } finally {
      session.close();
    }
  }

  public T update(T entity) throws Exception {
    Session session = HibernateUtils.getSessionFactory().openSession();
    Transaction transaction = null;
    try {
      transaction = session.beginTransaction();

      session.update(entity);

      transaction.commit();

      return entity;
    } catch (Exception e) {
      if (transaction != null) {
        transaction.rollback();
      }
      throw new Exception(e);
    } finally {
      session.close();
    }
  }

  public void remove(int id) throws Exception {
    Session session = HibernateUtils.getSessionFactory().openSession();
    Transaction transaction = null;
    try {
      transaction = session.beginTransaction();

      T entity = session.find(persistedClass, id);

      session.remove(entity);

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

  public void remove(T entity) throws Exception {
    Session session = HibernateUtils.getSessionFactory().openSession();
    Transaction transaction = null;
    try {
      transaction = session.beginTransaction();

      session.remove(entity);

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

}