package com.selectica.rcfdev.eclm.definitions.CGenBO.CGenDetails.scripts;

import com.selectica.rcfdev.stubs.CGenAddresses;
import com.selectica.rcfdev.stubs.CGenDetails;
import com.selectica.rcfscripts.AbstractDataReadScript;
import com.selectica.rcfutils.RCFBundleWrapper;
import com.selectica.rcfutils.RCFServiceAPI;
import com.selectica.rcfutils.RCFUserWrapper;
import com.selectica.user.messages.EmbeddedLinkEnum;
import com.selectica.user.messages.MsgTypeEnum;

/**
 * Created by vshilkin on 18.02.2015.
 */
public class ShowSuccessMessageScript  extends AbstractDataReadScript<Boolean> {
    /*
            <![CDATA[
            var event = String(thisComponent.getValue("bundleCreationWfEvent"));
            if (event != "WFAmendmentActivation") {
                if (!service.isImport(root.getValue("user"))) {
                    var bundle = thisComponent.getValue("bundle");
                    var addressComponent = bundle.getDataContainer().getDefinition().getChildDefinitionByName("ReqCGenAddress");
                    var addComponentLink = service.generateEmbeddedLinkPattern(com.selectica.user.messages.EmbeddedLinkEnum.URLLINK, service.getAddComponentLink(addressComponent, bundle), "add Addresses");
                    var navNodePath = "contracts/Gen/";
                    var navNodeLink = service.generateEmbeddedLinkPattern(com.selectica.user.messages.EmbeddedLinkEnum.URLLINK, service.getNavNodeLink(navNodePath), "view all General contracts");
                    var message = com.selectica.tools.LocaleUtil.getString("renderer.formDataHasBeenSubmittedTitle") + " You can " + addComponentLink + " or " + navNodeLink;
                    service.showNextInfoMessage("", message, bundle);
                    }
                }
            ]]>
     */
    @Override
    public Boolean process() throws Exception {
        CGenDetails details = getHelper().getCurrentComponentStub();

        String event = details.getBundleCreationWfEvent();
        RCFUserWrapper userWrapper = getHelper().getRCFUserWrapper();
        RCFServiceAPI serviceAPI = RCFServiceAPI.getInstance();
        if(!"WFAmendmentActivation".equals(event) && !serviceAPI.isImport(userWrapper)){
            RCFBundleWrapper bundleWrapper = getHelper().getCurrentBundleWrapper();
            String path = serviceAPI.getAddComponentLink(CGenAddresses.REFNAME, bundleWrapper);
            String addAddressLink = serviceAPI.generateEmbeddedLinkPattern(EmbeddedLinkEnum.URLLINK, path, "add Addresses");
            String navNodeLink = serviceAPI.generateEmbeddedLinkPattern(EmbeddedLinkEnum.URLLINK, serviceAPI.getNavNodeLink("contracts/Gen/"), "view all General contracts");
            String message = serviceAPI.getLocalizedString("renderer.formDataHasBeenSubmittedTitle", userWrapper) + " You can " + addAddressLink + " or " + navNodeLink;
            serviceAPI.showCustomMessage(MsgTypeEnum.SUCCESS, "", "", message, bundleWrapper);
        }

        return true;
    }
}
