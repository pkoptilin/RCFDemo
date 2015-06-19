package com.selectica.rcfdev.eclm.definitions.CSalesBO.CSDetails.scripts;

import com.selectica.rcfdev.stubs.CSDetails;
import com.selectica.rcfscripts.AbstractDataReadScript;

import java.util.Date;

/**
 * Created by vshilkin on 08/01/2015.
 */
public class OnValidateTerminationTrigger extends AbstractDataReadScript<Boolean> {
    /*
            <![CDATA[
            var td = thisComponent.getValue("termNoticeDate").getDate();
            var sd = thisComponent.getParameterValueObject("startDate");
            // pass validation if either date not set yet
            result = (td == null) || (sd == null) || sd.before(td);
            ]]>
     */
    @Override
    public Boolean process() throws Exception {
        CSDetails details = getHelper().getCurrentComponentStub();
        Date termNoticeDate = details.getTermNoticeDate();
        ;
        Date startDate = details.getStartDate();
        return (termNoticeDate == null) || (startDate == null) || startDate.before(termNoticeDate);
    }
}
