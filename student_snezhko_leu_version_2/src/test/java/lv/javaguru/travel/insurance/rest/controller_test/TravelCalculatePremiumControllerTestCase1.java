package lv.javaguru.travel.insurance.rest.controller_test;

import org.junit.jupiter.api.Test;

public class TravelCalculatePremiumControllerTestCase1 extends TravelCalculatePremiumControllerTestCase {

    @Test
    public void execute() throws Exception {
        executeAndCompare();
    }

    @Override
    protected String getTestCaseFolderName() {
        return "test_case_1";
    }
}
