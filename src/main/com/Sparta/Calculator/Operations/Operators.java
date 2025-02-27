package main.com.Sparta.Calculator.Operations;


public enum Operators {
  ADD("+"),
  SUB("-"),
  MUL("*"),
  DIVIDE("/"),
  MOD("%"),
  SQUARE("^");

  private String operator;

  private Operators(String operator) {
    this.operator = operator;
  }

  public String getOperator() {
    return operator;
  }
}
