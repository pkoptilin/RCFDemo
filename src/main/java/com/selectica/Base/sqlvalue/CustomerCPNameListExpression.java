package com.selectica.Base.sqlvalue;

import com.selectica.rcfdev.stubs.DCustDetails;
import com.selectica.error.BaseException;
import com.selectica.expression.FQNodeEvaluator;
import com.selectica.mcp.sql.query.QModelFilterType;
import com.selectica.mcp.sql.query.QModelTypeFactory;
import com.selectica.mcp.sql.query.dynamic.DynamicSQLQueryMCPExpression;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vshilkin on 19.03.2015.
 */
public class CustomerCPNameListExpression extends DynamicSQLQueryMCPExpression {

    @Override
    public List<QModelFilterType> evaluateExpression(FQNodeEvaluator eval) throws BaseException {
        List<QModelFilterType> qModelFilterTypes = new ArrayList<QModelFilterType>();

        String infoComponentRef = DCustDetails.REFPATH;
        qModelFilterTypes.add(QModelTypeFactory.buildQModelType(infoComponentRef, filterFactory.getFilteringCriteria(infoComponentRef, "dirStatus", "equals", "Active")));
        return qModelFilterTypes;
    }
}
