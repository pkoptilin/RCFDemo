package com.selectica.rcfdev.eclm.definitions.shared.actions;

import com.selectica.System.stubs.ContractStats;
import com.selectica.rcfscripts.AbstractBOWriteScript;

import java.util.Date;

/**
 * Created by vshilkin on 24/12/2014.
 */
public class SetLastAssembleDateAction extends AbstractBOWriteScript<Boolean> {
    /*
                    <![CDATA[
					//Compute Assemble date
					try {
						var today = new Packages.java.util.Date();
						var dateString = Packages.com.selectica.tools.Validator.createYYYYMMDDHHMMSSStringFromDate(today);
						thisComponent.setValue("CProcData/ReqContractStats/lastAssembleStartTime",dateString);

						var num = thisComponent.getBundleProxy().getParameterValueObjectFromAnyComponent("ReqContractStats","noAssemble");
						num++;
						thisComponent.setValue("CProcData/ReqContractStats/noAssemble",Packages.java.lang.Integer.toString(num));
						thisComponent.save();
					}
					catch(e) {
						out.println("Error in SetLastAssembleDate Compute Assemble date " + e);
					}
				]]>

     */
    @Override
    public Boolean process() throws Exception {
        ContractStats contractStats = getHelper().getComponentStub("ReqContractStats");

        contractStats.setLastAssembleStartTime(new Date());
        Integer num = contractStats.getNoAssemble();
        if (num == null) {
            num = 0;
        }
        num++;
        contractStats.setNoAssemble(num);

        return getHelper().saveComponent(contractStats);
    }
}
