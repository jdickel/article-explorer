package me.jdickel.articleexplorer.auth;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import me.jdickel.articleexplorer.entities.User;

@Repository
public interface UserRepository {

	Optional<User> findByEmail(String email);

}
