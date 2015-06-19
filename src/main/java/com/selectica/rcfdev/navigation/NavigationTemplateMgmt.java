package com.selectica.rcfdev.navigation;

import com.selectica.internalmodel.navigation.*;
import com.selectica.rcf.common.navigation.*;

public class NavigationTemplateMgmt {

    public void append(NavNode2 navNode) {
        // extend navigation here;
    }

    public void append_All_Summary(SummaryDisplayDef2 summaryDisplayDef) {
        new SummaryDisplayDefBuilder()
                    .appendAliasDef("openBundle","Open")
                    .setDisplayHint("open")
                    .setAligment("center")
                    .setSortable("false")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFOpenLinkUIBuilder")
                    .addAlias("BundleDef:/activeTaskName")
                    
                    .appendCustomizableDef("copyBundle","Copy")
                    .setDisplayHint("copy")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFCopyBundleLinkUIBuilder")
                    
                    .appendParamDef("TemplateMgmt/ReqTemplateMgmtInfo/name","Template Name")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("left")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("TemplateMgmt/ReqTemplateMgmtInfo/category","Contract Type")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("left")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("TemplateMgmt/ReqTemplateMgmtInfo/cType","Classification Type")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("left")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("TemplateMgmt/ReqTemplateMgmtInfo/displayOrder","Display Order")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("left")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("TemplateMgmt/ReqTemplateMgmtInfo/effectiveStartDate","Effective Start Date")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("left")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("TemplateMgmt/ReqTemplateMgmtInfo/effectiveEndDate","Effective End Date")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("left")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("TemplateMgmt/ReqTemplateMgmtInfo/contractStatus","Status")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("left")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("TemplateMgmt/ReqNewBoilerplate/fileName","Document Name")
                    .setDisplayHint("/pix/pic.gif")
                    .setAligment("left")
                    .setSortable("true")
                    .setRenderer("parameter")
                    
                    .appendParamDef("TemplateMgmt/ReqNewBoilerplate/fileVersion","Version")
                    .setDisplayHint("TemplateMgmt/ReqNewBoilerplate[last()]/fileVersion")
                    .setAligment("left")
                    .setSortable("true")
                    .setRenderer("xpathparameter")
                    
                    .appendParamDef("TemplateMgmt/ReqNewBoilerplate/modifiedBy","Modified By")
                    .setDisplayHint("TemplateMgmt/ReqNewBoilerplate[last()]/modifiedBy")
                    .setAligment("left")
                    .setSortable("true")
                    .setRenderer("xpathparameter")
                    
                    .appendParamDef("TemplateMgmt/ReqNewBoilerplate/modifyDate","Last Modified")
                    .setDisplayHint("TemplateMgmt/ReqNewBoilerplate[last()]/modifyDate")
                    .setAligment("left")
                    .setSortable("true")
                    .setRenderer("xpathparameter")
                    
                    .appendParamDef("TemplateMgmt/ReqNewBoilerplate/fileSize","Size")
                    .setDisplayHint("TemplateMgmt/ReqNewBoilerplate[last()]/fileSize")
                    .setAligment("left")
                    .setSortable("true")
                    .setRenderer("xpathparameter")
                    
                    .appendParamDef("TemplateMgmt/ReqNewBoilerplate/locale","Language")
                    .setDisplayHint("TemplateMgmt/ReqNewBoilerplate[last()]/locale")
                    .setAligment("left")
                    .setSortable("true")
                    .setRenderer("xpathparameter")
                    
                    .appendAliasDef("viewWFStage","Stage")
                    .setDisplayHint("pix/meta/bump.gif")
                    .setAligment("left")
                    .setSortable("true")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.WFStageLinkUIBuilder")
                    .addAlias("BundleDef:/activeTaskName")
                    
                    .appendCustomizableDef("DeleteCheckBox","Delete")
                    .setDisplayHint("")
                    .setRenderer("com.selectica.spring.domain.ui.uibuilder.MassDeleteUIBuilder")
                    
                    .useFor(summaryDisplayDef);
    }
}
