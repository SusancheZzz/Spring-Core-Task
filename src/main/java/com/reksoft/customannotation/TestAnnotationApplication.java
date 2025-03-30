package com.reksoft.customannotation;

import com.reksoft.customannotation.bean.TestBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.reksoft.customannotation")
public class TestAnnotationApplication {

  public static void main(String[] args) {

    ApplicationContext context
      = new AnnotationConfigApplicationContext(TestAnnotationApplication.class);
    TestBean testBean = context.getBean(TestBean.class);
    testBean.printRandomValue();
  }
}
