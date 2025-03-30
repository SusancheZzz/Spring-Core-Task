package com.reksoft.beaninject.beans;

public class BeanB { // DI constructor
  private final BeanA beanA;

  public BeanB(BeanA beanA) {
    this.beanA = beanA;
  }

  public void display() {
    System.out.println("BeanB содержит BeanA: " + beanA);
  }
}
