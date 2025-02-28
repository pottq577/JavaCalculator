package main.com.Sparta.Calculator.Utils;

import java.util.ArrayList;

public class ResultManager {
  //  속성
  private double result;
  private ArrayList<Double> resultList = new ArrayList<>();

  //  생성자
//  public ResultManager(double result) {
//    this.result = result;
//  }

  //  기능
  public void setResult(double result) {
    this.result = result;
  }

  public double getResult() {
    return result;
  }

  public void printCurrentResult(){
    System.out.println(result);
  }

  public void storeResult(){
    resultList.add(result);
  }

  public void displayResults() {
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

  public void removeAllResults() {
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
