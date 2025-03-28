package com.reksoft.horserace.config;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import java.util.List;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

@Configuration
@Getter
@Validated
public class RaceConfig {

  @Value("${race.horses.count}")
  @Positive
  private int raceHorsesCount;

  @Value("${race.track.length}")
  @Positive
  private int trackLength;

  @Value("${race.speed.min}")
  @Positive
  private double minSpeed;

  @Value("${race.speed.max}")
  @Positive
  private double maxSpeed;

  @Value("#{'${race.horse.names}'.split(',')}")
  @NotEmpty
  private List<String> horseNames;

  @Value("#{'${race.rider.names}'.split(',')}")
  @NotEmpty
  private List<String> riderNames;

  @Value("#{'${race.breed.names}'.split(',')}")
  @NotEmpty
  private List<String> breedNames;

  @Value("#{'${race.horce.age}'.split(',')}")
  @NotEmpty
  private List<Integer> horceAges;

  @Value("#{'${race.rider.age}'.split(',')}")
  @NotEmpty
  private List<Integer> riderAges;
}
