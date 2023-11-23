package lv.javaguru.travel.insurance.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import lv.javaguru.travel.insurance.core.TravelCalculatePremiumRequestValidator;
import net.minidev.json.parser.JSONParser;
import org.apache.coyote.Request;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static uk.org.webcompere.modelassert.json.JsonAssertions.assertJson;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TravelCalculatePremiumControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private final ObjectMapper mapper = new ObjectMapper();

    @Spy
    private TravelCalculatePremiumRequestValidator validator;

    /*@BeforeEach
    public void initMocks() {
        when(validator)
    }*/

    @Test
    public void simpleRestControllerTestExample() throws Exception {
        mockMvc.perform(post("/insurance/travel/")
                        .content("{" +
                                "\"personFirstName\" : \"Vasja\",\n" +
                                "\"personLastName\" : \"Pupkin\",\n" +
                                "\"agreementDateFrom\" : \"2021-05-25\",\n" +
                                "\"agreementDateTo\" : \"2021-05-29\"\n" +
                                "}")
                        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("personFirstName", is("Vasja")))
                .andExpect(jsonPath("personLastName", is("Pupkin")))
                .andExpect(jsonPath("agreementDateFrom", is("2021-05-25")))
                .andExpect(jsonPath("agreementDateTo", is("2021-05-29")))
                .andExpect(jsonPath("agreementPrice", is(4)))
                .andReturn();
    }

    @Test
    public void simpleRestControllerTest() throws Exception {
        mockMvc.perform(post("/insurance/travel/")
                        .content("{" +
                                "\"personFirstName\" : \"Name\",\n" +
                                "\"personLastName\" : \"Surname\",\n" +
                                "\"agreementDateFrom\" : \"2021-05-20\",\n" +
                                "\"agreementDateTo\" : \"2021-05-29\"\n" +
                                "}")
                        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("personFirstName", is("Name")))
                .andExpect(jsonPath("personLastName", is("Surname")))
                .andExpect(jsonPath("agreementDateFrom", is("2021-05-20")))
                .andExpect(jsonPath("agreementDateTo", is("2021-05-29")))
                .andExpect(jsonPath("agreementPrice", is(9)))
                .andReturn();
    }

    @Test
    public void jsonFilesTest() throws Exception {
        compareResponseToRequestInJsonFiles(
                "rest/TravelCalculatePremiumRequest_correct.json",
                "rest/TravelCalculatePremiumResponse_correct.json"
        );

        compareResponseToRequestInJsonFiles(
                "rest/TravelCalculatePremiumRequest_allWrong.json",
                "rest/TravelCalculatePremiumResponse_allWrong.json"
        );

        compareResponseToRequestInJsonFiles(
                "rest/TravelCalculatePremiumRequest_dateFromEmpty.json",
                "rest/TravelCalculatePremiumResponse_dateFromEmpty.json"
        );

        compareResponseToRequestInJsonFiles(
                "rest/TravelCalculatePremiumRequest_dateToEmpty.json",
                "rest/TravelCalculatePremiumResponse_dateToEmpty.json"
        );

        compareResponseToRequestInJsonFiles(
                "rest/TravelCalculatePremiumRequest_firstNameEmpty.json",
                "rest/TravelCalculatePremiumResponse_firstNameEmpty.json"
        );

        compareResponseToRequestInJsonFiles(
                "rest/TravelCalculatePremiumRequest_lastNameEmpty.json",
                "rest/TravelCalculatePremiumResponse_lastNameEmpty.json"
        );

        compareResponseToRequestInJsonFiles(
                "rest/TravelCalculatePremiumRequest_dateSeq.json",
                "rest/TravelCalculatePremiumResponse_dateSeq.json"
        );
    }

    public void compareResponseToRequestInJsonFiles(
            String fileNameRequest, String fileNameResponse
    ) throws Exception {
        String jsonRequest = JsonReader.read(fileNameRequest);

        MvcResult result = mockMvc.perform(post("/insurance/travel/")
                        .content(jsonRequest)
                        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andReturn();

        String responseBodyContent = result.getResponse().getContentAsString();

        String jsonResponse = JsonReader.read(fileNameResponse);

        assertJson(responseBodyContent)
                .where()
                .keysInAnyOrder()
                .arrayInAnyOrder()
                .isEqualTo(jsonResponse);
    }
}
