package com.selectica.rcfdev.eclm.definitions.shared.actions;

import com.selectica.System.stubs.ContractStats;
import com.selectica.rcfscripts.AbstractBOWriteScript;

import java.util.Date;

/**
 * Created by vshilkin on 24/12/2014.
 */
public class ComputeCollaborateElapsedTimeAction extends AbstractBOWriteScript<Boolean> {
    /*
                <![CDATA[
					var bp = thisComponent.getBundleProxy();
					var elapsedTime= bp.getParameterValueObjectFromAnyComponent("ReqContractStats","elapsedCollaborateTime");
					var elapsedContractCycleTime = bp.getParameterValueObjectFromAnyComponent("ReqContractStats","elapsedContractCycleTime");
					var startTime = bp.getParameterValueObjectFromAnyComponent("ReqContractStats","lastCollaborateStartTime");
					var today = new Packages.java.util.GregorianCalendar();
					var z = today.getTimeInMillis() - startTime.getTimeInMillis();
					var hour = z/86400000;
					var totalTime = Number(elapsedTime) + Number(hour);
                    var totalTime1 = Number(elapsedContractCycleTime) +  Number(hour);
					thisComponent.setValue("CProcData/ReqContractStats/elapsedCollaborateTime",totalTime);
					thisComponent.setValue("CProcData/ReqContractStats/elapsedContractCycleTime",totalTime1);
					thisComponent.save();
				]]>
     */
    @Override
    public Boolean process() throws Exception {
        Date today = new Date();

        ContractStats contractStats = getHelper().getComponentStub("ReqContractStats");

        Double elapsedTime = contractStats.getElapsedCollaborateTime();
        if (elapsedTime == null) {
            elapsedTime = 0d;
        }
        Double elapsedContractCycleTime = contractStats.getElapsedContractCycleTime();
        if (elapsedContractCycleTime == null) {
            elapsedContractCycleTime = 0d;
        }

        Date startTime = contractStats.getLastNegotiateStartTime();
        Date start;
        if (startTime != null) {
            start = startTime;
        } else {
            start = new Date();
        }

        long z = today.getTime() - start.getTime();
        double hour = z / 86400000;
        double totalReqTime = elapsedTime + hour;
        double totalCycleTime = elapsedContractCycleTime + hour;

        contractStats.setElapsedCollaborateTime(totalReqTime);
        contractStats.setElapsedContractCycleTime(totalCycleTime);

        return getHelper().saveComponent(contractStats);
    }
}

