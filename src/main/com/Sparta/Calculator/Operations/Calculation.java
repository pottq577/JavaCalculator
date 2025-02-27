package main.com.Sparta.Calculator.Operations;

import java.util.List;

public class Calculation implements Operation {

  //  속성
  private double value1;
  private double value2;
  private String operation;
  private double result;
  private List<Double> resultList;

  //  생성자
  public Calculation(double value1, String operation, double value2) {
    this.value1 = value1;
    this.value2 = value2;
    this.operation = operation;
  }

  //  기능
  // TODO 02/27
  //  case에 있는 "+", "-" 등을
  //  ENUM(Operators)을 활용해서 활용하는 방법 찾기
  // 연산자에 따라 계산 결과 저장
  @Override
  public double doCalculate() {
    if (operation.equals("/") || operation.equals("%")) {
      if (value2 == 0) {
        System.out.println("0으로 나눌 수 없습니다.");
        return 0;
      }
    }
    try {
      switch (operation) {
        case "+":
          result = value1 + value2;
          break;
        case "-":
          result = value1 - value2;
          break;
        case "*":
          result = value1 * value2;
          break;
        case "/":
          result = value1 / value2;
          break;
        case "%":
          result = value1 % value2;
          break;
        case "^":
          result = Math.pow(value1, value2);
          break;
        case "sqrt":
          result = Math.sqrt(value1);
          break;
        default:
          System.out.println("지원하지 않는 연산자입니다.");
          return 0;
      }
    } catch (Exception e) {
      System.out.println("잘못된 수식입니다.");
    }
    printResult();
    resultList.add(result);
    return 0;
  }

  // 계산 결과 출력
  @Override
  public void printResult() {
    if (operation.equals("sqrt")) {
      System.out.println(operation + "(" + value1 + ") = " + result);
    } else {
      System.out.println(value1 + " " + operation + " " + value2 + " = " + result);
    }
  }

  public void showResult(){
    int i = 0;
    for(double result : resultList){
      i++;
      System.out.println(i + "번째 결과: " + result);
    }
  }

  public void removeResult() {
    if (resultList.isEmpty()) {
      System.out.println("저장된 계산 결과가 없습니다.");
    } else{
      System.out.println("가장 나중에 저장된 결과가 삭제됩니다.");
      resultList.remove(0);
    }
  }
}
