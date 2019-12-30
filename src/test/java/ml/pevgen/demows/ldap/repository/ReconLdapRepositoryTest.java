package ml.pevgen.demows.ldap.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import javax.naming.directory.Attributes;
import java.util.List;

@SpringBootTest
@ActiveProfiles("test")
class ReconLdapRepositoryTest {

    @Autowired
    private ReconLdapRepository reconLdapRepository;

    @Test
    void findAttributesByObjectClassName() {
        List<Attributes> result = reconLdapRepository.findAttributesByObjectClassName("person");
        Assertions.assertThat(result).isNotNull();
        Assertions.assertThat(result.size()).isEqualTo(3);
    }
}