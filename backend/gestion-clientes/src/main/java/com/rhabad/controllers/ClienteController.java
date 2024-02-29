package com.rhabad.controllers;

import com.rhabad.models.dto.ClienteDto;
import com.rhabad.service.ICliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class ClienteController {

    @Autowired
    private ICliente ICliente;

    @RequestMapping(value = "/clientes", method = RequestMethod.GET)
    public ResponseEntity<?> showAllClient(){
        return new ResponseEntity<>(ICliente.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/cliente", method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestBody ClienteDto clienteDto){
        try {
            ICliente.save(clienteDto);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (DataAccessException exData){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/cliente/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable Integer id){
        ICliente.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/cliente/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody ClienteDto clienteDto){
        boolean response = ICliente.update(id, clienteDto);

        if (response){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
