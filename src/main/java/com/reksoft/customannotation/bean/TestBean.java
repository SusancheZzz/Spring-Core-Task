package com.reksoft.customannotation.bean;

import com.reksoft.customannotation.annotation.InjectRandomStringFromPredefinedList;
import org.springframework.stereotype.Component;

@Component
public class TestBean {

  @InjectRandomStringFromPredefinedList({"Hello", "World", "I", "Am", "Intern"})
  String randomValue;

  public void printRandomValue() {
    System.out.println(randomValue);
  }
}
