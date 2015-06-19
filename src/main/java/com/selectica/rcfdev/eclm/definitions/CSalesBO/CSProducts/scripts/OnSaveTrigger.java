package com.selectica.rcfdev.eclm.definitions.CSalesBO.CSProducts.scripts;

import com.selectica.rcfdev.stubs.CSDetails;
import com.selectica.rcfdev.stubs.CSProducts;
import com.selectica.rcfdev.stubs.CSServices;
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
            var prdNodes = bp.getMulticardComponentsByName("ReqCSProducts");
            if (prdNodes != null && agrCat.toString().contains("Product")) {
                for (var i = 0; i < prdNodes.length; i++) {
                    var prdNode = prdNodes[i];
                    var st = prdNode.get("prdSubTotal").getDouble();
                    prdTAmt = prdTAmt + Number(st);
                    totAmt = totAmt + Number(st);
                }
            }
            thisComponent.setValue("CSalesData/ReqCSalesDetails/prdTotal", prdTAmt);

            var serNodes = bp.getMulticardComponentsByName("ReqCSServices");
            if (serNodes != null && agrCat.toString().contains("Service")) {
                for (var i = 0; i < serNodes.length; i++) {
                    var serNode = serNodes[i];
                    var st = serNode.get("serSubTotal").getDouble();
                    serTAmt = serTAmt + Number(st);
                    totAmt = totAmt + Number(st);
                }
            }
            thisComponent.setValue("CSalesData/ReqCSalesDetails/serTotal", serTAmt);

            thisComponent.setValue("CSalesData/ReqCSalesDetails/totalAmt", totAmt);
            ]]>
     */
    @Override
    public Boolean process() throws Exception {
        CSDetails info = getHelper().getInfoComponentStub();
        String agrCat = info.getAgrCat();

        double productsTotalAmt = 0d;
        double servicesTotalAmt = 0d;
        double totalAmt = 0d;

        List<CSProducts> products = getHelper().getNodesStubs("ReqCSProducts");
        if (agrCat.contains("Product")) {
            for (CSProducts product : products) {
                Double sub = product.getPrdSubTotal();
                if (sub != null) {
                    productsTotalAmt += sub;
                    totalAmt += sub;
                }
            }
        }

        List<CSServices> services = getHelper().getNodesStubs("ReqCSServices");
        if (agrCat.contains("Service")) {
            for (CSServices service : services) {
                Double sub = service.getSerSubTotal();
                if (sub != null) {
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

