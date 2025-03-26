package com.reksoft.horserace.service;

import com.reksoft.horserace.entity.Horse;
import com.reksoft.horserace.entity.Race;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class EmulationService {

  public Horse startRace(Race race) {
    List<Horse> horses = race.getHorses();

    System.out.println("\nНачало гонки!\n");
    for (Horse horse : horses) {
      System.out.println(
        horse.getName() + " под управлением " + horse.getRider().getName() + " готов!");
    }

    try {
      TimeUnit.SECONDS.sleep(1);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }

    return horses.stream()
      .max(Comparator.comparingDouble(horse -> horse.getBreed().getSpeed()))
      .orElseThrow();
  }
}
