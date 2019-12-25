package ml.pevgen.demows.ldap.repository;


import ml.pevgen.demows.ldap.model.Person;
import org.springframework.data.ldap.repository.LdapRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemoLdapRepository extends LdapRepository<Person> {
}
