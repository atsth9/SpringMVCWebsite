package org.mach.springmvc;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import org.mach.springdao.User;

@Controller
@RequestMapping("/editUser.htm")
@SessionAttributes("user")
public class UserEditFormController {

	@RequestMapping(method = RequestMethod.GET)
    public String setupForm(ModelMap model) {
        model.addAttribute("user", new User());
        return "editUser"; //viewname
    }

    @RequestMapping(method = RequestMethod.POST)
    public String processSubmit( @ModelAttribute("user") @Valid User user, BindingResult result, SessionStatus status) {
        if (result.hasErrors()) {
            return "editUser";
        }

        //userStorageDao.save(user);
        User.add(user);
        status.setComplete();
        return "redirect:users.htm";
    }
}
