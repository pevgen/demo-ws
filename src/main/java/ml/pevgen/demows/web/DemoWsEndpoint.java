package ml.pevgen.demows.web;

import ml.pevgen.demows.service.DemoWsHelloService;
import ml.pevgen.demows.web.soap.InputSOATest;
import ml.pevgen.demows.web.soap.OutputSOATest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class DemoWsEndpoint {

    @Autowired
    private DemoWsHelloService service;

    private static final String NAMESPACE_URI = "http://pevgen.ml";

    public DemoWsEndpoint(DemoWsHelloService service) {
        this.service = service;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "inputSOATest")
    @ResponsePayload
    public OutputSOATest hello(@RequestPayload InputSOATest in) {
        OutputSOATest out = new OutputSOATest();
        out.setResult(service.hello(in.getTest()));
        return out;
    }
}
