package com.selectica.rcfdev.eclm.definitions.CProcBO.CPDetails.scripts;

import com.selectica.rcfdev.stubs.CPDetails;
import com.selectica.rcfscripts.AbstractDataReadScript;
import com.selectica.rcfutils.RCFServiceAPI;

/**
 * Created by vshilkin on 24/12/2014.
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
            CPDetails details = getHelper().getCurrentComponentStub();
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
