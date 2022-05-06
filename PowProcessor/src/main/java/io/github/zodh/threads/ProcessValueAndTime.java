package io.github.zodh.threads;

public class ProcessValueAndTime {

  private Double value;

  private Integer timeInMs;

  private Integer integrity;

  private Double finalValue;

  public ProcessValueAndTime(Double value, Integer timeInMs, Integer integrity, Double finalValue) {
    this.value = value;
    this.timeInMs = timeInMs;
    this.integrity = integrity;
    this.finalValue = finalValue;
  }

  public Double getValue() {
    return value;
  }

  public Integer getTimeInMs() {
    return timeInMs;
  }

  @Override
  public String toString() {
    return "ProcessValueAndTime - value = " + value + ", timeInMs = " + timeInMs + ", integrity ="
        + " " + (integrity) + ", finalValue = " + finalValue;
  }
}
