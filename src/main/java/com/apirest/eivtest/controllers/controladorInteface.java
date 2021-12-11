/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apirest.eivtest.controllers;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author usuario
 * @param <M>
 */
public interface controladorInteface<M extends Object> {

    @GetMapping()
    public List<?> list() throws Exception;

    @GetMapping("/{id}")
    public Object getOne(@PathVariable Integer id) throws Exception;

    @PostMapping()
    public Object create(@RequestBody M model)
            throws Exception;

    @PutMapping()
    public Object edit(@RequestBody M model)
            throws Exception;

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) throws Exception;
}
