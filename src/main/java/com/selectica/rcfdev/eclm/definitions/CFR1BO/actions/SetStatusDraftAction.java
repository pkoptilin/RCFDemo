package com.selectica.rcfdev.eclm.definitions.CFR1BO.actions;

import com.selectica.rcfdev.eclm.definitions.ContractStatus;
import com.selectica.rcfdev.stubs.CFR1Details;
import com.selectica.rcfscripts.AbstractBOWriteScript;

/**
 * Created by vshilkin on 08/01/2015.
 */
public class SetStatusDraftAction extends AbstractBOWriteScript<Boolean> {
    /*
                thisComponent.setValue("CFR1Data/ReqCFR1Details/contractStatus","Draft");
                thisComponent.save();
     */
    @Override
    public Boolean process() throws Exception {
        CFR1Details info = getHelper().getInfoComponentStub();
        info.setContractStatus(ContractStatus.DRAFT.getStatus());
        return getHelper().saveComponent(info);
    }
}
