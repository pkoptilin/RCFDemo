package com.selectica.rcfdev.navigation;

import com.selectica.internalmodel.navigation.*;
import com.selectica.rcf.common.navigation.*;

public class NavigationDashboard {

    public void append(NavNode2 navNode) {
        // extend navigation here;
    }

    public void append_Inbox_MyOpenTasks(BundleSummaryItem bundleSummaryItem) {
        new BundleFilterLogicBuilder()
                    .buildList("inbox")
                    .appendBundleFilterLogicWithClass("CurrentUserHasBundleEditPrivs",null,"com.selectica.navsumm.CurrentUserHasBundleEditPrivs")
                    .appendBundleFilterLogicWithScript("MyOpenTasksFilter",false,"\n"+
"                            var taskName = thisBundle.getValue(\"activeTaskName\");\n"+
"                            var currTask = thisBundle.getCurrentTask();\n"+
"                            var nonContrCond = true;\n"+
"                            if (!thisBundle.isContract()) {\n"+
"                                nonContrCond = currTask.isAPartOfApproval();\n"+
"                            }\n"+
"                            result = taskName != 'Complete' && taskName != 'Manage' && nonContrCond;\n"+
"                            ")
                    .useFor(bundleSummaryItem);
    }

    public void append_Inbox_MyAlerts_Summary(SummaryDisplayDef2 summaryDisplayDef) {
        new SummaryDisplayDefBuilder()
                    .appendAliasDef("contractType","Contract Type")
                    .setDisplayHint("pix/pic.gif")
                    .setSortable("true")
                    .setRenderer("defaultAliasResolver")
                    .addAlias("BundleDef:/bundleType")
                    
                    .appendAliasDef("ID","Contract ID")
                    .setDisplayHint("pix/pic.gif")
                    .setAligment("left")
                    .setSortable("true")
                    .setRenderer("defaultAliasResolver")
                    .addAlias("CNDAData/ReqCNDADetails/name")
                    .addAlias("CSalesData/ReqCSalesDetails/name")
                    .addAlias("CProcData/ReqCProcDetails/name")
                    .addAlias("CGenData/ReqCGenDetails/name")
                    .addAlias("CFR1Data/ReqCFR1Details/name")
                    .addAlias("RREPData/ReqRRepDetails/name")
                    
                    .appendAliasDef("startDate","Effective Date")
                    .setDisplayHint("pix/pic.gif")
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
                    .setDisplayHint("pix/pic.gif")
                    .setAligment("right")
                    .setSortable("true")
                    .setRenderer("defaultAliasResolver")
                    .addAlias("CNDAData/ReqCNDADetails/endDate")
                    .addAlias("CSalesData/ReqCSalesDetails/endDate")
                    .addAlias("CProcData/ReqCProcDetails/endDate")
                    .addAlias("CGenData/ReqCGenDetails/endDate")
                    .addAlias("CFR1Data/ReqCFR1Details/endDate")
                    .addAlias("RREPData/ReqRRepDetails/endDate")
                    
                    .appendCustomizableDef("wfAlert","Alert")
                    .setDisplayHint("pix/meta/alert.gif")
                    .setAligment("center")
                    .setSortable("false")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFAlertLinkUIBuilder")
                    
                    .useFor(summaryDisplayDef);
    }

    public void append_Inbox_ExpiringToday(BundleSummaryItem bundleSummaryItem) {
        new BundleFilterLogicBuilder()
                    .buildList("ExpiringContracts_1")
                    .appendBundleFilterLogicWithClass("MyContractsOnlyFilter",true,"com.selectica.navsumm.CurrentUserHasBundleViewPrivs")
                    .appendBundleFilterLogicWithScript("ExpirationTodayFilter",true,"\n"+
"                            \n"+
"                            result = false;\n"+
"                            var endDate = thisBundle.getInfoValueObject(\"endDate\");\n"+
"                            if (endDate == null) {\n"+
"                                result = false;\n"+
"                            } else {\n"+
"                                var currentDate = new java.util.Date();\n"+
"                                var month = currentDate.getMonth();\n"+
"                                var day = currentDate.getDate();\n"+
"                                var year = currentDate.getYear() + 1900;\n"+
"                                var todaysDate = Packages.com.selectica.tools.DateUtils.createDate(month + 1, day, year);\n"+
"                                result = endDate.equals(todaysDate);\n"+
"                            }\n"+
"                            \n"+
"                        ")
                    .useFor(bundleSummaryItem);
    }

    public void append_Inbox_ExpiringThisMonth(BundleSummaryItem bundleSummaryItem) {
        new BundleFilterLogicBuilder()
                    .buildList("ExpiringContracts_30")
                    .appendBundleFilterLogicWithClass("MyContractsOnlyFilter",true,"com.selectica.navsumm.CurrentUserHasBundleViewPrivs")
                    .appendBundleFilterLogicWithScript("ExpirationWithinMonthFilter30",true,"\n"+
"                            \n"+
"                            result = false;\n"+
"                            var endDate = thisBundle.getInfoValueObject(\"endDate\");\n"+
"                            if (endDate == null) {\n"+
"                                result = false;\n"+
"                            } else {\n"+
"                                var currentDate = new java.util.Date();\n"+
"                                var month = currentDate.getMonth();\n"+
"                                var year = currentDate.getYear() + 1900;\n"+
"                                var minValidDate = Packages.com.selectica.tools.DateUtils.createDate(month + 1, 1, year);\n"+
"                                var maxValidDate = Packages.com.selectica.tools.DateUtils.createDate(month + 2, 1, year);\n"+
"                                result = (endDate.after(minValidDate) || endDate.equals(minValidDate)) && endDate.before(maxValidDate);\n"+
"                            }\n"+
"                            \n"+
"                        ")
                    .useFor(bundleSummaryItem);
    }

    public void append_Inbox_ExpiringIn3Months(BundleSummaryItem bundleSummaryItem) {
        new BundleFilterLogicBuilder()
                    .buildList("ExpiringContracts_90")
                    .appendBundleFilterLogicWithClass("MyContractsOnlyFilter",true,"com.selectica.navsumm.CurrentUserHasBundleViewPrivs")
                    .appendBundleFilterLogicWithScript("ExpirationWithinMonthFilter90",true,"\n"+
"                            \n"+
"                            result = false;\n"+
"                            var endDate = thisBundle.getInfoValueObject(\"endDate\");\n"+
"                            if (endDate == null) {\n"+
"                                result = false;\n"+
"                            } else {\n"+
"                                var currentDate = new java.util.Date();\n"+
"                                var month = currentDate.getMonth();\n"+
"                                var year = currentDate.getYear() + 1900;\n"+
"                                var minValidDate = Packages.com.selectica.tools.DateUtils.createDate(month + 1, 1, year);\n"+
"                                var maxValidDate = Packages.com.selectica.tools.DateUtils.createDate(month + 4, 1, year);\n"+
"                                result = (endDate.after(minValidDate) || endDate.equals(minValidDate)) && endDate.before(maxValidDate);\n"+
"                            }\n"+
"                            \n"+
"                        ")
                    .useFor(bundleSummaryItem);
    }

    public void append_Inbox_Summary(SummaryDisplayDef2 summaryDisplayDef) {
        new SummaryDisplayDefBuilder()
                    .appendAliasDef("viewWFStage","Stage")
                    .setDisplayHint("pix/meta/bump.gif")
                    .setAligment("center")
                    .setSortable("true")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFStageLinkUIBuilder")
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
                    
                    .useFor(summaryDisplayDef);
    }
}
