package com.selectica.rcfdev.eclm.definitions.CNDABO.CNDASignature.scripts;

import com.selectica.rcfdev.stubs.Contact;
import com.selectica.rcfdev.stubs.ContractInfoComponent;
import com.selectica.config.Config;
import com.selectica.config.ConfigKeys;
import com.selectica.rcfscripts.AbstractDataWriteScript;
import com.selectica.rcfutils.RCFBundleServiceHelper;
import com.selectica.rcfutils.RCFBundleWrapper;
import com.selectica.rcfutils.RCFUserWrapper;

/**
 * Created by vshilkin on 27.04.2015.
 */
public class SetDefaultCpPrimSigner extends AbstractDataWriteScript<String> {
    /*
            <![CDATA[
            result = "";
            var useEsign = Packages.com.selectica.config.Config.getPropertyAsBoolean(Packages.com.selectica.config.ConfigKeys.ESIGNATURE_ENABLED);
            var ndaIsStandardContract = thisBundle.getParameterValueObjectFromAnyComponent("ReqCNDADetails", "isStandardContract");
            if (useEsign != null && ndaIsStandardContract != null &&
                    (useEsign.toString().equalsIgnoreCase("true") || useEsign.toString().equalsIgnoreCase("yes")) &&
                    "yes".equalsIgnoreCase(ndaIsStandardContract.toString())){
                var cpName = thisBundle.getParameterValueObjectFromAnyComponent("ReqCNDADetails", "cpName");
                var cpNameBundle = user.getBundleForTrackingNumber(cpName);
                var cp = cpNameBundle.getInfoValueObject("name").toString();
                if (cp != "") {
                    var uEntity = root.getValue("user");
                    var m = uEntity.getBundleMap("DCPBO");
                    var mIt = m.values().iterator();
                    while (mIt.hasNext()) {
                        var b = mIt.next();
                        var s = b.getInfoValueObject("dirStatus").toString();
                        if (s.equals("Active")) {
                            var n = b.getInfoValueObject("name").toString();
                            var cpPrimSignerEmail = b.getParameterValueObjectFromAnyComponent("ReqContact", "prContactEmail");
                            if (cpPrimSignerEmail != null && !cpPrimSignerEmail.toString().isEmpty() && n.equalsIgnoreCase(cp.toString())) {
                                result = cpPrimSignerEmail.toString();
                                break;
                            }
                        }
                    }
                }
            }
            ]]>
     */
    @Override
    public String process() throws Exception {
        String useEsignProp = Config.getProperty(ConfigKeys.ESIGNATURE_ENABLED);      //@todo move to RCFHelper !

        boolean useEsign = "true".equalsIgnoreCase(useEsignProp);
        ContractInfoComponent info = getHelper().getInfoComponentStub();
        boolean isStandardContract = "yes".equalsIgnoreCase(info.getIsStandardContract());

        if (useEsign && isStandardContract) {
            String cpName = info.getCpName();
            if (cpName != null && !cpName.isEmpty()) {
                RCFUserWrapper userWrapper = getHelper().getRCFUserWrapper();
                RCFBundleServiceHelper serviceHelper = RCFBundleServiceHelper.getInstance();
                RCFBundleWrapper bundleWrapper = serviceHelper.getBundleByTrackingNumber(Integer.valueOf(cpName), userWrapper);
                if (bundleWrapper != null) {
                    Contact contact = getHelper().getComponentStubForBundle(bundleWrapper, "ReqContact");
                    if(contact != null){
                        return contact.getPrContactName();
                    }
                }
            }

        }
        return null;
    }
}
