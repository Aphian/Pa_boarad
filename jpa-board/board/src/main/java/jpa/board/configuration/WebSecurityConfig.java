//package jpa.board.configuration;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.AuthenticationFailureHandler;
//
//import lombok.RequiredArgsConstructor;
//
//@Configuration
//@EnableWebSecurity
//@RequiredArgsConstructor
//public class WebSecurityConfig {
//	
//	private final AuthenticationFailureHandler customFailureHandler;
//	
//	@Bean
//	public BCryptPasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();		
//	}
//	
//	@Bean
//	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//		http.authorizeHttpRequests((authorize) -> authorize
//				.requestMatchers("/post").hasRole("USER")
//				.requestMatchers("/admin/**").hasRole("ADMIN")
//				.anyRequest().permitAll()
//			)
//			.formLogin((formLogin) -> formLogin
//					.loginPage("/members/login")
//					.loginProcessingUrl("/loginProc")
//					.usernameParameter("username")
//					.passwordParameter("password")
//					.defaultSuccessUrl("/")
//					.failureHandler(customFailureHandler)
//					.permitAll()
//			)
//			.logout((logout) -> logout
//					.logoutUrl("/logoutProc")
//					.logoutSuccessUrl("/")
//					.permitAll()
//			)
//			.csrf((csrf) -> csrf.disable());
//		
//		return http.build();
//	}
//
//}
