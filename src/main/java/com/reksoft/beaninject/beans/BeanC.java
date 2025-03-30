package com.reksoft.beaninject.beans;

public abstract class BeanC { // singleton
  public abstract BeanD getBeanD(); // lookup method injection

  public void useBeanD() {
    BeanD beanD = getBeanD();
    System.out.println("Используется BeanD: " + beanD);
  }
}
