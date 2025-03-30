package com.reksoft.beaninject.methodreplacer;

import java.lang.reflect.Method;
import org.springframework.beans.factory.support.MethodReplacer;

public class CustomMethodReplacer implements MethodReplacer {

  @Override
  public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
    System.out.println(
      "Метод process() в BeanE был заменён бином c id: customMethodReplacer: " + this);
    return null;
  }
}
