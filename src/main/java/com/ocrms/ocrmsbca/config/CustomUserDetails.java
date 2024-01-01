package com.ocrms.ocrmsbca.config;

import com.ocrms.ocrmsbca.entity.role.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class CustomUserDetails implements UserDetails {
    private Role role;

    public CustomUserDetails(Role role) {
        this.role = role;
    }

    @Override
    public  Collection<? extends GrantedAuthority> getAuthorities() {
       SimpleGrantedAuthority simpleGrantedAuthority= new SimpleGrantedAuthority(role.getRole());
        return List.of(simpleGrantedAuthority);
    }

    @Override
    public String getPassword() {
        return role.getPassword();
    }

    @Override
    public String getUsername() {
        return role.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
