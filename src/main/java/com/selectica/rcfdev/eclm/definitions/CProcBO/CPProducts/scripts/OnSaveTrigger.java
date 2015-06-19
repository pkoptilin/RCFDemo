package com.selectica.rcfdev.eclm.definitions.CProcBO.CPProducts.scripts;

import com.selectica.rcfdev.stubs.CPDetails;
import com.selectica.rcfdev.stubs.CPProducts;
import com.selectica.rcfdev.stubs.CPServices;
import com.selectica.rcfscripts.AbstractDataWriteScript;

import java.util.List;

/**
 * Created by vshilkin on 24/12/2014.
 */
public class OnSaveTrigger extends AbstractDataWriteScript<Boolean> {

    /*
            <![CDATA[
            var bp = thisComponent.getBundleProxy();
            var agrCat = bp.getInfoValueObject("agrCat");
            var prdTAmt = 0;
            var serTAmt = 0;
            var totAmt = 0;
            var prdNodes = bp.getMulticardComponentsByName("ReqCPProducts");
            if (prdNodes != null && agrCat.toString().contains("Product")) {
                for (var i = 0; i < prdNodes.length; i++) {
                    var prdNode = prdNodes[i];
                    var st = prdNode.get("prdSubTotal").getDouble();
                    prdTAmt = prdTAmt + Number(st);
                    totAmt = totAmt + Number(st);
                }
            }
            thisComponent.setValue("CProcData/ReqCProcDetails/prdTotal", prdTAmt);

            var serNodes = bp.getMulticardComponentsByName("ReqCPServices");
            if (serNodes != null && agrCat.toString().contains("Service")) {
                for (var i = 0; i < serNodes.length; i++) {
                    var serNode = serNodes[i];
                    var st = serNode.get("serSubTotal").getDouble();
                    serTAmt = serTAmt + Number(st);
                    totAmt = totAmt + Number(st);
                }
            }
            thisComponent.setValue("CProcData/ReqCProcDetails/serTotal", serTAmt);

            thisComponent.setValue("CProcData/ReqCProcDetails/totalAmt", totAmt);
            ]]>
     */
    @Override
    public Boolean process() throws Exception {
        CPDetails info = getHelper().getInfoComponentStub();
        String agrCat = info.getAgrCat();

        double productsTotalAmt = 0d;
        double servicesTotalAmt = 0d;
        double totalAmt = 0d;

        List<CPProducts> products = getHelper().getNodesStubs("ReqCPProducts");
        if(agrCat.contains("Product")){
            for(CPProducts product: products){
                Double sub = product.getPrdSubTotal();
                if(sub != null){
                    productsTotalAmt += sub;
                    totalAmt += sub;
                }
            }
        }

        List<CPServices> services = getHelper().getNodesStubs("ReqCPServices");
        if(agrCat.contains("Service")){
            for(CPServices service: services){
                Double sub = service.getSerSubTotal();
                if(sub != null){
                    servicesTotalAmt += sub;
                    totalAmt += sub;
                }
            }
        }

        info.setPrdTotal(productsTotalAmt);
        info.setSerTotal(servicesTotalAmt);
        info.setTotalAmt(totalAmt);

        return true;
    }
}

