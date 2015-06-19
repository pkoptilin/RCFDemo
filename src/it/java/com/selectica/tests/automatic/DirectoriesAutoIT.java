package com.selectica.tests.automatic;

import com.selectica.qa.automation.dto.SuiteTO;
import com.selectica.qa.automation.test.SuiteIT;
import com.selectica.qa.automation.testng.*;
import org.testng.annotations.Test;

@Test(groups="eclm.directories")
public class DirectoriesAutoIT extends SuiteIT {

    @Test(dataProvider = "listSuiteXML2List", dataProviderClass = TestNGDataProviders.class)
    @DataSource(file = "/automatic/directories.xml")
    public void testDirectories(SuiteTO suite) throws Exception {
        String sessionID = login(suite.getUserLogin(), suite.getUserPassword());
        testSuite(sessionID, suite);
        logout(sessionID);
    }
}
