package io.github.zodh.model.vo;

import io.github.zodh.threads.TimeGather;

public class SecondPow extends BasePowValue {

  public SecondPow(TimeGather timeGather){
    super(timeGather);
  }

  @Override
  public Double getActualValue() {
    if (this.actualValue == 0.0){
      return 3.0;
    }
    return this.actualValue;
  }
}
