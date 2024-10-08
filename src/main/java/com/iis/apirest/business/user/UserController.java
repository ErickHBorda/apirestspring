package com.iis.apirest.business.user;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iis.apirest.business.user.request.RequestLogin;
import com.iis.apirest.business.user.response.ResponseLogin;
import com.iis.apirest.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("user1")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(path = "login", consumes = { "multipart/form-data" })
    public ResponseEntity<ResponseLogin> actionLogin(@Valid @ModelAttribute RequestLogin requestlogin, BindingResult bindingResult) {
                ResponseLogin responseLogin = new ResponseLogin();
        try {
            if (bindingResult.hasErrors()) {
                bindingResult.getAllErrors().forEach(error -> {
                    responseLogin.addResponseMesssage(error.getDefaultMessage());
                });
                return new ResponseEntity<>(responseLogin, HttpStatus.OK);
            }

            Map<String, Object> response =userService.login(requestlogin.getNameUser(),requestlogin.getPassword());

            if ("success".equals(response.get("type"))) {
                responseLogin.setToken(response.get("token"));
                responseLogin.success();
                responseLogin.addResponseMesssage(response.get("message").toString());
                responseLogin.setDto(response.get("dto"));
            }
            else if("error".equals(response.get("type"))){
                responseLogin.error();
                responseLogin.addResponseMesssage(response.get("message").toString());
            }
            else if("exception".equals(response.get("type"))){
                responseLogin.exception();
                responseLogin.addResponseMesssage(response.get("message").toString());
            }

            return new ResponseEntity<>(responseLogin, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(responseLogin, HttpStatus.BAD_REQUEST);
        }
    }
}

