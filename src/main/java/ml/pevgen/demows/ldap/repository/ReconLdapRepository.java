package ml.pevgen.demows.ldap.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.AttributesMapper;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.stereotype.Repository;

import javax.naming.directory.Attributes;
import java.util.List;

import static org.springframework.ldap.query.LdapQueryBuilder.query;

@Repository
public class ReconLdapRepository {

    @Autowired
    private LdapTemplate ldapTemplate;

    public ReconLdapRepository(LdapTemplate ldapTemplate) {
        this.ldapTemplate = ldapTemplate;
    }

    public List<Attributes> findAttributesByObjectClassName(String className) {
        return ldapTemplate.search(
                        query()
                                .base("dc=mycompany,dc=com")
                                .where("objectclass")
                                .is(className), (AttributesMapper<Attributes>) attributes -> attributes);
    }
}
