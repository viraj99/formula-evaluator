package com.github.dkellenb.formulaevaluator.term.operator;

import com.github.dkellenb.formulaevaluator.FormulaEvaluatorConfiguration;
import com.github.dkellenb.formulaevaluator.definition.Operator;
import com.github.dkellenb.formulaevaluator.term.Term;

/**
 * Calculates the sum based on the terms passed in the constructor.
 *
 * @param <T> the result object after the evaluation
 */
public abstract class GenericSubtractionOperator<T>
    extends GenericStackableOperatorTerm<T> {

  /**
   * Initializes the calculator based on the terms.
   *
   * @param minuend the minuend
   * @param subtrahends all subtrahends
   */
  @SafeVarargs
  public GenericSubtractionOperator(Term<T> minuend, Term<T>... subtrahends) {
    super(minuend, subtrahends);
  }

  @Override
  public String getOperatorName() {
    return Operator.MINUS.getOperatorName();
  }

  /**
   * Implementation for this operator.
   *
   * @param conf the configuration.
   * @param minuend Operand 1.
   * @param subtrahend Operand 2.
   * @return The result of the operation.
   */
  protected T calculate(FormulaEvaluatorConfiguration conf, T minuend, T subtrahend) {
    switch (conf.getPlusMinusNullHandling()) {
      case IDENTITY:
        return minuend == null && subtrahend == null
          ? null
          : super.calculate(conf, minuend == null ? zero() : minuend, subtrahend == null ? zero() : subtrahend);
      case INHERIT:
      default:
        return super.calculate(conf, minuend, subtrahend);
    }
  }

}
