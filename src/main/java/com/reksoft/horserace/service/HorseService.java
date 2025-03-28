package com.reksoft.horserace.service;

import com.reksoft.horserace.config.RaceConfig;
import com.reksoft.horserace.entity.Breed;
import com.reksoft.horserace.entity.Horse;
import com.reksoft.horserace.entity.Rider;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Random;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@RequiredArgsConstructor
@Validated
public class HorseService {

  private final RaceConfig config;
  private final Random random = new Random();

  @Valid
  public Horse createRandomHorse() {
    List<String> horseNames = config.getHorseNames();
    List<String> riderNames = config.getRiderNames();
    List<String> breedNames = config.getBreedNames();
    List<Integer> riderAges = config.getRiderAges();
    List<Integer> horseAges = config.getHorceAges();

    return new Horse(
      horseNames.get(random.nextInt(horseNames.size())),
      new Rider(
        riderNames.get(random.nextInt(riderNames.size())),
        random.nextBoolean(),
        riderAges.get(random.nextInt(riderAges.size()))),
      new Breed(
        breedNames.get(random.nextInt(breedNames.size())),
        config.getMinSpeed() + random.nextDouble(config.getMaxSpeed() - config.getMinSpeed())),
      horseAges.get(random.nextInt(horseAges.size()))
    );
  }
}
