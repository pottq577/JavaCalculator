package main.com.Sparta.Calculator.Operations;

public enum Operators implements Computable {
  ADD("+") {
    @Override
    public double compute(double value1, double value2) {
      return value1 + value2;
    }
  },
  DIVIDE("/") {
    @Override
    public double compute(double value1, double value2) {
      if (value2 == 0) {
        throw new ArithmeticException("0으로 나눌 수 없습니다.");
      }
      return value1 / value2;
    }
  },
  MODULO("%") {
    @Override
    public double compute(double value1, double value2) {
      if (value2 == 0) {
        throw new ArithmeticException("0으로 나눌 수 없습니다.");
      }
      return value1 % value2;
    }
  },
  MULTIPLY("*") {
    @Override
    public double compute(double value1, double value2) {
      return value1 * value2;
    }
  },
  POWER("^") {
    @Override
    public double compute(double value1, double value2) {
      return Math.pow(value1, value2);
    }
  },
  SUBTRACT("-") {
    @Override
    public double compute(double value1, double value2) {
      return value1 - value2;
    }
  };

  private final String symbol;

  Operators(String symbol) {
    this.symbol = symbol;
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

  public abstract double compute(double value1, double value2);
}