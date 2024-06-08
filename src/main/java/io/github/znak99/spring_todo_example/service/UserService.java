package io.github.znak99.spring_todo_example.service;

import io.github.znak99.spring_todo_example.domain.User;
import io.github.znak99.spring_todo_example.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public Long join(User user) {
        validateDuplicateUser(user);
        userRepository.saveUser(user);
        return user.getId();
    }

    private void validateDuplicateUser(User user) {
        List<User> users = userRepository.findUserByEmail(user.getEmail());

        if (!users.isEmpty())
            throw new IllegalStateException("Email already exist");
    }
}
