package com.selectica.Base.sqlvalue;

import com.selectica.rcfdev.stubs.DVenDetails;
import com.selectica.error.BaseException;
import com.selectica.expression.FQNodeEvaluator;
import com.selectica.mcp.sql.query.QModelFilterType;
import com.selectica.mcp.sql.query.QModelTypeFactory;
import com.selectica.mcp.sql.query.dynamic.DynamicSQLQueryMCPExpression;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vshilkin on 24.03.2015.
 */
public class VendorCPNameListFullExpression extends DynamicSQLQueryMCPExpression {

    @Override
    public List<QModelFilterType> evaluateExpression(FQNodeEvaluator eval) throws BaseException {
        List<QModelFilterType> qModelFilterTypes = new ArrayList<QModelFilterType>(1);
        String infoComponentRef = DVenDetails.REFPATH;
        qModelFilterTypes.add(QModelTypeFactory.buildQModelType(infoComponentRef, null));
        return qModelFilterTypes;
    }
}
