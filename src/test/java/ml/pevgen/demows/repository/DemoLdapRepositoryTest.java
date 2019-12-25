package ml.pevgen.demows.repository;

import ml.pevgen.demows.ldap.model.Person;
import ml.pevgen.demows.ldap.repository.DemoLdapRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;


@SpringBootTest
@ActiveProfiles("test")
class DemoLdapRepositoryTest {

    @Autowired
    private DemoLdapRepository personRepository;

    @Test
    public void findAll() {
        List<Person> people = new ArrayList<>();
        personRepository.findAll().forEach(people::add);
        Assertions.assertThat(people).isNotEmpty();
    }
}