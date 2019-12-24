package ml.pevgen.demows.error;

import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;

@SoapFault(faultCode = FaultCode.SERVER)
public class DemoWsException extends Exception {

    public DemoWsException(String excMessage) {
        super(excMessage);
    }
}
