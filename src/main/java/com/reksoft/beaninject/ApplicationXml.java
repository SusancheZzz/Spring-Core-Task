package com.reksoft.beaninject;

import com.reksoft.beaninject.beans.BeanA;
import com.reksoft.beaninject.beans.BeanB;
import com.reksoft.beaninject.beans.BeanC;
import com.reksoft.beaninject.beans.BeanE;
import com.reksoft.beaninject.beans.BeanF;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationXml {
  public static void main(String[] args) {

    try (ClassPathXmlApplicationContext context
      = new ClassPathXmlApplicationContext("applicationContext.xml")) {

      System.out.println();

      // DI setter + property
      BeanA beanA = context.getBean("beanA", BeanA.class);
      beanA.printValue();
      System.out.println();

      // DI constructor
      BeanB beanB = context.getBean("beanB", BeanB.class);
      beanB.display();
      System.out.println();

      // singleton + prototype + lookup-method
      BeanC beanC = context.getBean("beanC", BeanC.class);
      beanC.useBeanD();
      beanC.useBeanD();
      System.out.println();

      // method replacement
      BeanE beanE = context.getBean("beanE", BeanE.class);
      beanE.process();
      System.out.println();

      // lifecycle
      BeanF beanF = context.getBean("beanF", BeanF.class);
      beanF.work();
      System.out.println();
    }
  }
}
