package com.selectica.tests.automatic;

import com.selectica.qa.automation.dto.SuiteTO;
import com.selectica.qa.automation.test.SuiteIT;
import com.selectica.qa.automation.testng.*;
import org.testng.annotations.Test;

@Test(groups="eclm.contracts")
public class ContractsAutoIT extends SuiteIT {

    @Test(dataProvider = "listSuiteXML2List", dataProviderClass = TestNGDataProviders.class)
    @DataSource(file = "/automatic/contracts.xml")
    public void testContracts(SuiteTO suite) throws Exception {
        String sessionID = login(suite.getUserLogin(), suite.getUserPassword());
        testSuite(sessionID, suite);
        logout(sessionID);
    }
}
