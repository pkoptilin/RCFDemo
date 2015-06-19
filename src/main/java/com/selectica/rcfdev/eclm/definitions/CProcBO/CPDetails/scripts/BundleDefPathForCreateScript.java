package com.selectica.rcfdev.eclm.definitions.CProcBO.CPDetails.scripts;

import com.selectica.rcfscripts.AbstractDataWriteScript;

/**
 * Created by vshilkin on 21/01/2015.
 */
public class BundleDefPathForCreateScript extends AbstractDataWriteScript<String> {
    /*
            <![CDATA[
            result = "BundleDef:/DVendorBO/";
            ]]>
     */
    @Override
    public String process() throws Exception {
        return "BundleDef:/DVendorBO/";
    }
}
