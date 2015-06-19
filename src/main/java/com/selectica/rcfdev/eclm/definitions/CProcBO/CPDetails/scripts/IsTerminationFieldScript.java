package com.selectica.rcfdev.eclm.definitions.CProcBO.CPDetails.scripts;

import com.selectica.rcfdev.stubs.CPDetails;
import com.selectica.rcfscripts.AbstractDataReadScript;

/**
 * Created by vshilkin on 24/12/2014.
 */
public class IsTerminationFieldScript extends AbstractDataReadScript<Boolean> {
    /*
            result = thisComponent.getParameterValueObject("termwoCause") == 'yes';
     */
    @Override
    public Boolean process() throws Exception {
        CPDetails details = getHelper().getCurrentComponentStub();
        return details.getTermwoCause().equals("yes");
    }
}

