package vn.com.devmaster.project.managermaterial.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
                .csrf().disable()
                .authorizeHttpRequests()
                .antMatchers("/**").permitAll()
                .antMatchers("/shopping-cart/view/checkout").hasAnyRole("USER") //những trang web có /views/** là authenticated
                .and().formLogin()
                .loginPage("/login")
        ;
        // lưu ý sắp xếp đúng antMatchers phía trên nếu ko antMatchers dòng 1 sẽ ko được phân quyền
        return http.build();

//        ((HttpSecurity) ((AuthorizeHttpRequestsConfigurer.AuthorizedUrl) ((AuthorizeHttpRequestsConfigurer.AuthorizedUrl)
//                ((AuthorizeHttpRequestsConfigurer.AuthorizedUrl) ((HttpSecurity)
//                        http.csrf().disable()).authorizeHttpRequests()
//                        .antMatchers(new String[]{"/admin"}))
//                        .hasAuthority("ADMIN")
//                        .antMatchers(new String[]{"/view/manager-material/store"}))
//                .hasAnyAuthority(new String[]{"ADMIN", "USER"})
//                .antMatchers(new String[]{"/**"}))
//                .permitAll().and()).formLogin()
//                .loginPage("/login").permitAll();
//        return (SecurityFilterChain) http.build();
    }
}
