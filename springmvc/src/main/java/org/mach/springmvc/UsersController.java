package org.mach.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import org.mach.springdao.User;

@Controller
public class UsersController {

    @RequestMapping("/users.htm")
    public ModelMap usersHandler() {
    	return new ModelMap("users", User.getList());
    }

}
