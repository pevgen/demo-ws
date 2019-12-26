//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.12.26 at 11:40:11 AM MSK 
//


package ml.pevgen.demows.web.soap.am;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ml.pevgen.demows.web.soap.am package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Fault_QNAME = new QName("http://xbank.ru/soa/service/sudir/itdi/generic.account.management.webservice/2.0.0", "fault");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ml.pevgen.demows.web.soap.am
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ResetPassword }
     * 
     */
    public ResetPassword createResetPassword() {
        return new ResetPassword();
    }

    /**
     * Create an instance of {@link ResetPasswordResponse }
     * 
     */
    public ResetPasswordResponse createResetPasswordResponse() {
        return new ResetPasswordResponse();
    }

    /**
     * Create an instance of {@link GenericAccountManagementException }
     * 
     */
    public GenericAccountManagementException createGenericAccountManagementException() {
        return new GenericAccountManagementException();
    }

    /**
     * Create an instance of {@link ComplexTest }
     * 
     */
    public ComplexTest createComplexTest() {
        return new ComplexTest();
    }

    /**
     * Create an instance of {@link GenericAccountInfo }
     * 
     */
    public GenericAccountInfo createGenericAccountInfo() {
        return new GenericAccountInfo();
    }

    /**
     * Create an instance of {@link ComplexTestResponse }
     * 
     */
    public ComplexTestResponse createComplexTestResponse() {
        return new ComplexTestResponse();
    }

    /**
     * Create an instance of {@link ValidatePassword }
     * 
     */
    public ValidatePassword createValidatePassword() {
        return new ValidatePassword();
    }

    /**
     * Create an instance of {@link ValidatePasswordResponse }
     * 
     */
    public ValidatePasswordResponse createValidatePasswordResponse() {
        return new ValidatePasswordResponse();
    }

    /**
     * Create an instance of {@link SetPassword }
     * 
     */
    public SetPassword createSetPassword() {
        return new SetPassword();
    }

    /**
     * Create an instance of {@link SetPasswordResponse }
     * 
     */
    public SetPasswordResponse createSetPasswordResponse() {
        return new SetPasswordResponse();
    }

    /**
     * Create an instance of {@link SuspendAccount }
     * 
     */
    public SuspendAccount createSuspendAccount() {
        return new SuspendAccount();
    }

    /**
     * Create an instance of {@link SuspendAccountResponse }
     * 
     */
    public SuspendAccountResponse createSuspendAccountResponse() {
        return new SuspendAccountResponse();
    }

    /**
     * Create an instance of {@link CreateAccount }
     * 
     */
    public CreateAccount createCreateAccount() {
        return new CreateAccount();
    }

    /**
     * Create an instance of {@link CreateAccountResponse }
     * 
     */
    public CreateAccountResponse createCreateAccountResponse() {
        return new CreateAccountResponse();
    }

    /**
     * Create an instance of {@link ModifyAccount }
     * 
     */
    public ModifyAccount createModifyAccount() {
        return new ModifyAccount();
    }

    /**
     * Create an instance of {@link ModifyAccountResponse }
     * 
     */
    public ModifyAccountResponse createModifyAccountResponse() {
        return new ModifyAccountResponse();
    }

    /**
     * Create an instance of {@link RestoreAccount }
     * 
     */
    public RestoreAccount createRestoreAccount() {
        return new RestoreAccount();
    }

    /**
     * Create an instance of {@link RestoreAccountResponse }
     * 
     */
    public RestoreAccountResponse createRestoreAccountResponse() {
        return new RestoreAccountResponse();
    }

    /**
     * Create an instance of {@link DeleteAccount }
     * 
     */
    public DeleteAccount createDeleteAccount() {
        return new DeleteAccount();
    }

    /**
     * Create an instance of {@link DeleteAccountResponse }
     * 
     */
    public DeleteAccountResponse createDeleteAccountResponse() {
        return new DeleteAccountResponse();
    }

    /**
     * Create an instance of {@link GetAccountList }
     * 
     */
    public GetAccountList createGetAccountList() {
        return new GetAccountList();
    }

    /**
     * Create an instance of {@link GetAccountListResponse }
     * 
     */
    public GetAccountListResponse createGetAccountListResponse() {
        return new GetAccountListResponse();
    }

    /**
     * Create an instance of {@link GetAccountListById }
     * 
     */
    public GetAccountListById createGetAccountListById() {
        return new GetAccountListById();
    }

    /**
     * Create an instance of {@link GetAccountListByIdResponse }
     * 
     */
    public GetAccountListByIdResponse createGetAccountListByIdResponse() {
        return new GetAccountListByIdResponse();
    }

    /**
     * Create an instance of {@link GenericAttribute }
     * 
     */
    public GenericAttribute createGenericAttribute() {
        return new GenericAttribute();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GenericAccountManagementException }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GenericAccountManagementException }{@code >}
     */
    @XmlElementDecl(namespace = "http://xbank.ru/soa/service/sudir/itdi/generic.account.management.webservice/2.0.0", name = "fault")
    public JAXBElement<GenericAccountManagementException> createFault(GenericAccountManagementException value) {
        return new JAXBElement<GenericAccountManagementException>(_Fault_QNAME, GenericAccountManagementException.class, null, value);
    }

}
