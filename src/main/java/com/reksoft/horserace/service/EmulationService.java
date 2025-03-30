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

  public List<Horse> startRace(Race race) {
    List<Horse> horses = race.getHorses().stream()
      .sorted(Comparator.comparingDouble(horse -> -horse.getBreed().getSpeed()))
      .toList();

    System.out.println("\nГонка начинается!\n");
    try {

      for (Horse horse : horses) {
        System.out.println(
          horse.getName() + " под управлением " + horse.getRider().getName() + " готов!");
        TimeUnit.MILLISECONDS.sleep(500);
      }

      System.out.println("\nКакая напряжённая гонка...");
      TimeUnit.SECONDS.sleep(3);
      System.out.println("Иии... Вот они!");
      for (Horse horse : horses) {
        TimeUnit.SECONDS.sleep(1);
        System.out.println(
          horse.getName() + " под управлением " + horse.getRider().getName() + " финишируют!");
      }
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }

    return horses;
  }
}
