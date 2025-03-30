package com.reksoft.horserace.service;

import com.reksoft.horserace.config.RaceConfig;
import com.reksoft.horserace.entity.Breed;
import com.reksoft.horserace.entity.Horse;
import com.reksoft.horserace.entity.Rider;
import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Random;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@RequiredArgsConstructor
@Validated
@DependsOn("raceConfig")
public class HorseService {

  private final RaceConfig config;
  private final Random random = new Random();
  private List<String> horseNames;
  private List<String> riderNames;
  private List<String> breedNames;
  private List<Integer> riderAges;
  private List<Integer> horseAges;

  @PostConstruct
  private void init(){
    this.horseNames = config.getHorseNames();
    this.riderNames = config.getRiderNames();
    this.breedNames = config.getBreedNames();
    this.riderAges = config.getRiderAge();
    this.horseAges = config.getHorseAge();
  }

  @Valid
  public Horse createRandomHorse() {

    return new Horse(
      horseNames.get(random.nextInt(horseNames.size())),
      new Rider(
        riderNames.get(random.nextInt(riderNames.size())),
        random.nextBoolean(),
        riderAges.get(random.nextInt(riderAges.size()))),
      new Breed(
        breedNames.get(random.nextInt(breedNames.size())),
        config.getSpeedMin() + random.nextDouble(config.getSpeedMax() - config.getSpeedMin())),
      horseAges.get(random.nextInt(horseAges.size()))
    );
  }
}
