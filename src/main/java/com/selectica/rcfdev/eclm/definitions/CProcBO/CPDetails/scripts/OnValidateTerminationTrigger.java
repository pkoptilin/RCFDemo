package com.selectica.rcfdev.eclm.definitions.CProcBO.CPDetails.scripts;

import com.selectica.rcfdev.stubs.CPDetails;
import com.selectica.rcfscripts.AbstractDataReadScript;

import java.util.Date;

/**
 * Created by vshilkin on 24/12/2014.
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
        CPDetails details = getHelper().getCurrentComponentStub();
        Date termNoticeDate = details.getTermNoticeDate();
        Date startDate = details.getStartDate();
        return (termNoticeDate == null) || (startDate == null) || startDate.before(termNoticeDate);
    }
}
