package com.system.survey.dto.authentication;

import com.system.survey.dto.user.UserDto;
import com.system.survey.enums.ActiveStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class UserPrincipal implements UserDetails {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private UserDto userDto;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // TODO Auto-generated method stub
        return new ArrayList<>();
    }

    @Override
    public String getPassword() {
        // TODO Auto-generated method stub
        return userDto.getUserPassword();
    }

    @Override
    public String getUsername() {
        // TODO Auto-generated method stub
        return userDto.getUserUserId();
    }

    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return Boolean.TRUE;
    }

    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return Boolean.TRUE;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return Boolean.TRUE;
    }

    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        if (userDto.getActiveStatus() == ActiveStatus.Y) {
            return true;
        } else {
            return false;
        }
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }
}
