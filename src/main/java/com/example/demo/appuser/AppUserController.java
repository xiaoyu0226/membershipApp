package com.example.demo.appuser;

import com.example.demo.appuser.AppUser;
import com.example.demo.appuser.AppUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/appUsers")
@AllArgsConstructor
public class AppUserController {
    private final AppUserRepository appUserRepository;

    @GetMapping
    public List<AppUser> getAllAppUsers() {
        System.out.println("something");
        return appUserRepository.findAll();
    }

    @GetMapping(path = "email/{email}")
    public Optional<AppUser> getByEmail(@PathVariable String email) {
        return appUserRepository.findByEmail(email);
    }

    @GetMapping(path = "id/{id}")
    public AppUser getAppUser(@PathVariable Long id) {
        Optional<AppUser> appUser = appUserRepository.findById(id);
        if (appUser.isPresent()) {
            return appUser.get();
        } else {
            throw new IllegalStateException("AppUser not found for the id " + id);
        }
    }

    @PutMapping(path = "id/{id}")
    public AppUser updateAppUser(@PathVariable Long id, @RequestBody AppUser appUser) {
        appUser.setId(id);
        return appUserRepository.save(appUser);
    }
}
