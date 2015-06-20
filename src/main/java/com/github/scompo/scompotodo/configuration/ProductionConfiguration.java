package com.github.scompo.scompotodo.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.github.scompo.scompotodo.configuration.profiles.ProfileConstants;

@Configuration
@Profile(value = ProfileConstants.PRODUCTION)
public class ProductionConfiguration {
	
	
}
