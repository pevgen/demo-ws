package ml.pevgen.demows.ldap.service;

import ml.pevgen.demows.ldap.model.Person;
import ml.pevgen.demows.ldap.repository.DemoLdapRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class DemoLdapService {

    private DemoLdapRepository ldapRepository;

    public DemoLdapService(DemoLdapRepository ldapRepository) {
        this.ldapRepository = ldapRepository;
    }

    public List<Person> findAll() {
        return StreamSupport.stream(ldapRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

}
