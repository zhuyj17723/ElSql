/**
 * Copyright (C) 2009 - present by OpenGamma Inc. and the OpenGamma group of companies
 *
 * Please see distribution for license.
 */
package com.opengamma.elsql;

import org.springframework.jdbc.core.namedparam.SqlParameterSource;

/**
 * Representation of VALUE(variable).
 * <p>
 * This includes the value of a parameter.
 */
final class ValueSqlFragment extends SqlFragment {

  /**
   * The variable to output.
   */
  private final String _valueVariable;

  /**
   * Creates an instance.
   * 
   * @param valueVariable  the value variable, not null
   */
  ValueSqlFragment(String valueVariable) {
    if (valueVariable == null) {
      throw new IllegalArgumentException("Variable must be specified");
    }
    _valueVariable = valueVariable;
  }

  //-------------------------------------------------------------------------
  /**
   * Gets the variable.
   * 
   * @return the variable, not null
   */
  String getVariable() {
    return _valueVariable;
  }

  //-------------------------------------------------------------------------
  @Override
  protected void toSQL(StringBuilder buf, ElSqlBundle bundle, SqlParameterSource paramSource) {
    Object value = paramSource.getValue(_valueVariable);
    buf.append(value);
  }

  //-------------------------------------------------------------------------
  @Override
  public String toString() {
    return getClass().getSimpleName() + ":" + _valueVariable;
  }

}
