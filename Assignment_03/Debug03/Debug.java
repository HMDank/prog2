enum Operator {
  ADD, SUBTRACT, MULTIPLY, DIVIDE
}

// Should not be instanciated with right_==0 and op_==DIVIDE
class Expression {
  double left_, right_;
  Operator op_;

  Expression(double left, double right, Operator op) {
    this.left_ = left;
    this.right_ = right;
    this.op_ = op;
  }

  double evaluate() {
    switch (this.op_) {
      // The qualified case label Operator.ADD must be replaced with the unqualified
      // enum constant ADD
      case ADD: // 1.
        return this.left_ + this.right_;
      case SUBTRACT: // 2.
        return this.left_ - this.right_;
      case MULTIPLY:// 3.
        return this.left_ * this.right_;
      case DIVIDE:// 4.
        // 6. Handle divide by 0
        if (this.right_ != 0)
          return this.left_ / this.right_;
        else {
          System.out.print("Warning: Divide by 0 \n");
          return 0.0;
        }
      default:
        return 0.0;
    }
  }
}

class Debug {

  public static void main(String[] args) {
    // 5. Exception in thread "main" java.lang.NullPointerException: Cannot invoke
    // "Operator.ordinal()" because "this.op_" is null -> 4 instead of 5
    Operator[] ops = new Operator[4];
    ops[0] = Operator.DIVIDE;
    ops[1] = Operator.SUBTRACT;
    ops[2] = Operator.MULTIPLY;
    ops[3] = Operator.ADD;

    Expression[] exp = new Expression[ops.length];
    for (int i = 0; i < ops.length; ++i) {
      exp[i] = new Expression(i + 1, i, ops[i]);
    }

    for (int i = 0; i < ops.length; ++i) {
      System.out.println(exp[i].evaluate());
    }
  }
}