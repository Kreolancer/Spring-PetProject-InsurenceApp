package lv.javaguru.travel.insurance.rest;

import org.junit.jupiter.api.Test;

public class TravelCalculatePremiumControllerTestCase7 extends TravelCalculatePremiumControllerTest{
    @Override
    protected String getTestCaseFolderName() {
        return "test_case_7";
    }
    @Test
    public void execute() throws Exception {
        executeAndCompare();
    }
}
