package com.selectica.rcfdev.eclm.definitions.CGenBO.CGenDetails.scripts;

import com.selectica.rcfdev.stubs.CGenDetails;
import com.selectica.rcfscripts.AbstractDataWriteScript;
import com.selectica.rcfutils.RCFServiceAPI;

/**
 * Created by vshilkin on 30/12/2014.
 */
public class OnChangeAgrTypeTrigger extends AbstractDataWriteScript<Boolean> {
    /*
                if (!service.isImport(root.getValue("user")) && !service.isWSCall()) {
                thisComponent.setValue("/cpName", "", false);
                thisComponent.setValue("/cpAdr1", "", false);
                thisComponent.setValue("/cpAdr2", "", false);
                thisComponent.setValue("/cpCity", "", false);
                thisComponent.setValue("/cpState", "", false);
                thisComponent.setValue("/cpZip", "", false);
                thisComponent.setValue("/cpCtry", "", false);

                var category = thisComponent.getParameterValueObject("agrType");
                var refValue;
                if(category == "Sales") refValue = "BundleDef:/DCustomerBO/";
                else if (category == "Procurement") refValue = "BundleDef:/DVendorBO/";
                else if (category == "NDA") refValue = "BundleDef:/DCPBO/";
                else if (category == "Real Estate/Lease") refValue = "BundleDef:/DLLBO/";
                else if (category == "Employment") refValue = "BundleDef:/DCPBO/";
                else if (category == "Physician") refValue = "BundleDef:/DPhyBO/";
                else refValue = "BundleDef:/DCPBO/";

                thisComponent.setValue("/cpNamegencpNameList", ""+refValue, false);

            }

     */

    @Override
    public Boolean process() throws Exception {
        if (!RCFServiceAPI.getInstance().isImport(getHelper().getRCFUserWrapper()) && !RCFServiceAPI.getInstance().isWSCall()) {
            CGenDetails details = getHelper().getCurrentComponentStub();
            details.setCpName(null);
            details.setCpAdr1(null);
            details.setCpAdr2(null);
            details.setCpCity(null);
            details.setCpState(null);
            details.setCpZip(null);
            details.setCpCtry(null);
        }

        return true;
    }
}
