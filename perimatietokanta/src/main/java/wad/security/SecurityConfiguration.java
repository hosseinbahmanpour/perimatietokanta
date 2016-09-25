package wad.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("*").permitAll()
                .antMatchers("/books").permitAll()
                .antMatchers("/narrators").permitAll()
                .antMatchers("/themes").permitAll()
                .antMatchers("/admin").hasAnyAuthority("ADMIN")
                .anyRequest().authenticated();                
         http.formLogin().permitAll().and()
                .logout().permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        // ohjelman muokkaustoiminnot on tarkoitettu vain adminille
        auth.inMemoryAuthentication()
                .withUser("hossein").password("erittäinsalainen").roles("ADMIN");
    }
}