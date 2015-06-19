package com.selectica.rcfdev.eclm.definitions.CNDABO.actions;

import com.selectica.rcfscripts.AbstractBOWriteScript;
import com.selectica.rcfutils.RCFServiceAPI;
import com.selectica.rcfutils.RCFUserWrapper;
import com.selectica.user.messages.MsgTypeEnum;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vshilkin on 12.02.2015.
 */
public class TemplatesSelectedAction extends AbstractBOWriteScript<Boolean> {

    /*
                <![CDATA[
                    var title = templatesData.size() + " template(s) selected";

                    var messages = [];

                    for (var i = 0; i < templatesData.size(); i++) {
                        var data = templatesData.get(i);
                        messages.push((i+1) + ". " + data.getTitle());
                    }

                    messages.push(Packages.java.text.MessageFormat.format(Packages.com.selectica.tools.LocaleUtil.getString("renderer.templatesSelectedTitlePart2"), "Generate", "Preview", "Select Templates"));
                    service.showCustomMessageList(Packages.com.selectica.user.messages.MsgTypeEnum.INFO, "templatesSelected", title, messages);

                ]]>
     */

    @Override
    public Boolean process() throws Exception {
        List<String> templates = getHelper().getSelectedTemplatesList();
        String title = templates.size() + " template(s) selected";
        List<String> messages = new ArrayList<String>();

        int i = 0;
        for (String template : templates) {
            i++;
            messages.add(i + ". " + template);
        }

        RCFServiceAPI serviceAPI = RCFServiceAPI.getInstance();
        RCFUserWrapper userWrapper = getHelper().getRCFUserWrapper();
        messages.add(MessageFormat.format(serviceAPI.getLocalizedString("renderer.templatesSelectedTitlePart2", userWrapper), "Generate", "Preview", "Select Templates"));
        serviceAPI.showCustomMessageList(MsgTypeEnum.INFO, "templatesSelected", title, messages.toArray(new String[messages.size()])); //@todo move MsgTypeEnum !!!!!!!!!!
        return true;
    }
}
