package com.iis.apirest.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iis.apirest.dto.DtoUser;
import com.iis.apirest.entity.TUser;
import com.iis.apirest.jwt.JwtService;
import com.iis.apirest.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtService jwtService;


    public Map<String, Object> login(String nameUser, String password) {
        Optional<TUser> optionalUser = userRepository.findByNameUser(nameUser);
        
        if (!optionalUser.isPresent()) {
            return new HashMap<String, Object>() {{
                put("type", "error");
                put("message", "Nombre de usuario incorrecto.");
            }};
        }
        TUser user = optionalUser.get();
    
        if (!user.getPassword().equals(password)) {
            return new HashMap<String, Object>() {{
                put("type", "error");
                put("message", "Contraseña incorrecta.");
            }};
        }
        
        String token = jwtService.generateToken(user);
        
        DtoUser dtoUser=new DtoUser();
        dtoUser.setIdUser(user.getIdUser());
        dtoUser.setNameUser(user.getNameUser());
        return new HashMap<String, Object>() {{
            put("token", token);
            put("type", "success");
            put("message", "Bienvenido.");
            put("dto",dtoUser);
        }};
    }
}