package com.selectica.rcfdev.eclm.definitions.CNDABO.actions;

import com.selectica.rcfscripts.AbstractBOWriteScript;
import com.selectica.rcfutils.RCFBundleWrapper;
import com.selectica.rcfutils.RCFServiceAPI;
import com.selectica.user.messages.MsgTypeEnum;

/**
 * Created by vshilkin on 17.02.2015.
 */
public class ShowCanceledCheckOutMessageAction extends AbstractBOWriteScript<Boolean> {

    /*
                <![CDATA[
                var bundle = thisComponent.getValue("bundle")
                var title  = com.selectica.tools.LocaleUtil.getStringWithLink("forms.cancelCheckout.confirmation" , bundle);
                service.showCustomMessage(com.selectica.user.messages.MsgTypeEnum.SUCCESS, title, title, "");
                ]]>
     */

    @Override
    public Boolean process() throws Exception {
        RCFBundleWrapper bundleWrapper = getHelper().getCurrentBundleWrapper();
        RCFServiceAPI serviceAPI = RCFServiceAPI.getInstance();
        String title = serviceAPI.getStringWithLink("forms.cancelCheckout.confirmation", bundleWrapper);
        serviceAPI.showCustomMessage(MsgTypeEnum.SUCCESS, title, title, ""); //@todo move MsgTypeEnum !!!!!!!!!!
        return true;
    }
}
