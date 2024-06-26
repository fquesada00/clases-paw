package ar.edu.itba.paw.webapp.config;

import ar.edu.itba.paw.webapp.auth.PawUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.Duration;

@Configuration
@EnableWebSecurity
@ComponentScan("ar.edu.itba.paw.webapp.auth")
public class WebAuthConfig extends WebSecurityConfigurerAdapter {

  @Autowired private PawUserDetailsService userDetailsService;

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
  }

  @Override
  protected void configure(final HttpSecurity http) throws Exception {
    http.sessionManagement()
        .invalidSessionUrl("/login")
        .and()
        .authorizeRequests()
        .antMatchers("/login")
        .anonymous()
        .antMatchers("/admin/**")
        .hasRole("ADMIN")
        .antMatchers("/users/**")
        .authenticated()
        .antMatchers("/**").permitAll()
        .and()
        .formLogin()
        .usernameParameter("j_username")
        .passwordParameter("j_password")
        .defaultSuccessUrl("/", false)
        .loginPage("/login")
        .and()
        .rememberMe()
        .rememberMeParameter("j_rememberme")
        .userDetailsService(userDetailsService)
        .key("mysupersecretketthatnobodyknowsabout")
        .tokenValiditySeconds((int) Duration.ofDays(30).toSeconds())
        .and()
        .logout()
        .logoutUrl("/logout")
        .logoutSuccessUrl("/login")
        .and()
        .exceptionHandling()
        .accessDeniedPage("/403")
        .and()
        .csrf()
        .disable();
  }

  @Override
  public void configure(final WebSecurity web) {
    web.ignoring().antMatchers("/css/**", "/js/**", "/img/**", "/favicon.ico", "/403");
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
