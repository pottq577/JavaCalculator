package calculator.operations;

public class Sub implements Operation {

  //  속성
  private int value1;
  private int value2;
  private String operation;

  //  생성자
  public Sub(int value1, String operation, int value2) {
    this.value1 = value1;
    this.value2 = value2;
    this.operation = operation;
  }

  //  기능
  @Override
  public int doCalculate() {
    return value1 - value2;
  }
}
