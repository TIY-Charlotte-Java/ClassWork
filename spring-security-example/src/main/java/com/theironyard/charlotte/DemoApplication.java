package com.theironyard.charlotte;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

// we are extending the WebSecurityConfigurerAdapter so that we can
// control who can see what pages.
@SpringBootApplication
//public class DemoApplication {
public class DemoApplication extends WebSecurityConfigurerAdapter {
    @Autowired
    PasswordEncoder encoder;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
    public PasswordEncoder encoder() {
	    return new BCryptPasswordEncoder();
    }


	// this configure method gives us a reference to an HttpSecurity object,
    // which we will use to configure our security settings.
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/", "/home", "/new-user").permitAll()
                .antMatchers("/admin-page").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
            .logout()
                .logoutUrl("/logout")
                .permitAll()
                .and()
            .csrf().disable();
    }


    // example configuration for an in-memory data store of users.
//    @Autowired
//    public void whateverwant(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//            // we want to use in-memory storage for our users (for testing purposes)
//            .inMemoryAuthentication()
//            // here we have a sample user with a sample password.
//            // with the role "USER";
//
//            // NOTE: when this user is saved, his role will be "ROLE_USER".
//            // but in code we reference that as "USER"
//            .withUser("user").password("password").roles("USER");
//    }


    @Autowired
    public void configureAuth(AuthenticationManagerBuilder auth, DataSource dataSource) throws Exception {
	    auth


                // .jdbcAuthentication says "use a database for looking for our users"
                .jdbcAuthentication()

                    // we're using the autowired encoder to encode passwords on login
                    .passwordEncoder(encoder)

                    // .dataSource says "use THIS data connection to look for our users"
                    .dataSource(dataSource)


                    // .usersByUsernameQuery will tell Spring Security How to run the query that will return
                    // user data.
                    .usersByUsernameQuery("select username, password, enabled from users where username = ?")

                    // authoritiesByUsernameQuery will tell spring security how to get a user's list of roles.
                    // authorities ~= roles
                    .authoritiesByUsernameQuery("select users.username, authorities.role_name from users inner join authorities on users.id = authorities.user_id where users.username = ?");
    }
}
