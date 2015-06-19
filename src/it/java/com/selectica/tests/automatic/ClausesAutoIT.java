package com.selectica.tests.automatic;

import com.selectica.qa.automation.dto.SuiteTO;
import com.selectica.qa.automation.test.SuiteIT;
import com.selectica.qa.automation.testng.DataSource;
import com.selectica.qa.automation.testng.TestNGDataProviders;
import org.testng.annotations.Test;

@Test(groups="eclm.clauses")
public class ClausesAutoIT extends SuiteIT {

    @Test(dataProvider = "listSuiteXML2List", dataProviderClass = TestNGDataProviders.class)
    @DataSource(file = "/automatic/clauses.xml")
    public void testClauses(SuiteTO suite) throws Exception {
        String sessionID = login(suite.getUserLogin(), suite.getUserPassword());
        testSuite(sessionID, suite);
        logout(sessionID);
    }
}
