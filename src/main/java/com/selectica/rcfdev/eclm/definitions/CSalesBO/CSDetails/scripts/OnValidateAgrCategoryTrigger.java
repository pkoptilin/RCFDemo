package com.selectica.rcfdev.eclm.definitions.CSalesBO.CSDetails.scripts;

import com.selectica.rcfdev.stubs.CSDetails;
import com.selectica.rcfscripts.AbstractDataReadScript;
import com.selectica.rcfutils.RCFServiceAPI;

/**
 * Created by vshilkin on 08/01/2015.
 */
public class OnValidateAgrCategoryTrigger extends AbstractDataReadScript<Boolean> {
    /*
            <![CDATA[
            result = true;
            if (service.isImport(root.getValue("user"))) {
                result = thisComponent.getParameterValueObject("agrType") == 'Master';
                if (result) {
                    result = thisComponent.getParameterValueObject("agrCat").toString().isEmpty();
                } else {
                    result = !thisComponent.getParameterValueObject("agrCat").toString().isEmpty();
                }
            }
            ]]>
     */
    @Override
    public Boolean process() throws Exception {
        boolean result = true;
        if (RCFServiceAPI.getInstance().isImport(getHelper().getRCFUserWrapper())) {
            CSDetails details = getHelper().getCurrentComponentStub();
            String agrType = details.getAgrType();
            String agrCat = details.getAgrCat();
            if (agrType.equals("Master")) {
                result = agrCat.isEmpty();
            } else {
                result = !agrCat.isEmpty();
            }
        }
        return result;
    }
}
