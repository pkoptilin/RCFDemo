package com.selectica.rcfdev.eclm.definitions.CFR1BO.CFR1Details.scripts;

import com.selectica.rcfdev.stubs.CFR1Details;
import com.selectica.rcfscripts.AbstractDataReadScript;

import java.util.Date;

/**
 * Created by vshilkin on 08/01/2015.
 */
public class OnValidateRenewalTrigger extends AbstractDataReadScript<Boolean> {
    /*
            <![CDATA[
            var rd = thisComponent.getValue("renNoticeDate").getDate();
            var sd = thisComponent.getParameterValueObject("startDate");
            // pass validation if either date not set yet
            result = (rd == null) || (sd == null) || sd.before(rd);
            ]]>
     */
    @Override
    public Boolean process() throws Exception {
        CFR1Details details = getHelper().getCurrentComponentStub();
        Date renNotice = details.getRenNoticeDate();
        Date start = details.getStartDate();

        return (renNotice == null) || (start == null) || start.before(renNotice);
    }
}
