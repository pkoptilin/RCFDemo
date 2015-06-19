package com.selectica.rcfdev.navigation;

import com.selectica.internalmodel.navigation.*;
import com.selectica.rcf.common.navigation.*;

public class NavigationContracts {

    public void append(NavNode2 navNode) {
        // extend navigation here;
    }

    public void append_Summary(SummaryDisplayDef2 summaryDisplayDef) {
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
                    
                    .appendCustomizableDef("contractDocuments","Contract Documents")
                    .setDisplayHint("documents")
                    .setAligment("center")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.ContractsDownloadUIBuilder")
                    
                    .appendCustomizableDef("copyBundle","Copy")
                    .setDisplayHint("copy")
                    .setAligment("center")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFCopyBundleLinkUIBuilder")
                    
                    .appendCustomizableDef("reassignBundleOwner","Reassign")
                    .setDisplayHint("reassign")
                    .setAligment("center")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFReassignBundleOwnerUIBuilder")
                    
                    .appendAliasDef("viewBundleAttachments","Attachment")
                    .setDisplayHint("attachment")
                    .setAligment("center")
                    .setSortable("false")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFOpenAttachmentsLinkUIBuilder")
                    .addAlias("BundleDef:/activeTaskName")
                    
                    .appendParamDef("BundleDef:/lastModified","Modified Date")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("right")
                    .setSortable("true")
                    .setRenderer("parameter")
                    .setWidth("170px")
                    
                    .appendAliasDef("contractType","Contract Type")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("defaultAliasResolver")
                    .addAlias("BundleDef:/bundleType")
                    
                    .appendAliasDef("agrType","Agreement Type")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("left")
                    .setSortable("true")
                    .setRenderer("defaultAliasResolver")
                    .addAlias("CNDAData/ReqCNDADetails/agrType")
                    .addAlias("CSalesData/ReqCSalesDetails/agrType")
                    .addAlias("CProcData/ReqCProcDetails/agrType")
                    .addAlias("CGenData/ReqCGenDetails/agrType")
                    .addAlias("CFR1Data/ReqCFR1Details/agrType")
                    .addAlias("RREPData/ReqRRepDetails/agrType")
                    
                    .appendAliasDef("status","Status")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("left")
                    .setSortable("true")
                    .setRenderer("defaultAliasResolver")
                    .addAlias("CNDAData/ReqCNDADetails/contractStatus")
                    .addAlias("CSalesData/ReqCSalesDetails/contractStatus")
                    .addAlias("CProcData/ReqCProcDetails/contractStatus")
                    .addAlias("CGenData/ReqCGenDetails/contractStatus")
                    .addAlias("CFR1Data/ReqCFR1Details/contractStatus")
                    .addAlias("RREPData/ReqRRepDetails/contractStatus")
                    
                    .appendAliasDef("cpName","Counterparty")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("left")
                    .setSortable("true")
                    .setRenderer("defaultAliasResolver")
                    .addAlias("CNDAData/ReqCNDADetails/cpName")
                    .addAlias("CSalesData/ReqCSalesDetails/cpName")
                    .addAlias("CProcData/ReqCProcDetails/cpName")
                    .addAlias("CGenData/ReqCGenDetails/cpName")
                    .addAlias("CFR1Data/ReqCFR1Details/cpName")
                    .addAlias("RREPData/ReqRRepDetails/cpName")
                    
                    .appendAliasDef("startDate","Effective Date")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("right")
                    .setSortable("true")
                    .setRenderer("defaultAliasResolver")
                    .addAlias("CNDAData/ReqCNDADetails/startDate")
                    .addAlias("CSalesData/ReqCSalesDetails/startDate")
                    .addAlias("CProcData/ReqCProcDetails/startDate")
                    .addAlias("CGenData/ReqCGenDetails/startDate")
                    .addAlias("CFR1Data/ReqCFR1Details/startDate")
                    .addAlias("RREPData/ReqRRepDetails/startDate")
                    
                    .appendAliasDef("endDate","Expiration Date")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("right")
                    .setSortable("true")
                    .setRenderer("defaultAliasResolver")
                    .addAlias("CNDAData/ReqCNDADetails/endDate")
                    .addAlias("CSalesData/ReqCSalesDetails/endDate")
                    .addAlias("CProcData/ReqCProcDetails/endDate")
                    .addAlias("CGenData/ReqCGenDetails/endDate")
                    .addAlias("CFR1Data/ReqCFR1Details/endDate")
                    .addAlias("RREPData/ReqRRepDetails/endDate")
                    
                    .appendAliasDef("buUnit","Business Unit")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("left")
                    .setSortable("true")
                    .setRenderer("defaultAliasResolver")
                    .addAlias("CNDAData/ReqCNDADetails/bussUnit")
                    .addAlias("CSalesData/ReqCSalesDetails/bussUnit")
                    .addAlias("CProcData/ReqCProcDetails/bussUnit")
                    .addAlias("CGenData/ReqCGenDetails/bussUnit")
                    .addAlias("CFR1Data/ReqCFR1Details/bussUnit")
                    .addAlias("RREPData/ReqRRepDetails/bussUnit")
                    
                    .appendAliasDef("req","Requestor")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("left")
                    .setSortable("true")
                    .setRenderer("defaultAliasResolver")
                    .addAlias("CNDAData/ReqCNDADetails/requestor")
                    .addAlias("CSalesData/ReqCSalesDetails/requestor")
                    .addAlias("CProcData/ReqCProcDetails/requestor")
                    .addAlias("CGenData/ReqCGenDetails/requestor")
                    .addAlias("CFR1Data/ReqCFR1Details/requestor")
                    
                    .appendAliasDef("reqDate","Request Date")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("right")
                    .setSortable("true")
                    .setRenderer("defaultAliasResolver")
                    .addAlias("CNDAData/ReqCNDADetails/reqDate")
                    .addAlias("CSalesData/ReqCSalesDetails/reqDate")
                    .addAlias("CProcData/ReqCProcDetails/reqDate")
                    .addAlias("CGenData/ReqCGenDetails/reqDate")
                    .addAlias("CFR1Data/ReqCFR1Details/reqDate")
                    .addAlias("RREPData/ReqRRepDetails/reqDate")
                    
                    .appendAliasDef("thirdParty1","Is this a Counterparty paper?")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("left")
                    .setSortable("true")
                    .setRenderer("defaultAliasResolver")
                    .addAlias("CNDAData/ReqCNDADetails/thirdParty1")
                    .addAlias("CSalesData/ReqCSalesDetails/thirdParty1")
                    .addAlias("CProcData/ReqCProcDetails/thirdParty1")
                    .addAlias("CGenData/ReqCGenDetails/thirdParty1")
                    .addAlias("CFR1Data/ReqCFR1Details/thirdParty1")
                    
                    .appendAliasDef("bunOwn","Owning User")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("defaultAliasResolver")
                    .addAlias("BundleDef:/bundleOwnerUser")
                    
                    .appendAliasDef("bunGrp","Owning Group")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("defaultAliasResolver")
                    .addAlias("BundleDef:/bundleOwnerGroup")
                    
                    .appendAliasDef("ID","Contract ID")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("left")
                    .setSortable("true")
                    .setRenderer("defaultAliasResolver")
                    .addAlias("CNDAData/ReqCNDADetails/name")
                    .addAlias("CSalesData/ReqCSalesDetails/name")
                    .addAlias("CProcData/ReqCProcDetails/name")
                    .addAlias("CGenData/ReqCGenDetails/name")
                    .addAlias("CFR1Data/ReqCFR1Details/name")
                    .addAlias("RREPData/ReqRRepDetails/name")
                    
                    .appendCustomizableDef("DeleteCheckBox","Delete")
                    .setDisplayHint("")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.MassDeleteUIBuilder")
                    
                    .useFor(summaryDisplayDef);
    }

    public void append_NDA_OneWayNDA_0(BundleSummaryItem bundleSummaryItem) {
        new BundleFilterLogicBuilder()
                    .buildList("")
                    .appendBundleFilterLogicWithScript("1",null,"\n"+
"                                \n"+
"                                result = thisBundle.getInfoValueObject(\"agrType\") == 'One Way NDA';\n"+
"                                \n"+
"                            ")
                    .useFor(bundleSummaryItem);
    }

    public void append_NDA_MutualNDA_0(BundleSummaryItem bundleSummaryItem) {
        new BundleFilterLogicBuilder()
                    .buildList("")
                    .appendBundleFilterLogicWithScript("1",null,"\n"+
"                                \n"+
"                                result = thisBundle.getInfoValueObject(\"agrType\") == 'Mutual NDA';\n"+
"                                \n"+
"                            ")
                    .useFor(bundleSummaryItem);
    }

    public void append_NDA_CDA_0(BundleSummaryItem bundleSummaryItem) {
        new BundleFilterLogicBuilder()
                    .buildList("")
                    .appendBundleFilterLogicWithScript("1",null,"\n"+
"                                \n"+
"                                result = thisBundle.getInfoValueObject(\"agrType\") == 'CDA';\n"+
"                                \n"+
"                            ")
                    .useFor(bundleSummaryItem);
    }

    public void append_NDA_Summary(SummaryDisplayDef2 summaryDisplayDef) {
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
                    
                    .appendCustomizableDef("contractDocuments","Contract Documents")
                    .setDisplayHint("documents")
                    .setAligment("center")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.ContractsDownloadUIBuilder")
                    
                    .appendCustomizableDef("copyBundle","Copy")
                    .setDisplayHint("copy")
                    .setAligment("center")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFCopyBundleLinkUIBuilder")
                    
                    .appendCustomizableDef("reassignBundleOwner","Reassign")
                    .setDisplayHint("reassign")
                    .setAligment("center")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFReassignBundleOwnerUIBuilder")
                    
                    .appendAliasDef("viewBundleAttachments","Attachment")
                    .setDisplayHint("attachment")
                    .setAligment("center")
                    .setSortable("false")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFOpenAttachmentsLinkUIBuilder")
                    .addAlias("BundleDef:/activeTaskName")
                    
                    .appendParamDef("BundleDef:/lastModified","Modified Date")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("right")
                    .setSortable("true")
                    .setRenderer("parameter")
                    .setWidth("170px")
                    
                    .appendAliasDef("agrType","Agreement Type")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("left")
                    .setSortable("true")
                    .setRenderer("defaultAliasResolver")
                    .addAlias("CNDAData/ReqCNDADetails/agrType")
                    
                    .appendAliasDef("status","Status")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("left")
                    .setSortable("true")
                    .setRenderer("defaultAliasResolver")
                    .addAlias("CNDAData/ReqCNDADetails/contractStatus")
                    
                    .appendAliasDef("cpName","Counterparty")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("left")
                    .setSortable("true")
                    .setRenderer("defaultAliasResolver")
                    .addAlias("CNDAData/ReqCNDADetails/cpName")
                    
                    .appendAliasDef("startDate","Effective Date")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("right")
                    .setSortable("true")
                    .setRenderer("defaultAliasResolver")
                    .addAlias("CNDAData/ReqCNDADetails/startDate")
                    
                    .appendAliasDef("endDate","Expiration Date")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("right")
                    .setSortable("true")
                    .setRenderer("defaultAliasResolver")
                    .addAlias("CNDAData/ReqCNDADetails/endDate")
                    
                    .appendAliasDef("buUnit","Business Unit")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("left")
                    .setSortable("true")
                    .setRenderer("defaultAliasResolver")
                    .addAlias("CNDAData/ReqCNDADetails/bussUnit")
                    
                    .appendAliasDef("req","Requestor")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("left")
                    .setSortable("true")
                    .setRenderer("defaultAliasResolver")
                    .addAlias("CNDAData/ReqCNDADetails/requestor")
                    
                    .appendAliasDef("reqDate","Request Date")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("right")
                    .setSortable("true")
                    .setRenderer("defaultAliasResolver")
                    .addAlias("CNDAData/ReqCNDADetails/reqDate")
                    
                    .appendAliasDef("thirdParty1","Is this a Counterparty paper?")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("left")
                    .setSortable("true")
                    .setRenderer("defaultAliasResolver")
                    .addAlias("CNDAData/ReqCNDADetails/thirdParty1")
                    
                    .appendAliasDef("bunOwn","Owning User")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("defaultAliasResolver")
                    .addAlias("BundleDef:/bundleOwnerUser")
                    
                    .appendAliasDef("bunGrp","Owning Group")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("defaultAliasResolver")
                    .addAlias("BundleDef:/bundleOwnerGroup")
                    
                    .appendAliasDef("ID","Contract ID")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("left")
                    .setSortable("true")
                    .setRenderer("defaultAliasResolver")
                    .addAlias("CNDAData/ReqCNDADetails/name")
                    
                    .appendCustomizableDef("DeleteCheckBox","Delete")
                    .setDisplayHint("")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.MassDeleteUIBuilder")
                    
                    .useFor(summaryDisplayDef);
    }

    public void append_Procurement_Master_0(BundleSummaryItem bundleSummaryItem) {
        new BundleFilterLogicBuilder()
                    .buildList("")
                    .appendBundleFilterLogicWithScript("1",null,"\n"+
"                                \n"+
"                                var agrType = thisBundle.getInfoValueObject(\"agrType\");\n"+
"                                result = agrType == 'Master';\n"+
"                                \n"+
"                            ")
                    .useFor(bundleSummaryItem);
    }

    public void append_Procurement_SubAgreement_0(BundleSummaryItem bundleSummaryItem) {
        new BundleFilterLogicBuilder()
                    .buildList("")
                    .appendBundleFilterLogicWithScript("1",null,"\n"+
"                                \n"+
"                                var agrType = thisBundle.getInfoValueObject(\"agrType\");\n"+
"                                result = agrType == 'Sub Agreement';\n"+
"                                \n"+
"                            ")
                    .useFor(bundleSummaryItem);
    }

    public void append_Procurement_Summary(SummaryDisplayDef2 summaryDisplayDef) {
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
                    
                    .appendCustomizableDef("contractDocuments","Contract Documents")
                    .setDisplayHint("documents")
                    .setAligment("center")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.ContractsDownloadUIBuilder")
                    
                    .appendCustomizableDef("copyBundle","Copy")
                    .setDisplayHint("copy")
                    .setAligment("center")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFCopyBundleLinkUIBuilder")
                    
                    .appendCustomizableDef("reassignBundleOwner","Reassign")
                    .setDisplayHint("reassign")
                    .setAligment("center")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFReassignBundleOwnerUIBuilder")
                    
                    .appendAliasDef("viewBundleAttachments","Attachment")
                    .setDisplayHint("attachment")
                    .setAligment("center")
                    .setSortable("false")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFOpenAttachmentsLinkUIBuilder")
                    .addAlias("BundleDef:/activeTaskName")
                    
                    .appendParamDef("BundleDef:/lastModified","Modified Date")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("right")
                    .setSortable("true")
                    .setRenderer("parameter")
                    .setWidth("170px")
                    
                    .appendAliasDef("agrType","Agreement Type")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("left")
                    .setSortable("true")
                    .setRenderer("defaultAliasResolver")
                    .addAlias("CProcData/ReqCProcDetails/agrType")
                    
                    .appendAliasDef("agrCat","Agreement Category")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("left")
                    .setSortable("true")
                    .setRenderer("defaultAliasResolver")
                    .addAlias("CProcData/ReqCProcDetails/agrCat")
                    
                    .appendAliasDef("status","Status")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("left")
                    .setSortable("true")
                    .setRenderer("defaultAliasResolver")
                    .addAlias("CProcData/ReqCProcDetails/contractStatus")
                    
                    .appendAliasDef("cpName","Counterparty")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("left")
                    .setSortable("true")
                    .setRenderer("defaultAliasResolver")
                    .addAlias("CProcData/ReqCProcDetails/cpName")
                    
                    .appendAliasDef("startDate","Effective Date")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("right")
                    .setSortable("true")
                    .setRenderer("defaultAliasResolver")
                    .addAlias("CProcData/ReqCProcDetails/startDate")
                    
                    .appendAliasDef("endDate","Expiration Date")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("right")
                    .setSortable("true")
                    .setRenderer("defaultAliasResolver")
                    .addAlias("CProcData/ReqCProcDetails/endDate")
                    
                    .appendAliasDef("buUnit","Business Unit")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("left")
                    .setSortable("true")
                    .setRenderer("defaultAliasResolver")
                    .addAlias("CProcData/ReqCProcDetails/bussUnit")
                    
                    .appendAliasDef("req","Requestor")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("left")
                    .setSortable("true")
                    .setRenderer("defaultAliasResolver")
                    .addAlias("CProcData/ReqCProcDetails/requestor")
                    
                    .appendAliasDef("reqDate","Request Date")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("right")
                    .setSortable("true")
                    .setRenderer("defaultAliasResolver")
                    .addAlias("CProcData/ReqCProcDetails/reqDate")
                    
                    .appendAliasDef("prdTotal","Product Total")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("right")
                    .setSortable("true")
                    .setRenderer("defaultAliasResolver")
                    .addAlias("CProcData/ReqCProcDetails/prdTotal")
                    
                    .appendAliasDef("serTotal","Services Total")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("right")
                    .setSortable("true")
                    .setRenderer("defaultAliasResolver")
                    .addAlias("CProcData/ReqCProcDetails/serTotal")
                    
                    .appendAliasDef("totalAmt","Total Amount")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("right")
                    .setSortable("true")
                    .setRenderer("defaultAliasResolver")
                    .addAlias("CProcData/ReqCProcDetails/totalAmt")
                    
                    .appendAliasDef("thirdParty1","Is this a Counterparty paper?")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("left")
                    .setSortable("true")
                    .setRenderer("defaultAliasResolver")
                    .addAlias("CProcData/ReqCProcDetails/thirdParty1")
                    
                    .appendAliasDef("bunOwn","Owning User")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("defaultAliasResolver")
                    .addAlias("BundleDef:/bundleOwnerUser")
                    
                    .appendAliasDef("bunGrp","Owning Group")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("defaultAliasResolver")
                    .addAlias("BundleDef:/bundleOwnerGroup")
                    
                    .appendAliasDef("ID","Contract ID")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("left")
                    .setSortable("true")
                    .setRenderer("defaultAliasResolver")
                    .addAlias("CProcData/ReqCProcDetails/name")
                    
                    .appendCustomizableDef("DeleteCheckBox","Delete")
                    .setDisplayHint("")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.MassDeleteUIBuilder")
                    
                    .useFor(summaryDisplayDef);
    }

    public void append_Sales_Master_0(BundleSummaryItem bundleSummaryItem) {
        new BundleFilterLogicBuilder()
                    .buildList("")
                    .appendBundleFilterLogicWithScript("1",null,"\n"+
"                                \n"+
"                                var agrType = thisBundle.getInfoValueObject(\"agrType\");\n"+
"                                result = agrType == 'Master';\n"+
"                                \n"+
"                            ")
                    .useFor(bundleSummaryItem);
    }

    public void append_Sales_SOW_0(BundleSummaryItem bundleSummaryItem) {
        new BundleFilterLogicBuilder()
                    .buildList("")
                    .appendBundleFilterLogicWithScript("1",null,"\n"+
"                                \n"+
"                                var agrType = thisBundle.getInfoValueObject(\"agrType\");\n"+
"                                result = agrType == 'SOW';\n"+
"                                \n"+
"                            ")
                    .useFor(bundleSummaryItem);
    }

    public void append_Sales_StandardSales_0(BundleSummaryItem bundleSummaryItem) {
        new BundleFilterLogicBuilder()
                    .buildList("")
                    .appendBundleFilterLogicWithScript("1",null,"\n"+
"                                \n"+
"                                var agrType = thisBundle.getInfoValueObject(\"agrType\");\n"+
"                                result = agrType == 'Standard Sales';\n"+
"                                \n"+
"                            ")
                    .useFor(bundleSummaryItem);
    }

    public void append_Sales_ChangeOrder_0(BundleSummaryItem bundleSummaryItem) {
        new BundleFilterLogicBuilder()
                    .buildList("")
                    .appendBundleFilterLogicWithScript("1",null,"\n"+
"                                \n"+
"                                var agrType = thisBundle.getInfoValueObject(\"agrType\");\n"+
"                                result = agrType == 'Change Order';\n"+
"                                \n"+
"                            ")
                    .useFor(bundleSummaryItem);
    }

    public void append_Sales_OrderForm_0(BundleSummaryItem bundleSummaryItem) {
        new BundleFilterLogicBuilder()
                    .buildList("")
                    .appendBundleFilterLogicWithScript("1",null,"\n"+
"                                \n"+
"                                var agrType = thisBundle.getInfoValueObject(\"agrType\");\n"+
"                                result = agrType == 'Order Form';\n"+
"                                \n"+
"                            ")
                    .useFor(bundleSummaryItem);
    }

    public void append_Sales_WorkOrder_0(BundleSummaryItem bundleSummaryItem) {
        new BundleFilterLogicBuilder()
                    .buildList("")
                    .appendBundleFilterLogicWithScript("1",null,"\n"+
"                                \n"+
"                                var agrType = thisBundle.getInfoValueObject(\"agrType\");\n"+
"                                result = agrType == 'Work Order';\n"+
"                                \n"+
"                            ")
                    .useFor(bundleSummaryItem);
    }

    public void append_Sales_Summary(SummaryDisplayDef2 summaryDisplayDef) {
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
                    
                    .appendCustomizableDef("contractDocuments","Contract Documents")
                    .setDisplayHint("documents")
                    .setAligment("center")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.ContractsDownloadUIBuilder")
                    
                    .appendCustomizableDef("copyBundle","Copy")
                    .setDisplayHint("copy")
                    .setAligment("center")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFCopyBundleLinkUIBuilder")
                    
                    .appendCustomizableDef("reassignBundleOwner","Reassign")
                    .setDisplayHint("reassign")
                    .setAligment("center")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFReassignBundleOwnerUIBuilder")
                    
                    .appendAliasDef("viewBundleAttachments","Attachment")
                    .setDisplayHint("attachment")
                    .setAligment("center")
                    .setSortable("false")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFOpenAttachmentsLinkUIBuilder")
                    .addAlias("BundleDef:/activeTaskName")
                    
                    .appendParamDef("BundleDef:/lastModified","Modified Date")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("right")
                    .setSortable("true")
                    .setRenderer("parameter")
                    .setWidth("170px")
                    
                    .appendAliasDef("agrType","Agreement Type")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("left")
                    .setSortable("true")
                    .setRenderer("defaultAliasResolver")
                    .addAlias("CSalesData/ReqCSalesDetails/agrType")
                    
                    .appendAliasDef("agrCat","Agreement Category")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("left")
                    .setSortable("true")
                    .setRenderer("defaultAliasResolver")
                    .addAlias("CSalesData/ReqCSalesDetails/agrCat")
                    
                    .appendAliasDef("status","Status")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("left")
                    .setSortable("true")
                    .setRenderer("defaultAliasResolver")
                    .addAlias("CSalesData/ReqCSalesDetails/contractStatus")
                    
                    .appendAliasDef("cpName","Counterparty")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("left")
                    .setSortable("true")
                    .setRenderer("defaultAliasResolver")
                    .addAlias("CSalesData/ReqCSalesDetails/cpName")
                    
                    .appendAliasDef("startDate","Effective Date")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("right")
                    .setSortable("true")
                    .setRenderer("defaultAliasResolver")
                    .addAlias("CSalesData/ReqCSalesDetails/startDate")
                    
                    .appendAliasDef("endDate","Expiration Date")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("right")
                    .setSortable("true")
                    .setRenderer("defaultAliasResolver")
                    .addAlias("CSalesData/ReqCSalesDetails/endDate")
                    
                    .appendAliasDef("buUnit","Business Unit")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("left")
                    .setSortable("true")
                    .setRenderer("defaultAliasResolver")
                    .addAlias("CSalesData/ReqCSalesDetails/bussUnit")
                    
                    .appendAliasDef("req","Requestor")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("left")
                    .setSortable("true")
                    .setRenderer("defaultAliasResolver")
                    .addAlias("CSalesData/ReqCSalesDetails/requestor")
                    
                    .appendAliasDef("reqDate","Request Date")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("right")
                    .setSortable("true")
                    .setRenderer("defaultAliasResolver")
                    .addAlias("CSalesData/ReqCSalesDetails/reqDate")
                    
                    .appendAliasDef("prdTotal","Product Total")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("right")
                    .setSortable("true")
                    .setRenderer("defaultAliasResolver")
                    .addAlias("CSalesData/ReqCSalesDetails/prdTotal")
                    
                    .appendAliasDef("serTotal","Services Total")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("right")
                    .setSortable("true")
                    .setRenderer("defaultAliasResolver")
                    .addAlias("CSalesData/ReqCSalesDetails/serTotal")
                    
                    .appendAliasDef("totalAmt","Total Amount")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("right")
                    .setSortable("true")
                    .setRenderer("defaultAliasResolver")
                    .addAlias("CSalesData/ReqCSalesDetails/totalAmt")
                    
                    .appendAliasDef("thirdParty1","Is this a Counterparty paper?")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("left")
                    .setSortable("true")
                    .setRenderer("defaultAliasResolver")
                    .addAlias("CSalesData/ReqCSalesDetails/thirdParty1")
                    
                    .appendAliasDef("bunOwn","Owning User")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("defaultAliasResolver")
                    .addAlias("BundleDef:/bundleOwnerUser")
                    
                    .appendAliasDef("bunGrp","Owning Group")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("defaultAliasResolver")
                    .addAlias("BundleDef:/bundleOwnerGroup")
                    
                    .appendAliasDef("customAction","Update")
                    .setDisplayHint("contactsUpdate")
                    .setAligment("center")
                    .setSortable("false")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.AjaxActionLinkUIBuilder")
                    .addAlias("BundleDef:/activeTaskName")
                    
                    .appendAliasDef("ID","Contract ID")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("left")
                    .setSortable("true")
                    .setRenderer("defaultAliasResolver")
                    .addAlias("CSalesData/ReqCSalesDetails/name")
                    
                    .appendCustomizableDef("DeleteCheckBox","Delete")
                    .setDisplayHint("")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.MassDeleteUIBuilder")
                    
                    .useFor(summaryDisplayDef);
    }

    public void append_General_Sales_0(BundleSummaryItem bundleSummaryItem) {
        new BundleFilterLogicBuilder()
                    .buildList("")
                    .appendBundleFilterLogicWithScript("1",null,"\n"+
"                                \n"+
"                                result = thisBundle.getInfoValueObject(\"agrType\") == 'Sales';\n"+
"                                \n"+
"                            ")
                    .useFor(bundleSummaryItem);
    }

    public void append_General_Procurement_0(BundleSummaryItem bundleSummaryItem) {
        new BundleFilterLogicBuilder()
                    .buildList("")
                    .appendBundleFilterLogicWithScript("1",null,"\n"+
"                                \n"+
"                                result = thisBundle.getInfoValueObject(\"agrType\") == 'Procurement';\n"+
"                                \n"+
"                            ")
                    .useFor(bundleSummaryItem);
    }

    public void append_General_NDA_0(BundleSummaryItem bundleSummaryItem) {
        new BundleFilterLogicBuilder()
                    .buildList("")
                    .appendBundleFilterLogicWithScript("1",null,"\n"+
"                                \n"+
"                                result = thisBundle.getInfoValueObject(\"agrType\") == 'NDA';\n"+
"                                \n"+
"                            ")
                    .useFor(bundleSummaryItem);
    }

    public void append_General_Summary(SummaryDisplayDef2 summaryDisplayDef) {
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
                    
                    .appendCustomizableDef("contractDocuments","Contract Documents")
                    .setDisplayHint("documents")
                    .setAligment("center")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.ContractsDownloadUIBuilder")
                    
                    .appendCustomizableDef("copyBundle","Copy")
                    .setDisplayHint("copy")
                    .setAligment("center")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFCopyBundleLinkUIBuilder")
                    
                    .appendCustomizableDef("reassignBundleOwner","Reassign")
                    .setDisplayHint("reassign")
                    .setAligment("center")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFReassignBundleOwnerUIBuilder")
                    
                    .appendAliasDef("viewBundleAttachments","Attachment")
                    .setDisplayHint("attachment")
                    .setAligment("center")
                    .setSortable("false")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFOpenAttachmentsLinkUIBuilder")
                    .addAlias("BundleDef:/activeTaskName")
                    
                    .appendParamDef("BundleDef:/lastModified","Modified Date")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("right")
                    .setSortable("true")
                    .setRenderer("parameter")
                    .setWidth("170px")
                    
                    .appendAliasDef("agrType","Agreement Type")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("left")
                    .setSortable("true")
                    .setRenderer("defaultAliasResolver")
                    .addAlias("CGenData/ReqCGenDetails/agrType")
                    
                    .appendAliasDef("status","Status")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("left")
                    .setSortable("true")
                    .setRenderer("defaultAliasResolver")
                    .addAlias("CGenData/ReqCGenDetails/contractStatus")
                    
                    .appendAliasDef("cpName","Counterparty")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("left")
                    .setSortable("true")
                    .setRenderer("defaultAliasResolver")
                    .addAlias("CGenData/ReqCGenDetails/cpName")
                    
                    .appendAliasDef("startDate","Effective Date")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("right")
                    .setSortable("true")
                    .setRenderer("defaultAliasResolver")
                    .addAlias("CGenData/ReqCGenDetails/startDate")
                    
                    .appendAliasDef("endDate","Expiration Date")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("right")
                    .setSortable("true")
                    .setRenderer("defaultAliasResolver")
                    .addAlias("CGenData/ReqCGenDetails/endDate")
                    
                    .appendAliasDef("buUnit","Business Unit")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("left")
                    .setSortable("true")
                    .setRenderer("defaultAliasResolver")
                    .addAlias("CGenData/ReqCGenDetails/bussUnit")
                    
                    .appendAliasDef("req","Requestor")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("left")
                    .setSortable("true")
                    .setRenderer("defaultAliasResolver")
                    .addAlias("CGenData/ReqCGenDetails/requestor")
                    
                    .appendAliasDef("reqDate","Request Date")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("right")
                    .setSortable("true")
                    .setRenderer("defaultAliasResolver")
                    .addAlias("CGenData/ReqCGenDetails/reqDate")
                    
                    .appendAliasDef("thirdParty1","Is this a Counterparty paper?")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("left")
                    .setSortable("true")
                    .setRenderer("defaultAliasResolver")
                    .addAlias("CGenData/ReqCGenDetails/thirdParty1")
                    
                    .appendAliasDef("bunOwn","Owning User")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("defaultAliasResolver")
                    .addAlias("BundleDef:/bundleOwnerUser")
                    
                    .appendAliasDef("bunGrp","Owning Group")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("defaultAliasResolver")
                    .addAlias("BundleDef:/bundleOwnerGroup")
                    
                    .appendAliasDef("ID","Contract ID")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("left")
                    .setSortable("true")
                    .setRenderer("defaultAliasResolver")
                    .addAlias("CGenData/ReqCGenDetails/name")
                    
                    .appendCustomizableDef("DeleteCheckBox","Delete")
                    .setDisplayHint("")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.MassDeleteUIBuilder")
                    
                    .useFor(summaryDisplayDef);
    }

    public void append_Framework1_Sales_0(BundleSummaryItem bundleSummaryItem) {
        new BundleFilterLogicBuilder()
                    .buildList("")
                    .appendBundleFilterLogicWithScript("1",null,"\n"+
"                                \n"+
"                                result = thisBundle.getInfoValueObject(\"agrType\") == 'Sales';\n"+
"                                \n"+
"                            ")
                    .useFor(bundleSummaryItem);
    }

    public void append_Framework1_Procurement_0(BundleSummaryItem bundleSummaryItem) {
        new BundleFilterLogicBuilder()
                    .buildList("")
                    .appendBundleFilterLogicWithScript("1",null,"\n"+
"                                \n"+
"                                result = thisBundle.getInfoValueObject(\"agrType\") == 'Procurement';\n"+
"                                \n"+
"                            ")
                    .useFor(bundleSummaryItem);
    }

    public void append_Framework1_NDA_0(BundleSummaryItem bundleSummaryItem) {
        new BundleFilterLogicBuilder()
                    .buildList("")
                    .appendBundleFilterLogicWithScript("1",null,"\n"+
"                                \n"+
"                                result = thisBundle.getInfoValueObject(\"agrType\") == 'NDA';\n"+
"                                \n"+
"                            ")
                    .useFor(bundleSummaryItem);
    }

    public void append_Framework1_Summary(SummaryDisplayDef2 summaryDisplayDef) {
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
                    
                    .appendCustomizableDef("contractDocuments","Contract Documents")
                    .setDisplayHint("documents")
                    .setAligment("center")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.ContractsDownloadUIBuilder")
                    
                    .appendCustomizableDef("copyBundle","Copy")
                    .setDisplayHint("copy")
                    .setAligment("center")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFCopyBundleLinkUIBuilder")
                    
                    .appendCustomizableDef("reassignBundleOwner","Reassign")
                    .setDisplayHint("reassign")
                    .setAligment("center")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFReassignBundleOwnerUIBuilder")
                    
                    .appendAliasDef("viewBundleAttachments","Attachment")
                    .setDisplayHint("attachment")
                    .setAligment("center")
                    .setSortable("false")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFOpenAttachmentsLinkUIBuilder")
                    .addAlias("BundleDef:/activeTaskName")
                    
                    .appendParamDef("BundleDef:/lastModified","Modified Date")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("right")
                    .setSortable("true")
                    .setRenderer("parameter")
                    .setWidth("170px")
                    
                    .appendAliasDef("contractType","Contract Type")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("defaultAliasResolver")
                    .addAlias("BundleDef:/bundleType")
                    
                    .appendAliasDef("agrType","Agreement Type")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("left")
                    .setSortable("true")
                    .setRenderer("defaultAliasResolver")
                    .addAlias("CFR1Data/ReqCFR1Details/agrType")
                    
                    .appendAliasDef("status","Status")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("left")
                    .setSortable("true")
                    .setRenderer("defaultAliasResolver")
                    .addAlias("CFR1Data/ReqCFR1Details/contractStatus")
                    
                    .appendAliasDef("cpName","Counterparty")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("left")
                    .setSortable("true")
                    .setRenderer("defaultAliasResolver")
                    .addAlias("CFR1Data/ReqCFR1Details/cpName")
                    
                    .appendAliasDef("startDate","Effective Date")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("right")
                    .setSortable("true")
                    .setRenderer("defaultAliasResolver")
                    .addAlias("CFR1Data/ReqCFR1Details/startDate")
                    
                    .appendAliasDef("endDate","Expiration Date")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("right")
                    .setSortable("true")
                    .setRenderer("defaultAliasResolver")
                    .addAlias("CFR1Data/ReqCFR1Details/endDate")
                    
                    .appendAliasDef("buUnit","Business Unit")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("left")
                    .setSortable("true")
                    .setRenderer("defaultAliasResolver")
                    .addAlias("CFR1Data/ReqCFR1Details/bussUnit")
                    
                    .appendAliasDef("req","Requestor")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("left")
                    .setSortable("true")
                    .setRenderer("defaultAliasResolver")
                    .addAlias("CFR1Data/ReqCFR1Details/requestor")
                    
                    .appendAliasDef("reqDate","Request Date")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("right")
                    .setSortable("true")
                    .setRenderer("defaultAliasResolver")
                    .addAlias("CFR1Data/ReqCFR1Details/reqDate")
                    
                    .appendAliasDef("thirdParty1","Is this a Counterparty paper?")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("left")
                    .setSortable("true")
                    .setRenderer("defaultAliasResolver")
                    .addAlias("CFR1Data/ReqCFR1Details/thirdParty1")
                    
                    .appendAliasDef("bunOwn","Owning User")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("defaultAliasResolver")
                    .addAlias("BundleDef:/bundleOwnerUser")
                    
                    .appendAliasDef("bunGrp","Owning Group")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("defaultAliasResolver")
                    .addAlias("BundleDef:/bundleOwnerGroup")
                    
                    .appendAliasDef("ID","Contract ID")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("left")
                    .setSortable("true")
                    .setRenderer("defaultAliasResolver")
                    .addAlias("CFR1Data/ReqCFR1Details/name")
                    
                    .appendCustomizableDef("DeleteCheckBox","Delete")
                    .setDisplayHint("")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.MassDeleteUIBuilder")
                    
                    .useFor(summaryDisplayDef);
    }

    public void append_Repository_Summary(SummaryDisplayDef2 summaryDisplayDef) {
        new SummaryDisplayDefBuilder()
                    .appendAliasDef("viewWFStage","Stage")
                    .setDisplayHint("/pix/pic.gif")
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
                    
                    .appendCustomizableDef("contractDocuments","Contract Documents")
                    .setDisplayHint("documents")
                    .setAligment("center")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.ContractsDownloadUIBuilder")
                    
                    .appendCustomizableDef("copyBundle","Copy")
                    .setDisplayHint("copy")
                    .setAligment("center")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFCopyBundleLinkUIBuilder")
                    
                    .appendCustomizableDef("reassignBundleOwner","Reassign")
                    .setDisplayHint("reassign")
                    .setAligment("center")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFReassignBundleOwnerUIBuilder")
                    
                    .appendAliasDef("viewBundleAttachments","Attachment")
                    .setDisplayHint("attachment")
                    .setAligment("center")
                    .setSortable("false")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFOpenAttachmentsLinkUIBuilder")
                    .addAlias("BundleDef:/activeTaskName")
                    
                    .appendParamDef("BundleDef:/lastModified","Modified Date")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("right")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendAliasDef("agrType","Agreement Type")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("left")
                    .setSortable("true")
                    .setRenderer("defaultAliasResolver")
                    .addAlias("RREPData/ReqRRepDetails/agrType")
                    
                    .appendAliasDef("status","Status")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("left")
                    .setSortable("true")
                    .setRenderer("defaultAliasResolver")
                    .addAlias("RREPData/ReqRRepDetails/contractStatus")
                    
                    .appendAliasDef("cpName","Counterparty")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("left")
                    .setSortable("true")
                    .setRenderer("defaultAliasResolver")
                    .addAlias("RREPData/ReqRRepDetails/cpName")
                    
                    .appendAliasDef("startDate","Effective Date")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("right")
                    .setSortable("true")
                    .setRenderer("defaultAliasResolver")
                    .addAlias("RREPData/ReqRRepDetails/startDate")
                    
                    .appendAliasDef("endDate","Expiration Date")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("right")
                    .setSortable("true")
                    .setRenderer("defaultAliasResolver")
                    .addAlias("RREPData/ReqRRepDetails/endDate")
                    
                    .appendAliasDef("buUnit","Business Unit")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("left")
                    .setSortable("true")
                    .setRenderer("defaultAliasResolver")
                    .addAlias("RREPData/ReqRRepDetails/bussUnit")
                    
                    .appendAliasDef("req","Requestor")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("left")
                    .setSortable("true")
                    .setRenderer("defaultAliasResolver")
                    .addAlias("RREPData/ReqRRepDetails/requestor")
                    
                    .appendAliasDef("reqDate","Request Date")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("right")
                    .setSortable("true")
                    .setRenderer("defaultAliasResolver")
                    .addAlias("RREPData/ReqRRepDetails/reqDate")
                    
                    .appendAliasDef("bunOwn","Owning User")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("defaultAliasResolver")
                    .addAlias("BundleDef:/bundleOwnerUser")
                    
                    .appendAliasDef("bunGrp","Owning Group")
                    .setDisplayHint("/pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("defaultAliasResolver")
                    .addAlias("BundleDef:/bundleOwnerGroup")
                    
                    .appendAliasDef("name","Contract ID")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("right")
                    .setSortable("true")
                    .setRenderer("defaultAliasResolver")
                    .addAlias("RREPData/ReqRRepDetails/name")
                    
                    .appendCustomizableDef("DeleteCheckBox","Delete")
                    .setDisplayHint("")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.MassDeleteUIBuilder")
                    
                    .useFor(summaryDisplayDef);
    }
}
