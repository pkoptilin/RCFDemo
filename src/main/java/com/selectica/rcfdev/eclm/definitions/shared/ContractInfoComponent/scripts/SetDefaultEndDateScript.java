package com.selectica.rcfdev.eclm.definitions.shared.ContractInfoComponent.scripts;

import com.selectica.rcfdev.stubs.ContractInfoComponent;
import com.selectica.rcfscripts.AbstractDataWriteScript;
import com.selectica.tools.Validator;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by vshilkin on 21/01/2015.
 */
public class SetDefaultEndDateScript extends AbstractDataWriteScript<String> {
    /*
            <![CDATA[
            var sdCal = Packages.java.util.Calendar.getInstance();
            sdCal.setTime(new Packages.java.util.Date());
            if (sdCal != null) {
                var term = thisComponent.getParameterValueObject("term");
                if (term != "" && Number(term) > 0) {
                    var termType = thisComponent.getParameterValueObject("termType");
                    if (termType != "") {
                        if (termType == "Months") {
                            sdCal.add(Packages.java.util.Calendar.MONTH, Number(term));
                        }
                    }
                }
                result = Packages.com.selectica.tools.Validator.formatDate(sdCal.getTime(), "M/dd/yyyy");
            }
            ]]>
     */
    @Override
    public String process() throws Exception {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(new Date().getTime());
        ContractInfoComponent info = getHelper().getCurrentComponentStub();
        Integer term = info.getTerm();
        if (term != null && term > 0) {
            String termType = info.getTermType();
            if (termType != null && termType.equals("Months")) {
                calendar.add(Calendar.MONTH, term);
            }
        }

        return Validator.formatDate(calendar.getTime(), "M/dd/yyyy");
    }
}
