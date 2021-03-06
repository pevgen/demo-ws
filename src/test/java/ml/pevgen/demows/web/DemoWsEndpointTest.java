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
import static org.springframework.ws.test.server.RequestCreators.withPayload;
import static org.springframework.ws.test.server.ResponseMatchers.*;

@SuppressWarnings("squid:S2699")
@SpringBootTest
@ActiveProfiles("test")
class DemoWsEndpointTest {

    @Value("payload/payloadHelloRequest.xml")
    private ClassPathResource payloadHelloRequestResource;
    @Value("payload/payloadHelloResponse.xml")
    private ClassPathResource payloadHelloResponseResource;
    @Value("payload/payloadHelloExceptionRequest.xml")
    private ClassPathResource payloadHelloExceptionRequest;

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
    public void helloRequestResponse() throws IOException {
        Source requestPayload = new ResourceSource(payloadHelloRequestResource);
        Source responsePayload = new ResourceSource(payloadHelloResponseResource);
        mockClient
                .sendRequest(withPayload(requestPayload))
                .andExpect(noFault())
                .andExpect(payload(responsePayload));
    }

    @Test
    public void helloRequestExceptionResponse() throws IOException {
        Source requestPayload = new ResourceSource(payloadHelloExceptionRequest);
        mockClient
                .sendRequest(withPayload(requestPayload))
                .andExpect(serverOrReceiverFault("Hello SOAP exception! Request: req-exception"));
    }

}