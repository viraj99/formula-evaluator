package com.github.dkellenb.formulaevaluator.term.operator.bigdecimal;

import java.math.BigDecimal;

import com.github.dkellenb.formulaevaluator.FormulaEvaluatorConfiguration;
import com.github.dkellenb.formulaevaluator.term.operator.GenericStackableOperatorTerm;
import com.github.dkellenb.formulaevaluator.definition.Operator;
import com.github.dkellenb.formulaevaluator.term.Term;

/**
 * BigDecimal &amp;&amp; Operator.
 */
public class BigDecimalLogicalAndOperator extends GenericStackableOperatorTerm<BigDecimal>
  implements BigDecimalOperator {

  /**
   * C'tor.
   *
   * @param base base value
   * @param applicants further terms (not null)
   */
  @SafeVarargs
  public BigDecimalLogicalAndOperator(Term<BigDecimal> base, Term<BigDecimal>... applicants) {
    super(base, applicants);
  }

  @Override
  public String getOperatorName() {
    return Operator.LOGICAL_AND.getOperatorName();
  }

  @Override
  public BigDecimal calculateDefault(FormulaEvaluatorConfiguration conf, BigDecimal v1, BigDecimal v2) {
    boolean b1 = !zero().equals(v1);
    boolean b2 = !zero().equals(v2);
    return b1 && b2 ? one() : zero();
  }

}
