package com.selectica.rcfdev.eclm.definitions.CSalesBO.CSDetails.scripts;

import com.selectica.rcfscripts.AbstractDataWriteScript;
import com.selectica.rcfutils.RCFBundleWrapper;
import com.selectica.rcfutils.RCFServiceAPI;
import com.selectica.rcfutils.RCFUserWrapper;
import com.selectica.user.messages.MsgTypeEnum;

/**
 * Created by vshilkin on 12.02.2015.
 */
public class OnChangeForAgrTypeTrigger extends AbstractDataWriteScript<Boolean> {
    /*
            <![CDATA[
                 var bundle = thisComponent.getValue("bundle");
                 var title = "";
                 var message = com.selectica.tools.LocaleUtil.getString("renderer.OnChangeAgrTypeTitle");
                 service.showCustomMessage(Packages.com.selectica.user.messages.MsgTypeEnum.INFO, "", title, message, bundle);
            ]]>
     */
    @Override
    public Boolean process() throws Exception {
        RCFBundleWrapper bundleWrapper = getHelper().getCurrentBundleWrapper();
        String title = "";
        RCFServiceAPI serviceAPI = RCFServiceAPI.getInstance();
        RCFUserWrapper userWrapper = getHelper().getRCFUserWrapper();
        String message = serviceAPI.getLocalizedString("renderer.OnChangeAgrTypeTitle", userWrapper);
        serviceAPI.showCustomMessage(MsgTypeEnum.INFO, "", title, message, bundleWrapper); //@todo move MsgTypeEnum !!!!!!!!!!
        return true;
    }
}



