package com.selectica.rcfdev.eclm.definitions.RREPBO.RRepDetails.scripts;

import com.selectica.rcfscripts.AbstractDataWriteScript;
import com.selectica.rcfdev.stubs.RRepDetails;

/**
 * Created by vshilkin on 08/01/2015.
 */
public class OnSaveTrigger extends AbstractDataWriteScript<Boolean> {
    /*
                <![CDATA[
            var curName = thisComponent.getValue("/name");
            if (!(curName != null && curName.toString().contains("" + thisComponent.getParameterValueObject("trackingNumber")))) {
                thisComponent.setValue("/name", "REP-" + thisComponent.getParameterValueObject("trackingNumber"), false);
            }
            ]]>

     */

    @Override
    public Boolean process() throws Exception {
        RRepDetails details = getHelper().getCurrentComponentStub();
        String curName = details.getName();
        String trackingNumber = String.valueOf(details.getTrackingNumber());
        if (!(curName != null && curName.contains(trackingNumber))) {
            details.setName("REP-" + trackingNumber);
        }

        details.setCpDbaNames(details.getCpName());

        return true;
    }
}
