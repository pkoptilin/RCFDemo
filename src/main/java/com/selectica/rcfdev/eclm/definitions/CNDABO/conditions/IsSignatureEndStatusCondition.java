package com.selectica.rcfdev.eclm.definitions.CNDABO.conditions;

import com.selectica.System.stubs.ContractAttachment;
import com.selectica.System.stubs.Signature;
import com.selectica.config.Config;
import com.selectica.config.ConfigKeys;
import com.selectica.rcfscripts.AbstractBOReadScript;

import java.util.List;

/**
 * Created by vshilkin on 09/01/2015.
 */
public class IsSignatureEndStatusCondition extends AbstractBOReadScript<Boolean> {
    /*
                <![CDATA[
                var useEsignProp = Packages.com.selectica.config.Config.getProperty("CUSTOMER_USE_ESIGNATURE");
                if (useEsignProp == null) {
                    result = true;
                } else if (!"true".equalsIgnoreCase(useEsignProp.toString())) {
                    result = true;
                } else {
                    if (thisBundle.getParameterValueObjectFromAnyComponent("ReqSignature", "useEsig") == 'no') {
                        result = true;
                    } else {
                        var sigStatus = thisBundle.getParameterValueObjectFromAnyComponent("ReqSignature", "docStatus");
                        if (sigStatus == 'ERROR' || sigStatus == 'ABORTED' || sigStatus == '' || sigStatus == 'CANCELLED' || sigStatus == 'ALREADY_CANCELLED') {
                            result = true;
                        } else {
                            result = false;
                        }
                    }
                }
                var isExistContractAttachment = thisBundle.getMulticardComponentsByName("ReqContractAttachment");
                if (isExistContractAttachment == null)
                    result = ((result) || (true));
                else
                    result = ((result) || (false));
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
                            "CANCELLED".equals(docStatus) || "SIGNED".equals(docStatus) || "ABORTED".equals(docStatus); //@todo CONST
                }
            } else {
                result = true;
            }
        }

        List<ContractAttachment> attachments = getHelper().getNodesStubs("ReqContractAttachment");
        boolean existsAttachments = attachments != null && !attachments.isEmpty();

        return (result || !existsAttachments);
    }
}
