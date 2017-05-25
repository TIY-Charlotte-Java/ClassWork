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
     * If we don't require password confirmation, use this method
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
        // if we're trying to insert a user, we need to first see if the user exists
        User existingUser = users.findFirstByUsername(username);

        // if the user doesn't exist and the password they entered equals the password confirmation they entered..
        if ((existingUser == null) && password.equals(passwordConfirmation)) {

            // make a new user
            User u = new User(username, encoder.encode(password));

            // add a new authority that points to this new user
            Authority authority = new Authority("ROLE_USER", u);

            // save both the user and the authority. NOTE:
            // if you attempt to save the AUTHORITY entity before the USER
            // entity, you will get a "transient object error," meaning
            // basically that you can't save this entity because it points to
            // another entity that is not yet saved.
            users.save(u);
            authorities.save(authority);

            // if this user is supposed to be an admin, add
            // another authority to their list of authorities.
            if (isAdmin) {
                authority = new Authority("ROLE_ADMIN", u);
                authorities.save(authority);
            }

        }
    }
}
