package com.linx.desafio.DTO;

import com.linx.desafio.domain.Cliente;

import java.io.Serializable;

public class ClienteDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    private String name;
    private String username;
    private String email;
    //private Endereco address;
    private String phone;
    private String website;
    //private Empresa company;

    public ClienteDTO() {
    }

    public ClienteDTO(Cliente obj){
        id = obj.getId();
        name = obj.getName();
        username = obj.getUsername();
        email = obj.getEmail();
        //address = obj.getAddress();
        phone = obj.getPhone();
        website = obj.getPhone();


    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}
