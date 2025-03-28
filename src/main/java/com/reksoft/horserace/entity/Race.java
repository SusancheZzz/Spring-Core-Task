package com.reksoft.horserace.entity;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Race {

  @Positive
  private final int trackLength;
  @NotEmpty
  private final List<Horse> horses;
}
