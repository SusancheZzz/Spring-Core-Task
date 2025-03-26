package com.reksoft.horserace.entity;

import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Race {

  private final List<Horse> horses;
}
