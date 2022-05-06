package io.github.zodh.threads;

public class Process {

  private Double potentiationValue;

  private Double remainingProcesses;

  private Integer integrity;

  private Integer timeInMs;

  private Double actualValue;

  public Process(Double potentiationValue, Double remainingProcesses) {
    this.potentiationValue = potentiationValue;
    this.remainingProcesses = remainingProcesses;
    this.integrity = 0;
    this.timeInMs = 0;
    this.actualValue = 0.0;
  }

  public Double getPotentiationValue() {
    return potentiationValue;
  }

  public Double getRemainingProcesses() {
    return remainingProcesses;
  }

  public Integer getTimeInMs() {
    return timeInMs;
  }

  public Integer getIntegrity() {
    return integrity;
  }

  public void setRemainingProcesses(Double remainingProcesses) {
    this.remainingProcesses = remainingProcesses;
  }

  public void setTimeInMs(Integer timeInMs) {
    this.timeInMs = timeInMs;
  }

  public void setIntegrity(Integer integrity) {
    this.integrity = integrity;
  }

  public Double getActualValue() {
    return actualValue;
  }

  public void setActualValue(Double actualValue) {
    this.actualValue = actualValue;
  }
}
