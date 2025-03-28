package com.reksoft.beaninject.beans;

public class BeanA { // DI setter
  private String value;

  public void setValue(String value) {
    this.value = value;
  }

  public void printValue() {
    System.out.println(" BeanA: " + this + " / BeanA value: " + value);
  }
}
