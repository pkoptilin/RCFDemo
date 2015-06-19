package com.selectica.rcfdev.eclm.definitions.CProcBO.CPDetails.scripts;

import com.selectica.rcfdev.stubs.CPDetails;
import com.selectica.rcfscripts.AbstractDataWriteScript;

/**
 * Created by vshilkin on 24/12/2014.
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
        CPDetails details = getHelper().getCurrentComponentStub();
        if ("no".equals(details.getTermwoCause())) {
            details.setTermNotice(null);
        }
        return true;
    }
}

