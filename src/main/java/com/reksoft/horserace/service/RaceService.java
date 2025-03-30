package com.reksoft.horserace.service;

import com.reksoft.horserace.config.RaceConfig;
import com.reksoft.horserace.entity.Race;
import java.util.stream.IntStream;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RaceService {

  private final HorseService horseService;
  private final RaceConfig config;

  public Race getRace() {
    return new Race(
      config.getTrackLength(),
      IntStream.range(0, config.getHorsesCount())
        .mapToObj(i -> horseService.createRandomHorse())
        .toList()
    );
  }
}
