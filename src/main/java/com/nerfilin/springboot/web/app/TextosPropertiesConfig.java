package com.nerfilin.springboot.web.app;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources({
	@PropertySource("classpath:textos.properties"),
	@PropertySource("classpath:propertieTest.properties")
})
public class TextosPropertiesConfig {
	
}
