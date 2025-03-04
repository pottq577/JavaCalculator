package main.com.Sparta.Calculator.Operations;

public enum Operators implements Computable {
  ADD("+", (value1, value2) -> value1 + value2),
  SUBTRACT("-", (value1, value2) -> value1 - value2),
  MULTIPLY("*", (value1, value2) -> value1 * value2),
  DIVIDE("/", (value1, value2) -> {
    if (value2 == 0) {
      throw new ArithmeticException("0으로 나눌 수 없습니다.");
    }
    return value1 / value2;
  }),
  MODULAR("%", (value1, value2) -> {
    if (value2 == 0) {
      throw new ArithmeticException("0으로 나눌 수 없습니다.");
    }
    return value1 % value2;
  }),
  POWER("^", (value1, value2) -> Math.pow(value1, value2));

  private final String symbol;
  private final Computable computation;

  Operators(String symbol, Computable computation) {
    this.symbol = symbol;
    this.computation = computation;
  }

  public static Operators fromSymbol(String symbol) {
    for (Operators op : values()) {
      if (op.symbol.equals(symbol)) {
//        System.out.println(op);
        return op;
      }
    }
    throw new IllegalArgumentException("지원하지 않는 연산자입니다: " + symbol);
  }

  public double compute(double value1, double value2) {
    return computation.compute(value1, value2);
  }
}