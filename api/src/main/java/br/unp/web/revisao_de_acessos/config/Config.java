package br.unp.web.revisao_de_acessos.config;

import br.unp.web.revisao_de_acessos.Application;
import br.unp.web.revisao_de_acessos.gui.Systray;
import br.unp.web.revisao_de_acessos.util.Constantes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

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
        int porta = Integer.parseInt(env.getProperty(Constantes.PORT_PROP, Constantes.DEFAULT_PORT));
        return (container -> container.setPort(porta));
    }


    @Bean
    public Systray frame() {
        return new Systray();
    }



}
