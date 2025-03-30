package com.reksoft.horserace.entity;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Rider {

  @NotBlank
  private final String name;
  private final boolean isMale;
  @Min(14)
  @Max(60)
  private final int age;
}
