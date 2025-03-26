package com.reksoft.horserace;

import com.reksoft.horserace.entity.Horse;
import com.reksoft.horserace.entity.Race;
import com.reksoft.horserace.entity.Rider;
import com.reksoft.horserace.service.EmulationService;
import com.reksoft.horserace.service.RaceService;
import java.util.Optional;
import java.util.Scanner;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class HorseRaceConsoleApplication implements CommandLineRunner {

  private final RaceService raceService;
  private final EmulationService emulationService;

  public static void main(String[] args) {
    SpringApplication.run(HorseRaceConsoleApplication.class, args);
  }

  @Override
  public void run(String... args) {
    Race race = raceService.getRace();

    System.out.println("Участники гонки:");
    race.getHorses().forEach(horse -> {
      String riderName = Optional.ofNullable(horse.getRider())
        .map(Rider::getName)
        .orElse("Без наездника");
      System.out.println(horse.getName() + " (Наездник: " + riderName + ")");
    });

    try (Scanner scanner = new Scanner(System.in)) {
      String bet;
      do {
        System.out.print("\nСделайте ставку (введите имя лошади): \n->");
        bet = scanner.nextLine().trim();
      } while (bet.isEmpty());

      Horse winner = emulationService.startRace(race);
      System.out.println("\nПобедитель гонки: " + winner.getName());

      if (winner.getName().equalsIgnoreCase(bet)) {
        System.out.println("Поздравляем! Вы угадали!");
      } else {
        System.out.println("Вы проиграли! Удачи в следующий раз!");
      }
    }
  }
}
