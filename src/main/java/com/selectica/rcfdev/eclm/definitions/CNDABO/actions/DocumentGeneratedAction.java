package com.selectica.rcfdev.eclm.definitions.CNDABO.actions;

import com.selectica.rcfscripts.AbstractBOWriteScript;
import com.selectica.rcfutils.RCFServiceAPI;
import com.selectica.rcfutils.RCFUserWrapper;
import com.selectica.user.messages.MsgTypeEnum;

/**
 * Created by vshilkin on 12.02.2015.
 */
public class DocumentGeneratedAction extends AbstractBOWriteScript<Boolean> {

    /*
                <![CDATA[
                    var message = Packages.com.selectica.tools.LocaleUtil.getString("forms.generate.confirmation");
                    service.showCustomMessage(Packages.com.selectica.user.messages.MsgTypeEnum.SUCCESS, "documentGenerated", "Document Generated", message);
                ]]>
     */

    @Override
    public Boolean process() throws Exception {
        RCFServiceAPI serviceAPI = RCFServiceAPI.getInstance();
        RCFUserWrapper userWrapper = getHelper().getRCFUserWrapper();
        String message = serviceAPI.getLocalizedString("forms.generate.confirmation", userWrapper);
        serviceAPI.showCustomMessage(MsgTypeEnum.SUCCESS, "documentGenerated", "Document Generated", message); //@todo move MsgTypeEnum !!!!!!!!!!
        return true;
    }
}
