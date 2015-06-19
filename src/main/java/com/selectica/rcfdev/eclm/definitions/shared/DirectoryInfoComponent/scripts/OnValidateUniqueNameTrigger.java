package com.selectica.rcfdev.eclm.definitions.shared.DirectoryInfoComponent.scripts;

import com.selectica.rcfscripts.AbstractDataReadScript;

/**
 * Created by vshilkin on 13.03.2015.
 */
public class OnValidateUniqueNameTrigger extends AbstractDataReadScript<Boolean> {
    /*
                <![CDATA[
		result = thisComponent.hasUniqueParameterValue("name", true);
	]]>

     */
    @Override
    public Boolean process() throws Exception {
        return !getHelper().hasUniqueParameterValue("name");
    }
}
