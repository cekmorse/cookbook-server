package com.github.cekmorse.persist.util;

import com.mysema.query.types.expr.BooleanExpression;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.validation.constraints.NotNull;


/**
 * Created by keith on 6/20/17.
 */
public class PredicateHelper {
    enum ExpressionCombination
    {
        Or,
        And
    }

    public static BooleanExpression andAll(BooleanExpression... aExpressions)
    {
        return combineAll(ExpressionCombination.And, aExpressions);
    }

    public static BooleanExpression orAll(BooleanExpression... aExpressions)
    {
        return combineAll(ExpressionCombination.Or, aExpressions);
    }

    public static BooleanExpression andAll(List<BooleanExpression> aExpressions)
    {
        return combineAll(ExpressionCombination.And, aExpressions);
    }

    public static BooleanExpression orAll(List<BooleanExpression> aExpressions)
    {
        return combineAll(ExpressionCombination.Or, aExpressions);
    }

    protected static BooleanExpression combineAll(@NotNull ExpressionCombination aCombination, BooleanExpression... aExpressions)
    {
        List<BooleanExpression> expressions = new ArrayList<BooleanExpression>();
        Collections.addAll(expressions, aExpressions);
        return combineAll(aCombination, expressions);
    }

    protected static BooleanExpression combineAll(@NotNull ExpressionCombination aCombination, List<BooleanExpression> aExpressions)
    {
        BooleanExpression current = null;
        for (BooleanExpression expression : aExpressions)
        {
            //only do something if we have an expression
            if (expression != null)
            {
                //assign to current or combine if it has a current expression
                if (current == null)
                {
                    current = expression;
                }
                else
                {
                    switch (aCombination)
                    {
                        case Or:
                            current = current.or(expression);
                            break;
                        case And:
                            current = current.and(expression);
                            break;
                    }
                }
            }
        }
        return current;
    }
}
