package br.jus.tjrn.esb.scheduled.config;

import br.jus.tjrn.esb.scheduled.Application;
import br.jus.tjrn.esb.scheduled.util.Constantes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan(basePackageClasses = Application.class)
@PropertySource(value = {"classpath:my.properties"})
@PropertySource(value = {".external.properties"}, ignoreResourceNotFound = true)
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class Config {
    private final Environment env;

    @Autowired
    public Config(Environment env) {
        this.env = env;
    }


    @Bean
    public EmbeddedServletContainerCustomizer containerCustomizer() {
        int porta = Integer.parseInt(env.getProperty(Constantes.PORT_PROP));
        return (container -> container.setPort(porta));
    }
    
    @Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

}
