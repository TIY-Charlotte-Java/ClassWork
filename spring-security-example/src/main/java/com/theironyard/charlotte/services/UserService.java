package com.theironyard.charlotte.services;

import com.theironyard.charlotte.entities.Authority;
import com.theironyard.charlotte.entities.User;
import com.theironyard.charlotte.repositories.AuthorityRepository;
import com.theironyard.charlotte.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    UserRepository users;
    AuthorityRepository authorities;
    PasswordEncoder encoder;

    public UserService(UserRepository users, AuthorityRepository authorities, PasswordEncoder encoder) {
        this.users = users;
        this.authorities = authorities;
        this.encoder = encoder;
    }

    /**
     * If we do'nt require password confirmation, use this method
     * @param username
     * @param password
     */
    public void createUser(String username, String password) {
        createUser(username, password, password, false);
    }


    /**
     * Use this method to create a user if we need to confirm their password
     * @param username
     * @param password
     * @param passwordConfirmation
     */
    public void createUser(String username, String password, String passwordConfirmation, boolean isAdmin) {
        User existingUser = users.findFirstByUsername(username);

        if ((existingUser == null) && password.equals(passwordConfirmation)) {
            User u = new User(username, encoder.encode(password));
            Authority authority = new Authority("ROLE_USER", u);

            users.save(u);
            authorities.save(authority);

            if (isAdmin) {
                authority = new Authority("ROLE_ADMIN", u);
                authorities.save(authority);
            }

        }
    }
}
