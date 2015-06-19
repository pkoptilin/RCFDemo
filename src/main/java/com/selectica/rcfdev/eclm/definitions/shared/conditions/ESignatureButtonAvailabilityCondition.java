package com.selectica.rcfdev.eclm.definitions.shared.conditions;

import com.selectica.System.stubs.Signature;
import com.selectica.config.Config;
import com.selectica.config.ConfigKeys;
import com.selectica.rcfscripts.AbstractBOReadScript;

import java.util.List;

/**
 * This is abstract class to evaluate availability of the eSignature buttons
 *
 * @author Andrey Paslavsky
 */
public abstract class ESignatureButtonAvailabilityCondition extends AbstractBOReadScript<Boolean> {

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
            String useEsig = signature.getUseEsig();
            String docStatus = signature.getDocStatus();
            return "yes".equalsIgnoreCase(useEsig) && getStatusesWhenButtonIsAvailable().contains(docStatus);
        }

        return false;
    }

    protected abstract List<String> getStatusesWhenButtonIsAvailable();

}
