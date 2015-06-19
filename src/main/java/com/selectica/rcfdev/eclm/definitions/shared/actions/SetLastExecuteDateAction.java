package com.selectica.rcfdev.eclm.definitions.shared.actions;

import com.selectica.System.stubs.ContractStats;
import com.selectica.rcfscripts.AbstractBOWriteScript;

import java.util.Date;

/**
 * Created by vshilkin on 24/12/2014.
 */
public class SetLastExecuteDateAction extends AbstractBOWriteScript<Boolean> {
    /*
                <![CDATA[
					//Set Execute last start date
					try {
						var today = new Packages.java.util.Date();
						var dateString = Packages.com.selectica.tools.Validator.createYYYYMMDDHHMMSSStringFromDate(today);
						thisComponent.setValue("CProcData/ReqContractStats/lastExecuteStartTime",dateString);

						var num = thisComponent.getBundleProxy().getParameterValueObjectFromAnyComponent("ReqContractStats","noExecute");
						num++;
						thisComponent.setValue("CProcData/ReqContractStats/noExecute",Packages.java.lang.Integer.toString(num));
						thisComponent.save();
					}
					catch(e) {
						out.println("Error in SetLastExecuteDate Set Execute last start date " + e);
					}
				]]>
     */
    @Override
    public Boolean process() throws Exception {
        ContractStats contractStats = getHelper().getComponentStub("ReqContractStats");

        contractStats.setLastExecuteStartTime(new Date());

        Integer num = contractStats.getNoExecute();
        if (num == null) {
            num = 0;
        }
        num++;
        contractStats.setNoExecute(num);

        return getHelper().saveComponent(contractStats);
    }
}
