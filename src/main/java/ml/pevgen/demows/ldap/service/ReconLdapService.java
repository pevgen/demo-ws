package ml.pevgen.demows.ldap.service;

import ml.pevgen.demows.ldap.repository.ReconLdapRepository;
import org.springframework.stereotype.Service;

import javax.naming.directory.Attributes;
import java.util.List;

@Service
public class ReconLdapService {

    private ReconLdapRepository reconLdapRepository;

    public ReconLdapService(ReconLdapRepository reconLdapRepository) {
        this.reconLdapRepository = reconLdapRepository;
    }

    public List<Attributes> findAttributesByObjectClassName(String className){
        return reconLdapRepository.findAttributesByObjectClassName(className);
    }
}
