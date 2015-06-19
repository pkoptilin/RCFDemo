package com.selectica.rcfdev.eclm.definitions.CFR1BO.CFR1Details.scripts;

import com.selectica.rcfdev.stubs.CFR1Details;
import com.selectica.rcfdev.stubs.DCPDetails;
import com.selectica.rcfdev.stubs.DCustDetails;
import com.selectica.rcfdev.stubs.DVenDetails;
import com.selectica.clm.datatypes.CLMComponent;
import com.selectica.rcfscripts.AbstractDataWriteScript;
import com.selectica.rcfutils.RCFBundleServiceHelper;
import com.selectica.rcfutils.RCFBundleWrapper;
import com.selectica.rcfutils.RCFServiceAPI;
import com.selectica.rcfutils.RCFUserWrapper;

/**
 * Created by vshilkin on 10.02.2015.
 */
public class OnValidateCpNameOnImportTrigger extends AbstractDataWriteScript<Boolean> {

    /*
            <![CDATA[
            result = true;
            if (service.isImport(root.getValue("user"))) {
                result = false;
                var cp = thisComponent.getParameterValueObject("cpName");
                if (cp != "") {
                    var cpNameBundle = user.getBundleForTrackingNumber(cp);
                    var cpName = cpNameBundle.getInfoValueObject("trackingNumber").toString();
                    var c = thisComponent.getParameterValueObject("agrType");
                    var dCat = "";
                    if (c == "Sales") dCat = "DCustomerBO";
                    else if (c == "Procurement") dCat = "DVendorBO";
                    else dCat = "DCPBO";
                    if (dCat != "") {
                        dCat = dCat.toString();
                        var uEntity = root.getValue("user");
                        var m = uEntity.getBundleMap(dCat);
                        var mIt = m.values().iterator();
                        while (mIt.hasNext()) {
                            var b = mIt.next();
                            var s = b.getInfoValueObject("dirStatus").toString();
                            if (s.equals("Active")) {
                                var d = b.getInfoValueObject("trackingNumber").toString();
                                if (d.equals(cpName)) {
                                    result = true;
                                }
                            }
                        }
                    }
                }
            }
            ]]>
     */


    @Override
    public Boolean process() throws Exception {
        RCFUserWrapper userWrapper = getHelper().getRCFUserWrapper();
        if (!RCFServiceAPI.getInstance().isImport(userWrapper)) {
            return true;
        }
        CFR1Details details = getHelper().getCurrentComponentStub();
        String cpName = details.getCpName();
        String agreementType = details.getAgrType();
        if (cpName != null && !cpName.isEmpty()) {
            RCFBundleServiceHelper serviceHelper = RCFBundleServiceHelper.getInstance();
            RCFBundleWrapper bundleWrapper = serviceHelper.getBundleByTrackingNumber(Integer.valueOf(cpName), userWrapper);
            if (bundleWrapper != null) {
                CLMComponent comp = getHelper().getInfoComponentStubForBundle(bundleWrapper);
                if ("Sales".equals(agreementType)) {
                    return comp instanceof DCustDetails;
                } else if ("Procurement".equals(agreementType)) {
                    return comp instanceof DVenDetails;
                } else {
                    return comp instanceof DCPDetails;
                }
            }
        }
        return false;
    }
}




