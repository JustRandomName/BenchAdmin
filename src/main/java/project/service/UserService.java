package project.service;

import static java.util.UUID.fromString;
import static model.enums.UserRoles.ROLE_ADMIN;

import model.entity.Role;
import model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.repositoty.UserRepository;

import java.util.Optional;

/**
 * @author n.zhuchkevich
 * @since 09/22/2020
 */
@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void makeAdmin(final String userId) throws Exception {
        final Optional<User> user = userRepository.findById(fromString(userId));
        if (user.isPresent()) {
            user.get().getRoles().add(new Role(ROLE_ADMIN.value));
        } else {
            throw new Exception("User not found");
        }
    }
}
