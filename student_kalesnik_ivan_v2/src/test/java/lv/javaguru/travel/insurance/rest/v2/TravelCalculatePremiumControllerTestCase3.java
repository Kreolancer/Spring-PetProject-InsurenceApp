package lv.javaguru.travel.insurance.rest.v2;

import org.junit.jupiter.api.Test;

public class TravelCalculatePremiumControllerTestCase3 extends TravelCalculatePremiumControllerTestCaseV2 {

    @Test
    public void execute() throws Exception {
        executeAndCompare();
    }

    @Override
    protected String getTestCaseFolderName() {
        return "test_case_3";
    }
}
