package io.github.zodh.threads;

import io.github.zodh.model.vo.BasePowValue;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class PowProcessor extends Thread {

  private final Integer quantum;

  private final List<BasePowValue> powValues;

  public PowProcessor(List<BasePowValue> powValues, Integer quantum) {
    this.powValues = powValues;
    this.quantum = quantum;
    start();
  }

  @Override
  public void run() {
    processPotencies(this.quantum);
  }

  private void processPotencies(Integer time) {
    var p1 = 0;
    var p2 = 1;
    var p3 = 2;
    while (
        powValues.get(p1).getTimeGather().getShouldRun().equals(Boolean.TRUE)
            || powValues.get(p2).getTimeGather().getShouldRun().equals(Boolean.TRUE)
            || powValues.get(p3).getTimeGather().getShouldRun().equals(Boolean.TRUE)
    ) {
      powValues.forEach(
          powValue -> {
            var finalTime = LocalDateTime.now().plus(time, ChronoUnit.MILLIS);
            var shouldRun = powValue.getTimeGather().getShouldRun();
            try {
              if (Boolean.TRUE.equals(shouldRun)) {
                powValue.getTimeGather().setCount(true);
                while (LocalDateTime.now().isBefore(finalTime)) {
                  if (powValue.getPowTimes() == 0) {
                    powValue.getTimeGather().getTimeSpentInMillis();
                    powValue.setPowTimes(powValue.getPowTimes() - 1);
                  }
                  if (powValue.getPowTimes() > 0) {
                    powValue.setActualValue(
                        Math.pow(powValue.getActualValue(), powValue.getPowTimes()));
                    powValue.setPowTimes(powValue.getPowTimes() - 1);
                  }
                }
              }
            } finally {
              if (Boolean.TRUE.equals(powValue.getTimeGather().getCount())) {
                powValue.getTimeGather().setCount(false);
              }
            }
          }
      );
    }
  }

}
