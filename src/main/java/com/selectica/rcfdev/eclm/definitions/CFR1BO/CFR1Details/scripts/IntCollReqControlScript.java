package com.selectica.rcfdev.eclm.definitions.CFR1BO.CFR1Details.scripts;

import com.selectica.rcfscripts.AbstractDataReadScript;
import com.selectica.rcfutils.RCFBundleWrapper;

/**
 * Created by vshilkin on 30/12/2014.
 */
public class IntCollReqControlScript extends AbstractDataReadScript<Boolean> {
    /*
      <![CDATA[
            var bp = thisComponent.getBundleProxy();
            var taskName = bp.getValue("activeTaskName");
            result = taskName != 'Request' && taskName != 'Assemble';
            ]]>
     */
    @Override
    public Boolean process() throws Exception {
        RCFBundleWrapper bundleWrapper = getHelper().getCurrentBundleWrapper();
        String activeTaskName = bundleWrapper.getActiveTaskName();
        return !"Request".equals(activeTaskName) && !"Assemble".equals(activeTaskName);    //todo CONST
    }
}
