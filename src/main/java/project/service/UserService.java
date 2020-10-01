package project.service;

import static java.util.UUID.fromString;
import static java.util.stream.Collectors.toList;
import static model.enums.UserRoles.ROLE_ADMIN;

import model.dto.UserDto;
import model.entity.Role;
import model.entity.User;
import model.utils.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.repositoty.UserRepository;

import java.util.List;
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

    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(UserUtil::fromEntityToDto)
                .collect(toList());
    }

    public void makeAdmin(final String userId) throws Exception {
        final Optional<User> user = userRepository.findById(fromString(userId));
        if (user.isPresent() && !isUserAlreadyAdmin(user.get())) {
            user.get().getRoles().add(new Role(ROLE_ADMIN.value));
            userRepository.save(user.get());
        } else {
            throw new Exception("User not found");
        }
    }

    private boolean isUserAlreadyAdmin(final User user) {
        return user.getRoles().stream().anyMatch(role -> role.getName().equals(ROLE_ADMIN.value));
    }
}
