package com.ctseducare.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import com.ctseducare.jpa.JPAUtils;

public abstract class DAO<T> {

  private Class<T> persistedClass;

  public DAO(Class<T> persistedClass) {
    this.persistedClass = persistedClass;
  }

  public T insert(T entity) throws Exception {
    EntityManager entityManager = JPAUtils.getEntityManagerFactory().createEntityManager();
    EntityTransaction transaction = null;
    try {
      transaction = entityManager.getTransaction();
      transaction.begin();
      
      entityManager.persist(entity);
      entityManager.flush();

      transaction.commit();

      return entity;
    } catch (Exception e) {
      if (transaction != null) {
        transaction.rollback();
      }
      throw new Exception(e);
    } finally {
      entityManager.close();
    }
  }
  
  public List<T> findAll() throws Exception {
    EntityManager entityManager = JPAUtils.getEntityManagerFactory().createEntityManager();
    List<T> entities = null;
    try {
      CriteriaBuilder cb = entityManager.getCriteriaBuilder();
      CriteriaQuery<T> query = cb.createQuery(persistedClass);
      query.from(persistedClass);
      entities = entityManager.createQuery(query).getResultList();
      return entities;
    } catch (Exception e) {
      throw new Exception(e);
    } finally {
      entityManager.close();
    }
  }

  public T findById(int id) throws Exception {
    EntityManager entityManager = JPAUtils.getEntityManagerFactory().createEntityManager();
    T entity = null;
    try {
      entity = entityManager.find(persistedClass, id);
      return entity;
    } catch (Exception e) {
      throw new Exception(e);
    } finally {
      entityManager.close();
    }
  }

  public T update(T entity) throws Exception {
    EntityManager entityManager = JPAUtils.getEntityManagerFactory().createEntityManager();
    EntityTransaction transaction = null;
    try {
      transaction = entityManager.getTransaction();
      transaction.begin();

      entityManager.merge(entity);
      entityManager.flush();

      transaction.commit();

      return entity;
    } catch (Exception e) {
      if (transaction != null) {
        transaction.rollback();
      }
      throw new Exception(e);
    } finally {
      entityManager.close();
    }
  }

  public void remove(int id) throws Exception {
    EntityManager entityManager = JPAUtils.getEntityManagerFactory().createEntityManager();
    EntityTransaction transaction = null;
    try {
      transaction = entityManager.getTransaction();
      transaction.begin();

      T entity = entityManager.find(persistedClass, id);

      entityManager.remove(entity);
      entityManager.flush();

      transaction.commit();
    } catch (Exception e) {
      if (transaction != null) {
        transaction.rollback();
      }
      throw new Exception(e);
    } finally {
      entityManager.close();
    }
  }

  public void remove(T entity) throws Exception {
    EntityManager entityManager = JPAUtils.getEntityManagerFactory().createEntityManager();
    EntityTransaction transaction = null;
    try {
      transaction = entityManager.getTransaction();
      transaction.begin();

      entityManager.remove(entity);
      entityManager.flush();

      transaction.commit();
    } catch (Exception e) {
      if (transaction != null) {
        transaction.rollback();
      }
      throw new Exception(e);
    } finally {
      entityManager.close();
    }
  }
  
}
