package com.app.userservice.resource.admin;

import com.app.userservice.entity.User;
import com.app.userservice.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/user")
public class AdminUserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public ResponseEntity<?> addNewUser(@RequestBody @NonNull User user) {
        return ResponseEntity.ok(userService.saveUser(user));
    }

}
