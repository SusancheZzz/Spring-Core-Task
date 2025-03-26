package com.reksoft.horserace.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Breed {

  private final String name;
  private final double speed;
}
