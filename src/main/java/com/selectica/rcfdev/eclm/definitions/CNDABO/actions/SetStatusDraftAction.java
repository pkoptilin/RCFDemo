package com.selectica.rcfdev.eclm.definitions.CNDABO.actions;

import com.selectica.rcfdev.eclm.definitions.ContractStatus;
import com.selectica.rcfdev.stubs.CNDADetails;
import com.selectica.rcfscripts.AbstractBOWriteScript;

/**
 * Created by vshilkin on 09/01/2015.
 */
public class SetStatusDraftAction extends AbstractBOWriteScript<Boolean> {
    /*
                thisComponent.setValue("CNDABO/ReqCNDADetails/contractStatus","Draft");
                thisComponent.save();
     */
    @Override
    public Boolean process() throws Exception {
        CNDADetails info = getHelper().getInfoComponentStub();
        info.setContractStatus(ContractStatus.DRAFT.getStatus());
        return getHelper().saveComponent(info);
    }
}
