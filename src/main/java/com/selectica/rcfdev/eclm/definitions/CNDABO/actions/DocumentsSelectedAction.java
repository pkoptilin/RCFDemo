package com.selectica.rcfdev.eclm.definitions.CNDABO.actions;

import com.selectica.rcfscripts.AbstractBOWriteScript;
import com.selectica.rcfutils.RCFServiceAPI;
import com.selectica.rcfutils.RCFUserWrapper;
import com.selectica.user.messages.MsgTypeEnum;

import java.text.MessageFormat;

/**
 * Created by vshilkin on 17.02.2015.
 */
public class DocumentsSelectedAction extends AbstractBOWriteScript<Boolean> {

    /*
                <![CDATA[
                var title = Packages.java.text.MessageFormat.format(Packages.com.selectica.tools.LocaleUtil.getString("eSign.selectedDocuments"), selectedDocuments.length);
                service.showCustomMessageList(Packages.com.selectica.user.messages.MsgTypeEnum.INFO, "documentsSelected", title, selectedDocuments);
                ]]>
     */

    @Override
    public Boolean process() throws Exception {
        String[] selectedDocuments = (String[]) getHelper().getExtraVariables("selectedDocuments");
        RCFServiceAPI serviceAPI = RCFServiceAPI.getInstance();
        RCFUserWrapper userWrapper = getHelper().getRCFUserWrapper();
        String title = MessageFormat.format(serviceAPI.getLocalizedString("eSign.selectedDocuments", userWrapper), selectedDocuments.length);
        RCFServiceAPI.getInstance().showCustomMessageList(MsgTypeEnum.SUCCESS, "documentsSelected", title, selectedDocuments); //@todo move MsgTypeEnum !!!!!!!!!!
        return true;
    }
}
