package com.selectica.Base.sqlvalue;

import com.selectica.rcfdev.stubs.DCPDetails;
import com.selectica.rcfdev.stubs.DCustDetails;
import com.selectica.rcfdev.stubs.DVenDetails;
import com.selectica.error.BaseException;
import com.selectica.expression.FQNodeEvaluator;
import com.selectica.fq.FQNodeInstance;
import com.selectica.mcp.Parameter;
import com.selectica.mcp.sql.query.QModelFilterType;
import com.selectica.mcp.sql.query.QModelTypeFactory;
import com.selectica.mcp.sql.query.dynamic.DynamicSQLQueryMCPExpression;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vzakharchenko on 02.03.15.
 */
public class ComplexCPNameListExpression extends DynamicSQLQueryMCPExpression {
    @Override
    public List<QModelFilterType> evaluateExpression(FQNodeEvaluator eval) throws BaseException {
        List<QModelFilterType> qModelFilterTypes = new ArrayList<QModelFilterType>();
        FQNodeInstance comp = (FQNodeInstance) eval.getNode();
        Parameter agrType = (Parameter) comp.get("agrType");
        String value = agrType.getValue();
        String infoComponentRef;
        if (StringUtils.equalsIgnoreCase(value, "Sales")) {
            infoComponentRef = DCustDetails.REFPATH;;
        } else if (StringUtils.equalsIgnoreCase(value, "Procurement")) {
            infoComponentRef = DVenDetails.REFPATH;
        } else {
            infoComponentRef = DCPDetails.REFPATH;

        }
        qModelFilterTypes.add(QModelTypeFactory.buildQModelType(infoComponentRef, filterFactory.getFilteringCriteria(infoComponentRef, "dirStatus", "equals", "Active")));
        return qModelFilterTypes;
    }


}
