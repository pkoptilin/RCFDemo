package com.selectica.rcfdev.eclm.definitions.shared.actions;

import com.selectica.System.stubs.Attachment;
import com.selectica.System.stubs.Signature;
import com.selectica.config.Config;
import com.selectica.config.ConfigKeys;
import com.selectica.rcfscripts.AbstractBOReadScript;

import java.util.List;

/**
 * Created by vshilkin on 09/01/2015.
 */
public class CompleteExecuteAction extends AbstractBOReadScript<Boolean> {
    /*
                    <![CDATA[
                        result = false;
                        var useEsig = thisBundle.getParameterValueObjectFromAnyComponent("ReqSignature", "useEsig");
                        var useEsignProp = Packages.com.selectica.config.Config.getProperty("CUSTOMER_USE_ESIGNATURE");
                        if (useEsignProp == null) {
                            result = true;
                        } else if (!useEsignProp.toString().equalsIgnoreCase("true")) {
                            result = true;
                        } else if (useEsig != null && useEsig.toString().equalsIgnoreCase("no")) {
                            result = true;
                        } else {
                            var sigStatus = thisBundle.getParameterValueObjectFromAnyComponent("ReqSignature", "docStatus");
                            if (sigStatus == 'SIGNED') {
                                var docNodes = thisBundle.getMulticardComponentsByName("ReqAttachment");
                                if (docNodes != null) {
                                    for (var i = 0; i < docNodes.length; i++) {
                                        var docNode = docNodes[i];
                                        var c = docNode.get("category");
                                        if (c == 'Signed Contract' || c == 'Signature Request Form') {
                                            result = true;
                                            break;
                                        }
                                    }
                                }
                            }
                        }
				]]>

     */
    @Override
    public Boolean process() throws Exception {
        boolean result = false;
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
                    if ("SIGNED".equals(docStatus)) {   //@todo CONST !!!!!!!!!
                        List<Attachment> attachments = getHelper().getNodesStubs("ReqAttachment");
                        if (attachments != null) {
                            for (Attachment attachment : attachments) {
                                String category = attachment.getCategory();
                                if ("Signed Contract".equals(category) || "Signature Request Form".equals(category)) {
                                    result = true;
                                    break;
                                }
                            }
                        }
                    }
                }
            } else {
                result = true;
            }
        }
        return result;
    }
}
