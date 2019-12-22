package ml.pevgen.demows.web;

import ml.pevgen.demows.web.soap.InputSOATest;
import ml.pevgen.demows.web.soap.OutputSOATest;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class DemoWsEndpoint {

    private static final String NAMESPACE_URI = "http://pevgen.ml";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "inputSOATest")
    @ResponsePayload
    public OutputSOATest hello(@RequestPayload InputSOATest in) {
        OutputSOATest out = new OutputSOATest();
        out.setResult(in.getTest() + ":response");
        return out;
    }
}
