package main.com.Sparta.Calculator.Operations;

import java.util.ArrayList;

public class Results {

  //  속성
  private static ArrayList<Double> resultList = new ArrayList<>();
  private double result;

  //  생성자
  public Results(double result) {
    this.result = result;
  }

  public Results() {
  }

  //  기능
  public boolean handleCommand(String userInput) {
    switch (userInput) {
      case "a":
        removeResult();
        return true;
      case "ac":
        removeAllResult();
        return true;
      case "ls":
        showResult();
        return true;
      default:
        return false;
    }
  }

  public void addResult(double result) {
    resultList.add(result);
  }

  public void showResult() {
    if (resultList.isEmpty()) {
      printNoResultsMessage();
    } else {
      System.out.println("\n저장된 결과: " + resultList);
      System.out.println("\n=============================\n");
    }
  }

  public void removeResult() {
    if (resultList.isEmpty()) {
      printNoResultsMessage();
    } else {
      System.out.println("\n" + resultList.get(0) + " 이 삭제되었습니다.");
      System.out.println("\n=============================\n");
      resultList.remove(0);
    }
  }

  public void removeAllResult() {
    if (resultList.isEmpty()) {
      printNoResultsMessage();
    } else {
      System.out.println("\n모든 결과가 삭제되었습니다.");
      System.out.println("\n=============================\n");
      resultList.clear();
    }
  }

  public void printNoResultsMessage(){
    System.out.println("\n저장된 계산 결과가 없습니다.");
    System.out.println("\n=============================\n");
  }

}
