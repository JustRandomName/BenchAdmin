package admin.admin.controller;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import model.dto.FormDto;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/admin")
public class FormController {

    @RequestMapping(value = "/edit", method = POST)
    public FormDto edit(@RequestBody final FormDto formDto) {
        return formDto;
    }
}
