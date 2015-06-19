package com.selectica.rcfdev.eclm.definitions.CProcBO.conditions;

import com.selectica.rcfdev.stubs.CPDetails;
import com.selectica.rcfscripts.AbstractBOReadScript;

/**
 * Created by vshilkin on 24/12/2014.
 */
public class NeedCollIntCondition extends AbstractBOReadScript<Boolean> {
    /*
                <![CDATA[
					result  = thisBundle.getInfoValueObject("intCollReq") == 'yes'
				]]>
     */
    @Override
    public Boolean process() throws Exception {
        CPDetails info = getHelper().getInfoComponentStub();
        return info.getIntCollReq() != null && info.getIntCollReq().equals("yes");
    }
}
