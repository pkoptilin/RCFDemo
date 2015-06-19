package com.selectica.rcfdev.eclm.definitions.CSalesBO.CSServices.scripts;


import com.selectica.rcfdev.stubs.CSServices;
import com.selectica.rcfscripts.AbstractDataWriteScript;

/**
 * Created by vshilkin on 24/12/2014.
 */
public class OnChangeTrigger extends AbstractDataWriteScript<Boolean> {

    /*
            <![CDATA[
            var Qty = thisComponent.getParameterValueObject("serQty");
            if (Number(Qty) > 0 && Qty != "") {
                var serPricePU = thisComponent.getParameterValueObject("serPricePU");
                if (Number(serPricePU) > 0 && serPricePU != null) {
                    var amt = Number(Qty) * Number(serPricePU);
                    var serDiscount = thisComponent.getParameterValueObject("serDiscount");
                    if (serDiscount == "") serDiscount = 0;
                    var disAmt = (100 - Number(serDiscount)) * .01;
                    amt = amt * disAmt;
                    thisComponent.setValue("/serSubTotal", amt, false);
                }
                else {
                    thisComponent.setValue("/serSubTotal", "0.00", false);
                }
            }
            else {
                thisComponent.setValue("/serSubTotal", "0.00", false);
            }
            ]]>
     */
    @Override
    public Boolean process() throws Exception {
        CSServices service = getHelper().getCurrentComponentStub();
        Integer qty = service.getSerQty();
        if (qty != null && qty > 0) {
            Double pricePU = service.getSerPricePU();
            if (pricePU != null && pricePU > 0d) {
                double amt = qty * pricePU;
                Integer discount = service.getSerDiscount();
                if (discount == null) {
                    discount = 0;
                }
                double discountAmt = (100 - discount) * 0.01d;
                amt = amt * discountAmt;
                service.setSerSubTotal(amt);
            } else {
                service.setSerSubTotal(0d);
            }
        } else {
            service.setSerSubTotal(0d);
        }
        return true;
    }
}
