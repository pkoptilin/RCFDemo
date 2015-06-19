package com.selectica.rcfdev.eclm.definitions.CNDABO.actions;

import com.selectica.rcfscripts.AbstractBOWriteScript;
import com.selectica.rcfutils.RCFServiceAPI;
import com.selectica.user.messages.MsgTypeEnum;

/**
 * Created by vshilkin on 17.02.2015.
 */
public class ShowRemoveDraftMessageScript extends AbstractBOWriteScript<Boolean> {

    /*
                <![CDATA[
                var bundle = thisComponent.getValue("bundle")
                service.showCustomMessage(com.selectica.user.messages.MsgTypeEnum.SUCCESS, removeDraftMessage, removeDraftMessage, "");
                ]]>
     */

    @Override
    public Boolean process() throws Exception {
        String removeDraftMessage = (String) getHelper().getExtraVariables("removeDraftMessage");
        RCFServiceAPI.getInstance().showCustomMessage(MsgTypeEnum.SUCCESS, removeDraftMessage, removeDraftMessage, ""); //@todo move MsgTypeEnum !!!!!!!!!!
        return true;
    }
}
