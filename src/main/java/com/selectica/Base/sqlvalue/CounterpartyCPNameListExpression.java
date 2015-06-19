package com.selectica.Base.sqlvalue;

import com.selectica.rcfdev.stubs.DCPDetails;
import com.selectica.error.BaseException;
import com.selectica.expression.FQNodeEvaluator;
import com.selectica.mcp.sql.query.QModelFilterType;
import com.selectica.mcp.sql.query.QModelTypeFactory;
import com.selectica.mcp.sql.query.dynamic.DynamicSQLQueryMCPExpression;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vzakharchenko on 02.03.15.
 */
public class CounterpartyCPNameListExpression extends DynamicSQLQueryMCPExpression {

    @Override
    public List<QModelFilterType> evaluateExpression(FQNodeEvaluator eval) throws BaseException {
        List<QModelFilterType> qModelFilterTypes = new ArrayList<QModelFilterType>();
        String infoComponentRef = DCPDetails.REFPATH;
        qModelFilterTypes.add(QModelTypeFactory.buildQModelType(infoComponentRef, filterFactory.getFilteringCriteria(infoComponentRef, "dirStatus", "equals", "Active")));
        return qModelFilterTypes;
    }
}
