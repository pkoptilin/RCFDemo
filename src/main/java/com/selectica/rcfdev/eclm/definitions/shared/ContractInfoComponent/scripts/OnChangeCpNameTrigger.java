package com.selectica.rcfdev.eclm.definitions.shared.ContractInfoComponent.scripts;

import com.selectica.rcfdev.stubs.ContractInfoComponent;
import com.selectica.rcfdev.stubs.DirectoryInfoComponent;
import com.selectica.rcfscripts.AbstractDataWriteScript;
import com.selectica.rcfutils.RCFBundleServiceHelper;
import com.selectica.rcfutils.RCFBundleWrapper;
import com.selectica.rcfutils.RCFUserWrapper;

/**
 * Created by vshilkin on 21.04.2015.
 */
public class OnChangeCpNameTrigger extends AbstractDataWriteScript<Boolean> {

    /*

                <![CDATA[
            <![CDATA[
            var cp = thisComponent.getParameterValueObject("cpName");
            if (cp != "") {
                var b = user.getBundleForTrackingNumber(cp);
                var s = b.getInfoValueObject("dirStatus").toString();
                if (s.equals("Active")) {
                    var a1 = b.getInfoValueObject("dirAdr1");
                    var a2 = b.getInfoValueObject("dirAdr2");
                    var c = b.getInfoValueObject("dirCity");
                    var s = b.getInfoComponentParam("dirState").getDisplayValue();
                    var z = b.getInfoValueObject("dirZip");
                    var ct = b.getInfoComponentParam("dirCountry").getDisplayValue();
                    thisComponent.setValue("/cpAdr1", a1, false);
                    thisComponent.setValue("/cpAdr2", a2, false);
                    thisComponent.setValue("/cpCity", c, false);
                    thisComponent.setValue("/cpState", s, false);
                    thisComponent.setValue("/cpCtry", ct, false);
                    thisComponent.setValue("/cpZip", z, false);
                }
            }
            ]]>
            ]]>

     */


    @Override
    public Boolean process() throws Exception {
        ContractInfoComponent infoComponent = getHelper().getCurrentComponentStub();
        String cpName = infoComponent.getCpName();
        if (cpName != null && !cpName.isEmpty()) {
            RCFUserWrapper userWrapper = getHelper().getRCFUserWrapper();
            RCFBundleServiceHelper serviceHelper = RCFBundleServiceHelper.getInstance();
            RCFBundleWrapper bundleWrapper = serviceHelper.getBundleByTrackingNumber(Integer.valueOf(cpName), userWrapper);
            if (bundleWrapper != null) {
                DirectoryInfoComponent directoryInfo = getHelper().getInfoComponentStubForBundle(bundleWrapper);
                infoComponent.setCpAdr1(directoryInfo.getDirAdr1());
                infoComponent.setCpAdr2(directoryInfo.getDirAdr2());
                infoComponent.setCpCity(directoryInfo.getDirCity());
                infoComponent.setCpState(directoryInfo.getDirState());
                infoComponent.setCpCtry(directoryInfo.getDirCountry());
                infoComponent.setCpZip(directoryInfo.getDirZip());
            }
        }
        return true;
    }
}






