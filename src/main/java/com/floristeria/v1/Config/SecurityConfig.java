package com.floristeria.v1.Config;
// import com.floristeria.servicio.UsuarioServicio;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Configuration
public class SecurityConfig {

    // // private final UsuarioServicio usuarioServicio;

    // // public SecurityConfig(UsuarioServicio usuarioServicio) {
    // //     this.usuarioServicio = usuarioServicio;
    // // }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/error").permitAll()
                .requestMatchers("/flores/**").authenticated() // Requiere inicio de sesión
                .requestMatchers("/","/home/**").permitAll() 
                           // Acceso público
                .requestMatchers("/images/**").permitAll() // Recursos estáticos
            )
            .formLogin(form -> form
                .loginPage("/home/login")                          // Página personalizada para login
                .defaultSuccessUrl("/", true)       // Redirección tras login
                .permitAll()
            )
            .logout(logout -> logout
                .logoutUrl("/logout")                        // URL para cerrar sesión
                .logoutSuccessUrl("/login?logout=true")      // Redirección tras logout
                .invalidateHttpSession(true)                // Invalida sesión
                .deleteCookies("JSESSIONID")                // Borra cookies de sesión
                .permitAll()
            );
    
        return http.build();
    }
    
    

    // @Bean
    // public PasswordEncoder passwordEncoder() {
    //     return new BCryptPasswordEncoder();
    // }
}
