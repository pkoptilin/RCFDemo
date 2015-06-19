package com.selectica.rcfdev.eclm.definitions.RREPBO.RRepDetails.scripts;

import com.selectica.rcfdev.eclm.definitions.DirectoryStatus;
import com.selectica.rcfdev.eclm.definitions.RepositoryStatus;
import com.selectica.rcfdev.stubs.DirectoryInfoComponent;
import com.selectica.rcfdev.stubs.RRepDetails;
import com.selectica.rcfscripts.AbstractDataWriteScript;

public class OnCreateTrigger extends AbstractDataWriteScript<Boolean> {

    @Override
    public Boolean process() throws Exception {
        RRepDetails details = getHelper().getCurrentComponentStub();
        DirectoryInfoComponent directoryInfo = getHelper().getInfoComponentStubForRelatedDirectoryBundle();
        if (directoryInfo != null) {
            String status = directoryInfo.getDirStatus();
            if (DirectoryStatus.ACTIVE.getStatus().equals(status)) {
                details.setCpAdr1(directoryInfo.getDirAdr1());
                details.setCpAdr2(directoryInfo.getDirAdr2());
                details.setCpCity(directoryInfo.getDirCity());
                details.setCpState(directoryInfo.getDirState());
                details.setCpZip(directoryInfo.getDirZip());
                details.setCpCtry(directoryInfo.getDirCountry());
                details.setCpName(String.valueOf(directoryInfo.getTrackingNumber()));
            }
        }
        details.setAdditionalInfo("Wrong contract");
        details.setContractStatus(RepositoryStatus.ACTIVE.getStatus());
        return true;
    }
}

