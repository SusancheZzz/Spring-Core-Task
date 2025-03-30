package com.reksoft.beaninject.beans;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class BeanF { //lifecycle-bean
  @PostConstruct
  public void init() {
    System.out.println("BeanF: init() выполнен");
  }

  public void work() {
    System.out.println("BeanF работает");
  }

  @PreDestroy
  public void destroy() {
    System.out.println("BeanF: destroy() выполнен");
  }
}
