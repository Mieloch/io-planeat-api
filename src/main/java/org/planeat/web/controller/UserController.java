package org.planeat.web.controller;

import org.planeat.core.db.UserRepository;
import org.planeat.core.model.User;
import org.planeat.web.converter.CoreToWeb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest controller for users CRUD operations
 */
@RestController
public class UserController {

    private final UserRepository userRepository;
    private final CoreToWeb coreToWeb;

    @Autowired
    public UserController(UserRepository userRepository, CoreToWeb coreToWeb) {
        this.userRepository = userRepository;
        this.coreToWeb = coreToWeb;
    }

    @CrossOrigin
    @PostMapping("/user/register")
    public ResponseEntity register(@RequestBody User user) {
        if (userRepository.findByUsername(user.getUsername()) != null) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }else {
            userRepository.save(user);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    ;

    @CrossOrigin
    @PostMapping("/user/login")
    public ResponseEntity login(@RequestBody User user) {
        User userEntity = userRepository.findByUsername(user.getUsername());
        if (userEntity != null) {
            if (userEntity.getPassword().equals(user.getPassword())) {
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            }
        }else {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    };

}
