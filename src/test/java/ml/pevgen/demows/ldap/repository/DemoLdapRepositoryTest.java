package ml.pevgen.demows.ldap.repository;

import ml.pevgen.demows.ldap.model.Person;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ldap.core.AttributesMapper;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.test.context.ActiveProfiles;

import javax.naming.NamingException;
import javax.naming.directory.*;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.ldap.query.LdapQueryBuilder.query;


@SpringBootTest
@ActiveProfiles("test")
class DemoLdapRepositoryTest {

    @Autowired
    private DemoLdapRepository personRepository;

    @Test
    public void testFindAll() {
        List<Person> people = new ArrayList<>();
        personRepository.findAll().forEach(people::add);
        Assertions.assertThat(people).isNotEmpty();
    }

    @Test
    public void testCount() {
        Assertions.assertThat(personRepository.count()).isEqualTo(3L);
    }

}