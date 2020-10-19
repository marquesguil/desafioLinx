package com.linx.desafio.services;

import com.linx.desafio.DTO.ClienteDTO;
import com.linx.desafio.domain.Cliente;
import com.linx.desafio.exception.ObjectNotFoundException;
import com.linx.desafio.repositories.ClienteRepository;
import com.linx.desafio.repositories.EmpresaRepository;
import com.linx.desafio.repositories.EnderecoRepository;
import com.linx.desafio.repositories.GeolocalizacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repo;

    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private GeolocalizacaoRepository geolocalizacaoRepository;

    public Cliente find(Integer id) throws ObjectNotFoundException {
        Optional<Cliente> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
    }

    public Cliente update(Cliente obj) {
        Cliente newObj = find(obj.getId());
        updateData(newObj, obj);
        find(obj.getId());
        return repo.save(newObj);
    }

    public void delete(Integer id) {
        find(id);
        try {
            repo.deleteById(id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Não foi possível fazer a exclusão por que há entidades relacionadas" + id);
        }
    }

    public List<Cliente> findAll() {
        return repo.findAll();
    }

    public Page<Cliente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return repo.findAll(pageRequest);
    }

    public Cliente fromDTO(ClienteDTO objDto) {
        //throw new UnsupportedOperationException();
        return new Cliente(objDto.getId(), objDto.getName(), objDto.getUsername(), objDto.getEmail(), null, null, null, null);
    }

    private void updateData(Cliente newObj, Cliente obj){
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());
    }

}
