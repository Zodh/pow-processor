package io.github.zodh.robin.round;

public class Process {

  private final Double potentiationValue;

  private Double remainingProcesses;

  private Integer integrity;

  private Integer timeInMs;

  public Process(Double potentiationValue, Double remainingProcesses) {
    this.potentiationValue = potentiationValue;
    this.remainingProcesses = remainingProcesses;
    this.integrity = 0;
    this.timeInMs = 0;
  }

  public Double getPotentiationValue() {
    return potentiationValue;
  }

  public Double getRemainingProcesses() {
    return remainingProcesses;
  }

  public void setRemainingProcesses(Double remainingProcesses) {
    this.remainingProcesses = remainingProcesses;
  }

  public Integer getTimeInMs() {
    return timeInMs;
  }

  public void setTimeInMs(Integer timeInMs) {
    this.timeInMs = timeInMs;
  }

  public Integer getIntegrity() {
    return integrity;
  }

  public void setIntegrity(Integer integrity) {
    this.integrity = integrity;
  }

  @Override
  public String toString() {
    return "ProcessValueAndTime - value = " + potentiationValue
        + ", timeInMs = " + timeInMs
        + ", integrity = " + integrity;
  }
}
