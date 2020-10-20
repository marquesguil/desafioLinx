package com.uam.desafio.resources;

import com.uam.desafio.DTO.ClienteNewDTO;
import com.uam.desafio.exception.ObjectNotFoundException;
import com.uam.desafio.services.ClienteService;
import com.uam.desafio.DTO.ClienteDTO;
import com.uam.desafio.domain.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteResource {

    @Autowired
    private ClienteService service;

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable Integer id) throws ObjectNotFoundException {
        Cliente obj = service.find(id);
        return ResponseEntity.ok().body(obj);
    }


    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@Validated @RequestBody Cliente obj){
        //Cliente obj = service.fromDTO(objDto);
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value="/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@Validated @RequestBody Cliente obj, @PathVariable Integer id) {
        //Cliente obj = service.fromDTO(objDto);
        obj.setId(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Cliente>> findAll() throws ObjectNotFoundException {
        List<Cliente> list = service.findAll();
        //List<Cliente> listDto = list.stream().map(obj -> new ClienteDTO(obj)).collect(Collectors.toList());//ClienteDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(list);
    }

}
