package com.dh.projetointegradorv1._equipe4.dh_carshop.controller;

import com.dh.projetointegradorv1._equipe4.dh_carshop.dto.CategoryDto;
import com.dh.projetointegradorv1._equipe4.dh_carshop.dto.RoleDto;
import com.dh.projetointegradorv1._equipe4.dh_carshop.dto.UserDto;
import com.dh.projetointegradorv1._equipe4.dh_carshop.service.CategoryService;
import com.dh.projetointegradorv1._equipe4.dh_carshop.service.RoleService;
import com.dh.projetointegradorv1._equipe4.dh_carshop.service.UserService;
import com.dh.projetointegradorv1._equipe4.dh_carshop.service.exceptions.RecursoNaoEncontrado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping
    public ResponseEntity<Page<RoleDto>> findAll(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "3") Integer size
    ) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<RoleDto> list = roleService.findAllPage(pageRequest);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoleDto> findById(@PathVariable Integer id) {
        try {
            RoleDto dto = roleService.findById(id);
            return ResponseEntity.ok().body(dto);
        } catch (RecursoNaoEncontrado e) {
            return ResponseEntity.status(404).body(new RoleDto());
        }
    }

    @PostMapping
    public ResponseEntity<RoleDto> insert(@RequestBody RoleDto dto) {
        dto = roleService.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoleDto> update(@PathVariable Integer id, @RequestBody RoleDto dto) throws RecursoNaoEncontrado {
        dto = roleService.update(id, dto);
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws RecursoNaoEncontrado {
        roleService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
