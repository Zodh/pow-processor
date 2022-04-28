package io.github.zodh.view;

import io.github.zodh.model.vo.BasePowValue;
import io.github.zodh.model.vo.FirstPow;
import io.github.zodh.model.vo.SecondPow;
import io.github.zodh.model.vo.ThirdPow;
import io.github.zodh.threads.PowProcessor;
import io.github.zodh.threads.TimeGather;
import java.util.ArrayList;

public class Application {

  public static void main(String[] args) {
    var timeGatherForFirstPow = new TimeGather("P1");
    var timeGatherForSecondPow = new TimeGather("P2");
    var timeGatherForThirdPow = new TimeGather("P3");

    var quantum = 1;

    var powValues = new ArrayList<BasePowValue>();
    powValues.add(new FirstPow(timeGatherForFirstPow));
    powValues.add(new SecondPow(timeGatherForSecondPow));
    powValues.add(new ThirdPow(timeGatherForThirdPow));

    new PowProcessor(powValues, quantum);
  }

}
