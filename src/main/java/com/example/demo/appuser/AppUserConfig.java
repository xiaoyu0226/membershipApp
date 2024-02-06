package com.example.demo.appuser;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.util.Collections;

@Configuration
public class AppUserConfig {
    @Bean
    public CommandLineRunner createAdminUser(AppUserRepository appUserRepository) {
        return args -> {
            // Check if admin user already exists
            if (!appUserRepository.existsByFirstName("admin") && !appUserRepository.existsByLastName("admin")) {
                // Create admin user
                AppUser admin = new AppUser();
                admin.setLastName("admin");
                admin.setFirstName("admin");
                admin.setPassword(new BCryptPasswordEncoder().encode("admin"));
                admin.setAppUserRole(AppUserRole.ROLE_ADMIN);
                admin.setEmail("emilyyu0226@gmail.com");
                admin.setEnabled(Boolean.TRUE);
                admin.getAuthorities();
                appUserRepository.save(admin);
            }

            if (!appUserRepository.existsByFirstName("partner") && !appUserRepository.existsByLastName("partner")) {
                // Create admin user
                AppUser admin = new AppUser();
                admin.setLastName("partner");
                admin.setFirstName("partner");
                admin.setPassword(new BCryptPasswordEncoder().encode("partner"));
                admin.setAppUserRole(AppUserRole.ROLE_PARTNER);
                admin.setEmail("emilyyu0226@hotmail.com");
                admin.setEnabled(Boolean.TRUE);
                admin.getAuthorities();
                appUserRepository.save(admin);
            }
        };
    }
}
