package com.selectica.rcfdev.eclm.definitions.DVendorBO.DVenDBA.scripts;

import com.selectica.rcfdev.stubs.DVenDBA;
import com.selectica.rcfdev.stubs.DVenDetails;
import com.selectica.rcfdev.stubs.DVenFKA;
import com.selectica.rcfscripts.AbstractDataWriteScript;

import java.util.Iterator;
import java.util.List;

/**
 * Created by vshilkin on 21.05.2015.
 */
public class OnSaveTrigger extends AbstractDataWriteScript<Boolean> {
    /*
            <![CDATA[
        				var allKnownNames = '';
        				var dbaList = thisBundle.getValue("ReqDVenDBA");
        				var dbaIt = dbaList.iterator();
        				while (dbaIt.hasNext()) {
               				var dbaComp = dbaIt.next();
        				    var dbaName = dbaComp.get("dbaName");
        				    allKnownNames = allKnownNames + dbaName;
        				    if(dbaIt.hasNext()){
        				        allKnownNames = allKnownNames + '|';
                            }
                        }
                        var fkaKnownNames = '';
                        var dbaList = thisBundle.getValue("ReqDVenFKA");
                        var dbaIt = dbaList.iterator();
                        while (dbaIt.hasNext()) {
                        	var dbaComp = dbaIt.next();
                            var dbaName = dbaComp.get("fkaBussName");
                            fkaKnownNames = fkaKnownNames + dbaName;
                            if(dbaIt.hasNext()){
                                fkaKnownNames = fkaKnownNames + '|';
                            }
                        }
                        if (fkaKnownNames != '') {
                            if(allKnownNames != ''){
                                allKnownNames = allKnownNames + '|' + fkaKnownNames;
                            } else{
                                allKnownNames = fkaKnownNames;
                            }
                        }

                        var aka = thisComponent.getBundleProxy().getParameterValueObjectFromAnyComponent("ReqDVenDetails", "venAKA");
                        if (aka != '') {
                            if (allKnownNames != '') {
                                allKnownNames = allKnownNames + '|' + aka;
                            } else {
                                allKnownNames = aka;
                            }
                        }

                        var name = thisComponent.getBundleProxy().getParameterValueObjectFromAnyComponent("ReqDVenDetails", "name");
                        if (name != '') {
                            if (allKnownNames != '') {
                                allKnownNames = allKnownNames + '|' + name;
                            } else {
                                allKnownNames = name;
                            }
                        }
                        thisBundle.setValue("allKnownNames", allKnownNames);
                        result = true;
			]]>
     */

    @Override
    public Boolean process() throws Exception {
        DVenDetails details = getHelper().getInfoComponentStub();

        String allKnownNames = "";
        List<DVenDBA> dbaList = getHelper().getNodesStubs("ReqDVenDBA");
        Iterator<DVenDBA> dVenDBAIterator = dbaList.iterator();
        while (dVenDBAIterator.hasNext()) {
            allKnownNames += dVenDBAIterator.next().getDbaName();
            if (dVenDBAIterator.hasNext()) {
                allKnownNames += "|";
            }
        }

        String fkaKnownNames = "";
        List<DVenFKA> fkaList = getHelper().getNodesStubs("ReqDVenFKA");
        Iterator<DVenFKA> dVenFKAIterator = fkaList.iterator();
        while (dVenFKAIterator.hasNext()) {
            fkaKnownNames += dVenFKAIterator.next().getFkaBussName();
            if (dVenFKAIterator.hasNext()) {
                fkaKnownNames += "|";
            }
        }

        if (!fkaKnownNames.isEmpty()) {
            if (!allKnownNames.isEmpty()) {
                allKnownNames = allKnownNames + '|' + fkaKnownNames;
            } else {
                allKnownNames = fkaKnownNames;
            }
        }

        String venAka = details.getVenAKA();
        if (!venAka.isEmpty()) {
            if (!allKnownNames.isEmpty()) {
                allKnownNames = allKnownNames + '|' + venAka;
            } else {
                allKnownNames = venAka;
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

