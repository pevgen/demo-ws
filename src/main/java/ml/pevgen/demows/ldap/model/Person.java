package ml.pevgen.demows.ldap.model;

import org.springframework.ldap.odm.annotations.Attribute;
import org.springframework.ldap.odm.annotations.Entry;
import org.springframework.ldap.odm.annotations.Id;

import javax.naming.Name;

@Entry(base = "ou=people,dc=mycompany,dc=com", objectClasses = {"top", "organizationalPerson", "inetOrgPerson"})
public class Person {

    @Id
    private Name id;

    @Attribute(name = "uid")
    private String uid;

    @Attribute(name = "cn")
    private String fullName;
    @Attribute(name = "sn")
    private String surName;
    @Attribute(name = "password")
    private String password;

}
