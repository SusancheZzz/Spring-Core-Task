package com.reksoft.horserace.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Breed {

  @NotBlank
  private final String name;

  @Positive
  private final double speed;
}
