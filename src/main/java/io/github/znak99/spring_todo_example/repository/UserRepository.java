package io.github.znak99.spring_todo_example.repository;

import io.github.znak99.spring_todo_example.domain.User;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserRepository {
    private final EntityManager entityManager;

    public void saveUser(User user) {
        entityManager.persist(user);
    }

    public List<User> findUserByEmail(String email) {
        return entityManager.createQuery("SELECT m FROM User m WHERE m.email = :email", User.class)
                .setParameter("email", email)
                .getResultList();
    }

}
