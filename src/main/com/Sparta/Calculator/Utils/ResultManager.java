package main.com.Sparta.Calculator.Utils;

import java.util.ArrayList;
import main.com.Sparta.Calculator.App.Calculator;
import main.com.Sparta.Calculator.Operations.MathOperator;

public class ResultManager {
  //  속성
  private double result;
  private final ArrayList<Double> resultList = new ArrayList<>();

  //  기능
  public void setResult(double result) {
    this.result = result;
  }

  /**
   * resultList Getter
   * @return 결과 리스트
   */
  public ArrayList<Double> getResult() {
    return resultList;
  }

  // 사용자가 수식을 입력하면 결과 출력
  public void printCurrentResult(){
    System.out.println(result);
  }

  // 사용자가 입력한 수식의 결과 저장
  public void storeResult(){
    resultList.add(result);
  }
}
