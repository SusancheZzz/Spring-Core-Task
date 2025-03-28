package com.reksoft.beaninject.beans;

import lombok.Setter;

@Setter
public class BeanA { // DI setter
  private String value;

  public void printValue() {
    System.out.println("BeanA: " + this + " / BeanA value: " + value);
  }
}
