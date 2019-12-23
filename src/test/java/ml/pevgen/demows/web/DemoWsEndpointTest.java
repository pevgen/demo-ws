package ml.pevgen.demows.web;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.test.server.MockWebServiceClient;
import org.springframework.xml.transform.ResourceSource;
import org.springframework.xml.transform.StringSource;

import javax.xml.transform.Source;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.ws.test.server.RequestCreators.withPayload;
import static org.springframework.ws.test.server.ResponseMatchers.*;

@SpringBootTest
class DemoWsEndpointTest {

    @Value("payload/payloadHelloRequest.xml")
    private ClassPathResource payloadHelloRequestResource;
    @Value("payload/payloadHelloResponse.xml")
    private ClassPathResource payloadHelloResponseResource;

    @Autowired
    private ApplicationContext applicationContext;

    private MockWebServiceClient mockClient;

    @BeforeEach
    void setUp() {
        // create the mock client
        mockClient = MockWebServiceClient.createClient(applicationContext);
        assertThat(mockClient).isNotNull();
    }

    @Test
    @SuppressWarnings("squid:S2699")
    public void helloRequestResponse() throws IOException {
        Source requestPayload = new ResourceSource(payloadHelloRequestResource);
        Source responsePayload = new ResourceSource(payloadHelloResponseResource);
        mockClient
                .sendRequest(withPayload(requestPayload))
                .andExpect(noFault())
                .andExpect(payload(responsePayload));
    }
}