package com.selectica.rcfdev.eclm.definitions.shared.ContractInfoComponent.scripts;

import com.selectica.rcfdev.stubs.ContractInfoComponent;
import com.selectica.rcfscripts.AbstractDataWriteScript;
import org.joda.time.DateTime;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by vshilkin on 20.04.2015.
 */
public class OnChangeStartDateTrigger extends AbstractDataWriteScript<Boolean> {
    /*
            <![CDATA[
            var renewed = thisComponent.getParameterValueObject("renewed");
            if (renewed == 'No') {
                var sd = thisComponent.getParameterValueObject("startDate");
                if (sd != null) {
                    var sdCal = sd.copy();
                    var term = thisComponent.getParameterValueObject("term");
                    if (term != "" && Number(term) > 0) {
                        var termType = thisComponent.getParameterValueObject("termType");
                        if (termType != "") {
                            if (termType == "Months") {
                                sdCal.add(Packages.java.util.Calendar.MONTH, Number(term));
                                sdCal = thisComponent.correctEndOfMonth(sdCal, sd);
                            }
                            else if (termType == "Years") {
                                sdCal.add(Packages.java.util.Calendar.YEAR, Number(term));
                            }
                            else if (termType == "Days") {
                                sdCal.add(Packages.java.util.Calendar.DAY_OF_MONTH, Number(term));
                            }
                        }
                    }
                    sdCal.add(Packages.java.util.Calendar.DAY_OF_MONTH, -1);
                    thisComponent.setDateValue("/endDate", sdCal, false);
                }
            }
            ]]>
     */
    @Override
    public Boolean process() throws Exception {
        ContractInfoComponent infoComponent = getHelper().getCurrentComponentStub();
        String renewed = infoComponent.getRenewed();
        if ("No".equals(renewed)) {
            Date start = infoComponent.getStartDate();
            if (start != null) {
                Calendar startDateCal = Calendar.getInstance();
                startDateCal.setTime(start);

                Integer term = infoComponent.getTerm();
                if (term != null && term > 0) {
                    String termType = infoComponent.getTermType();
                    if (termType != null && !termType.isEmpty()) {
                        if (termType.equals("Months")) {
                            startDateCal.add(Calendar.MONTH, term);
                            startDateCal = correctEndOfMonth(startDateCal, start);
                        } else if (termType.equals("Years")) {
                            startDateCal.add(Calendar.YEAR, term);
                        } else if (termType.equals("Days")) {
                            startDateCal.add(Calendar.DAY_OF_MONTH, term);
                        }
                    }
                    startDateCal.add(Calendar.DAY_OF_MONTH, -1);
                    infoComponent.setEndDate(startDateCal.getTime());
                }
            }
        }

        return true;
    }


    //If Effective Date = the last day of month, then Expiration Date always = the last day of the next month.
    private Calendar correctEndOfMonth(Calendar cal, Object sd) {
        int day = cal.get(Calendar.DATE);
        DateTime dateTime = new DateTime(cal);
        DateTime startDateTime = new DateTime(sd);
        if (startDateTime.dayOfMonth().getMaximumValue() == startDateTime.getDayOfMonth()) {
            day = dateTime.dayOfMonth().getMaximumValue();
        }
        cal.set(Calendar.DATE, day);
        return cal;
    }

}

