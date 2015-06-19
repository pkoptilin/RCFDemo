package com.selectica.rcfdev.navigation;

import com.selectica.internalmodel.navigation.*;
import com.selectica.rcf.common.navigation.*;

public class NavigationClauseLibrary {

    public void append(NavNode2 navNode) {
        // extend navigation here;
    }

    public void append_All_All_Summary(SummaryDisplayDef2 summaryDisplayDef) {
        new SummaryDisplayDefBuilder()
                    .appendAliasDef("viewWFStage","Stage")
                    .setDisplayHint("pix/meta/view_sm.gif")
                    .setAligment("center")
                    .setSortable("true")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFStageLinkUIBuilder")
                    .addAlias("BundleDef:/activeTaskName")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/name","Name")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendCustomizableDef("viewClauseText","Content")
                    .setDisplayHint("preview")
                    .setAligment("center")
                    .setSortable("false")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.ClauseTextJSONUIBuilder")
                    
                    .appendAliasDef("openBundle","Open")
                    .setDisplayHint("open")
                    .setAligment("center")
                    .setSortable("false")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFOpenLinkUIBuilder")
                    .addAlias("BundleDef:/activeTaskName")
                    
                    .appendCustomizableDef("copyBundle","Copy")
                    .setDisplayHint("copy")
                    .setAligment("center")
                    .setSortable("false")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFCopyBundleLinkUIBuilder")
                    
                    .appendParamDef("BundleDef:/lastModified","Modified Date")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("right")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/Flag","Flag")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ContractTypeRef","Contract Type")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseType","Clause Type")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseCategory","Category")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseSubCategory","Sub Category")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseStatus","Status")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseRisk","Risk")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendCustomizableDef("DeleteCheckBox","Delete")
                    .setDisplayHint("")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.MassDeleteUIBuilder")
                    
                    .useFor(summaryDisplayDef);
    }

    public void append_All_Active_Active(BundleSummaryItem bundleSummaryItem) {
        new BundleFilterLogicBuilder()
                    .buildList("")
                    .appendBundleFilterLogicWithScript("2",null,"\n"+
"                                \n"+
"                                result = thisBundle.getInfoValueObject(\"ClauseStatus\") == 'active';\n"+
"                                \n"+
"                            ")
                    .useFor(bundleSummaryItem);
    }

    public void append_All_Active_Summary(SummaryDisplayDef2 summaryDisplayDef) {
        new SummaryDisplayDefBuilder()
                    .appendAliasDef("viewWFStage","Stage")
                    .setDisplayHint("pix/meta/view_sm.gif")
                    .setAligment("center")
                    .setSortable("true")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFStageLinkUIBuilder")
                    .addAlias("BundleDef:/activeTaskName")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/name","Name")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendCustomizableDef("viewClauseText","Content")
                    .setDisplayHint("ppreview")
                    .setAligment("center")
                    .setSortable("false")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.ClauseTextJSONUIBuilder")
                    
                    .appendAliasDef("openBundle","Open")
                    .setDisplayHint("open")
                    .setAligment("center")
                    .setSortable("false")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFOpenLinkUIBuilder")
                    .addAlias("BundleDef:/activeTaskName")
                    
                    .appendCustomizableDef("copyBundle","Copy")
                    .setDisplayHint("copy")
                    .setAligment("center")
                    .setSortable("false")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFCopyBundleLinkUIBuilder")
                    
                    .appendParamDef("BundleDef:/lastModified","Modified Date")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("right")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/Flag","Flag")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ContractTypeRef","Contract Type")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseType","Clause Type")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseCategory","Category")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseSubCategory","Sub Category")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseStatus","Status")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseRisk","Risk")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .useFor(summaryDisplayDef);
    }

    public void append_All_Inactive_Inactive(BundleSummaryItem bundleSummaryItem) {
        new BundleFilterLogicBuilder()
                    .buildList("")
                    .appendBundleFilterLogicWithScript("3",null,"\n"+
"                                \n"+
"                                result = thisBundle.getInfoValueObject(\"ClauseStatus\") == 'inactive';\n"+
"                                \n"+
"                            ")
                    .useFor(bundleSummaryItem);
    }

    public void append_All_Inactive_Summary(SummaryDisplayDef2 summaryDisplayDef) {
        new SummaryDisplayDefBuilder()
                    .appendAliasDef("viewWFStage","Stage")
                    .setDisplayHint("pix/meta/view_sm.gif")
                    .setAligment("center")
                    .setSortable("true")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFStageLinkUIBuilder")
                    .addAlias("BundleDef:/activeTaskName")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/name","Name")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendCustomizableDef("viewClauseText","Content")
                    .setDisplayHint("preview")
                    .setAligment("center")
                    .setSortable("false")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.ClauseTextJSONUIBuilder")
                    
                    .appendAliasDef("openBundle","Open")
                    .setDisplayHint("open")
                    .setAligment("center")
                    .setSortable("false")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFOpenLinkUIBuilder")
                    .addAlias("BundleDef:/activeTaskName")
                    
                    .appendCustomizableDef("copyBundle","Copy")
                    .setDisplayHint("copy")
                    .setAligment("center")
                    .setSortable("false")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFCopyBundleLinkUIBuilder")
                    
                    .appendParamDef("BundleDef:/lastModified","Modified Date")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("right")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/Flag","Flag")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ContractTypeRef","Contract Type")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseType","Clause Type")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseCategory","Category")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseSubCategory","Sub Category")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseStatus","Status")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseRisk","Risk")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendCustomizableDef("DeleteCheckBox","Delete")
                    .setDisplayHint("")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.MassDeleteUIBuilder")
                    
                    .useFor(summaryDisplayDef);
    }

    public void append_All_Draft_Draft(BundleSummaryItem bundleSummaryItem) {
        new BundleFilterLogicBuilder()
                    .buildList("")
                    .appendBundleFilterLogicWithScript("4",null,"\n"+
"                                \n"+
"                                result = thisBundle.getInfoValueObject(\"ClauseStatus\") == 'draft';\n"+
"                                \n"+
"                            ")
                    .useFor(bundleSummaryItem);
    }

    public void append_All_Draft_Summary(SummaryDisplayDef2 summaryDisplayDef) {
        new SummaryDisplayDefBuilder()
                    .appendAliasDef("viewWFStage","Stage")
                    .setDisplayHint("pix/meta/view_sm.gif")
                    .setAligment("center")
                    .setSortable("true")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFStageLinkUIBuilder")
                    .addAlias("BundleDef:/activeTaskName")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/name","Name")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendCustomizableDef("viewClauseText","Content")
                    .setDisplayHint("preview")
                    .setAligment("center")
                    .setSortable("false")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.ClauseTextJSONUIBuilder")
                    
                    .appendAliasDef("openBundle","Open")
                    .setDisplayHint("open")
                    .setAligment("center")
                    .setSortable("false")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFOpenLinkUIBuilder")
                    .addAlias("BundleDef:/activeTaskName")
                    
                    .appendCustomizableDef("copyBundle","Copy")
                    .setDisplayHint("copy")
                    .setAligment("center")
                    .setSortable("false")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFCopyBundleLinkUIBuilder")
                    
                    .appendParamDef("BundleDef:/lastModified","Modified Date")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("right")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/Flag","Flag")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ContractTypeRef","Contract Type")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseType","Clause Type")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseCategory","Category")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseSubCategory","Sub Category")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseStatus","Status")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseRisk","Risk")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendCustomizableDef("DeleteCheckBox","Delete")
                    .setDisplayHint("")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.MassDeleteUIBuilder")
                    
                    .useFor(summaryDisplayDef);
    }

    public void append_NDA_All_All(BundleSummaryItem bundleSummaryItem) {
        new BundleFilterLogicBuilder()
                    .buildList("")
                    .appendBundleFilterLogicWithScript("1",null,"\n"+
"                                \n"+
"                                result = thisBundle.getInfoValueObject(\"ContractTypeRef\") == 'CNDABO';\n"+
"                                \n"+
"                            ")
                    .useFor(bundleSummaryItem);
    }

    public void append_NDA_All_Summary(SummaryDisplayDef2 summaryDisplayDef) {
        new SummaryDisplayDefBuilder()
                    .appendAliasDef("viewWFStage","Stage")
                    .setDisplayHint("pix/meta/view_sm.gif")
                    .setAligment("center")
                    .setSortable("true")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFStageLinkUIBuilder")
                    .addAlias("BundleDef:/activeTaskName")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/name","Name")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendCustomizableDef("viewClauseText","Content")
                    .setDisplayHint("preview")
                    .setAligment("center")
                    .setSortable("false")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.ClauseTextJSONUIBuilder")
                    
                    .appendAliasDef("openBundle","Open")
                    .setDisplayHint("open")
                    .setAligment("center")
                    .setSortable("false")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFOpenLinkUIBuilder")
                    .addAlias("BundleDef:/activeTaskName")
                    
                    .appendCustomizableDef("copyBundle","Copy")
                    .setDisplayHint("copy")
                    .setAligment("center")
                    .setSortable("false")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFCopyBundleLinkUIBuilder")
                    
                    .appendParamDef("BundleDef:/lastModified","Modified Date")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("right")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/Flag","Flag")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ContractTypeRef","Contract Type")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseType","Clause Type")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseCategory","Category")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseSubCategory","Sub Category")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseStatus","Status")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseRisk","Risk")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendCustomizableDef("DeleteCheckBox","Delete")
                    .setDisplayHint("")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.MassDeleteUIBuilder")
                    
                    .useFor(summaryDisplayDef);
    }

    public void append_NDA_Active_Active(BundleSummaryItem bundleSummaryItem) {
        new BundleFilterLogicBuilder()
                    .buildList("")
                    .appendBundleFilterLogicWithScript("2",null,"\n"+
"                                \n"+
"                                result = thisBundle.getInfoValueObject(\"ClauseStatus\") == 'active' && thisBundle.getInfoValueObject(\"ContractTypeRef\") == 'CNDABO';\n"+
"                                \n"+
"                            ")
                    .useFor(bundleSummaryItem);
    }

    public void append_NDA_Active_Summary(SummaryDisplayDef2 summaryDisplayDef) {
        new SummaryDisplayDefBuilder()
                    .appendAliasDef("viewWFStage","Stage")
                    .setDisplayHint("pix/meta/view_sm.gif")
                    .setAligment("center")
                    .setSortable("true")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFStageLinkUIBuilder")
                    .addAlias("BundleDef:/activeTaskName")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/name","Name")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendCustomizableDef("viewClauseText","Content")
                    .setDisplayHint("preview")
                    .setAligment("center")
                    .setSortable("false")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.ClauseTextJSONUIBuilder")
                    
                    .appendAliasDef("openBundle","Open")
                    .setDisplayHint("open")
                    .setAligment("center")
                    .setSortable("false")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFOpenLinkUIBuilder")
                    .addAlias("BundleDef:/activeTaskName")
                    
                    .appendCustomizableDef("copyBundle","Copy")
                    .setDisplayHint("copy")
                    .setAligment("center")
                    .setSortable("false")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFCopyBundleLinkUIBuilder")
                    
                    .appendParamDef("BundleDef:/lastModified","Modified Date")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("right")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/Flag","Flag")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ContractTypeRef","Contract Type")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseType","Clause Type")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseCategory","Category")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseSubCategory","Sub Category")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseStatus","Status")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseRisk","Risk")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .useFor(summaryDisplayDef);
    }

    public void append_NDA_Inactive_Inactive(BundleSummaryItem bundleSummaryItem) {
        new BundleFilterLogicBuilder()
                    .buildList("")
                    .appendBundleFilterLogicWithScript("3",null,"\n"+
"                                \n"+
"                                result = thisBundle.getInfoValueObject(\"ClauseStatus\") == 'inactive' && thisBundle.getInfoValueObject(\"ContractTypeRef\") == 'CNDABO';\n"+
"                                \n"+
"                            ")
                    .useFor(bundleSummaryItem);
    }

    public void append_NDA_Inactive_Summary(SummaryDisplayDef2 summaryDisplayDef) {
        new SummaryDisplayDefBuilder()
                    .appendAliasDef("viewWFStage","Stage")
                    .setDisplayHint("pix/meta/view_sm.gif")
                    .setAligment("center")
                    .setSortable("true")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFStageLinkUIBuilder")
                    .addAlias("BundleDef:/activeTaskName")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/name","Name")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendCustomizableDef("viewClauseText","Content")
                    .setDisplayHint("preview")
                    .setAligment("center")
                    .setSortable("false")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.ClauseTextJSONUIBuilder")
                    
                    .appendAliasDef("openBundle","Open")
                    .setDisplayHint("open")
                    .setAligment("center")
                    .setSortable("false")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFOpenLinkUIBuilder")
                    .addAlias("BundleDef:/activeTaskName")
                    
                    .appendCustomizableDef("copyBundle","Copy")
                    .setDisplayHint("copy")
                    .setAligment("center")
                    .setSortable("false")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFCopyBundleLinkUIBuilder")
                    
                    .appendParamDef("BundleDef:/lastModified","Modified Date")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("right")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/Flag","Flag")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ContractTypeRef","Contract Type")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseType","Clause Type")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseCategory","Category")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseSubCategory","Sub Category")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseStatus","Status")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseRisk","Risk")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendCustomizableDef("DeleteCheckBox","Delete")
                    .setDisplayHint("")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.MassDeleteUIBuilder")
                    
                    .useFor(summaryDisplayDef);
    }

    public void append_NDA_Draft_Draft(BundleSummaryItem bundleSummaryItem) {
        new BundleFilterLogicBuilder()
                    .buildList("")
                    .appendBundleFilterLogicWithScript("4",null,"\n"+
"                                \n"+
"                                result = thisBundle.getInfoValueObject(\"ClauseStatus\") == 'draft' && thisBundle.getInfoValueObject(\"ContractTypeRef\") == 'CNDABO';\n"+
"                                \n"+
"                            ")
                    .useFor(bundleSummaryItem);
    }

    public void append_NDA_Draft_Summary(SummaryDisplayDef2 summaryDisplayDef) {
        new SummaryDisplayDefBuilder()
                    .appendAliasDef("viewWFStage","Stage")
                    .setDisplayHint("pix/meta/view_sm.gif")
                    .setAligment("center")
                    .setSortable("true")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFStageLinkUIBuilder")
                    .addAlias("BundleDef:/activeTaskName")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/name","Name")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendCustomizableDef("viewClauseText","Content")
                    .setDisplayHint("preview")
                    .setAligment("center")
                    .setSortable("false")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.ClauseTextJSONUIBuilder")
                    
                    .appendAliasDef("openBundle","Open")
                    .setDisplayHint("open")
                    .setAligment("center")
                    .setSortable("false")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFOpenLinkUIBuilder")
                    .addAlias("BundleDef:/activeTaskName")
                    
                    .appendCustomizableDef("copyBundle","Copy")
                    .setDisplayHint("copy")
                    .setAligment("center")
                    .setSortable("false")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFCopyBundleLinkUIBuilder")
                    
                    .appendParamDef("BundleDef:/lastModified","Modified Date")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("right")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/Flag","Flag")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ContractTypeRef","Contract Type")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseType","Clause Type")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseCategory","Category")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseSubCategory","Sub Category")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseStatus","Status")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseRisk","Risk")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendCustomizableDef("DeleteCheckBox","Delete")
                    .setDisplayHint("")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.MassDeleteUIBuilder")
                    
                    .useFor(summaryDisplayDef);
    }

    public void append_Procurement_All_All(BundleSummaryItem bundleSummaryItem) {
        new BundleFilterLogicBuilder()
                    .buildList("")
                    .appendBundleFilterLogicWithScript("1",null,"\n"+
"                                \n"+
"                                result = thisBundle.getInfoValueObject(\"ContractTypeRef\") == 'CProcBO';\n"+
"                                \n"+
"                            ")
                    .useFor(bundleSummaryItem);
    }

    public void append_Procurement_All_Summary(SummaryDisplayDef2 summaryDisplayDef) {
        new SummaryDisplayDefBuilder()
                    .appendAliasDef("viewWFStage","Stage")
                    .setDisplayHint("pix/meta/view_sm.gif")
                    .setAligment("center")
                    .setSortable("true")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFStageLinkUIBuilder")
                    .addAlias("BundleDef:/activeTaskName")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/name","Name")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendCustomizableDef("viewClauseText","Content")
                    .setDisplayHint("preview")
                    .setAligment("center")
                    .setSortable("false")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.ClauseTextJSONUIBuilder")
                    
                    .appendAliasDef("openBundle","Open")
                    .setDisplayHint("open")
                    .setAligment("center")
                    .setSortable("false")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFOpenLinkUIBuilder")
                    .addAlias("BundleDef:/activeTaskName")
                    
                    .appendCustomizableDef("copyBundle","Copy")
                    .setDisplayHint("copy")
                    .setAligment("center")
                    .setSortable("false")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFCopyBundleLinkUIBuilder")
                    
                    .appendParamDef("BundleDef:/lastModified","Modified Date")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("right")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/Flag","Flag")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ContractTypeRef","Contract Type")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseType","Clause Type")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseCategory","Category")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseSubCategory","Sub Category")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseStatus","Status")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseRisk","Risk")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendCustomizableDef("DeleteCheckBox","Delete")
                    .setDisplayHint("")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.MassDeleteUIBuilder")
                    
                    .useFor(summaryDisplayDef);
    }

    public void append_Procurement_Active_Active(BundleSummaryItem bundleSummaryItem) {
        new BundleFilterLogicBuilder()
                    .buildList("")
                    .appendBundleFilterLogicWithScript("2",null,"\n"+
"                                \n"+
"                                result = thisBundle.getInfoValueObject(\"ClauseStatus\") == 'active' && thisBundle.getInfoValueObject(\"ContractTypeRef\") == 'CProcBO';\n"+
"                                \n"+
"                            ")
                    .useFor(bundleSummaryItem);
    }

    public void append_Procurement_Active_Summary(SummaryDisplayDef2 summaryDisplayDef) {
        new SummaryDisplayDefBuilder()
                    .appendAliasDef("viewWFStage","Stage")
                    .setDisplayHint("pix/meta/view_sm.gif")
                    .setAligment("center")
                    .setSortable("true")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFStageLinkUIBuilder")
                    .addAlias("BundleDef:/activeTaskName")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/name","Name")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendCustomizableDef("viewClauseText","Content")
                    .setDisplayHint("preview")
                    .setAligment("center")
                    .setSortable("false")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.ClauseTextJSONUIBuilder")
                    
                    .appendAliasDef("openBundle","Open")
                    .setDisplayHint("open")
                    .setAligment("center")
                    .setSortable("false")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFOpenLinkUIBuilder")
                    .addAlias("BundleDef:/activeTaskName")
                    
                    .appendCustomizableDef("copyBundle","Copy")
                    .setDisplayHint("copy")
                    .setAligment("center")
                    .setSortable("false")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFCopyBundleLinkUIBuilder")
                    
                    .appendParamDef("BundleDef:/lastModified","Modified Date")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("right")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/Flag","Flag")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ContractTypeRef","Contract Type")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseType","Clause Type")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseCategory","Category")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseSubCategory","Sub Category")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseStatus","Status")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseRisk","Risk")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .useFor(summaryDisplayDef);
    }

    public void append_Procurement_Inactive_Inactive(BundleSummaryItem bundleSummaryItem) {
        new BundleFilterLogicBuilder()
                    .buildList("")
                    .appendBundleFilterLogicWithScript("3",null,"\n"+
"                                \n"+
"                                result = thisBundle.getInfoValueObject(\"ClauseStatus\") == 'inactive' && thisBundle.getInfoValueObject(\"ContractTypeRef\") == 'CProcBO';\n"+
"                                \n"+
"                            ")
                    .useFor(bundleSummaryItem);
    }

    public void append_Procurement_Inactive_Summary(SummaryDisplayDef2 summaryDisplayDef) {
        new SummaryDisplayDefBuilder()
                    .appendAliasDef("viewWFStage","Stage")
                    .setDisplayHint("pix/meta/view_sm.gif")
                    .setAligment("center")
                    .setSortable("true")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFStageLinkUIBuilder")
                    .addAlias("BundleDef:/activeTaskName")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/name","Name")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendCustomizableDef("viewClauseText","Content")
                    .setDisplayHint("preview")
                    .setAligment("center")
                    .setSortable("false")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.ClauseTextJSONUIBuilder")
                    
                    .appendAliasDef("openBundle","Open")
                    .setDisplayHint("open")
                    .setAligment("center")
                    .setSortable("false")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFOpenLinkUIBuilder")
                    .addAlias("BundleDef:/activeTaskName")
                    
                    .appendCustomizableDef("copyBundle","Copy")
                    .setDisplayHint("copy")
                    .setAligment("center")
                    .setSortable("false")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFCopyBundleLinkUIBuilder")
                    
                    .appendParamDef("BundleDef:/lastModified","Modified Date")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("right")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/Flag","Flag")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ContractTypeRef","Contract Type")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseType","Clause Type")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseCategory","Category")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseSubCategory","Sub Category")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseStatus","Status")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseRisk","Risk")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendCustomizableDef("DeleteCheckBox","Delete")
                    .setDisplayHint("")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.MassDeleteUIBuilder")
                    
                    .useFor(summaryDisplayDef);
    }

    public void append_Procurement_Draft_Draft(BundleSummaryItem bundleSummaryItem) {
        new BundleFilterLogicBuilder()
                    .buildList("")
                    .appendBundleFilterLogicWithScript("4",null,"\n"+
"                                \n"+
"                                result = thisBundle.getInfoValueObject(\"ClauseStatus\") == 'draft' && thisBundle.getInfoValueObject(\"ContractTypeRef\") == 'CProcBO';\n"+
"                                \n"+
"                            ")
                    .useFor(bundleSummaryItem);
    }

    public void append_Procurement_Draft_Summary(SummaryDisplayDef2 summaryDisplayDef) {
        new SummaryDisplayDefBuilder()
                    .appendAliasDef("viewWFStage","Stage")
                    .setDisplayHint("pix/meta/view_sm.gif")
                    .setAligment("center")
                    .setSortable("true")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFStageLinkUIBuilder")
                    .addAlias("BundleDef:/activeTaskName")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/name","Name")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendCustomizableDef("viewClauseText","Content")
                    .setDisplayHint("preview")
                    .setAligment("center")
                    .setSortable("false")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.ClauseTextJSONUIBuilder")
                    
                    .appendAliasDef("openBundle","Open")
                    .setDisplayHint("open")
                    .setAligment("center")
                    .setSortable("false")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFOpenLinkUIBuilder")
                    .addAlias("BundleDef:/activeTaskName")
                    
                    .appendCustomizableDef("copyBundle","Copy")
                    .setDisplayHint("copy")
                    .setAligment("center")
                    .setSortable("false")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFCopyBundleLinkUIBuilder")
                    
                    .appendParamDef("BundleDef:/lastModified","Modified Date")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("right")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/Flag","Flag")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ContractTypeRef","Contract Type")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseType","Clause Type")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseCategory","Category")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseSubCategory","Sub Category")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseStatus","Status")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseRisk","Risk")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendCustomizableDef("DeleteCheckBox","Delete")
                    .setDisplayHint("")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.MassDeleteUIBuilder")
                    
                    .useFor(summaryDisplayDef);
    }

    public void append_Sales_All_All(BundleSummaryItem bundleSummaryItem) {
        new BundleFilterLogicBuilder()
                    .buildList("")
                    .appendBundleFilterLogicWithScript("1",null,"\n"+
"                                \n"+
"                                result = thisBundle.getInfoValueObject(\"ContractTypeRef\") == 'CSalesBO';\n"+
"                                \n"+
"                            ")
                    .useFor(bundleSummaryItem);
    }

    public void append_Sales_All_Summary(SummaryDisplayDef2 summaryDisplayDef) {
        new SummaryDisplayDefBuilder()
                    .appendAliasDef("viewWFStage","Stage")
                    .setDisplayHint("pix/meta/view_sm.gif")
                    .setAligment("center")
                    .setSortable("true")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFStageLinkUIBuilder")
                    .addAlias("BundleDef:/activeTaskName")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/name","Name")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendCustomizableDef("viewClauseText","Content")
                    .setDisplayHint("preview")
                    .setAligment("center")
                    .setSortable("false")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.ClauseTextJSONUIBuilder")
                    
                    .appendAliasDef("openBundle","Open")
                    .setDisplayHint("open")
                    .setAligment("center")
                    .setSortable("false")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFOpenLinkUIBuilder")
                    .addAlias("BundleDef:/activeTaskName")
                    
                    .appendCustomizableDef("copyBundle","Copy")
                    .setDisplayHint("copy")
                    .setAligment("center")
                    .setSortable("false")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFCopyBundleLinkUIBuilder")
                    
                    .appendParamDef("BundleDef:/lastModified","Modified Date")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("right")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/Flag","Flag")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ContractTypeRef","Contract Type")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseType","Clause Type")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseCategory","Category")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseSubCategory","Sub Category")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseStatus","Status")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseRisk","Risk")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendCustomizableDef("DeleteCheckBox","Delete")
                    .setDisplayHint("")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.MassDeleteUIBuilder")
                    
                    .useFor(summaryDisplayDef);
    }

    public void append_Sales_Active_Active(BundleSummaryItem bundleSummaryItem) {
        new BundleFilterLogicBuilder()
                    .buildList("")
                    .appendBundleFilterLogicWithScript("2",null,"\n"+
"                                \n"+
"                                result = thisBundle.getInfoValueObject(\"ClauseStatus\") == 'active' && thisBundle.getInfoValueObject(\"ContractTypeRef\") == 'CSalesBO';\n"+
"                                \n"+
"                            ")
                    .useFor(bundleSummaryItem);
    }

    public void append_Sales_Active_Summary(SummaryDisplayDef2 summaryDisplayDef) {
        new SummaryDisplayDefBuilder()
                    .appendAliasDef("viewWFStage","Stage")
                    .setDisplayHint("pix/meta/view_sm.gif")
                    .setAligment("center")
                    .setSortable("true")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFStageLinkUIBuilder")
                    .addAlias("BundleDef:/activeTaskName")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/name","Name")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendCustomizableDef("viewClauseText","Content")
                    .setDisplayHint("preview")
                    .setAligment("center")
                    .setSortable("false")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.ClauseTextJSONUIBuilder")
                    
                    .appendAliasDef("openBundle","Open")
                    .setDisplayHint("open")
                    .setAligment("center")
                    .setSortable("false")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFOpenLinkUIBuilder")
                    .addAlias("BundleDef:/activeTaskName")
                    
                    .appendCustomizableDef("copyBundle","Copy")
                    .setDisplayHint("copy")
                    .setAligment("center")
                    .setSortable("false")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFCopyBundleLinkUIBuilder")
                    
                    .appendParamDef("BundleDef:/lastModified","Modified Date")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("right")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/Flag","Flag")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ContractTypeRef","Contract Type")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseType","Clause Type")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseCategory","Category")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseSubCategory","Sub Category")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseStatus","Status")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseRisk","Risk")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .useFor(summaryDisplayDef);
    }

    public void append_Sales_Inactive_Inactive(BundleSummaryItem bundleSummaryItem) {
        new BundleFilterLogicBuilder()
                    .buildList("")
                    .appendBundleFilterLogicWithScript("3",null,"\n"+
"                                \n"+
"                                result = thisBundle.getInfoValueObject(\"ClauseStatus\") == 'inactive' && thisBundle.getInfoValueObject(\"ContractTypeRef\") == 'CSalesBO';\n"+
"                                \n"+
"                            ")
                    .useFor(bundleSummaryItem);
    }

    public void append_Sales_Inactive_Summary(SummaryDisplayDef2 summaryDisplayDef) {
        new SummaryDisplayDefBuilder()
                    .appendAliasDef("viewWFStage","Stage")
                    .setDisplayHint("pix/meta/view_sm.gif")
                    .setAligment("center")
                    .setSortable("true")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFStageLinkUIBuilder")
                    .addAlias("BundleDef:/activeTaskName")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/name","Name")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendCustomizableDef("viewClauseText","Content")
                    .setDisplayHint("preview")
                    .setAligment("center")
                    .setSortable("false")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.ClauseTextJSONUIBuilder")
                    
                    .appendAliasDef("openBundle","Open")
                    .setDisplayHint("open")
                    .setAligment("center")
                    .setSortable("false")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFOpenLinkUIBuilder")
                    .addAlias("BundleDef:/activeTaskName")
                    
                    .appendCustomizableDef("copyBundle","Copy")
                    .setDisplayHint("copy")
                    .setAligment("center")
                    .setSortable("false")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFCopyBundleLinkUIBuilder")
                    
                    .appendParamDef("BundleDef:/lastModified","Modified Date")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("right")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/Flag","Flag")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ContractTypeRef","Contract Type")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseType","Clause Type")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseCategory","Category")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseSubCategory","Sub Category")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseStatus","Status")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseRisk","Risk")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendCustomizableDef("DeleteCheckBox","Delete")
                    .setDisplayHint("")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.MassDeleteUIBuilder")
                    
                    .useFor(summaryDisplayDef);
    }

    public void append_Sales_Draft_Draft(BundleSummaryItem bundleSummaryItem) {
        new BundleFilterLogicBuilder()
                    .buildList("")
                    .appendBundleFilterLogicWithScript("4",null,"\n"+
"                                \n"+
"                                result = thisBundle.getInfoValueObject(\"ClauseStatus\") == 'draft' && thisBundle.getInfoValueObject(\"ContractTypeRef\") == 'CSalesBO';\n"+
"                                \n"+
"                            ")
                    .useFor(bundleSummaryItem);
    }

    public void append_Sales_Draft_Summary(SummaryDisplayDef2 summaryDisplayDef) {
        new SummaryDisplayDefBuilder()
                    .appendAliasDef("viewWFStage","Stage")
                    .setDisplayHint("pix/meta/view_sm.gif")
                    .setAligment("center")
                    .setSortable("true")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFStageLinkUIBuilder")
                    .addAlias("BundleDef:/activeTaskName")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/name","Name")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendCustomizableDef("viewClauseText","Content")
                    .setDisplayHint("preview")
                    .setAligment("center")
                    .setSortable("false")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.ClauseTextJSONUIBuilder")
                    
                    .appendAliasDef("openBundle","Open")
                    .setDisplayHint("open")
                    .setAligment("center")
                    .setSortable("false")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFOpenLinkUIBuilder")
                    .addAlias("BundleDef:/activeTaskName")
                    
                    .appendCustomizableDef("copyBundle","Copy")
                    .setDisplayHint("copy")
                    .setAligment("center")
                    .setSortable("false")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFCopyBundleLinkUIBuilder")
                    
                    .appendParamDef("BundleDef:/lastModified","Modified Date")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("right")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/Flag","Flag")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ContractTypeRef","Contract Type")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseType","Clause Type")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseCategory","Category")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseSubCategory","Sub Category")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseStatus","Status")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseRisk","Risk")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendCustomizableDef("DeleteCheckBox","Delete")
                    .setDisplayHint("")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.MassDeleteUIBuilder")
                    
                    .useFor(summaryDisplayDef);
    }

    public void append_General_All_All(BundleSummaryItem bundleSummaryItem) {
        new BundleFilterLogicBuilder()
                    .buildList("")
                    .appendBundleFilterLogicWithScript("1",null,"\n"+
"                                \n"+
"                                result = thisBundle.getInfoValueObject(\"ContractTypeRef\") == 'CGenBO';\n"+
"                                \n"+
"                            ")
                    .useFor(bundleSummaryItem);
    }

    public void append_General_All_Summary(SummaryDisplayDef2 summaryDisplayDef) {
        new SummaryDisplayDefBuilder()
                    .appendAliasDef("viewWFStage","Stage")
                    .setDisplayHint("pix/meta/view_sm.gif")
                    .setAligment("center")
                    .setSortable("true")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFStageLinkUIBuilder")
                    .addAlias("BundleDef:/activeTaskName")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/name","Name")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendCustomizableDef("viewClauseText","Content")
                    .setDisplayHint("preview")
                    .setAligment("center")
                    .setSortable("false")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.ClauseTextJSONUIBuilder")
                    
                    .appendAliasDef("openBundle","Open")
                    .setDisplayHint("open")
                    .setAligment("center")
                    .setSortable("false")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFOpenLinkUIBuilder")
                    .addAlias("BundleDef:/activeTaskName")
                    
                    .appendCustomizableDef("copyBundle","Copy")
                    .setDisplayHint("copy")
                    .setAligment("center")
                    .setSortable("false")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFCopyBundleLinkUIBuilder")
                    
                    .appendParamDef("BundleDef:/lastModified","Modified Date")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("right")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/Flag","Flag")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ContractTypeRef","Contract Type")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseType","Clause Type")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseCategory","Category")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseSubCategory","Sub Category")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseStatus","Status")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseRisk","Risk")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendCustomizableDef("DeleteCheckBox","Delete")
                    .setDisplayHint("")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.MassDeleteUIBuilder")
                    
                    .useFor(summaryDisplayDef);
    }

    public void append_General_Active_Active(BundleSummaryItem bundleSummaryItem) {
        new BundleFilterLogicBuilder()
                    .buildList("")
                    .appendBundleFilterLogicWithScript("2",null,"\n"+
"                                \n"+
"                                result = thisBundle.getInfoValueObject(\"ClauseStatus\") == 'active' && thisBundle.getInfoValueObject(\"ContractTypeRef\") == 'CGenBO';\n"+
"                                \n"+
"                            ")
                    .useFor(bundleSummaryItem);
    }

    public void append_General_Active_Summary(SummaryDisplayDef2 summaryDisplayDef) {
        new SummaryDisplayDefBuilder()
                    .appendAliasDef("viewWFStage","Stage")
                    .setDisplayHint("pix/meta/view_sm.gif")
                    .setAligment("center")
                    .setSortable("true")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFStageLinkUIBuilder")
                    .addAlias("BundleDef:/activeTaskName")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/name","Name")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendCustomizableDef("viewClauseText","Content")
                    .setDisplayHint("preview")
                    .setAligment("center")
                    .setSortable("false")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.ClauseTextJSONUIBuilder")
                    
                    .appendAliasDef("openBundle","Open")
                    .setDisplayHint("open")
                    .setAligment("center")
                    .setSortable("false")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFOpenLinkUIBuilder")
                    .addAlias("BundleDef:/activeTaskName")
                    
                    .appendCustomizableDef("copyBundle","Copy")
                    .setDisplayHint("copy")
                    .setAligment("center")
                    .setSortable("false")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFCopyBundleLinkUIBuilder")
                    
                    .appendParamDef("BundleDef:/lastModified","Modified Date")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("right")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/Flag","Flag")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ContractTypeRef","Contract Type")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseType","Clause Type")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseCategory","Category")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseSubCategory","Sub Category")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseStatus","Status")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseRisk","Risk")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .useFor(summaryDisplayDef);
    }

    public void append_General_Inactive_Inactive(BundleSummaryItem bundleSummaryItem) {
        new BundleFilterLogicBuilder()
                    .buildList("")
                    .appendBundleFilterLogicWithScript("3",null,"\n"+
"                                \n"+
"                                result = thisBundle.getInfoValueObject(\"ClauseStatus\") == 'inactive' && thisBundle.getInfoValueObject(\"ContractTypeRef\") == 'CGenBO';\n"+
"                                \n"+
"                            ")
                    .useFor(bundleSummaryItem);
    }

    public void append_General_Inactive_Summary(SummaryDisplayDef2 summaryDisplayDef) {
        new SummaryDisplayDefBuilder()
                    .appendAliasDef("viewWFStage","Stage")
                    .setDisplayHint("pix/meta/view_sm.gif")
                    .setAligment("center")
                    .setSortable("true")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFStageLinkUIBuilder")
                    .addAlias("BundleDef:/activeTaskName")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/name","Name")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendCustomizableDef("viewClauseText","Content")
                    .setDisplayHint("preview")
                    .setAligment("center")
                    .setSortable("false")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.ClauseTextJSONUIBuilder")
                    
                    .appendAliasDef("openBundle","Open")
                    .setDisplayHint("open")
                    .setAligment("center")
                    .setSortable("false")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFOpenLinkUIBuilder")
                    .addAlias("BundleDef:/activeTaskName")
                    
                    .appendCustomizableDef("copyBundle","Copy")
                    .setDisplayHint("copy")
                    .setAligment("center")
                    .setSortable("false")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFCopyBundleLinkUIBuilder")
                    
                    .appendParamDef("BundleDef:/lastModified","Modified Date")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("right")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/Flag","Flag")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ContractTypeRef","Contract Type")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseType","Clause Type")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseCategory","Category")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseSubCategory","Sub Category")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseStatus","Status")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseRisk","Risk")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendCustomizableDef("DeleteCheckBox","Delete")
                    .setDisplayHint("")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.MassDeleteUIBuilder")
                    
                    .useFor(summaryDisplayDef);
    }

    public void append_General_Draft_Draft(BundleSummaryItem bundleSummaryItem) {
        new BundleFilterLogicBuilder()
                    .buildList("")
                    .appendBundleFilterLogicWithScript("4",null,"\n"+
"                                \n"+
"                                result = thisBundle.getInfoValueObject(\"ClauseStatus\") == 'draft' && thisBundle.getInfoValueObject(\"ContractTypeRef\") == 'CGenBO';\n"+
"                                \n"+
"                            ")
                    .useFor(bundleSummaryItem);
    }

    public void append_General_Draft_Summary(SummaryDisplayDef2 summaryDisplayDef) {
        new SummaryDisplayDefBuilder()
                    .appendAliasDef("viewWFStage","Stage")
                    .setDisplayHint("pix/meta/view_sm.gif")
                    .setAligment("center")
                    .setSortable("true")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFStageLinkUIBuilder")
                    .addAlias("BundleDef:/activeTaskName")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/name","Name")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendCustomizableDef("viewClauseText","Content")
                    .setDisplayHint("preview")
                    .setAligment("center")
                    .setSortable("false")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.ClauseTextJSONUIBuilder")
                    
                    .appendAliasDef("openBundle","Open")
                    .setDisplayHint("open")
                    .setAligment("center")
                    .setSortable("false")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFOpenLinkUIBuilder")
                    .addAlias("BundleDef:/activeTaskName")
                    
                    .appendCustomizableDef("copyBundle","Copy")
                    .setDisplayHint("copy")
                    .setAligment("center")
                    .setSortable("false")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFCopyBundleLinkUIBuilder")
                    
                    .appendParamDef("BundleDef:/lastModified","Modified Date")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("right")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/Flag","Flag")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ContractTypeRef","Contract Type")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseType","Clause Type")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseCategory","Category")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseSubCategory","Sub Category")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseStatus","Status")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseRisk","Risk")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendCustomizableDef("DeleteCheckBox","Delete")
                    .setDisplayHint("")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.MassDeleteUIBuilder")
                    
                    .useFor(summaryDisplayDef);
    }

    public void append_Framework1_All_All(BundleSummaryItem bundleSummaryItem) {
        new BundleFilterLogicBuilder()
                    .buildList("")
                    .appendBundleFilterLogicWithScript("1",null,"\n"+
"                                \n"+
"                                result = thisBundle.getInfoValueObject(\"ContractTypeRef\") == 'CFR1BO';\n"+
"                                \n"+
"                            ")
                    .useFor(bundleSummaryItem);
    }

    public void append_Framework1_All_Summary(SummaryDisplayDef2 summaryDisplayDef) {
        new SummaryDisplayDefBuilder()
                    .appendAliasDef("viewWFStage","Stage")
                    .setDisplayHint("pix/meta/view_sm.gif")
                    .setAligment("center")
                    .setSortable("true")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFStageLinkUIBuilder")
                    .addAlias("BundleDef:/activeTaskName")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/name","Name")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendCustomizableDef("viewClauseText","Content")
                    .setDisplayHint("preview")
                    .setAligment("center")
                    .setSortable("false")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.ClauseTextJSONUIBuilder")
                    
                    .appendAliasDef("openBundle","Open")
                    .setDisplayHint("open")
                    .setAligment("center")
                    .setSortable("false")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFOpenLinkUIBuilder")
                    .addAlias("BundleDef:/activeTaskName")
                    
                    .appendCustomizableDef("copyBundle","Copy")
                    .setDisplayHint("copy")
                    .setAligment("center")
                    .setSortable("false")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFCopyBundleLinkUIBuilder")
                    
                    .appendParamDef("BundleDef:/lastModified","Modified Date")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("right")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/Flag","Flag")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ContractTypeRef","Contract Type")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseType","Clause Type")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseCategory","Category")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseSubCategory","Sub Category")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseStatus","Status")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseRisk","Risk")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendCustomizableDef("DeleteCheckBox","Delete")
                    .setDisplayHint("")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.MassDeleteUIBuilder")
                    
                    .useFor(summaryDisplayDef);
    }

    public void append_Framework1_Active_Active(BundleSummaryItem bundleSummaryItem) {
        new BundleFilterLogicBuilder()
                    .buildList("")
                    .appendBundleFilterLogicWithScript("2",null,"\n"+
"                                \n"+
"                                result = thisBundle.getInfoValueObject(\"ClauseStatus\") == 'active' && thisBundle.getInfoValueObject(\"ContractTypeRef\") == 'CFR1BO';\n"+
"                                \n"+
"                            ")
                    .useFor(bundleSummaryItem);
    }

    public void append_Framework1_Active_Summary(SummaryDisplayDef2 summaryDisplayDef) {
        new SummaryDisplayDefBuilder()
                    .appendAliasDef("viewWFStage","Stage")
                    .setDisplayHint("pix/meta/view_sm.gif")
                    .setAligment("center")
                    .setSortable("true")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFStageLinkUIBuilder")
                    .addAlias("BundleDef:/activeTaskName")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/name","Name")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendCustomizableDef("viewClauseText","Content")
                    .setDisplayHint("preview")
                    .setAligment("center")
                    .setSortable("false")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.ClauseTextJSONUIBuilder")
                    
                    .appendAliasDef("openBundle","Open")
                    .setDisplayHint("open")
                    .setAligment("center")
                    .setSortable("false")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFOpenLinkUIBuilder")
                    .addAlias("BundleDef:/activeTaskName")
                    
                    .appendCustomizableDef("copyBundle","Copy")
                    .setDisplayHint("copy")
                    .setAligment("center")
                    .setSortable("false")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFCopyBundleLinkUIBuilder")
                    
                    .appendParamDef("BundleDef:/lastModified","Modified Date")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("right")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/Flag","Flag")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ContractTypeRef","Contract Type")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseType","Clause Type")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseCategory","Category")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseSubCategory","Sub Category")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseStatus","Status")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseRisk","Risk")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .useFor(summaryDisplayDef);
    }

    public void append_Framework1_Inactive_Inactive(BundleSummaryItem bundleSummaryItem) {
        new BundleFilterLogicBuilder()
                    .buildList("")
                    .appendBundleFilterLogicWithScript("3",null,"\n"+
"                                \n"+
"                                result = thisBundle.getInfoValueObject(\"ClauseStatus\") == 'inactive' && thisBundle.getInfoValueObject(\"ContractTypeRef\") == 'CFR1BO';\n"+
"                                \n"+
"                            ")
                    .useFor(bundleSummaryItem);
    }

    public void append_Framework1_Inactive_Summary(SummaryDisplayDef2 summaryDisplayDef) {
        new SummaryDisplayDefBuilder()
                    .appendAliasDef("viewWFStage","Stage")
                    .setDisplayHint("pix/meta/view_sm.gif")
                    .setAligment("center")
                    .setSortable("true")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFStageLinkUIBuilder")
                    .addAlias("BundleDef:/activeTaskName")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/name","Name")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendCustomizableDef("viewClauseText","Content")
                    .setDisplayHint("preview")
                    .setAligment("center")
                    .setSortable("false")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.ClauseTextJSONUIBuilder")
                    
                    .appendAliasDef("openBundle","Open")
                    .setDisplayHint("open")
                    .setAligment("center")
                    .setSortable("false")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFOpenLinkUIBuilder")
                    .addAlias("BundleDef:/activeTaskName")
                    
                    .appendCustomizableDef("copyBundle","Copy")
                    .setDisplayHint("copy")
                    .setAligment("center")
                    .setSortable("false")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFCopyBundleLinkUIBuilder")
                    
                    .appendParamDef("BundleDef:/lastModified","Modified Date")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("right")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/Flag","Flag")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ContractTypeRef","Contract Type")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseType","Clause Type")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseCategory","Category")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseSubCategory","Sub Category")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseStatus","Status")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseRisk","Risk")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendCustomizableDef("DeleteCheckBox","Delete")
                    .setDisplayHint("")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.MassDeleteUIBuilder")
                    
                    .useFor(summaryDisplayDef);
    }

    public void append_Framework1_Draft_Draft(BundleSummaryItem bundleSummaryItem) {
        new BundleFilterLogicBuilder()
                    .buildList("")
                    .appendBundleFilterLogicWithScript("4",null,"\n"+
"                                \n"+
"                                result = thisBundle.getInfoValueObject(\"ClauseStatus\") == 'draft' && thisBundle.getInfoValueObject(\"ContractTypeRef\") == 'CFR1BO';\n"+
"                                \n"+
"                            ")
                    .useFor(bundleSummaryItem);
    }

    public void append_Framework1_Draft_Summary(SummaryDisplayDef2 summaryDisplayDef) {
        new SummaryDisplayDefBuilder()
                    .appendAliasDef("viewWFStage","Stage")
                    .setDisplayHint("pix/meta/view_sm.gif")
                    .setAligment("center")
                    .setSortable("true")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFStageLinkUIBuilder")
                    .addAlias("BundleDef:/activeTaskName")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/name","Name")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendCustomizableDef("viewClauseText","Content")
                    .setDisplayHint("preview")
                    .setAligment("center")
                    .setSortable("false")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.ClauseTextJSONUIBuilder")
                    
                    .appendAliasDef("openBundle","Open")
                    .setDisplayHint("open")
                    .setAligment("center")
                    .setSortable("false")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFOpenLinkUIBuilder")
                    .addAlias("BundleDef:/activeTaskName")
                    
                    .appendCustomizableDef("copyBundle","Copy")
                    .setDisplayHint("copy")
                    .setAligment("center")
                    .setSortable("false")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFCopyBundleLinkUIBuilder")
                    
                    .appendParamDef("BundleDef:/lastModified","Modified Date")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("right")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/Flag","Flag")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ContractTypeRef","Contract Type")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseType","Clause Type")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseCategory","Category")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseSubCategory","Sub Category")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseStatus","Status")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseRisk","Risk")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendCustomizableDef("DeleteCheckBox","Delete")
                    .setDisplayHint("")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.MassDeleteUIBuilder")
                    
                    .useFor(summaryDisplayDef);
    }

    public void append_Repository_All_All(BundleSummaryItem bundleSummaryItem) {
        new BundleFilterLogicBuilder()
                    .buildList("")
                    .appendBundleFilterLogicWithScript("1",null,"\n"+
"                                \n"+
"                                result = thisBundle.getInfoValueObject(\"ContractTypeRef\") == 'RREPBO';\n"+
"                                \n"+
"                            ")
                    .useFor(bundleSummaryItem);
    }

    public void append_Repository_All_Summary(SummaryDisplayDef2 summaryDisplayDef) {
        new SummaryDisplayDefBuilder()
                    .appendAliasDef("viewWFStage","Stage")
                    .setDisplayHint("pix/meta/view_sm.gif")
                    .setAligment("center")
                    .setSortable("true")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFStageLinkUIBuilder")
                    .addAlias("BundleDef:/activeTaskName")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/name","Name")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendCustomizableDef("viewClauseText","Content")
                    .setDisplayHint("preview")
                    .setAligment("center")
                    .setSortable("false")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.ClauseTextJSONUIBuilder")
                    
                    .appendAliasDef("openBundle","Open")
                    .setDisplayHint("open")
                    .setAligment("center")
                    .setSortable("false")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFOpenLinkUIBuilder")
                    .addAlias("BundleDef:/activeTaskName")
                    
                    .appendCustomizableDef("copyBundle","Copy")
                    .setDisplayHint("copy")
                    .setAligment("center")
                    .setSortable("false")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFCopyBundleLinkUIBuilder")
                    
                    .appendParamDef("BundleDef:/lastModified","Modified Date")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("right")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/Flag","Flag")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ContractTypeRef","Contract Type")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseType","Clause Type")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseCategory","Category")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseSubCategory","Sub Category")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseStatus","Status")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseRisk","Risk")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendCustomizableDef("DeleteCheckBox","Delete")
                    .setDisplayHint("")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.MassDeleteUIBuilder")
                    
                    .useFor(summaryDisplayDef);
    }

    public void append_Repository_Active_Active(BundleSummaryItem bundleSummaryItem) {
        new BundleFilterLogicBuilder()
                    .buildList("")
                    .appendBundleFilterLogicWithScript("2",null,"\n"+
"                                \n"+
"                                result = thisBundle.getInfoValueObject(\"ClauseStatus\") == 'active' && thisBundle.getInfoValueObject(\"ContractTypeRef\") == 'RREPBO';\n"+
"                                \n"+
"                            ")
                    .useFor(bundleSummaryItem);
    }

    public void append_Repository_Active_Summary(SummaryDisplayDef2 summaryDisplayDef) {
        new SummaryDisplayDefBuilder()
                    .appendAliasDef("viewWFStage","Stage")
                    .setDisplayHint("pix/meta/view_sm.gif")
                    .setAligment("center")
                    .setSortable("true")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFStageLinkUIBuilder")
                    .addAlias("BundleDef:/activeTaskName")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/name","Name")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendCustomizableDef("viewClauseText","Content")
                    .setDisplayHint("preview")
                    .setAligment("center")
                    .setSortable("false")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.ClauseTextJSONUIBuilder")
                    
                    .appendAliasDef("openBundle","Open")
                    .setDisplayHint("open")
                    .setAligment("center")
                    .setSortable("false")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFOpenLinkUIBuilder")
                    .addAlias("BundleDef:/activeTaskName")
                    
                    .appendCustomizableDef("copyBundle","Copy")
                    .setDisplayHint("copy")
                    .setAligment("center")
                    .setSortable("false")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFCopyBundleLinkUIBuilder")
                    
                    .appendParamDef("BundleDef:/lastModified","Modified Date")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("right")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/Flag","Flag")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ContractTypeRef","Contract Type")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseType","Clause Type")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseCategory","Category")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseSubCategory","Sub Category")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseStatus","Status")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseRisk","Risk")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .useFor(summaryDisplayDef);
    }

    public void append_Repository_Inactive_Inactive(BundleSummaryItem bundleSummaryItem) {
        new BundleFilterLogicBuilder()
                    .buildList("")
                    .appendBundleFilterLogicWithScript("3",null,"\n"+
"                                \n"+
"                                result = thisBundle.getInfoValueObject(\"ClauseStatus\") == 'inactive' && thisBundle.getInfoValueObject(\"ContractTypeRef\") == 'RREPBO';\n"+
"                                \n"+
"                            ")
                    .useFor(bundleSummaryItem);
    }

    public void append_Repository_Inactive_Summary(SummaryDisplayDef2 summaryDisplayDef) {
        new SummaryDisplayDefBuilder()
                    .appendAliasDef("viewWFStage","Stage")
                    .setDisplayHint("pix/meta/view_sm.gif")
                    .setAligment("center")
                    .setSortable("true")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFStageLinkUIBuilder")
                    .addAlias("BundleDef:/activeTaskName")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/name","Name")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendCustomizableDef("viewClauseText","Content")
                    .setDisplayHint("preview")
                    .setAligment("center")
                    .setSortable("false")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.ClauseTextJSONUIBuilder")
                    
                    .appendAliasDef("openBundle","Open")
                    .setDisplayHint("open")
                    .setAligment("center")
                    .setSortable("false")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFOpenLinkUIBuilder")
                    .addAlias("BundleDef:/activeTaskName")
                    
                    .appendCustomizableDef("copyBundle","Copy")
                    .setDisplayHint("copy")
                    .setAligment("center")
                    .setSortable("false")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFCopyBundleLinkUIBuilder")
                    
                    .appendParamDef("BundleDef:/lastModified","Modified Date")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("right")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/Flag","Flag")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ContractTypeRef","Contract Type")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseType","Clause Type")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseCategory","Category")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseSubCategory","Sub Category")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseStatus","Status")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseRisk","Risk")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendCustomizableDef("DeleteCheckBox","Delete")
                    .setDisplayHint("")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.MassDeleteUIBuilder")
                    
                    .useFor(summaryDisplayDef);
    }

    public void append_Repository_Draft_Draft(BundleSummaryItem bundleSummaryItem) {
        new BundleFilterLogicBuilder()
                    .buildList("")
                    .appendBundleFilterLogicWithScript("4",null,"\n"+
"                                \n"+
"                                result = thisBundle.getInfoValueObject(\"ClauseStatus\") == 'draft' && thisBundle.getInfoValueObject(\"ContractTypeRef\") == 'RREPBO';\n"+
"                                \n"+
"                            ")
                    .useFor(bundleSummaryItem);
    }

    public void append_Repository_Draft_Summary(SummaryDisplayDef2 summaryDisplayDef) {
        new SummaryDisplayDefBuilder()
                    .appendAliasDef("viewWFStage","Stage")
                    .setDisplayHint("pix/meta/view_sm.gif")
                    .setAligment("center")
                    .setSortable("true")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFStageLinkUIBuilder")
                    .addAlias("BundleDef:/activeTaskName")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/name","Name")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendCustomizableDef("viewClauseText","Content")
                    .setDisplayHint("preview")
                    .setAligment("center")
                    .setSortable("false")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.ClauseTextJSONUIBuilder")
                    
                    .appendAliasDef("openBundle","Open")
                    .setDisplayHint("open")
                    .setAligment("center")
                    .setSortable("false")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFOpenLinkUIBuilder")
                    .addAlias("BundleDef:/activeTaskName")
                    
                    .appendCustomizableDef("copyBundle","Copy")
                    .setDisplayHint("copy")
                    .setAligment("center")
                    .setSortable("false")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFCopyBundleLinkUIBuilder")
                    
                    .appendParamDef("BundleDef:/lastModified","Modified Date")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("right")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/Flag","Flag")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ContractTypeRef","Contract Type")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseType","Clause Type")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseCategory","Category")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseSubCategory","Sub Category")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseStatus","Status")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("ClauseLibraryModule/ReqClauseAttributes/ClauseRisk","Risk")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendCustomizableDef("DeleteCheckBox","Delete")
                    .setDisplayHint("")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.MassDeleteUIBuilder")
                    
                    .useFor(summaryDisplayDef);
    }
}
