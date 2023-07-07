//package id.co.indivara.jdt12.warehouseproject.security;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@Configuration
//public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
//    // method untuk membuat user di memory
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("warehouseadmin").password("{noop}wh123").roles("WHADMIN")
//                .and()
//                .withUser("storeadmin").password("{noop}st123").roles("STADMIN")
//                .and()
//                .withUser("admin").password("{noop}admin123").roles("ADMIN");
//    }
//    // method untuk mengatur privileges
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .httpBasic()
//                .and()
//                .authorizeHttpRequests()
//                .antMatchers(HttpMethod.GET, "/**").hasRole("ADMIN")
//                .antMatchers(HttpMethod.POST, "/**").hasRole("ADMIN")
//                .antMatchers(HttpMethod.GET, "/supply/**").hasRole("WHADMIN")
//                .antMatchers(HttpMethod.POST, "/supply/**").hasRole("WHADMIN")
//                .antMatchers(HttpMethod.GET, "/whtowh/**").hasRole("WHADMIN")
//                .antMatchers(HttpMethod.POST, "/whtowh/**").hasRole("WHADMIN")
//                .antMatchers(HttpMethod.GET, "/whtostr/**").hasRole("WHADMIN")
//                .antMatchers(HttpMethod.POST, "/whtostr/**").hasRole("WHADMIN")
//                .antMatchers(HttpMethod.POST, "/warehouse-inventory/**").hasRole("WHADMIN")
//                .antMatchers(HttpMethod.POST, "/store-inventory/viewbystoreid/**").hasRole("STADMIN")
//                .and()
//                .csrf().disable()
//                .formLogin().disable();
//    }
//}
