package com.reksoft.horserace;

import com.reksoft.horserace.entity.Horse;
import com.reksoft.horserace.entity.Race;
import com.reksoft.horserace.service.EmulationService;
import com.reksoft.horserace.service.RaceService;
import java.util.List;
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

    System.out.println("\nУчастники гонки на " + race.getTrackLength() + " метров:\n");
    race.getHorses().forEach(System.out::println);

    try (Scanner scanner = new Scanner(System.in)) {
      String bet;
      boolean isHorse;
      do {
        System.out.print("\nСделайте ставку (введите имя лошади): \n->");
        bet = scanner.nextLine().trim();

        if (bet.isEmpty()) {
          System.out.println("Имя лошади не может быть пустым. Попробуйте снова.");
        }
        isHorse = race.getHorses().stream()
          .map(Horse::getName).anyMatch(bet::equalsIgnoreCase);

        if (!isHorse) {
          System.out.println("Лошадь с таким именем не участвует в сегодняшнем забеге.");
        }

      } while (bet.isEmpty() || !isHorse);
      List<Horse> sortedHorses = emulationService.startRace(race);
      System.out.println("\nПобедитель гонки: " + sortedHorses.get(0).getName());

      if (sortedHorses.get(0).getName().equalsIgnoreCase(bet)) {
        System.out.println("Поздравляем! Вы угадали!");
      } else {
        System.out.println("Вы проиграли! Удачи в следующий раз!");
      }
    }
  }
}
