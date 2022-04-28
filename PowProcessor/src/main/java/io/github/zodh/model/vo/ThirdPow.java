package io.github.zodh.model.vo;

import io.github.zodh.threads.TimeGather;

public class ThirdPow extends BasePowValue {

  public ThirdPow(TimeGather timeGather){
    super(timeGather);
  }

  @Override
  public Double getActualValue() {
    if (this.actualValue == 0.0){
      return 5.0;
    }
    return this.actualValue;
  }
}
