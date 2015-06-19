package com.selectica.rcfdev.eclm.definitions.CGenBO.CGenDetails.scripts;

import com.selectica.rcfdev.stubs.CGenDetails;
import com.selectica.rcfscripts.AbstractDataWriteScript;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by vshilkin on 08/01/2015.
 */
public class OnChangeForRenNoticeDateTrigger extends AbstractDataWriteScript<Boolean> {
    /*
            <![CDATA[
            var autoRenewal = thisComponent.getParameterValueObject("autoRenewal");
            if (autoRenewal == 'yes') {
                var ed = thisComponent.getParameterValueObject("endDate");
                if (ed != null) {
                    var renNoticePer = Number(thisComponent.getParameterValueObject("renNoticePer"));
                    if (renNoticePer > 0) {
                        edCal = ed.copy();
                        edCal.add(Packages.java.util.Calendar.DATE, -renNoticePer);
                        thisComponent.setDateValue("/renNoticeDate", edCal, false);
                    }
                    else {
                        thisComponent.setValue("/renNoticeDate", "", false);
                    }
                }
                else {
                    thisComponent.setValue("/renNoticeDate", "", false);
                }
            }
            else {
                thisComponent.setValue("/renNoticeDate", "", false);
            }
            ]]>
     */
    @Override
    public Boolean process() throws Exception {
        CGenDetails details = getHelper().getCurrentComponentStub();
        String autoRenewal = details.getAutoRenewal();
        if ("yes".equals(autoRenewal)) {
            Date end = details.getEndDate();
            if (end != null) {
                Integer renNoticePeriod = details.getRenNoticePer();
                if (renNoticePeriod != null && renNoticePeriod > 0) {
                    Calendar endCal = Calendar.getInstance();
                    endCal.setTime(end);
                    endCal.add(Calendar.DATE, -renNoticePeriod);
                    details.setRenNoticeDate(endCal.getTime());
                } else {
                    details.setRenNoticeDate(null);
                }
            } else {
                details.setRenNoticeDate(null);
            }
        } else {
            details.setRenNoticeDate(null);
        }
        return true;
    }
}



