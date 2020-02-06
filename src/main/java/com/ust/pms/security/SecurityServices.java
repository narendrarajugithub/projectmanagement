
  package com.ust.pms.security;
  
  import javax.sql.DataSource;
  
  import org.springframework.beans.factory.annotation.Autowired; import
  org.springframework.context.annotation.Bean; import
  org.springframework.context.annotation.Configuration; import
  org.springframework.security.config.annotation.authentication.builders.
  AuthenticationManagerBuilder; import
  org.springframework.security.config.annotation.web.builders.HttpSecurity;
  import org.springframework.security.config.annotation.web.configuration.
  EnableWebSecurity; import
  org.springframework.security.config.annotation.web.configuration.
  WebSecurityConfigurerAdapter; import
  org.springframework.security.crypto.password.NoOpPasswordEncoder; import
  org.springframework.security.crypto.password.PasswordEncoder;
  
  @Configuration
  
  @EnableWebSecurity public class SecurityServices extends
  WebSecurityConfigurerAdapter {
  
  @Autowired DataSource datasource;
  
  
  @Override protected void configure(AuthenticationManagerBuilder auth) throws
  Exception {
	  // TODO Auto-generated method stub
  
  auth.jdbcAuthentication().dataSource(datasource).withDefaultSchema().withUser
  ("user").password("user1").roles("USER").and().withUser("admin1").password(
  "user1").roles("ADMIN");
  System.out.println("-------------------------------> authENTICATION config");
  // super.configure(auth); 
  }
  
  @Bean public PasswordEncoder getPasswordEncoder() {
  System.out.println("------->Pwd encription"); return
  NoOpPasswordEncoder.getInstance(); }
  
  @Override protected void configure(HttpSecurity http) throws Exception {
	  //TODO Auto-generated method stub
  http.authorizeRequests().antMatchers("/projects/new").hasRole("ADMIN")
  .antMatchers("/employees/new").hasRole("ADMIN")
  .antMatchers("/h2-console/**").permitAll()
  .antMatchers("/").authenticated().and().formLogin();
  System.out.println("-------------------------------> autthorization config");
  
  http.csrf().disable();
  http.headers().frameOptions().disable();
  }
  
  }
 