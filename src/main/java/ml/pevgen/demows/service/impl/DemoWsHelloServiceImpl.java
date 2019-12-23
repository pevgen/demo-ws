package ml.pevgen.demows.service.impl;

import ml.pevgen.demows.service.DemoWsHelloService;
import org.springframework.stereotype.Service;

@Service
public class DemoWsHelloServiceImpl implements DemoWsHelloService {
    @Override
    public String hello(String request) {
        return request + ":response";
    }
}
