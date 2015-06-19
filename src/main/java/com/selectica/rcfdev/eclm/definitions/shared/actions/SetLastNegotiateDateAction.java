package com.selectica.rcfdev.eclm.definitions.shared.actions;

import com.selectica.System.stubs.ContractStats;
import com.selectica.rcfscripts.AbstractBOWriteScript;

import java.util.Date;

/**
 * Created by vshilkin on 24/12/2014.
 */
public class SetLastNegotiateDateAction extends AbstractBOWriteScript<Boolean> {
    /*
                <![CDATA[
					thisComponent.setValue("CProcData/ReqCNHBasicReq/contractStatus","In Negotiations");
					var today = new Packages.java.util.Date();
					var dateString = Packages.com.selectica.tools.Validator.createYYYYMMDDHHMMSSStringFromDate(today);
					thisComponent.setValue("CProcData/ReqContractStats/lastNegotiateStartTime",dateString);

					var num = thisComponent.getBundleProxy().getParameterValueObjectFromAnyComponent("ReqContractStats","noNegotiate");
					num++;
					thisComponent.setValue("CProcData/ReqContractStats/noNegotiate",Packages.java.lang.Integer.toString(num));
					thisComponent.save();
				]]>
     */
    @Override
    public Boolean process() throws Exception {
        ContractStats contractStats = getHelper().getComponentStub("ReqContractStats");

        contractStats.setLastNegotiateStartTime(new Date());

        Integer num = contractStats.getNoNegotiate();
        if (num == null) {
            num = 0;
        }
        num++;
        contractStats.setNoNegotiate(num);

        return getHelper().saveComponent(contractStats);
    }
}
