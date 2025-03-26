package com.reksoft.horserace.service;

import com.reksoft.horserace.config.RaceConfig;
import com.reksoft.horserace.entity.Breed;
import com.reksoft.horserace.entity.Horse;
import com.reksoft.horserace.entity.Rider;
import java.util.List;
import java.util.Random;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HorseService {

  private final RaceConfig config;
  private final Random random = new Random();

  public Horse createRandomHorse() {
    List<String> horseNames = config.getHorseNames();
    List<String> riderNames = config.getRiderNames();
    List<String> breedNames = config.getBreedNames();
    List<Integer> riderAges = config.getRiderAges();
    List<Integer> horceAges = config.getHorceAges();

    return new Horse(
      horseNames.get(random.nextInt(horseNames.size())),
      new Rider(
        riderNames.get(random.nextInt(riderNames.size())),
        random.nextBoolean(),
        riderAges.get(random.nextInt(riderAges.size()))),
      new Breed(
        breedNames.get(random.nextInt(breedNames.size())),
      config.getMinSpeed() + random.nextDouble(config.getMaxSpeed() - config.getMinSpeed())),
      horceAges.get(random.nextInt(horceAges.size()))
    );
  }
}
