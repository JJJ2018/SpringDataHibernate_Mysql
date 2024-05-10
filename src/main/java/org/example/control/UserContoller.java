package org.example.control;

import org.example.entity.User;
import org.example.entity.UserRequestDto;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserContoller {
    @Autowired
    UserService userService;

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable Integer id) {
        return userService.getById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> saveUser(@Validated @RequestBody UserRequestDto userRequestDto) {
        userService.save(userRequestDto.toUser());
        return ResponseEntity.ok().build();
    }
}
