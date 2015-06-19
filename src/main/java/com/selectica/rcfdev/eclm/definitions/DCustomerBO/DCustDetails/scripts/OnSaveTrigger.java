package com.selectica.rcfdev.eclm.definitions.DCustomerBO.DCustDetails.scripts;

import com.selectica.rcfdev.stubs.DCustDBA;
import com.selectica.rcfdev.stubs.DCustDetails;
import com.selectica.rcfscripts.AbstractDataWriteScript;

import java.util.Iterator;
import java.util.List;

/**
 * Created by vshilkin on 21.05.2015.
 */
public class OnSaveTrigger extends AbstractDataWriteScript<Boolean> {
    /*
            <![CDATA[
                var dbaList = thisBundle.getValue("ReqDCustDBA");
                var allKnownNames = '';
                var dbaIt = dbaList.iterator();
                while (dbaIt.hasNext()) {
                    var dbaComp = dbaIt.next();
                    var dbaName = dbaComp.get("dbaName");
                    allKnownNames = allKnownNames + dbaName;
                    if(dbaIt.hasNext()){
                        allKnownNames = allKnownNames + '|';
                    }
                }
                var name = thisComponent.getBundleProxy().getParameterValueObjectFromAnyComponent("ReqDCustDetails", "name");
                if (name != '') {
                    if (allKnownNames != '') {
                        allKnownNames = allKnownNames + '|' + name;
                    } else {
                        allKnownNames = name;
                    }
                }
                thisBundle.setValue("allKnownNames", allKnownNames);
          ]]>
     */

    @Override
    public Boolean process() throws Exception {
        DCustDetails details = getHelper().getCurrentComponentStub();

        String allKnownNames = "";
        List<DCustDBA> dbaList = getHelper().getNodesStubs("ReqDCustDBA");
        Iterator<DCustDBA> dCustDBAIterator = dbaList.iterator();
        while (dCustDBAIterator.hasNext()) {
            allKnownNames += dCustDBAIterator.next().getDbaName();
            if (dCustDBAIterator.hasNext()) {
                allKnownNames += "|";
            }
        }

        String name = details.getName();
        if (!name.isEmpty()) {
            if (!allKnownNames.isEmpty()) {
                allKnownNames = allKnownNames + '|' + name;
            } else {
                allKnownNames = name;
            }
        }

        details.setAllKnownNames(allKnownNames);

        return true;
    }
}


