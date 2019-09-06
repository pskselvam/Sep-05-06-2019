```java
package com.ds;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
 
	@Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
		PasswordEncoder encoder =
			     PasswordEncoderFactories.createDelegatingPasswordEncoder();
        auth.inMemoryAuthentication().withUser("man")
                .password(encoder.encode("man")).roles("ACTUATOR");
    }
	@Override
    protected void configure(HttpSecurity http) throws Exception {
		http
        .authorizeRequests()
            .antMatchers("/actuator/**").authenticated() // These urls are allowed by any authenticated user
        .and()
            .httpBasic();
        http.csrf().disable();
    }
	
	
}

```