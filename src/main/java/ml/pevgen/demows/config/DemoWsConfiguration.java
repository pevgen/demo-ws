package ml.pevgen.demows.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.SimpleWsdl11Definition;
import org.springframework.ws.wsdl.wsdl11.Wsdl11Definition;

/**
 *
 * Servlet path: http://localhost:8080/{@link #SERVLET_PREFIX_WS_CONTEXT}/{@link #WSDL_DEFINITION_BEAN_NAME}.wsdl
 * <p>
 * Relative path to a real wsdl-file in src/main/resources: {@link #WSDL_SERVLET_RELATIVE_PATH}
 *
 */
@EnableWs
@Configuration
public class DemoWsConfiguration {

    private static final String SERVLET_PREFIX_WS_CONTEXT = "/demo-ws/ws/*";
    private static final String WSDL_DEFINITION_BEAN_NAME = "hello-world-demo";
    private static final String WSDL_SERVLET_RELATIVE_PATH = "/wsdl/helloworld.wsdl";

    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        return new ServletRegistrationBean(servlet, SERVLET_PREFIX_WS_CONTEXT);
    }

    @Bean(name = WSDL_DEFINITION_BEAN_NAME)
    public Wsdl11Definition defaultWsdl11Definition() {
        SimpleWsdl11Definition wsdl11Definition = new SimpleWsdl11Definition();
        wsdl11Definition.setWsdl(new ClassPathResource(WSDL_SERVLET_RELATIVE_PATH));
        return wsdl11Definition;
    }
}
