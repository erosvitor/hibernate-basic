package com.ctseducare.jpa;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtils {
  
  private static EntityManagerFactory entityManagerFactory = null;
  
  private JPAUtils() {}
  
  public static EntityManagerFactory getEntityManagerFactory() {
    if (entityManagerFactory == null) {
      entityManagerFactory = Persistence.createEntityManagerFactory("JPABasic-PU");
    }
    return entityManagerFactory;
  }
  
  public static void shutdown() {
    if (entityManagerFactory != null) {
      entityManagerFactory.close();
    }
  }
  
}
