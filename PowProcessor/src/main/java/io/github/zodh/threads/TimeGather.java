package io.github.zodh.threads;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import lombok.Getter;

public class TimeGather extends Thread {


  private final LocalDateTime startDateTime;

  private final LocalDateTime endDateTime;

  private final Process process;

  public TimeGather(Process process, Integer quantum) {
    this.process = process;
    if (process.getActualValue() == 0) {
      process.setActualValue(process.getPotentiationValue());
    }
    this.startDateTime = LocalDateTime.now();
    this.endDateTime = this.startDateTime.plus(quantum, ChronoUnit.MILLIS);
    start();
  }

  @Override
  public void run() {
    while (LocalDateTime.now().isBefore(endDateTime)) {
      if (process.getRemainingProcesses() > 0) {
        process.setIntegrity(process.getIntegrity() + 1);
        process.setActualValue(process.getActualValue() * process.getPotentiationValue());
        process.setRemainingProcesses(process.getRemainingProcesses() - 1);
      }
    }
    this.interrupt();
  }

  public Process retrieveProcess() {
    Long tempoDecorrido = ChronoUnit.MILLIS.between(startDateTime, endDateTime);
    process.setTimeInMs(process.getTimeInMs() + tempoDecorrido.intValue());
    return process;
  }
}
