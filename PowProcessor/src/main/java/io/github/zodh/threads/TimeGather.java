package io.github.zodh.threads;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import lombok.Getter;
import lombok.Setter;

public class TimeGather extends Thread {

  private final String identifier;

  private final LocalDateTime initialTime;

  private LocalDateTime finalTime;

  @Setter
  @Getter
  private Boolean count = false;

  @Getter
  private Boolean shouldRun = true;

  public TimeGather(String identifier) {
    this.identifier = identifier;
    this.initialTime = LocalDateTime.now();
    start();
  }

  @Override
  public void run() {
    while (Boolean.TRUE.equals(this.shouldRun)) {
      if (Boolean.TRUE.equals(count)) {
        try {
          this.finalTime = LocalDateTime.now();
        } catch (Exception exception) {
          this.interrupt();
        }
      }
    }
  }

  public void getTimeSpentInMillis() {
    this.shouldRun = false;
    var timeSpent = ChronoUnit.MILLIS.between(this.initialTime, this.finalTime);
    System.out.println(this.identifier + " - " + timeSpent + "ms");
  }
}
