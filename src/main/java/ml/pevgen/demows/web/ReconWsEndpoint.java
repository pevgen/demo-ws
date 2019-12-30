package ml.pevgen.demows.web;

import lombok.extern.slf4j.Slf4j;
import ml.pevgen.demows.ldap.service.ReconLdapService;
import ml.pevgen.demows.web.soap.recon.GenericAttribute;
import ml.pevgen.demows.web.soap.recon.GenericSupportingDataObject;
import ml.pevgen.demows.web.soap.recon.GetSupportingData;
import ml.pevgen.demows.web.soap.recon.GetSupportingDataResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;

@Slf4j
@Endpoint
public class ReconWsEndpoint {

    private static final String NAMESPACE_URI = "http://xbank.ru/soa/service/sudir/itdi/smallsystem.generic.supportingdata.reconciliation/2.0.0";

    private ReconLdapService ldapService;

    public ReconWsEndpoint(ReconLdapService ldapService) {
        this.ldapService = ldapService;
    }

    // TODO refactoring needed
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getSupportingData")
    @ResponsePayload
    public GetSupportingDataResponse getSupportingData(@RequestPayload GetSupportingData parameters) {

        GetSupportingDataResponse dataResponse = new GetSupportingDataResponse();
        ldapService.findAttributesByObjectClassName(parameters.getObjectClass())
                .forEach(attrs -> {
                    GenericSupportingDataObject attrListResponse = new GenericSupportingDataObject();
                    NamingEnumeration<? extends Attribute> aaa = attrs.getAll();
                    while (aaa.hasMoreElements()) {
                        try {
                            Attribute ldapAttribute = aaa.next();

                            GenericAttribute attrResponse = new GenericAttribute();
                            attrResponse.setName(ldapAttribute.getID());
                            NamingEnumeration<?> allValues = ldapAttribute.getAll();
                            while (allValues.hasMoreElements()) {
                                attrResponse.getValues().add(String.valueOf(allValues.next()));
                            }
                            attrListResponse.getAttributes().add(attrResponse);
                        } catch (NamingException e) {
                            log.warn(e.getExplanation(), e);
                        }
                    }
                    dataResponse.getGetSupportingDataReturn().add(attrListResponse);
                });


        return dataResponse;
    }

}
