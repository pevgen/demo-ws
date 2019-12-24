package ml.pevgen.demows.service;

import ml.pevgen.demows.error.DemoWsException;

public interface DemoWsHelloService {

    String hello(String request);

    void helloException(String request) throws DemoWsException;

}
