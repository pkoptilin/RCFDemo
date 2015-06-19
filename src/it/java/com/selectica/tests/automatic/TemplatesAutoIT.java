package com.selectica.tests.automatic;

import com.selectica.qa.automation.dto.SuiteTO;
import com.selectica.qa.automation.test.SuiteIT;
import com.selectica.qa.automation.testng.DataSource;
import com.selectica.qa.automation.testng.TestNGDataProviders;
import org.testng.annotations.Test;

@Test(groups="eclm.templates")
public class TemplatesAutoIT extends SuiteIT {

    @Test(dataProvider = "listSuiteXML2List", dataProviderClass = TestNGDataProviders.class)
    @DataSource(file = "/automatic/templates.xml")
    public void testTemplates(SuiteTO suite) throws Exception {
        String sessionID = login(suite.getUserLogin(), suite.getUserPassword());
        testSuite(sessionID, suite);
        logout(sessionID);
    }
}
