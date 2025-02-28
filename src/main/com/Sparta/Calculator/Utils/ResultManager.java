package main.com.Sparta.Calculator.Utils;

import java.util.ArrayList;

public class ResultManager {
  //  속성
  private double result;
  private final ArrayList<Double> resultList = new ArrayList<>();

  //  기능
  public void setResult(double result) {
    this.result = result;
  }

  public ArrayList<Double> getResult() {
    return resultList;
  }

  public void printCurrentResult(){
    System.out.println(result);
  }

  public void storeResult(){
    resultList.add(result);
  }
}
