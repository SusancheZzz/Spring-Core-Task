package com.reksoft.horserace.entity;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.text.DecimalFormat;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Horse {

  @NotEmpty
  private final String name;
  @NotNull
  private final Rider rider;
  @NotNull
  private final Breed breed;
  @Min(2)
  @Max(10)
  private final int age;

  @Override
  public String toString() {
    return
      "Horse name = '"
        + name
        + "' (rider = "
        + rider.getName()
        + ", age = "
        + rider.getAge()
        + "), breed = "
        + breed.getName()
        + ", speed = "
        + new DecimalFormat("#.##").format(breed.getSpeed())
        + ", age = "
        + age;
  }
}
