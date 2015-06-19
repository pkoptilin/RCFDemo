package com.selectica.rcfdev.eclm.definitions.shared.actions;

import com.selectica.System.stubs.ContractStats;
import com.selectica.rcfscripts.AbstractBOWriteScript;

import java.util.Date;

/**
 * Created by vshilkin on 24/12/2014.
 */
public class SetLastCollaborateDateAction extends AbstractBOWriteScript<Boolean> {
    /*
                <![CDATA[
					var today = new Packages.java.util.Date();
					var dateString = Packages.com.selectica.tools.Validator.createYYYYMMDDHHMMSSStringFromDate(today);
					thisComponent.setValue("CProcData/ReqContractStats/lastCollaborateStartTime",dateString);

					var num = thisComponent.getBundleProxy().getParameterValueObjectFromAnyComponent("ReqContractStats","noCollaborate");
					num++;
					thisComponent.setValue("CProcData/ReqContractStats/noCollaborate",Packages.java.lang.Integer.toString(num));
					thisComponent.save();
				]]>
     */
    @Override
    public Boolean process() throws Exception {
        ContractStats contractStats = getHelper().getComponentStub("ReqContractStats");

        contractStats.setLastCollaborateStartTime(new Date());

        Integer num = contractStats.getNoCollaborate();
        if (num == null) {
            num = 0;
        }
        num++;
        contractStats.setNoCollaborate(num);

        return getHelper().saveComponent(contractStats);
    }
}
