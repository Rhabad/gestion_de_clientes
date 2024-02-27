package com.rhabad.controllers;

import com.rhabad.models.dto.ClienteDto;
import com.rhabad.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @RequestMapping(value = "/clientes", method = RequestMethod.GET)
    public ResponseEntity<?> showAllClient(){
        return new ResponseEntity<>(clienteService.findAll(), HttpStatus.OK);
    }

}
