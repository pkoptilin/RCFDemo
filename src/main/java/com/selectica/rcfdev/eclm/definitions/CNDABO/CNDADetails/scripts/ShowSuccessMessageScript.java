package com.selectica.rcfdev.eclm.definitions.CNDABO.CNDADetails.scripts;

import com.selectica.rcfdev.stubs.CNDADetails;
import com.selectica.rcfscripts.AbstractDataReadScript;
import com.selectica.rcfutils.RCFBundleWrapper;
import com.selectica.rcfutils.RCFServiceAPI;
import com.selectica.rcfutils.RCFUserWrapper;
import com.selectica.user.messages.EmbeddedLinkEnum;
import com.selectica.user.messages.MsgTypeEnum;

/**
 * Created by vshilkin on 18.02.2015.
 */
public class ShowSuccessMessageScript extends AbstractDataReadScript<Boolean> {
    /*
            <![CDATA[
            var event = String(thisComponent.getValue("bundleCreationWfEvent"));
            if (event != "WFAmendmentActivation") {
                if (!service.isImport(root.getValue("user"))) {
                    var bundle = thisComponent.getValue("bundle");
                    var bundleProxy = thisComponent.getBundleProxy();
                    var currentStage = bundleProxy.getCurrentTask().getDefinition().getName();
                    var viewComponentLink = "";
                    if (currentStage == "Assemble") {
                        var createContractLink = bundle.getBundleDefinition().getDataDefinitionList("AssembleDataDefList").getChildDefinitionByName("ReqAuthoringGenerateContract");
                        var viewComponentLink = service.generateEmbeddedLinkPattern(com.selectica.user.messages.EmbeddedLinkEnum.URLLINK, service.getViewDataDefLink(createContractLink, bundle), "Create Contract document");
                        viewComponentLink = viewComponentLink + " or ";
                    }
                    var navNodePath = "contracts/NDA/";
                    var navNodeLink = service.generateEmbeddedLinkPattern(com.selectica.user.messages.EmbeddedLinkEnum.URLLINK, service.getNavNodeLink(navNodePath), "view all NDA contracts");
                    var message = com.selectica.tools.LocaleUtil.getString("renderer.formDataHasBeenSubmittedTitle") + " You can " + viewComponentLink + navNodeLink;

                    var ndaIsStandardContract = thisBundle.getParameterValueObjectFromAnyComponent("ReqCNDADetails", "isStandardContract");
                    if (ndaIsStandardContract != null && "yes".equalsIgnoreCase(ndaIsStandardContract.toString())) {
                        message = com.selectica.tools.LocaleUtil.getString("renderer.formDataHasBeenSubmittedTitle") + " You can " + navNodeLink;
                    }

                    var title = "";
                    if (event == "TaskAuthAmendWF") {
                        title = "Amendment created.";
                    }
                    service.showNextInfoMessage(title, message, bundle);
                }
            }
            ]]>
     */
    @Override
    public Boolean process() throws Exception {
        CNDADetails details = getHelper().getCurrentComponentStub();

        String event = details.getBundleCreationWfEvent();
        RCFUserWrapper userWrapper = getHelper().getRCFUserWrapper();
        RCFServiceAPI serviceAPI = RCFServiceAPI.getInstance();
        if (!"WFAmendmentActivation".equals(event) && !serviceAPI.isImport(userWrapper)) {
            RCFBundleWrapper bundleWrapper = getHelper().getCurrentBundleWrapper();

            String viewComponentLink = "";
            String currentStage = bundleWrapper.getActiveTaskName();
            if ("Assemble".equals(currentStage)) {
                String path = serviceAPI.getViewDataDefLink("AssembleDataDefList", "ReqAuthoringGenerateContract", bundleWrapper);
                viewComponentLink = serviceAPI.generateEmbeddedLinkPattern(EmbeddedLinkEnum.URLLINK, path, "Create Contract document");
                viewComponentLink = viewComponentLink + " or ";
            }

            String navNodeLink = serviceAPI.generateEmbeddedLinkPattern(EmbeddedLinkEnum.URLLINK, serviceAPI.getNavNodeLink("contracts/NDA/"), "view all NDA contracts");
            String message = serviceAPI.getLocalizedString("renderer.formDataHasBeenSubmittedTitle", userWrapper) + " You can " + viewComponentLink + navNodeLink;


            String ndaIsStandardContract = details.getIsStandardContract();
            if ("yes".equalsIgnoreCase(ndaIsStandardContract)) {
                message = serviceAPI.getLocalizedString("renderer.formDataHasBeenSubmittedTitle", userWrapper) + " You can " + navNodeLink;
            }

            String title = "";
            if ("TaskAuthAmendWF".equals(event)) {
                title = "Amendment created.";
            }


            serviceAPI.showCustomMessage(MsgTypeEnum.SUCCESS, title, title, message, bundleWrapper);
        }

        return true;
    }
}
