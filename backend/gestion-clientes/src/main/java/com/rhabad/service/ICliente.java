package com.rhabad.service;

import com.rhabad.models.dto.ClienteDto;

import java.util.List;

public interface ICliente {
    List<ClienteDto> findAll();
    void save(ClienteDto clienteDto);
    void delete(Integer id);
    boolean update(Integer id, ClienteDto clienteDto);
}
