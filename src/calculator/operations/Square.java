package calculator.operations;

public class Square implements Operation {

  //  속성
  private int value1;
  private String operation;
  private int value2;

  //  생성자
  public Square(int value1, String operation, int value2) {
    this.value1 = value1;
    this.operation = operation;
    this.value2 = value2;
  }

  //  기능
  public int doCalculate() {
    return (int) Math.pow(value1, value2);
  }
}
