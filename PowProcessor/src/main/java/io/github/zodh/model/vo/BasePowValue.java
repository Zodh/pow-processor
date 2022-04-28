package io.github.zodh.model.vo;

import io.github.zodh.threads.TimeGather;
import lombok.Getter;
import lombok.Setter;

public abstract class BasePowValue {

  @Setter
  @Getter
  protected Integer powTimes = 100_000;

  @Setter
  protected Double actualValue = 0.0;

  @Getter
  protected TimeGather timeGather;

  protected BasePowValue (TimeGather timeGather){
    this.timeGather = timeGather;
  }

  public abstract Double getActualValue();

}
