package com.selectica.rcfdev.eclm.definitions.shared.actions;

import com.selectica.System.stubs.ContractStats;
import com.selectica.rcfscripts.AbstractBOWriteScript;

import java.util.Date;

/**
 * Created by vshilkin on 24/12/2014.
 */
public class SetLastManageDateAction extends AbstractBOWriteScript<Boolean> {
    /*
                <![CDATA[
					var bp = thisComponent.getBundleProxy();
					var today = new Packages.java.util.Date();
					var dateString = Packages.com.selectica.tools.Validator.createYYYYMMDDHHMMSSStringFromDate(today);
					thisComponent.setValue("CProcData/ReqContractStats/lastManageStartTime",dateString);

					var num = thisComponent.getBundleProxy().getParameterValueObjectFromAnyComponent("ReqContractStats","noManage");
					num++;
					thisComponent.setValue("CProcData/ReqContractStats/noManage",Packages.java.lang.Integer.toString(num));

					var contStartTime = thisComponent.getBundleProxy().getParameterValueObjectFromAnyComponent("ReqContractStats","contStartTime");
					if (contStartTime != null) {
						var today1 = new Packages.java.util.GregorianCalendar();
						var z = today1.getTimeInMillis() - contStartTime.getTimeInMillis();
						var totalTime = z/86400000;
						thisComponent.setValue("CProcData/ReqContractStats/elapsedContractCycleTime",totalTime);
					}
					thisComponent.save();
				]]>
     */
    @Override
    public Boolean process() throws Exception {
        ContractStats contractStats = getHelper().getComponentStub("ReqContractStats");

        contractStats.setLastManageStartTime(new Date());

        Integer num = contractStats.getNoManage();
        if (num == null) {
            num = 0;
        }
        num++;
        contractStats.setNoManage(num);

        Date contStartTime = contractStats.getContStartTime();
        if (contStartTime != null) {
            double total = (new Date().getTime() - contStartTime.getTime()) / 86400000;
            contractStats.setElapsedContractCycleTime(total);
        }

        return getHelper().saveComponent(contractStats);
    }
}
