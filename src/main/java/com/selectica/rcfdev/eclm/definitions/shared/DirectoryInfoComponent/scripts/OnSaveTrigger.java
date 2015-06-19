package com.selectica.rcfdev.eclm.definitions.shared.DirectoryInfoComponent.scripts;


import com.selectica.rcfdev.stubs.DirectoryInfoComponent;
import com.selectica.rcfscripts.AbstractDataWriteScript;
import com.selectica.rcfutils.RCFBundleServiceHelper;
import com.selectica.rcfutils.RCFBundleWrapper;
import com.selectica.rcfutils.RCFServiceAPI;
import com.selectica.rcfutils.RCFUserWrapper;

/**
 * Created by vshilkin on 20/01/2015.
 */
public class OnSaveTrigger extends AbstractDataWriteScript<Boolean> {
    /*
            <![CDATA[
                // Sub Directories naming logic
                var event = String(thisComponent.getValue("bundleCreationWfEvent"));
                if ((thisComponent.isNew() && event == "RelatedWFCreate") ||
                                (typeof currentEvent != 'undefined' && currentEvent == "TaskWFChangeParent")){
                    var curName = String(thisComponent.getValue("name"));
                    var msg = user.getLocalizedString("wf.create.sub.name");
                    var index = curName.indexOf(msg);
                    //remove " (TrNumber) Sub of ..." part
                    if(index > 0){
                        curName = curName.substring(0, index - 1);
                    }

                    //update tracking number if it is present
                    var trackNo = "" + thisComponent.getParameterValueObject("trackingNumber");
                    curName = String(curName.replace(new RegExp(" \\(\\d+\\)")," ("+trackNo+")"));
                    //insert trackingNumber if absent
                    if (curName.indexOf(trackNo) < 0) {
                        curName = curName + " (" + trackNo  + ")";
                    }

                    var parent = thisComponent.getValue("parentContractID");
                    if(parent == ""){
                        thisComponent.setValue("/name", curName);
                    } else {
                        var parentObj = root.getValue(parent);
                        var parentName = String(parentObj.get("name"));
                        index = Number(parentName.indexOf(msg));
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
        DirectoryInfoComponent info = getHelper().getCurrentComponentStub();
        String event = info.getBundleCreationWfEvent();
        String currentEvent = getHelper().getCurrentEventVariable();

        if ((getHelper().isCurrentComponentNew() && "RelatedWFCreate".equals(event)) ||
                (currentEvent != null && "TaskWFChangeParent".equals(currentEvent))) {

            String curName = info.getName();
            RCFServiceAPI serviceAPI = RCFServiceAPI.getInstance();
            RCFUserWrapper userWrapper = getHelper().getRCFUserWrapper();
            String msg = serviceAPI.getLocalizedString("wf.create.sub.name", userWrapper);
            int index = curName.indexOf(msg);
            if (index > 1) {
                curName = curName.substring(0, index - 1);
            }
            int trackingNumber = info.getTrackingNumber();
            curName = curName.replaceAll(" \\(\\d+\\)", " (" + trackingNumber + ")");
            //insert trackingNumber if absent
            if (!curName.contains(String.valueOf(trackingNumber))) {
                curName = curName + " (" + trackingNumber + ")";
            }

            Integer parent = info.getParentContractID();
            if (parent == null) {
                info.setName(curName);
            } else {
                RCFBundleWrapper bundleWrapper = RCFBundleServiceHelper.getInstance().getBundleByTrackingNumber(parent, userWrapper);
                if (bundleWrapper != null) {
                    DirectoryInfoComponent parentInfo = getHelper().getInfoComponentStubForBundle(bundleWrapper);
                    String parentName = parentInfo.getName();
                    int ind = parentName.indexOf(msg);
                    if (ind > 1) {
                        parentName = parentName.substring(0, ind - 1);
                    }
                    info.setName(curName + " " + msg + " " + parentName);
                }
            }
        }
        return true;
    }
}

