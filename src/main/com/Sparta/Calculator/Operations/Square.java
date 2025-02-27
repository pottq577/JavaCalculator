package main.com.Sparta.Calculator.Operations;

public class Square implements Operation {

  //  속성
  private double value1;
  private String operation;
  private double value2;

  //  생성자
  public Square(double value1, String operation, double value2) {
    this.value1 = value1;
    this.operation = operation;
    this.value2 = value2;
  }

  //  기능
  public double doCalculate() {
    return Math.pow(value1, value2);
  }

  @Override
  public void printResult() {
    System.out.println(value1 + " " + operation + " " + value2 + " = " + doCalculate());
  }
}
