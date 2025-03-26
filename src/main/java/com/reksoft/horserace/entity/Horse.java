package com.reksoft.horserace.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

@Getter
@Setter
@RequiredArgsConstructor
@Validated
public class Horse {

  private final String name;
  private final Rider rider;
  private final Breed breed;
  private final int age;
}
