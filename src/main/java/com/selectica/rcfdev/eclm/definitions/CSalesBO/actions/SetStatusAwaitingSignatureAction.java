package com.selectica.rcfdev.eclm.definitions.CSalesBO.actions;

import com.selectica.rcfdev.eclm.definitions.ContractStatus;
import com.selectica.rcfdev.stubs.CSDetails;
import com.selectica.rcfscripts.AbstractBOWriteScript;

/**
 * Created by vshilkin on 08/01/2015.
 */
public class SetStatusAwaitingSignatureAction extends AbstractBOWriteScript<Boolean> {
    /*
                thisComponent.setValue("CSalesData/ReqCSalesDetails/contractStatus", "Awaiting Signature");
                thisComponent.save();
     */
    @Override
    public Boolean process() throws Exception {
        CSDetails info = getHelper().getInfoComponentStub();
        info.setContractStatus(ContractStatus.AWAITING_SIGNATURE.getStatus());
        return getHelper().saveComponent(info);
    }
}
