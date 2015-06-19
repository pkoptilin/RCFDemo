package com.selectica.rcfdev.navigation;

import com.selectica.internalmodel.navigation.*;
import com.selectica.rcf.common.navigation.*;

public class NavigationAccount {

    public void append(NavNode2 navNode) {
        // extend navigation here;
    }

    public void append_Composers_Emails_Summary(SummaryDisplayDef2 summaryDisplayDef) {
        new SummaryDisplayDefBuilder()
                    .appendAliasDef("trackingNumber","Tracking #")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("right")
                    .setSortable("true")
                    .setRenderer("defaultAliasResolver")
                    .addAlias("BundleDef:/bundleTrackingNum")
                    
                    .appendAliasDef("emailName","Name")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("defaultAliasResolver")
                    .addAlias("EmailAccountTemplate/ReqEmailAccountTemplateInfo/name")
                    .addAlias("EmailTemplate/ReqEmailTemplateInfo/name")
                    
                    .appendAliasDef("emailSubject","Subject")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("defaultAliasResolver")
                    .addAlias("EmailAccountTemplate/ReqEmailAccountTemplateInfo/subject")
                    .addAlias("EmailTemplate/ReqEmailTemplateInfo/subject")
                    
                    .appendAliasDef("emailType","Email Type")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("left")
                    .setSortable("true")
                    .setRenderer("defaultAliasResolver")
                    .addAlias("BundleDef:/bundleType")
                    
                    .appendAliasDef("isApprovalTemplate","Is approval template?")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("center")
                    .setSortable("true")
                    .setRenderer("defaultAliasResolver")
                    .addAlias("EmailAccountTemplate/ReqEmailAccountTemplateInfo/isApprovalTemplate")
                    .addAlias("EmailTemplate/ReqEmailTemplateInfo/isApprovalTemplate")
                    
                    .appendParamDef("BundleDef:/lastModified","Modified Date")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("right")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendAliasDef("openBundle","Open")
                    .setDisplayHint("open")
                    .setAligment("center")
                    .setSortable("false")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFOpenLinkUIBuilder")
                    .addAlias("BundleDef:/activeTaskName")
                    
                    .appendCustomizableDef("copyBundle","Copy")
                    .setDisplayHint("copy")
                    .setAligment("center")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFCopyBundleLinkUIBuilder")
                    
                    .appendAliasDef("viewWFStage","View")
                    .setDisplayHint("pix/meta/view_sm.gif")
                    .setAligment("center")
                    .setSortable("true")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFStageLinkUIBuilder")
                    .addAlias("BundleDef:/activeTaskName")
                    
                    .appendCustomizableDef("DeleteCheckBox","Delete")
                    .setDisplayHint("")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.MassDeleteUIBuilder")
                    
                    .useFor(summaryDisplayDef);
    }

    public void append_Composers_DynamicInclusion_Summary(SummaryDisplayDef2 summaryDisplayDef) {
        new SummaryDisplayDefBuilder()
                    .appendParamDef("DynamicInclusionModule/ReqDynamicInclusionInfo/name","Title")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("DynamicInclusionModule/ReqDynamicInclusionInfo/shortName","Short Name")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("BundleDef:/lastModified","Modified Date")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("right")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendAliasDef("viewWFStage","View")
                    .setDisplayHint("pix/meta/view_sm.gif")
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
                    
                    .appendCustomizableDef("copyBundle","Copy")
                    .setDisplayHint("copy")
                    .setAligment("center")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFCopyBundleLinkUIBuilder")
                    
                    .appendCustomizableDef("reassignBundleOwner","Reassign")
                    .setDisplayHint("reassign")
                    .setAligment("center")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFReassignBundleOwnerUIBuilder")
                    
                    .appendCustomizableDef("DeleteCheckBox","Delete")
                    .setDisplayHint("")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.MassDeleteUIBuilder")
                    
                    .useFor(summaryDisplayDef);
    }
}
