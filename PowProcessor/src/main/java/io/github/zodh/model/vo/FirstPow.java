package io.github.zodh.model.vo;

import io.github.zodh.threads.TimeGather;

public class FirstPow extends BasePowValue {

  public FirstPow(TimeGather timeGather){
    super(timeGather);
  }

  @Override
  public Double getActualValue() {
    if (this.actualValue == 0.0){
      return 2.0;
    }
    return this.actualValue;
  }
}
