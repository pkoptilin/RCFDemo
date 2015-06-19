package com.selectica.rcfdev.eclm.definitions.shared.conditions;

import com.selectica.System.stubs.Signature;
import com.selectica.config.Config;
import com.selectica.config.ConfigKeys;
import com.selectica.rcfscripts.AbstractBOReadScript;

import java.util.Arrays;
import java.util.List;

/**
 * Expression to evaluate availability of the {@code Reset eSignature} button
 *
 * @author Andrey Paslavsky
 */
public class ESignatureResetAvailableCondition extends AbstractBOReadScript<Boolean> {

    private final static List<String> AVAILABLE = Arrays.asList("ERROR", "ABORTED", "CANCELLED");

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
            String docStatus = signature.getDocStatus();
            return AVAILABLE.contains(docStatus);
        }

        return false;
    }

}
