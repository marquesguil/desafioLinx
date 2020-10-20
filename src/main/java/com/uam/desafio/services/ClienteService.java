package com.uam.desafio.services;

import com.uam.desafio.DTO.ClienteNewDTO;
import com.uam.desafio.domain.Empresa;
import com.uam.desafio.domain.Endereco;
import com.uam.desafio.domain.Geolocalizacao;
import com.uam.desafio.exception.ObjectNotFoundException;
import com.uam.desafio.DTO.ClienteDTO;
import com.uam.desafio.domain.Cliente;
import com.uam.desafio.repositories.ClienteRepository;
import com.uam.desafio.repositories.EmpresaRepository;
import com.uam.desafio.repositories.EnderecoRepository;
import com.uam.desafio.repositories.GeolocalizacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repo;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private GeolocalizacaoRepository geolocalizacaoRepository;

    public Cliente find(Integer id) throws ObjectNotFoundException {
        Optional<Cliente> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
    }

    @Transactional
    public Cliente insert(Cliente obj) {
        obj.setId(null);
        obj = repo.save(obj);
        enderecoRepository.save(obj.getAddress());
        empresaRepository.save(obj.getCompany());
        return obj;
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
        List<Cliente> obj = repo.findAll();
        return obj;
    }

    public Page<Cliente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return repo.findAll(pageRequest);
    }

    public Cliente fromDTO(ClienteDTO objDto) {
        return new Cliente(objDto.getId(), objDto.getName(),
                objDto.getUsername(), objDto.getEmail(), objDto.getPhone(),
                objDto.getWebsite(), null, null);
    }

    public Cliente fromDTO(ClienteNewDTO objDto) {
        Empresa emp = new Empresa(null, objDto.getName(), objDto.getCatchPhrase(), objDto.getBs());
        Geolocalizacao geo = new Geolocalizacao(null, objDto.getLat(), objDto.getLng());
        //Geolocalizacao geo = new Geolocalizacao(objDto.getGeoId(), null, null);
        Endereco end = new Endereco(null, objDto.getStreet(), objDto.getSuite(), objDto.getCity(), objDto.getZipcode(), geo);
        Cliente cli = new Cliente(null, objDto.getClienteName(), objDto.getEmail(), objDto.getUsername(), objDto.getPhone(), objDto.getWebsite(), end, emp);
        //cli.getAddress().getClass(end);
        //cli.getCompany().add(emp);
        return cli;
    }

    private void updateData(Cliente newObj, Cliente obj){
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());
        newObj.setPhone(obj.getPhone());
        newObj.setWebsite(obj.getWebsite());
        newObj.setUsername(obj.getUsername());
    }

}
