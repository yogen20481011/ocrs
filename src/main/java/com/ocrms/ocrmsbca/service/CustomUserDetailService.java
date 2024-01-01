package com.ocrms.ocrmsbca.service;


import com.ocrms.ocrmsbca.config.CustomUserDetails;
import com.ocrms.ocrmsbca.entity.role.Role;
import com.ocrms.ocrmsbca.repository.role.RoleRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {
   private final RoleRepository userRepo;

    public CustomUserDetailService(RoleRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //find the user name
      Role userByEmail=  userRepo.findUserByEmail(username);
        //if user by email null
        if(userByEmail==null){
            //print the user not fount expection
            throw new UsernameNotFoundException("User not found!!!");
        }
        //return the custome user
        return new CustomUserDetails(userByEmail);
    }
}
