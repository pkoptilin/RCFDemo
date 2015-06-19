package com.selectica.rcfdev.eclm.definitions.shared.conditions;

import com.selectica.rcfdev.stubs.ContractInfoComponent;
import com.selectica.rcfscripts.AbstractBOReadScript;

/**
 * Created by vshilkin on 24.04.2015.
 */
public class IsShowNegotiateStage extends AbstractBOReadScript<Boolean> {
    /*
                <![CDATA[
                var ndaIsStandardContract = thisBundle.getInfoValueObject("isStandardContract");
                var isStandartContract = ndaIsStandardContract != null && "yes".equalsIgnoreCase(ndaIsStandardContract.toString());
                result = !isStandartContract;
                ]]>
     */
    @Override
    public Boolean process() throws Exception {
        ContractInfoComponent info = getHelper().getInfoComponentStub();
        String isStandardStr = info.getIsStandardContract();
        boolean isStandard = isStandardStr != null && "yes".equalsIgnoreCase(isStandardStr);

        return !isStandard;
    }
}

