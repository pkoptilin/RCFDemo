package com.selectica.rcfdev.eclm.definitions.CSalesBO.CSDetails.scripts;

import com.selectica.rcfdev.stubs.CSDetails;
import com.selectica.rcfscripts.AbstractDataWriteScript;
import com.selectica.rcfutils.RCFBundleWrapper;
import com.selectica.rcfutils.RCFServiceAPI;
import com.selectica.rcfutils.RCFUserWrapper;
import com.selectica.user.messages.MsgTypeEnum;

/**
 * Created by vshilkin on 12.02.2015.
 */
public class OnChangeForThirdPartyTrigger extends AbstractDataWriteScript<Boolean> {
    /*
            <![CDATA[
            var thirdParty = thisComponent.getParameterValueObject("thirdParty1");
            if(thirdParty == 'yes'){
                var bundle = thisComponent.getValue("bundle");
                var title = "";
                var message = com.selectica.tools.LocaleUtil.getString("render.IsThisCounterPartyPaperTitle");
                service.showCustomMessage(Packages.com.selectica.user.messages.MsgTypeEnum.WARNING, "", title, message, bundle);
            }
            ]]>
     */
    @Override
    public Boolean process() throws Exception {
        CSDetails details = getHelper().getCurrentComponentStub();
        if("yes".equals(details.getThirdParty1())){
            RCFBundleWrapper bundleWrapper = getHelper().getCurrentBundleWrapper();
            String title = "";
            RCFServiceAPI serviceAPI = RCFServiceAPI.getInstance();
            RCFUserWrapper userWrapper = getHelper().getRCFUserWrapper();
            String message = serviceAPI.getLocalizedString("render.IsThisCounterPartyPaperTitle", userWrapper);
            serviceAPI.showCustomMessage(MsgTypeEnum.WARNING, "", title, message, bundleWrapper); //@todo move MsgTypeEnum !!!!!!!!!!
        }
        return true;
    }
}

