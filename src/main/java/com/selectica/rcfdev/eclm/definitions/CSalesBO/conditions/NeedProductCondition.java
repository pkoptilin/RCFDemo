package com.selectica.rcfdev.eclm.definitions.CSalesBO.conditions;

import com.selectica.rcfdev.stubs.CSDetails;
import com.selectica.rcfscripts.AbstractBOReadScript;

/**
 * Created by vshilkin on 08/01/2015.
 */
public class NeedProductCondition extends AbstractBOReadScript<Boolean> {
    /*
                <![CDATA[
                result = false;
                var at = thisBundle.getInfoValueObject("agrCat");
                if (at != "") {
                    var agrType = thisBundle.getInfoValueObject("agrType");
                    result = at.toString().contains("Product") && agrType != 'Master';
                }
                ]]>
     */
    @Override
    public Boolean process() throws Exception {
        boolean result = false;
        CSDetails info = getHelper().getInfoComponentStub();
        String agtCategory = info.getAgrCat();
        if(agtCategory != null && !agtCategory.isEmpty()){
            String agtType = info.getAgrType();
            if (agtType != null && !agtType.isEmpty()) {
                result = agtCategory.contains("Product") && !agtType.equals("Master");
            }
        }
        return result;
    }
}
