package codigo.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(      "/",
                                "/Index",
                                "/BuscarPuesto",
                                "/Empresa/Registro",
                                "/Oferente/Registro",
                                "/login",
                                "/redirect",
                                "/Access-denied",
                                "/Publico/**",
                                "/css/**",
                                "/js/**",
                                "/images/**",
                                "/webjars/**").permitAll()

                        .requestMatchers("/Administrador/**").hasRole("ADMIN")
                        .requestMatchers("/Empresa/**").hasRole("EMPRESA")
                        .requestMatchers("/Oferente/**").hasRole("OFERENTE")

                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/login")
                        .usernameParameter("email")
                        .defaultSuccessUrl("/", false)
                        .permitAll()
                )
                .exceptionHandling(e -> e
                        .accessDeniedPage("/Access-denied")
                )
                .logout(logout -> logout.permitAll())
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
