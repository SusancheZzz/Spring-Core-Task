package com.reksoft.horserace.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Rider {

  private final String name;
  private final boolean gender;
  private final int age;
}
