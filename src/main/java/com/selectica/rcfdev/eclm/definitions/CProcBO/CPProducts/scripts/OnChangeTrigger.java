package com.selectica.rcfdev.eclm.definitions.CProcBO.CPProducts.scripts;

import com.selectica.rcfdev.stubs.CPProducts;
import com.selectica.rcfscripts.AbstractDataWriteScript;

/**
 * Created by vshilkin on 24/12/2014.
 */
public class OnChangeTrigger extends AbstractDataWriteScript<Boolean> {

    /*
                <![CDATA[
            var Qty = thisComponent.getParameterValueObject("prdQty");
            if (Number(Qty) > 0 && Qty != "") {
                var prdPricePU = thisComponent.getParameterValueObject("prdPricePU");
                if (Number(prdPricePU) > 0 && prdPricePU != null) {
                    var amt = Number(Qty) * Number(prdPricePU);
                    var prdDiscount = thisComponent.getParameterValueObject("prdDiscount");
                    if (prdDiscount == "") prdDiscount = 0;
                    var disAmt = (100 - Number(prdDiscount)) * .01;
                    amt = amt * disAmt;
                    thisComponent.setValue("/prdSubTotal", amt, false);
                }
                else {
                    thisComponent.setValue("/prdSubTotal", "0.00", false);
                }
            }
            else {
                thisComponent.setValue("/prdSubTotal", "0.00", false);
            }
            ]]>

     */
    @Override
    public Boolean process() throws Exception {
        CPProducts product = getHelper().getCurrentComponentStub();
        Integer qty = product.getPrdQty();
        if (qty != null && qty > 0) {
            Double pricePU = product.getPrdPricePU();
            if (pricePU != null && pricePU > 0d) {
                double amt = qty * pricePU;
                Integer discount = product.getPrdDiscount();
                if (discount == null) {
                    discount = 0;
                }
                double discountAmt = (100 - discount) * 0.01d;
                amt = amt * discountAmt;
                product.setPrdSubTotal(amt);
            } else {
                product.setPrdSubTotal(0d);
            }
        } else {
            product.setPrdSubTotal(0d);
        }
        return true;
    }
}
