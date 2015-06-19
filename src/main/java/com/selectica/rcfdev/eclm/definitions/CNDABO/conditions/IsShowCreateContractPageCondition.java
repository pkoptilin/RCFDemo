package com.selectica.rcfdev.eclm.definitions.CNDABO.conditions;

import com.selectica.rcfdev.stubs.CNDADetails;
import com.selectica.rcfscripts.AbstractBOReadScript;

/**
 * Created by vshilkin on 24/12/2014.
 */
public class IsShowCreateContractPageCondition extends AbstractBOReadScript<Boolean> {
    /*
                    <![CDATA[
                var ndaIsStandardContract = thisBundle.getParameterValueObjectFromAnyComponent("ReqCNDADetails", "isStandardContract");
                var isStandartContract = ndaIsStandardContract != null && "yes".equalsIgnoreCase(ndaIsStandardContract.toString());
                var ndaIsThirdParty = thisBundle.getParameterValueObjectFromAnyComponent("ReqCNDADetails", "thirdParty1");
                var isThirdParty = ndaIsThirdParty != null && "yes".equalsIgnoreCase(ndaIsThirdParty.toString());
                result = !isStandartContract && !isThirdParty;
                ]]>

     */
    @Override
    public Boolean process() throws Exception {
        CNDADetails info = getHelper().getInfoComponentStub();
        String isStandardStr = info.getIsStandardContract();
        boolean isStandard = isStandardStr != null && "yes".equalsIgnoreCase(isStandardStr);
        String isThirdPartyStr = info.getThirdParty1();
        boolean isThirdParty = isThirdPartyStr != null && "yes".equalsIgnoreCase(isThirdPartyStr);

        return !isStandard && !isThirdParty;
    }
}
