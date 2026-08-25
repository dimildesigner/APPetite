package com.senai.cantina.cantina.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        String frontendOrigin = System.getenv().getOrDefault(
                "FRONTEND_ORIGIN",
                "http://localhost:5500"
        );
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(java.util.List.of(frontendOrigin));
        configuration.setAllowedMethods(java.util.List.of(
                "GET", "POST", "PUT", "DELETE", "OPTIONS"
        ));
        configuration.setAllowedHeaders(java.util.List.of("*"));
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source =
                new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/api/**", configuration);
        return source;
    }

    @Bean
    public SecurityFilterChain filterChain(
            HttpSecurity http
    ) throws Exception {

        http
                .cors(cors -> { })
                .authorizeHttpRequests(auth -> auth

                        .requestMatchers(
                                "/",
                                "/login",
                                "/cadastro",
                                "/cardapio",
                                "/cardapio/**",
                                "/css/**",
                                "/js/**",
                                "/images/**",
                                "/assets/**",
                                "/favicon.ico",
                                "/error"
                        ).permitAll()

                        .requestMatchers("/gerente/**")
                        .hasRole("GERENTE")

                        .requestMatchers("/funcionario/**")
                        .hasAnyRole(
                                "FUNCIONARIO",
                                "GERENTE"
                        )

                        .requestMatchers("/pedido/**")
                        .hasAnyRole(
                                "CLIENTE",
                                "FUNCIONARIO",
                                "GERENTE"
                        )

                        // ADICIONADO: regra explícita para pagamento,
                        // no mesmo padrão de "/pedido/**"
                        .requestMatchers("/pagamento/**")
                        .hasAnyRole(
                                "CLIENTE",
                                "FUNCIONARIO",
                                "GERENTE"
                        )

                        .anyRequest()
                        .authenticated()
                )

                .formLogin(form -> form
                        .loginPage("/login")
                        .loginProcessingUrl("/login")
                        .defaultSuccessUrl("/inicio", true)
                        .failureUrl("/login?erro")
                        .permitAll()
                )

                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login?logout")
                        .permitAll()
                );

        return http.build();
    }
}
