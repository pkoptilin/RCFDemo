package com.selectica.rcfdev.eclm.definitions.shared.conditions;

import com.selectica.System.stubs.Signature;
import com.selectica.config.Config;
import com.selectica.config.ConfigKeys;
import com.selectica.rcfscripts.AbstractBOReadScript;

/**
 * Created by vshilkin on 09/01/2015.
 */
public class IsSignatureEndStatusCondition extends AbstractBOReadScript<Boolean> {
    /*
        <![CDATA[
		    var useEsignProp = Packages.com.selectica.config.Config.getProperty("CUSTOMER_USE_ESIGNATURE");
            if (useEsignProp == null) {
                result = true;
            } else if (!useEsignProp.toString().equalsIgnoreCase("true")) {
                result = true;
            } else {
                if (thisBundle.getParameterValueObjectFromAnyComponent("ReqSignature", "useEsig") == 'no') {
                    result = true;
                } else {
                    var sigStatus = thisBundle.getParameterValueObjectFromAnyComponent("ReqSignature", "docStatus");
                    if (sigStatus == 'ERROR' || sigStatus == 'CANCELLED' || sigStatus == 'SIGNED' || sigStatus == 'ABORTED' || sigStatus == '') {
                        result = true;
                    } else {
                        result = false;
                    }
                }
            }
        ]]>

     */
    @Override
    public Boolean process() throws Exception {
        boolean result;
        String useEsignProp = Config.getProperty(ConfigKeys.ESIGNATURE_ENABLED);      //@todo move to RCFHelper !
        if (useEsignProp == null || useEsignProp.isEmpty() || useEsignProp.equalsIgnoreCase("true")) {
            result = true;
        } else {
            Signature signature = getHelper().getComponentStub("ReqSignature");
            if (signature != null) {
                String useEsig = signature.getUseEsig();
                if ("no".equals(useEsig)) {
                    result = true;
                } else {
                    String docStatus = signature.getDocStatus();
                    result = docStatus == null || docStatus.isEmpty() || "ERROR".equals(docStatus) ||
                            "CANCELLED".equals(docStatus) || "SIGNED".equals(docStatus) || "ABORTED".equals(docStatus);        //@todo CONST!!!!!!!!!!!!
                }
            } else {
                result = true;
            }
        }
        return result;
    }
}
