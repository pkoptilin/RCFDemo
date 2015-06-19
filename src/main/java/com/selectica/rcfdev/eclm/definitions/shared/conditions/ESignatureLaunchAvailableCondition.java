package com.selectica.rcfdev.eclm.definitions.shared.conditions;

import com.selectica.System.stubs.Signature;
import com.selectica.config.Config;
import com.selectica.config.ConfigKeys;
import com.selectica.rcfscripts.AbstractBOReadScript;

/**
 * Expression to evaluate availability of the {@code Launch eSignature} button
 *
 * @author Andrey Paslavsky
 */
public class ESignatureLaunchAvailableCondition extends AbstractBOReadScript<Boolean> {

    @Override
    public Boolean process() throws Exception {
        if (!Config.isProperty(ConfigKeys.ESIGNATURE_ENABLED)) {
            return false;
        }

        String currentTask = getHelper().getCurrentBundleWrapper().getActiveTaskName();

        if (!"Execute".equalsIgnoreCase(currentTask)) { //@todo CONST!!!!!!!!!!
            return false;
        }

        Signature signature = getHelper().getComponentStub("ReqSignature");
        if (signature != null) {
            boolean showOnEmpty = Config.isProperty(ConfigKeys.ESIGNATURE_USE_TAGGERVIEW_JSP_FOR_SEND);
            String useEsig = signature.getUseEsig();
            String docStatus = signature.getDocStatus();
            return "yes".equalsIgnoreCase(useEsig) && ((showOnEmpty && docStatus.isEmpty()) || "SENT".equals(docStatus));
        }

        return false;
    }

}

