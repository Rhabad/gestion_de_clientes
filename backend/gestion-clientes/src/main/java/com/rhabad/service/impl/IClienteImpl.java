package com.rhabad.service.impl;

import com.rhabad.models.dto.ClienteDto;
import com.rhabad.models.entity.Cliente;
import com.rhabad.service.ICliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
public class IClienteImpl implements ICliente {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<ClienteDto> findAll() {
        String query = "select c from Cliente c";
        List<Cliente> clientesList = em.createQuery(query).getResultList();

        List<ClienteDto> clienteDtoList = new ArrayList<>();
        for (Cliente cliente: clientesList) {
            clienteDtoList.add(ClienteDto.builder()
                            .id(cliente.getId())
                            .nombre(cliente.getNombre())
                            .apellido(cliente.getApellido())
                            .email(cliente.getEmail())
                            .telefono(cliente.getTelefono())
                    .build());
        }


        return clienteDtoList;
    }

    @Override
    @Transactional
    public void save(ClienteDto clienteDto) {
        Cliente cliente = Cliente.builder()
                .nombre(clienteDto.getNombre())
                .apellido(clienteDto.getApellido())
                .email(clienteDto.getEmail())
                .telefono(clienteDto.getTelefono())
                .build();
        em.persist(cliente);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Cliente cliente = em.find(Cliente.class, id);
        em.remove(cliente);
    }

    @Override
    @Transactional
    public boolean update(Integer id, ClienteDto clienteDto) {
        Cliente cliente = em.find(Cliente.class, id);

        if (cliente != null){
            cliente.setNombre(clienteDto.getNombre());
            cliente.setApellido(clienteDto.getApellido());
            cliente.setEmail(clienteDto.getEmail());
            cliente.setTelefono(clienteDto.getTelefono());

            em.merge(cliente);
            return true;
        }

        return false;
    }
}
