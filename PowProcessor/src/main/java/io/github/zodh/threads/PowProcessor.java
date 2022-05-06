package io.github.zodh.threads;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PowProcessor {

  public static void main(String[] args) {
    System.out.println(LocalDateTime.now());
    final Integer quantum = 1;

    // Lembre-se que:
    // potentiationValue = base
    // remainingProcesses = (número de vezes que o cálculo de potênciação acontecerá)
    // exemplo: new Process(2.0, 2.0) = 2 * 2 * 2 = 8
    // exemplo: new Process(2.0, 1.0) = 2 * 2 = 4
    var processOne = new Process(2.0, 1000.0);
    var processTwo = new Process(3.0, 2000.0);
    var processThree = new Process(5.0, 10_000_000.0);

    var listOfProccesses = new ArrayList<>(List.of(processOne, processTwo, processThree));
    var listOfValues = new ArrayList<ProcessValueAndTime>();

    while(listOfValues.size() != 3){
        listOfProccesses.forEach(
            process -> {
              try {
                if (process.getRemainingProcesses() == -1) {
                  var newProcessValueAndTime = new ProcessValueAndTime(
                      process.getPotentiationValue(),
                      process.getTimeInMs(),
                      process.getIntegrity(),
                      process.getActualValue()
                  );
                  System.err.println(newProcessValueAndTime);
                  listOfValues.add(newProcessValueAndTime);
                  process.setRemainingProcesses(-2.0);
                } else {
                  if (process.getRemainingProcesses() == 0) {
                    process.setRemainingProcesses(-1.0);
                  } else if (process.getRemainingProcesses() > 0){
                    var timeGather = new TimeGather(process, quantum);
                    Thread.sleep(quantum);
                    process = timeGather.retrieveProcess();
                    timeGather.stop();
                    timeGather.interrupt();
                  }
                }
              } catch (Exception exception) {
                System.out.println("Error: " + exception.getMessage());
              }
            }
        );

    }
    System.out.println(LocalDateTime.now());
  }


}
