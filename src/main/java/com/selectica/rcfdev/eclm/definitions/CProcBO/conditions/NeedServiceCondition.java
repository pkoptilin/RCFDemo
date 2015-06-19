package com.selectica.rcfdev.eclm.definitions.CProcBO.conditions;

import com.selectica.rcfdev.stubs.CPDetails;
import com.selectica.rcfscripts.AbstractBOReadScript;

/**
 * Created by vshilkin on 24/12/2014.
 */
public class NeedServiceCondition extends AbstractBOReadScript<Boolean> {
    /*
                <![CDATA[
					result = false;
					var at = thisBundle.getInfoValueObject("agrCat");
					if(at != "") {
						result = at.toString().contains("Service");
					}
				]]>
     */
    @Override
    public Boolean process() throws Exception {
        boolean result = false;
        CPDetails info = getHelper().getInfoComponentStub();
        String agrCat = info.getAgrCat();
        if (agrCat != null && !agrCat.isEmpty()) {
            result = agrCat.contains("Service");
        }
        return result;
    }
}
