package com.selectica.rcfdev.eclm.definitions.CProcBO.CPDetails.scripts;

import com.selectica.rcfdev.stubs.CPDetails;
import com.selectica.rcfscripts.AbstractDataReadScript;

/**
 * Created by vshilkin on 24/12/2014.
 */
public class AgrTypeControlScript extends AbstractDataReadScript {
    /*
            <![CDATA[
            result = thisComponent.getParameterValueObject("agrType") != 'Master';
            ]]>
     */
    @Override
    public Boolean process() throws Exception {
        CPDetails details = getHelper().getCurrentComponentStub();
        return !details.getAgrType().equals("Master");
    }
}

