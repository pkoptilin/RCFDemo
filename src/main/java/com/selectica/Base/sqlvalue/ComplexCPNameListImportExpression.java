package com.selectica.Base.sqlvalue;

import com.selectica.rcfdev.stubs.DCPDetails;
import com.selectica.rcfdev.stubs.DCustDetails;
import com.selectica.rcfdev.stubs.DVenDetails;
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
public class ComplexCPNameListImportExpression extends DynamicSQLQueryMCPExpression {

    @Override
    public List<QModelFilterType> evaluateExpression(FQNodeEvaluator eval) throws BaseException {
        List<QModelFilterType> modelFilterTypes = new ArrayList<QModelFilterType>();

        modelFilterTypes.add(buildQModelFilterType(DCustDetails.REFPATH));

        modelFilterTypes.add(buildQModelFilterType(DVenDetails.REFPATH));

        modelFilterTypes.add(buildQModelFilterType(DCPDetails.REFPATH));

        return modelFilterTypes;
    }

    private QModelFilterType buildQModelFilterType(String componentRef) {
        return QModelTypeFactory.buildQModelType(componentRef,
                filterFactory.getFilteringCriteria(componentRef, "dirStatus", "equals", "Active"));
    }
}
