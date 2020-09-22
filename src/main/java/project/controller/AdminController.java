package project.controller;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.service.UserService;

/**
 * @author n.zhuchkevich
 * @since 09/22/2020
 */
@RestController(value = "/admin")
public class AdminController {

    private final UserService userService;

    @Autowired
    public AdminController(final UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/makeAdmin", method = POST)
    public void makeAdmin(@RequestBody final String userId) throws Exception {
        userService.makeAdmin(userId);
    }
}
