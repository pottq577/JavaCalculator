package main.com.Sparta.Calculator.Operations;

public class SquareRoot implements Operation {

  //  속성
  private double value;
  private String operation;

  //  생성자
  public SquareRoot(double value, String operation) {
    this.value = value;
    this.operation = operation;
  }

  //  기능
  /**
   * 제곱근 연산 수행
   * @return sqrt(value)
   */
  @Override
  public double doCalculate() {
    return Math.sqrt(value);
  }

  @Override
  public void printResult() {
    System.out.println(operation + "(" + value + ") = " + doCalculate());
  }
}
