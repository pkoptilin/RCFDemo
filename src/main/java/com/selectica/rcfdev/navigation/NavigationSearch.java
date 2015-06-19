package com.selectica.rcfdev.navigation;

import com.selectica.internalmodel.navigation.*;
import com.selectica.rcf.common.navigation.*;

public class NavigationSearch {

    public void append(NavNode2 navNode) {
        // extend navigation here;
    }

    public void append_All_Summary(SummaryDisplayDef2 summaryDisplayDef) {
        new SummaryDisplayDefBuilder()
                    .appendCustomizableDef("contractDocuments","Contract Documents")
                    .setDisplayHint("documents")
                    .setAligment("center")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.ContractsDownloadUIBuilder")
                    
                    .appendAliasDef("contractName","Contract Name")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("left")
                    .setSortable("true")
                    .setRenderer("defaultAliasResolver")
                    .addAlias("CNDAData/ReqCNDADetails/contractName")
                    .addAlias("CSalesData/ReqCSalesDetails/contractName")
                    .addAlias("CProcData/ReqCProcDetails/contractName")
                    .addAlias("CGenData/ReqCGenDetails/contractName")
                    .addAlias("CFR1Data/ReqCFR1Details/contractName")
                    .addAlias("RREPData/ReqRRepDetails/contractName")
                    
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
                    
                    .appendAliasDef("viewWFStage","Current Stage")
                    .setDisplayHint("pix/meta/bump.gif")
                    .setAligment("center")
                    .setSortable("true")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFStageLinkUIBuilder")
                    .addAlias("BundleDef:/activeTaskName")
                    
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
                    
                    .appendAliasDef("startDate","Create Date")
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
                    
                    .appendParamDef("BundleDef:/lastModified","Last Modified")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("right")
                    .setSortable("true")
                    .setRenderer("parameter")
                    .setWidth("170px")
                    
                    .useFor(summaryDisplayDef);
    }
}
