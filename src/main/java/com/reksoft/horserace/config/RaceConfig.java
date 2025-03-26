package com.reksoft.horserace.config;

import java.util.List;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "race")
@Configuration
@Getter
public class RaceConfig {

  @Value("${race.horses.count}")
  private int raceHorsesCount;

  @Value("${race.track.length}")
  private int trackLength;

  @Value("${race.speed.min}")
  private double minSpeed;

  @Value("${race.speed.max}")
  private double maxSpeed;

  @Value("#{'${race.horse.names}'.split(',')}")
  private List<String> horseNames;

  @Value("#{'${race.rider.names}'.split(',')}")
  private List<String> riderNames;

  @Value("#{'${race.breed.names}'.split(',')}")
  private List<String> breedNames;

  @Value("#{'${race.horce.age}'.split(',')}")
  private List<Integer> horceAges;

  @Value("#{'${race.rider.age}'.split(',')}")
  private List<Integer> riderAges;
}
