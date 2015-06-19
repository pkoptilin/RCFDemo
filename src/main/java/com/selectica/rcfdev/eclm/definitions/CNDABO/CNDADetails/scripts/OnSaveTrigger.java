package com.selectica.rcfdev.eclm.definitions.CNDABO.CNDADetails.scripts;

import com.selectica.rcfdev.eclm.definitions.ContractStatus;
import com.selectica.rcfdev.stubs.CNDADetails;
import com.selectica.System.stubs.ContractStats;
import com.selectica.rcfscripts.AbstractDataWriteScript;
import com.selectica.rcfutils.RCFBundleServiceHelper;
import com.selectica.rcfutils.RCFBundleWrapper;
import com.selectica.rcfutils.RCFServiceAPI;
import com.selectica.rcfutils.RCFUserWrapper;

import java.util.Date;

/**
 * Created by vshilkin on 20/01/2015.
 */
public class OnSaveTrigger extends AbstractDataWriteScript<Boolean> {
    /*
            <![CDATA[
                if (thisComponent.isNew()) {
                   //executes only once when record stores after creation/copy/amen/addsub
                   //COPY case processed in InfoComponent copyScript
                    var parentName;
                    var parentObj;
                    var parent;
                    var msg;
                    var trackNo;
                    //always get contractTypeName for English Locale (naming rules have not be changed with Locale of logged in user)
                    var curName = thisComponent.getLocalizedString("contractTypeName", java.util.Locale.ENGLISH) + thisComponent.getParameterValueObject("trackingNumber");

                    var event = String(thisComponent.getValue("bundleCreationWfEvent"));

                    if (event != "WFAmendmentActivation") {//when Amendment activated we should not create a new record
                        var mySummary = thisComponent.addNode("ReqContractStats/");
                        if (mySummary != null) {
                            var today = new Packages.java.util.Date();
                            var dateString = Packages.com.selectica.tools.Validator.createYYYYMMDDHHMMSSStringFromDate(today);
                            mySummary.setValue("/contStartTime", dateString, false);
                            mySummary.setValue("/lastAssembleStartTime", dateString, false);
                            mySummary.setValue("/noAssemble", "1", false);
                            mySummary.save();
                        }
                        thisComponent.setValue("/contractStatus", "Draft", false);
                    }
                    if (event == "TaskAuthAmendWF") {
                        parent = thisComponent.getValue("parentContractID/internal");
                        if (parent != null) {
                            parentObj = user.getBundleForTrackingNumber(parent);;
                            if (parentObj != null) {
                                parentName = String(parentObj.get("name"));
                            }
                        }
                        thisComponent.setValue("/name", parentName, false);
                    } else if (event == "RelatedWFCreate") {
                        parent = thisComponent.getValue("parentContractID/internal");
                        parentObj = user.getBundleForTrackingNumber(parent);;
                        trackNo = "" + thisComponent.getParameterValueObject("trackingNumber");
                        if (curName.indexOf(trackNo) < 0) {
                            curName = curName + " (" + trackNo + ")";
                        }
                        msg = user.getLocalizedString("wf.create.sub.name");
                        parentName = String(parentObj.get("name"));
                        var index = Number(parentName.indexOf(msg));
                        if (index > 1) {
                            parentName = parentName.substring(0, index - 1);
                        }
                        thisComponent.setValue("/name", curName + " " + msg + " " + parentName);
                    } else {
                        thisComponent.setValue("/name", curName, false);
                        thisComponent.setValue("/contractStatus", "Draft", false);
                      }
                }
                if(typeof currentEvent != 'undefined' && currentEvent == "TaskWFChangeParent"){
                        //always get contractTypeName for English Locale (naming rules have not be changed with Locale of logged in user)
                        var curName = thisComponent.getLocalizedString("contractTypeName", java.util.Locale.ENGLISH) + thisComponent.getParameterValueObject("trackingNumber");
                        parent = thisComponent.getValue("parentContractID/internal");
                        if(parent == ""){
                            thisComponent.setValue("/name", curName);
                        } else {
                            parentObj = user.getBundleForTrackingNumber(parent);;
                            trackNo = "" + thisComponent.getParameterValueObject("trackingNumber");
                            if (curName.indexOf(trackNo) < 0) {
                                curName = curName + " (" + trackNo + ")";
                            }
                            msg = user.getLocalizedString("wf.create.sub.name");
                            parentName = String(parentObj.get("name"));
                            var index = Number(parentName.indexOf(msg));
                            if (index > 1) {
                                parentName = parentName.substring(0, index - 1);
                            }
                            thisComponent.setValue("/name", curName + " " + msg + " " + parentName);
                        }
                }
            ]]>
     */

    @Override
    public Boolean process() throws Exception {
        CNDADetails info = getHelper().getCurrentComponentStub();
        RCFUserWrapper userWrapper = getHelper().getRCFUserWrapper();
        if (getHelper().isCurrentComponentNew()) {
            String event = info.getBundleCreationWfEvent();

            String curName = getHelper().getComponentDefinitionHelper(info).getLocalizedString("contractTypeName")
                    + String.valueOf(info.getTrackingNumber());
            if (!"WFAmendmentActivation".equals(event)) {//when Amendment activated we should not create a new record
                ContractStats stats = getHelper().addNewComponent("ReqContractStats");
                stats.setContStartTime(new Date());
                stats.setLastAssembleStartTime(new Date());
                stats.setNoAssemble(1);
                info.setContractStatus(ContractStatus.DRAFT.getStatus());
            }
            if ("TaskAuthAmendWF".equals(event)) {
                Integer parent = info.getParentContractID();
                if (parent != null) {
                    RCFBundleWrapper bundleWrapper = RCFBundleServiceHelper.getInstance().getBundleByTrackingNumber(parent, userWrapper);
                    if (bundleWrapper != null) {
                        CNDADetails parentInfo = getHelper().getInfoComponentStubForBundle(bundleWrapper);
                        String parentName = parentInfo.getName();
                        info.setName(parentName);
                    }
                }
            } else if ("RelatedWFCreate".equals(event)) {
                Integer parent = info.getParentContractID();
                if (parent != null) {
                    RCFBundleWrapper bundleWrapper = RCFBundleServiceHelper.getInstance().getBundleByTrackingNumber(parent, userWrapper);
                    if (bundleWrapper != null) {
                        Integer trackingNumber = info.getTrackingNumber();
                        if (!curName.contains(String.valueOf(trackingNumber))) {
                            curName = curName + "( " + trackingNumber + " )";
                        }
                        String msg = RCFServiceAPI.getInstance().getLocalizedString("wf.create.sub.name", userWrapper);

                        CNDADetails parentInfo = getHelper().getInfoComponentStubForBundle(bundleWrapper);
                        String parentName = parentInfo.getName();
                        int index = parentName.indexOf(msg);
                        if (index > 1) {
                            parentName = parentName.substring(0, index - 1);
                        }
                        info.setName(curName + " " + msg + " " + parentName);
                    }
                }
            } else {
                info.setContractStatus(ContractStatus.DRAFT.getStatus());
                info.setName(curName);
            }
        }

        String currentEvent = getHelper().getCurrentEventVariable();
        if (currentEvent != null && "TaskWFChangeParent".equals(currentEvent)) {
            String curName = getHelper().getComponentDefinitionHelper(info).getLocalizedString("contractTypeName")
                    + String.valueOf(info.getTrackingNumber());

            Integer parent = info.getParentContractID();
            if (parent == null || parent == 0) {
                info.setName(curName);
            } else {
                RCFBundleWrapper bundleWrapper = RCFBundleServiceHelper.getInstance().getBundleByTrackingNumber(parent, userWrapper);
                if (bundleWrapper != null) {
                    Integer trackingNumber = info.getTrackingNumber();
                    if (!curName.contains(String.valueOf(trackingNumber))) {
                        curName = curName + "( " + trackingNumber + " )";
                    }
                    String msg = RCFServiceAPI.getInstance().getLocalizedString("wf.create.sub.name", userWrapper);

                    CNDADetails parentInfo = getHelper().getInfoComponentStubForBundle(bundleWrapper);
                    String parentName = parentInfo.getName();
                    int index = parentName.indexOf(msg);
                    if (index > 1) {
                        parentName = parentName.substring(0, index - 1);
                    }
                    info.setName(curName + " " + msg + " " + parentName);
                }
            }
        }
        return true;
    }
}


