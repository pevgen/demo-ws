package ml.pevgen.demows.web;

import ml.pevgen.demows.web.soap.recon.GetSupportingData;
import ml.pevgen.demows.web.soap.recon.GetSupportingDataResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class ReconWsEndpoint {

    private static final String NAMESPACE_URI = "http://xbank.ru/soa/service/sudir/itdi/smallsystem.generic.supportingdata.reconciliation/2.0.0";


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getSupportingData")
    @ResponsePayload
    public GetSupportingDataResponse getSupportingData(@RequestPayload GetSupportingData parameters) {
        System.out.println(parameters.getObjectClass());
        GetSupportingDataResponse out = new GetSupportingDataResponse();
        return out;
    }

}
