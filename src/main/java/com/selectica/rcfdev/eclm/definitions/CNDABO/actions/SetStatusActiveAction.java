package com.selectica.rcfdev.eclm.definitions.CNDABO.actions;

import com.selectica.rcfdev.eclm.definitions.ContractStatus;
import com.selectica.rcfdev.stubs.CNDADetails;
import com.selectica.rcfscripts.AbstractBOWriteScript;

/**
 * Created by vshilkin on 24/12/2014.
 */
public class SetStatusActiveAction extends AbstractBOWriteScript<Boolean> {
    /*
                thisComponent.setValue("CNDAData/ReqCNDADetails/contractStatus", "Executed");
                thisComponent.save();
     */
    @Override
    public Boolean process() throws Exception {
        CNDADetails info = getHelper().getInfoComponentStub();
        info.setContractStatus(ContractStatus.EXECUTED.getStatus());
        return getHelper().saveComponent(info);
    }
}
