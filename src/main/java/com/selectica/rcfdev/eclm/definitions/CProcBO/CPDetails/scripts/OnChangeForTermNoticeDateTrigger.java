package com.selectica.rcfdev.eclm.definitions.CProcBO.CPDetails.scripts;

import com.selectica.rcfdev.stubs.CPDetails;
import com.selectica.rcfscripts.AbstractDataWriteScript;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by vshilkin on 24/12/2014.
 */
public class OnChangeForTermNoticeDateTrigger extends AbstractDataWriteScript<Boolean> {
    /*
            <![CDATA[
            var termwoCause = thisComponent.getParameterValueObject("termwoCause");
            if (termwoCause == 'yes') {
                var ed = thisComponent.getParameterValueObject("endDate");
                if (ed != null) {
                    var termNotice = Number(thisComponent.getParameterValueObject("termNotice"));
                    if (termNotice > 0) {
                        edCal = ed.copy();
                        edCal.add(Packages.java.util.Calendar.DATE, -termNotice);
                        thisComponent.setDateValue("/termNoticeDate", edCal, false);
                    }
                    else {
                        thisComponent.setValue("/termNoticeDate", "", false);
                    }
                }
                else {
                    thisComponent.setValue("/termNoticeDate", "", false);
                }
            }
            else {
                thisComponent.setValue("/termNoticeDate", "", false);
            }
            ]]>
     */
    @Override
    public Boolean process() throws Exception {
        CPDetails details = getHelper().getCurrentComponentStub();
        String termwoCause = details.getTermwoCause();
        if ("yes".equals(termwoCause)) {
            Date end = details.getEndDate();
            if (end != null) {
                Integer termNotice = details.getTermNotice();
                if (termNotice != null && termNotice > 0) {
                    Calendar endCal = Calendar.getInstance();
                    endCal.setTime(end);
                    endCal.add(Calendar.DATE, -termNotice);
                    details.setTermNoticeDate(endCal.getTime());
                } else {
                    details.setTermNoticeDate(null);
                }
            } else {
                details.setTermNoticeDate(null);
            }
        } else {
            details.setTermNoticeDate(null);
        }
        return true;
    }
}



