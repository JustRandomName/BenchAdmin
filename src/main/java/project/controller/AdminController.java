package project.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import model.dto.FormDto;
import model.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.service.FormService;
import project.service.UserService;

import java.util.List;

/**
 * @author n.zhuchkevich
 * @since 09/22/2020
 */
@RestController(value = "/admin")
public class AdminController {

    private final UserService userService;
    private final FormService formService;

    @Autowired
    public AdminController(final UserService userService,
                           final FormService formService) {
        this.userService = userService;
        this.formService = formService;
    }

    @RequestMapping(value = "/makeAdmin", method = POST)
    public void makeAdmin(@RequestBody final String userId) throws Exception {
        userService.makeAdmin(userId);
    }

    @RequestMapping(value = "/getAllForms", method = GET)
    public List<FormDto> getAllForms() {
        return formService.getAllForms();
    }

    @RequestMapping(value = "/getAllUsers", method = GET)
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }
}
