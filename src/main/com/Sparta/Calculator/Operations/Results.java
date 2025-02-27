package main.com.Sparta.Calculator.Operations;

import java.util.ArrayList;

public class Results {

  //  속성
  private static ArrayList<Double> resultList = new ArrayList<>();
  private String userInput;
  private double result;

  //  생성자
  public Results(String userInput) {
    this.userInput = userInput;
  }

  public Results(double result) {
    this.result = result;
  }

  //  기능
  public boolean isRemove() {
    if (userInput.equals("a")) {
      removeResult();
      return true;
    } else if (userInput.equals("ac")) {
      removeAllResult();
      return true;
    }
    return false;
  }

  public boolean isShow() {
    if (userInput.equals("ls")) {
      if (resultList.isEmpty()) {
        System.out.println("저장된 계산 결과가 없습니다.");
      }
      showResult();
      return true;
    } else {
      return false;
    }
  }

  public void addResult(double result) {
    resultList.add(result);
  }

  public void showResult() {
    System.out.println("\n저장된 결과\n" + resultList);
    System.out.println("\n=============================\n");
  }

  public void removeResult() {
    if (resultList.isEmpty()) {
      System.out.println("\n저장된 계산 결과가 없습니다.");
      System.out.println("\n=============================\n");
    } else {
      System.out.println("\n" + resultList.get(0) + " 이 삭제되었습니다.");
      System.out.println("\n=============================\n");
      resultList.remove(0);
    }
  }

  public void removeAllResult() {
    if (resultList.isEmpty()) {
      System.out.println("\n저장된 계산 결과가 없습니다.");
      System.out.println("\n=============================\n");
    } else {
      System.out.println("\n모든 결과가 삭제되었습니다.");
      System.out.println("\n=============================\n");
      resultList.clear();
    }
  }

}
