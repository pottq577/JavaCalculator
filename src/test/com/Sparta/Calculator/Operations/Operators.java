package test.com.Sparta.Calculator.Operations;

public enum Operators {
  ADD("+") {
    @Override
    public double compute(double value1, double value2) {
      return value1 + value2;
    }
  },
  SUB("-") {
    @Override
    public double compute(double value1, double value2) {
      return value1 - value2;
    }
  },
  MUL("*") {
    @Override
    public double compute(double value1, double value2) {
      return value1 * value2;
    }
  },
  DIVIDE("/") {
    @Override
    public double compute(double value1, double value2) {
      return value1 / value2;
    }
  },
  MOD("%") {
    @Override
    public double compute(double value1, double value2) {
      return value1 % value2;
    }
  },
  SQUARE("^") {
    @Override
    public double compute(double value1, double value2) {
      return Math.pow(value1, value2);
    }
  };

  private final String operator;

  Operators(String operator) {
    this.operator = operator;
  }

  public static Operators fromString(String operator) {
    for (Operators op : values()) {
      if (op.operator.equals(operator)) {
        return op;
      }
    }
    throw new IllegalArgumentException("지원하지 않는 연산자입니다. " + operator);
  }

  public abstract double compute(double value1, double value2);
}
