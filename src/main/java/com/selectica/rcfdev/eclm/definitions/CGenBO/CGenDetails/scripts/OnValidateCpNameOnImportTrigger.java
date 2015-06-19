package com.selectica.rcfdev.eclm.definitions.CGenBO.CGenDetails.scripts;

import com.selectica.rcfdev.stubs.CGenDetails;
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
                out.println("cp = " + cp);
                if (cp != "") {
                    var cpNameBundle = user.getBundleForTrackingNumber(cp);
                    out.println("cp info obj= " + cpNameBundle.getInfoValueObject("trackingNumber").toString());
                    var cpName = cpNameBundle.getInfoValueObject("trackingNumber").toString();
                    out.println("cpname = " + cpName);
                    var c = thisComponent.getParameterValueObject("agrType");
                    var dCat = "";
                    if (c == "Sales") dCat = "DCustomerBO";
                    else if (c == "Procurement") dCat = "DVendorBO";
                    else if (c == "NDA") dCat = "DCPBO";
                    else if (c == "Real Estate/Lease") dCat = "DLLBO";
                    else if (c == "Employment") dCat = "DCPBO";
                    else if (c == "Physician") dCat = "DPhyBO";
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
        CGenDetails details = getHelper().getCurrentComponentStub();
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




