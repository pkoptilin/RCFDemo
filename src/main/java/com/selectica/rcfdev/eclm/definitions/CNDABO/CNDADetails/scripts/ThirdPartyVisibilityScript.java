package com.selectica.rcfdev.eclm.definitions.CNDABO.CNDADetails.scripts;

import com.selectica.rcfdev.stubs.CNDADetails;
import com.selectica.rcfscripts.AbstractDataReadScript;

/**
 * Created by vshilkin on 12.03.2015.
 */
public class ThirdPartyVisibilityScript extends AbstractDataReadScript<Boolean> {
    /*
    <![CDATA[
            var ndaIsStandardContract = thisComponent.getParameterValueObject("isStandardContract");
            var isStandartContract = ndaIsStandardContract != null && "yes".equalsIgnoreCase(ndaIsStandardContract.toString());
            result = !isStandartContract;
            ]]>
     */
    @Override
    public Boolean process() throws Exception {
        CNDADetails info = getHelper().getCurrentComponentStub();
        String isStandardContract = info.getIsStandardContract();
        return !(isStandardContract != null && "yes".equalsIgnoreCase(isStandardContract));
    }
}
