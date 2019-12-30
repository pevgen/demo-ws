package ml.pevgen.demows.web;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.ws.test.server.MockWebServiceClient;
import org.springframework.xml.transform.ResourceSource;

import javax.xml.transform.Source;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.ws.test.server.RequestCreators.withPayload;
import static org.springframework.ws.test.server.ResponseMatchers.noFault;
import static org.springframework.ws.test.server.ResponseMatchers.payload;

@SuppressWarnings("squid:S2699")
@SpringBootTest
@ActiveProfiles("test")
class ReconWsEndpointTest {

    @Value("payload/getSupportingDataRequest.xml")
    private ClassPathResource payloadGetSupportingDataRequestResource;
    @Value("payload/getSupportingDataResponse.xml")
    private ClassPathResource payloadGetSupportingDataResponseResource;
    @Autowired
    private ApplicationContext applicationContext;

    private MockWebServiceClient mockClient;

    @BeforeEach
    void setUp() {
        mockClient = MockWebServiceClient.createClient(applicationContext);
        assertThat(mockClient).isNotNull();
    }

    @Test
    void test_getSupportingData() throws IOException {
        Source requestPayload = new ResourceSource(payloadGetSupportingDataRequestResource);
        Source responsePayload = new ResourceSource(payloadGetSupportingDataResponseResource);
        mockClient
                .sendRequest(withPayload(requestPayload))
                .andExpect(noFault())
                .andExpect(payload(responsePayload));
    }
}