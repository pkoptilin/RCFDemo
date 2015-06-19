package com.selectica.rcfdev.eclm.definitions.CGenBO.CGenDetails.scripts;

import com.selectica.rcfdev.stubs.CGenDetails;
import com.selectica.rcfscripts.AbstractDataReadScript;

import java.util.Date;

/**
 * Created by vshilkin on 30/12/2014.
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
        CGenDetails details = getHelper().getCurrentComponentStub();
        Date renNoticeDate = details.getRenNoticeDate();
        Date startDate = details.getStartDate();
        return (renNoticeDate == null) || (startDate == null) || startDate.before(renNoticeDate);
    }
}
