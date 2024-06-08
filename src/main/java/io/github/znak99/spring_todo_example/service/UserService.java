package io.github.znak99.spring_todo_example.service;

import io.github.znak99.spring_todo_example.domain.Role;
import io.github.znak99.spring_todo_example.domain.User;
import io.github.znak99.spring_todo_example.dto.UserDTO;
import io.github.znak99.spring_todo_example.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public Optional<User> findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    @Transactional
    public Long joinUser(UserDTO dto) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        dto.setPassword(passwordEncoder.encode(dto.getPassword()));

        return userRepository.save(dto.toEntity()).getId();
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        System.out.println("email: >> " + email);
        Optional<User> findName = userRepository.findUserByEmail(email);
        User member = findName.get();

        List<GrantedAuthority> authorities = new ArrayList<>();

        if(("admin@admin.com").equals(email)){
            authorities.add(new SimpleGrantedAuthority(Role.ADMIN.getValue()));
        }else {
            authorities.add(new SimpleGrantedAuthority(Role.USER.getValue()));
        }
        return new org.springframework.security.core.userdetails.User(member.getEmail(), member.getPassword(), authorities);
    }
}
