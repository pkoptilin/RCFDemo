package com.selectica.rcfdev.navigation;

import com.selectica.internalmodel.navigation.*;
import com.selectica.rcf.common.navigation.*;

public class NavigationDirectories {

    public void append(NavNode2 navNode) {
        // extend navigation here;
    }

    public void append_Vendor_Summary(SummaryDisplayDef2 summaryDisplayDef) {
        new SummaryDisplayDefBuilder()
                    .appendAliasDef("viewWFStage","Stage")
                    .setDisplayHint("pix/meta/bump.gif")
                    .setAligment("center")
                    .setSortable("true")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFStageLinkUIBuilder")
                    .addAlias("BundleDef:/activeTaskName")
                    
                    .appendAliasDef("openBundle","Open")
                    .setDisplayHint("open")
                    .setAligment("center")
                    .setSortable("false")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFOpenLinkUIBuilder")
                    .addAlias("BundleDef:/activeTaskName")
                    
                    .appendParamDef("BundleDef:/lastModified","Modified Date")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("right")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("DVenData/ReqDVenDetails/name","Vendor Name")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("left")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("DVenData/ReqDVenDetails/dirCategory","Category")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("left")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("DVenData/ReqDVenDetails/dirStatus","Status")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("left")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendCustomizableDef("DeleteCheckBox","Delete")
                    .setDisplayHint("")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.MassDeleteUIBuilder")
                    
                    .useFor(summaryDisplayDef);
    }

    public void append_Customer_Summary(SummaryDisplayDef2 summaryDisplayDef) {
        new SummaryDisplayDefBuilder()
                    .appendAliasDef("viewWFStage","Stage")
                    .setDisplayHint("pix/meta/bump.gif")
                    .setAligment("center")
                    .setSortable("true")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFStageLinkUIBuilder")
                    .addAlias("BundleDef:/activeTaskName")
                    
                    .appendAliasDef("openBundle","Open")
                    .setDisplayHint("open")
                    .setAligment("center")
                    .setSortable("false")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFOpenLinkUIBuilder")
                    .addAlias("BundleDef:/activeTaskName")
                    
                    .appendParamDef("BundleDef:/lastModified","Modified Date")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("right")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("DCustData/ReqDCustDetails/name","Customer Name")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("left")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("DCustData/ReqDCustDetails/dirCategory","Category")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("left")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("DCustData/ReqDCustDetails/dirStatus","Status")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("left")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendCustomizableDef("DeleteCheckBox","Delete")
                    .setDisplayHint("")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.MassDeleteUIBuilder")
                    
                    .useFor(summaryDisplayDef);
    }

    public void append_Counterparty_Summary(SummaryDisplayDef2 summaryDisplayDef) {
        new SummaryDisplayDefBuilder()
                    .appendAliasDef("viewWFStage","Stage")
                    .setDisplayHint("pix/meta/bump.gif")
                    .setAligment("center")
                    .setSortable("true")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFStageLinkUIBuilder")
                    .addAlias("BundleDef:/activeTaskName")
                    
                    .appendAliasDef("openBundle","Open")
                    .setDisplayHint("open")
                    .setAligment("center")
                    .setSortable("false")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFOpenLinkUIBuilder")
                    .addAlias("BundleDef:/activeTaskName")
                    
                    .appendParamDef("BundleDef:/lastModified","Modified Date")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("right")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("DCPData/ReqDCPDetails/name","Counterparty Name")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("left")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("DCPData/ReqDCPDetails/dirCategory","Category")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("left")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("DCPData/ReqDCPDetails/dirStatus","Status")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("left")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendCustomizableDef("DeleteCheckBox","Delete")
                    .setDisplayHint("")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.MassDeleteUIBuilder")
                    
                    .useFor(summaryDisplayDef);
    }
}
