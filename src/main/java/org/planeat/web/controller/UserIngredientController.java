package org.planeat.web.controller;

import org.planeat.core.db.IngredientRepository;
import org.planeat.core.db.UserRepository;
import org.planeat.core.model.Ingredient;
import org.planeat.core.model.User;
import org.planeat.core.model.exception.UserNotFoundException;
import org.planeat.web.converter.CoreToWeb;
import org.planeat.web.converter.WebToCore;
import org.planeat.web.model.IngredientWeb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by User on 2017-05-15.
 */
@RestController
public class UserIngredientController {

    private IngredientRepository ingredientRepository;
    private UserRepository userRepository;
    private CoreToWeb coreToWeb;
    private WebToCore webToCore;

    @Autowired
    public UserIngredientController(IngredientRepository ingredientRepository, UserRepository userRepository, CoreToWeb coreToWeb, WebToCore webToCore) {
        this.ingredientRepository = ingredientRepository;
        this.userRepository = userRepository;
        this.coreToWeb = coreToWeb;
        this.webToCore = webToCore;
    }

    @CrossOrigin
    @GetMapping("/user/ingredients")
    public List<IngredientWeb> getAllUserIngredients(@RequestParam(name = "user_id") Long userId){
        List<Ingredient> foundIngredients = ingredientRepository.findAllUserIngredients(userId);
        return coreToWeb.ingredientList(foundIngredients);
    }

    @PostMapping("/user/{userId}/ingredient")
    public List<IngredientWeb> insertNewIngredient(@RequestBody IngredientWeb newIngradientWeb, @PathVariable(name = "userId") Long userId) throws UserNotFoundException {
        Ingredient newIngredient = webToCore.ingredient(newIngradientWeb);
        User user = userRepository.findOne(userId);
        if(user == null) {
            throw new UserNotFoundException();
        }
        user.addIngredient(newIngredient);
        User savedUser = userRepository.save(user);
        return coreToWeb.ingredientList(savedUser.getIngerdientList());
    }
}
