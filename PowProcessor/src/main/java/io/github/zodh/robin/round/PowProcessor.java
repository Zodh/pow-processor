package io.github.zodh.robin.round;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PowProcessor {

  public static void main(String[] args) {
    System.out.println("Enter how many quantums you want to pass:");
    var quantumQuantity = new Scanner(System.in).nextInt();
    if ( quantumQuantity <= 0){
      System.out.println("Invalid value. Start the software again.");
      System.exit(0);
    }

    var quantumValues = retrieveMsResultForQuantums(quantumQuantity);

    quantumValues.forEach(quantum -> {
          System.out.println(String.format("%n---Starting the %dms quantum---", quantum));
          var processOne = new Process(2.0, 500_000.0);
          var processTwo = new Process(3.0, 5_000_000.0);
          var processThree = new Process(5.0, 50_000_000.0);
          var processList = new ArrayList<>(List.of(processOne, processTwo, processThree));
          while (
              processOne.getRemainingProcesses() != 0
                  || processTwo.getRemainingProcesses() != 0
                  || processThree.getRemainingProcesses() != 0
          ) {
            for (var process : processList) {
              if (process.getRemainingProcesses() != 0) {
                calculateProcessInQuantum(quantum, process);
              }
            }
          }
          showResult(processList);
          System.out.println(String.format("---Finishing the %dms quantum---", quantum));
        }
    );
  }

  private static Process calculateProcessInQuantum(Integer quantumInMillis, Process process) {
    var endDateTime = LocalDateTime.now().plus(quantumInMillis, ChronoUnit.MILLIS);
    var potentiationValue = process.getPotentiationValue();

    while (LocalDateTime.now().isBefore(endDateTime)) {
      if (process.getRemainingProcesses() != 0) {
        process.setIntegrity(process.getIntegrity() + 1);
        Math.pow(potentiationValue, potentiationValue);
        process.setRemainingProcesses(process.getRemainingProcesses() - 1);
      }
    }

    var newProcessTime = process.getTimeInMs() + quantumInMillis;
    process.setTimeInMs(newProcessTime);

    return process;
  }

  private static List<Integer> retrieveMsResultForQuantums(Integer quantumQuantity) {
    var quantumValues = new ArrayList<Integer>();
    for (var counter = 0; counter < quantumQuantity; counter++) {
      System.out.println(String.format("Insert the %d° quantum: ", counter+1));
      quantumValues.add(new Scanner(System.in).nextInt());
    }
    return quantumValues;
  }

  private static void showResult(List<Process> processList) {
    processList.forEach(System.out::println);
  }
}
