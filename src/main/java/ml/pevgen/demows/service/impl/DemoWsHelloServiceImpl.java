package ml.pevgen.demows.service.impl;

import ml.pevgen.demows.error.DemoWsException;
import ml.pevgen.demows.service.DemoWsHelloService;
import org.springframework.stereotype.Service;

@Service
public class DemoWsHelloServiceImpl implements DemoWsHelloService {
    @Override
    public String hello(String request) {
        return request + ":response";
    }

    @Override
    public void helloException(String request) throws DemoWsException {
        throw new DemoWsException("Hello SOAP exception! Request: " + request);
    }
}
