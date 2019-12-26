package ml.pevgen.demows.ldap.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
class DemoLdapServiceTest {

    @Autowired
    DemoLdapService ldapService;

    @Test
    void findAll() {
        Assertions.assertThat(ldapService.findAll()).isNotEmpty();
    }
}