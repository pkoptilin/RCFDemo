package com.selectica.rcfdev.definitions.CNDABO.CNDADetails.scripts;

import com.selectica.rcfdev.eclm.definitions.CNDABO.CNDADetails.scripts.OnSaveTrigger;
import com.selectica.rcfdev.stubs.CNDADetails;
import com.selectica.rcfscripts.AbstractDataWriteScript;
import com.selectica.rcfutils.RCFBundleWrapper;
import com.selectica.rcfutils.RCFServiceAPI;
import com.selectica.rcfutils.RCFUserWrapper;
import com.selectica.user.messages.EmbeddedLinkEnum;
import com.selectica.user.messages.MsgTypeEnum;

/**null*/
public class OnSAVE extends OnSaveTrigger {

    @Override
    public Boolean process() throws Exception {
        Boolean b1 = super.process();
        Boolean b2 = showSuccessMessage();
        return b1 && b2;
    }

    public Boolean showSuccessMessage() throws Exception {
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
