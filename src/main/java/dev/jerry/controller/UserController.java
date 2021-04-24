package dev.jerry.controller;

import dev.jerry.common.CommonResult;
import dev.jerry.entity.User;
import dev.jerry.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * Manage user data
 */
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping(value = "users/auth", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public CommonResult<User> login(@RequestBody User user) {
        try {
            User userAuth = userService.login(user);
            return CommonResult.success(userAuth);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.validateFailed("wrong username or password");
        }
    }

    @GetMapping("users/email/{email}")
    public CommonResult findUser(@PathVariable String email) {
        User user = userService.findUserByEmail(email);
        return CommonResult.success(user);
    }


    @PostMapping("/users")
    public CommonResult save(@RequestBody User user) {
//        (#{userId}, #{firstName}, #{lastName}, #{email}, md5(#{password}), #{dob}, CURRENT_TIMESTAMP(), 1, #{gender})
        int status = userService.save(user);
        if (status == 1) {
            return CommonResult.success(status);
        } else{
            return CommonResult.failed("register failed");
        }
    }
}


