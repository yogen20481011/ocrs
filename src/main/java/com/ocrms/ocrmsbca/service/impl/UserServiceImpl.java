package com.ocrms.ocrmsbca.service.impl;

import com.ocrms.ocrmsbca.dto.UserDto;
import com.ocrms.ocrmsbca.entity.role.Role;
import com.ocrms.ocrmsbca.entity.user.User;
import com.ocrms.ocrmsbca.repository.role.RoleRepository;
import com.ocrms.ocrmsbca.repository.user.UserRepository;
import com.ocrms.ocrmsbca.service.user.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
   private final RoleRepository roleRepository;

    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    @Override
    public UserDto save(UserDto userDto){
        User user = new User();
        Role role=new Role();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setContact(userDto.getContact());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        role.setId(userDto.getId());
        userRepository.save(user);

        role.setName(userDto.getName());
        role.setEmail(userDto.getEmail());
        role.setPassword(passwordEncoder.encode(userDto.getPassword()));
        role.setRole("ROLE_USER");
        roleRepository.save(role);
     return userDto;
    }

    @Override
    public List<UserDto> findAll() {
        List<UserDto> userList = new ArrayList<>();
        List<User> users = userRepository.findAll();
        for (User user : users){
            userList.add(UserDto.builder()
                    .id(user.getId())
                    .name(user.getName())
                    .contact(user.getContact())
                    .email(user.getEmail())
                    .build());

        }
        return userList;
    }

    @Override
    public UserDto findById(Long aLong) {
        User user = null;
        Optional<User> optionalUser=userRepository.findById(aLong);
        if (optionalUser.isPresent())
        {
            user=optionalUser.get();
            return UserDto.builder()
                    .id(user.getId())
                    .name(user.getName())
                    .contact(user.getContact())
                    .email(user.getEmail())
                    .build();
        }
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .contact(user.getContact())
                .email(user.getEmail())
                .build();
    }


    @Override
    public void deleteById(Long aLong) {

    }
    public User findUserByEmail(String email){
        return userRepository.findUserByEmail(email);
    }
}



