package com.github.dkellenb.formulaevaluator.term.function.bigdecimal;

import java.math.BigDecimal;
import java.util.List;

import com.github.dkellenb.formulaevaluator.FormulaEvaluatorConfiguration;
import com.github.dkellenb.formulaevaluator.definition.Function;
import com.github.dkellenb.formulaevaluator.term.Term;
import com.github.dkellenb.formulaevaluator.term.function.GenericFunctionTerm;

/**
 * BigDecimal TANH Function.
 */
public class BigDecimalHyperbolicTangentFunctionTerm extends GenericFunctionTerm<BigDecimal>
    implements BigDecimalFunction {

  /**
   * C'tor. This one should be used for external usage
   *
   * @param term parameter term
   */
  public BigDecimalHyperbolicTangentFunctionTerm(Term<BigDecimal> term) {
    super(term);
  }

  /**
   * C'tor.
   *
   * @param parameters parameter terms
   */
  BigDecimalHyperbolicTangentFunctionTerm(List<Term<BigDecimal>> parameters) {
    super(parameters);
  }

  @Override
  protected Function getFunction() {
    return Function.TANH;
  }

  @Override
  public BigDecimal calculateDefault(FormulaEvaluatorConfiguration conf, List<BigDecimal> parameters) {
    double d = Math.tanh(Math.toRadians(parameters.get(0).doubleValue()));
    return new BigDecimal(d, conf.getCalculationMathContext());
  }

}
