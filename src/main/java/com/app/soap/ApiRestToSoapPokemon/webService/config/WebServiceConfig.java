package com.app.soap.ApiRestToSoapPokemon.webService.config;

import com.app.soap.ApiRestToSoapPokemon.constans.GeneralConstans;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;


@EnableWs
@Configuration
/**
 * WebServiceConfig class
 * Class  web service config
 * @autor jjpc
 */
public class WebServiceConfig extends WsConfigurerAdapter {

    @Bean
    /**
     * messageDispatcherServlet method.
     * @arg ApplicationContext
     * @autor jjpc
     */
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext
    applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(servlet, GeneralConstans.URL_MAPPING);
    }

    @Bean(name = "pokeapi")
    /**
     * defaultWsdl11Definition method
     * @arg XsdSchema
     * @autor jjpc
     */
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema pokeApiSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName(GeneralConstans.PORT_TYPE_NAME);
        wsdl11Definition.setLocationUri(GeneralConstans.LOCATION_URI);
        wsdl11Definition.setTargetNamespace(GeneralConstans.NAMESPACE_URI);
        wsdl11Definition.setSchema(pokeApiSchema);
        return wsdl11Definition;
    }

    @Bean
    /**
     * pokemonSchema method
     * @autor jjpc
     */
    public XsdSchema pokemonSchema() {
        return new SimpleXsdSchema(new ClassPathResource(GeneralConstans.PATH_XSD));
    }


}
