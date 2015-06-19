package com.selectica.rcfdev.eclm.definitions.shared.ContractInfoComponent.scripts;

import com.selectica.rcfdev.stubs.ContractInfoComponent;
import com.selectica.rcfscripts.AbstractDataReadScript;

/**
 * Created by vshilkin on 20.04.2015.
 */
public class IsAutoRenewalScript extends AbstractDataReadScript<Boolean> {
    /*
                result = thisComponent.getParameterValueObject("autoRenewal") == 'yes';

     */
    @Override
    public Boolean process() throws Exception {
        ContractInfoComponent infoComponent = getHelper().getCurrentComponentStub();
        return "yes".equals(infoComponent.getAutoRenewal());
    }
}
