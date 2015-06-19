package com.selectica.rcfdev.eclm.definitions.shared.ContractInfoComponent.scripts;

import com.selectica.rcfdev.stubs.ContractInfoComponent;
import com.selectica.rcfscripts.AbstractDataWriteScript;

/**
 * Created by vshilkin on 22.04.2015.
 */
public class OnCopyTrigger extends AbstractDataWriteScript<Boolean> {
        /*
            <![CDATA[
                    var status = thisComponent.getParameterValueObject("contractStatus");
                      targetComponent.setValue("/parentContractID", ""); //broke parent-sub connection in case when source was sub contract
                    var usageType = thisBundle.getBundleDefinitionAttribute("usageType");
                    var statusType = "/contractStatus";
            		var name = thisComponent.getParameterValueObject("name");
                    msg = user.getLocalizedString("wf.create.copy.name");
                    var isContractStatusUsed = true;
                    if (usageType != "Contract") {
                        targetComponent.setValue("/name", msg + " " + name);
                    }
                     if (usageType == "NonContract" && status == null) {
                        status = thisComponent.getParameterValueObject("ClauseStatus");
                        statusType = "/ClauseStatus";
                         //set the Unique Name of The Clause's Copy
                         var userEntity = root.getValue('/user');
                         var uName = service.getUniqueID(userEntity);
                         targetComponent.setValue("/shortName", ""+uName, false);
                         isContractStatusUsed = false;
                     }

                    if (status != null) {
                            targetComponent.setValue(statusType, (!isContractStatusUsed || usageType == "TemplateManager") ?
                                Packages.com.selectica.BaseStatus.DOCUMENT_STATE_DRAFT : Packages.com.selectica.BaseStatus.CONTRACT_STATUS_DRAFT);
                    }
        	]]>
     */

    @Override
    public Boolean process() throws Exception {
        ContractInfoComponent info = getHelper().getTargetComponentStub();
        info.setParentContractID(null);
        info.setContractStatus("Draft");
        return true;
    }
}


