package com.reksoft.horserace.config;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

@Configuration
@Getter
@Setter
@Validated
@ConfigurationProperties(prefix = "race")
public class RaceConfig {

  @Positive
  private int horsesCount;

  @Positive
  private int trackLength;

  @Positive
  private double speedMin;

  @Positive
  private double speedMax;

  @NotEmpty
  private List<String> horseNames;

  @NotEmpty
  private List<String> riderNames;

  @NotEmpty
  private List<String> breedNames;

  @NotEmpty
  private List<Integer> horseAge;

  @NotEmpty
  private List<Integer> riderAge;
}
