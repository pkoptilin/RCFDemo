package com.selectica.rcfdev.eclm.definitions.CSalesBO.actions;

import com.selectica.rcfdev.stubs.CSContacts;
import com.selectica.rcfdev.stubs.CSDetails;
import com.selectica.rcfscripts.AbstractBOWriteScript;
import com.selectica.rcfutils.RCFBundleWrapper;
import com.selectica.rcfutils.RCFServiceAPI;
import com.selectica.user.messages.MsgTypeEnum;

import java.util.List;

/**
 * Created by vshilkin on 17.02.2015.
 */
public class ContactsUpdateAction extends AbstractBOWriteScript<Boolean> {
    /*
                <![CDATA[
                var bp = thisComponent.getBundleProxy();
                var bundle = thisComponent.getValue("bundle");
                var infoComponent = bundle.get("ReqCSalesDetails");
                var contactNodes = thisBundle.getMulticardComponentsByName("ReqCSContacts");
                var contFN = thisComponent.getUser().getUserWrapper().getFirstName();
                var contLN = thisComponent.getUser().getUserWrapper().getLastName();
                var contactExistMessage = "Same Contact is exist";
                var viewComponentLink = service.getViewComponentLink(infoComponent, bundle);

                var contractName = bp.getInfoValueObject("name");
                var successMessage = "Current user has been added as a contact for Sales contract [URLLink link = \"" + viewComponentLink + "\"]" + contractName + "[URLLink]";

                var isExistSameContact = false;
                if (contactNodes == null) {
                    contactNodes = thisComponent.addNode("ReqCSContacts/");
                    contactNodes.setValue("/contFN", contFN);
                    contactNodes.setValue("/contLN", contLN);
                    contactNodes.save();
                    service.showNextCustomMessage(com.selectica.user.messages.MsgTypeEnum.SUCCESS,successMessage, successMessage, "", bundle);
                } else {
                    for (var i = 0; i < contactNodes.length; i++) {
                        var docNode = contactNodes[i];
                        var currentContactFN = docNode.get("contFN");
                        if (currentContactFN.toString().equals(contFN.toString())) {
                            isExistSameContact = true;
                            service.showNextCustomMessage(com.selectica.user.messages.MsgTypeEnum.ERROR, contactExistMessage, contactExistMessage, "", bundle);
                        }
                    }
                    if (!isExistSameContact) {
                        contactNodes = thisComponent.addNode("ReqCSContacts/");
                        contactNodes.setValue("/contFN", contFN);
                        contactNodes.setValue("/contLN", contLN);
                        contactNodes.save();
                        service.showNextCustomMessage(com.selectica.user.messages.MsgTypeEnum.SUCCESS, successMessage, successMessage, "", bundle);
                    }
                }
                ]]>
     */

    @Override
    public Boolean process() throws Exception {
        RCFBundleWrapper bundleWrapper = getHelper().getCurrentBundleWrapper();
        CSDetails info = getHelper().getInfoComponentStub();
        String contractName = info.getName();
        List<CSContacts> contacts = getHelper().getNodesStubs("ReqCSContacts");

        String viewComponentLink = RCFServiceAPI.getInstance().getViewInfoComponentComponentLink(bundleWrapper);

        String contactExistMessage = "Same Contact is exist";
        String successMessage = "Current user has been added as a contact for Sales contract [URLLink link = \"" + viewComponentLink + "\"]" + contractName + "[URLLink]";

        boolean isExistSameContact = false;
        String firstName = getHelper().getRCFUserWrapper().getFirstName();
        String lastName = getHelper().getRCFUserWrapper().getLastName();
        if (contacts.isEmpty()) {
            CSContacts contact = getHelper().addNewComponent("ReqCSContacts");
            contact.setContFN(firstName);
            contact.setContLN(lastName);
            getHelper().saveComponent(contact);
            RCFServiceAPI.getInstance().showCustomMessage(MsgTypeEnum.SUCCESS, successMessage, successMessage, "", bundleWrapper);
        } else {
            for (CSContacts contact : contacts) {
                String currentContactFN = contact.getContFN();
                String currentContactLN = contact.getContLN();
                if (firstName.equals(currentContactFN) && lastName.equals(currentContactLN)) {
                    isExistSameContact = true;
                    RCFServiceAPI.getInstance().showCustomMessage(MsgTypeEnum.ERROR, contactExistMessage, contactExistMessage, "", bundleWrapper);
                }
            }
            if (!isExistSameContact) {
                CSContacts contact = getHelper().addNewComponent("ReqCSContacts");
                contact.setContFN(firstName);
                contact.setContLN(lastName);
                getHelper().saveComponent(contact);
                RCFServiceAPI.getInstance().showCustomMessage(MsgTypeEnum.SUCCESS, successMessage, successMessage, "", bundleWrapper);
            }
        }
        return true;
    }
}

