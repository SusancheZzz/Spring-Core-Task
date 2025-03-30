package com.reksoft.customannotation.bpp;

import com.reksoft.customannotation.annotation.InjectRandomStringFromPredefinedList;
import java.lang.reflect.Field;
import java.util.Random;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class CustomInjectRandomStringFromPredefinedListBeanPostProcessor implements
  BeanPostProcessor {

  private final Random random = new Random();

  @Override
  public Object postProcessBeforeInitialization(Object bean, String beanName)
      throws BeansException {

    Class<?> beanClass = bean.getClass();
    for (Field field : beanClass.getDeclaredFields()) {
      if (field.isAnnotationPresent(InjectRandomStringFromPredefinedList.class)
        && field.getType().equals(String.class)) {
        InjectRandomStringFromPredefinedList annotation
          = field.getAnnotation(InjectRandomStringFromPredefinedList.class);
        String[] values = annotation.value();
        if (values.length > 0) {
          String randomString = values[random.nextInt(values.length)];
          field.setAccessible(true);
          try {
            field.set(bean, randomString);
          } catch (IllegalAccessException e) {
            throw new RuntimeException("Can't inject random string from " + field.getName(), e);
          }
        }
      }
    }

    return bean;
  }
}
