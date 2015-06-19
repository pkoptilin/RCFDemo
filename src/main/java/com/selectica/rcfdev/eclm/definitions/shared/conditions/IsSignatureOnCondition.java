package com.selectica.rcfdev.eclm.definitions.shared.conditions;

import com.selectica.config.Config;
import com.selectica.config.ConfigKeys;
import com.selectica.rcfscripts.AbstractBOReadScript;

/**
 * Created by vshilkin on 24/12/2014.
 */
public class IsSignatureOnCondition extends AbstractBOReadScript<Boolean> {
    /*
                    <![CDATA[
                var useEsignProp = Packages.com.selectica.config.Config.getProperty("CUSTOMER_USE_ESIGNATURE");
                if (useEsignProp == null) {
                    result = false;
                } else if (!useEsignProp.toString().equalsIgnoreCase("true")) {
                    result = false;
                } else {
                    result = true;
                }
                ]]>

     */
    @Override
    public Boolean process() throws Exception {
        String useEsignProp = Config.getProperty(ConfigKeys.ESIGNATURE_ENABLED);      //@todo move to RCFHelper !
        return !(useEsignProp == null || useEsignProp.isEmpty() || !useEsignProp.equalsIgnoreCase("true"));
    }
}
