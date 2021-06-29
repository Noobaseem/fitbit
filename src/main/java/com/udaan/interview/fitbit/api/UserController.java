package com.udaan.interview.fitbit.api;

import com.udaan.interview.fitbit.exceptions.UserNotFoundException;
import com.udaan.interview.fitbit.model.DashboardResponse;
import com.udaan.interview.fitbit.service.dashboard.DashboardService;
import com.udaan.interview.fitbit.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private DashboardService dashboardService;

    @RequestMapping(path = "/login/{userId}", method = RequestMethod.POST)
    public DashboardResponse login(@PathVariable("userId") Long userId) {
        //Validate User
        if (userService.isRegisteredUser(userId)) {
            return dashboardService.getDashboard(userId);
        } else {
            throw new UserNotFoundException("Not a registered user");
        }
    }
}
