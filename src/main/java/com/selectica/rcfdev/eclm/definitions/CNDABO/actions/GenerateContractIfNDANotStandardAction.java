package com.selectica.rcfdev.eclm.definitions.CNDABO.actions;

import com.selectica.rcfdev.stubs.CNDADetails;
import com.selectica.rcfscripts.AbstractBOWriteScript;
import com.selectica.rcfutils.RCFGenerateContractHelper;

/**
 * Created by vshilkin on 12/01/2015.
 */
public class GenerateContractIfNDANotStandardAction extends AbstractBOWriteScript<Boolean> {
    /*
                    <![CDATA[
                var ndaIsStandardContract = thisBundle.getParameterValueObjectFromAnyComponent("ReqCNDADetails", "isStandardContract");
                if (ndaIsStandardContract != null && "yes".equalsIgnoreCase(ndaIsStandardContract.toString())) {
                    Packages.com.selectica.utils.GenerateContractHelper.generate(thisComponent);
                }
                result = true;
                ]]>

     */

    @Override
    public Boolean process() throws Exception {
        CNDADetails info = getHelper().getInfoComponentStub();
        String isStandardStr = info.getIsStandardContract();
        boolean isStandard = isStandardStr != null && "yes".equalsIgnoreCase(isStandardStr);
        if(isStandard){
            RCFGenerateContractHelper.generate(getHelper().getCurrentBundleWrapper(), getHelper().getRCFUserWrapper());
        }
        return  true;
    }
}
