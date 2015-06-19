package com.selectica.rcfdev.eclm.definitions.CSalesBO.CSDetails.scripts;

import com.selectica.rcfdev.stubs.CSDetails;
import com.selectica.rcfscripts.AbstractDataWriteScript;

/**
 * Created by vshilkin on 08/01/2015.
 */
public class OnChangeTermWOCauseTrigger extends AbstractDataWriteScript<Boolean> {
    /*
            <![CDATA[
            var termwoCause = thisComponent.getParameterValueObject("termwoCause");
            if (termwoCause == 'no') {
                thisComponent.setValue("/termNotice", "", false);
            }
            ]]>
     */
    @Override
    public Boolean process() throws Exception {
        CSDetails details = getHelper().getCurrentComponentStub();
        if ("no".equals(details.getTermwoCause())) {
            details.setTermNotice(null);
        }
        return true;
    }
}

