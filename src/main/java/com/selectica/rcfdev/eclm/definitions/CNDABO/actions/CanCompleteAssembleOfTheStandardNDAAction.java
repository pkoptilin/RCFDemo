package com.selectica.rcfdev.eclm.definitions.CNDABO.actions;

import com.selectica.rcfdev.stubs.CNDADetails;
import com.selectica.rcfscripts.AbstractBOReadScript;
import com.selectica.rcfutils.RCFGenerateContractHelper;

/**
 *
 */
public class CanCompleteAssembleOfTheStandardNDAAction extends AbstractBOReadScript<Boolean> {

    @Override
    public Boolean process() throws Exception {
        CNDADetails info = getHelper().getInfoComponentStub();
        String isStandardStr = info.getIsStandardContract();
        boolean isStandard = isStandardStr != null && "yes".equalsIgnoreCase(isStandardStr);
        boolean hasAutoSelectTemplates = RCFGenerateContractHelper.hasAutoSelectTemplates(getHelper().getCurrentBundleWrapper(), getHelper().getRCFUserWrapper());
        return  !isStandard || hasAutoSelectTemplates;
    }
}
