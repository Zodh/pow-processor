package io.github.zodh.threads;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import lombok.Getter;
import lombok.Setter;

public class TimeGather extends Thread {

  private final String identifier;

  private Long timeSpent;

  private LocalDateTime lastUpdatedTime;

  @Setter
  @Getter
  private Boolean shouldRun = true;

  public TimeGather(String identifier) {
    this.identifier = identifier;
    start();
  }

  public void accumulateTime(LocalDateTime initAccumulateCount) {
    timeSpent += ChronoUnit.MILLIS.between(initAccumulateCount, LocalDateTime.now());
  }

  public void getTimeSpentInMillis() {
    this.setShouldRun(false);
    System.out.println(this.identifier + " - " + timeSpent + "ms");
  }
}
