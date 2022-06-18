package com.dh.projetointegradorv1._equipe4.dh_carshop.service;

import com.dh.projetointegradorv1._equipe4.dh_carshop.dto.CategoryDto;
import com.dh.projetointegradorv1._equipe4.dh_carshop.dto.ProductDto;
import com.dh.projetointegradorv1._equipe4.dh_carshop.dto.RoleDto;
import com.dh.projetointegradorv1._equipe4.dh_carshop.model.Category;
import com.dh.projetointegradorv1._equipe4.dh_carshop.model.Product;
import com.dh.projetointegradorv1._equipe4.dh_carshop.model.Role;
import com.dh.projetointegradorv1._equipe4.dh_carshop.repository.CategoryRepository;
import com.dh.projetointegradorv1._equipe4.dh_carshop.repository.ProductRepository;
import com.dh.projetointegradorv1._equipe4.dh_carshop.repository.RoleRepository;
import com.dh.projetointegradorv1._equipe4.dh_carshop.service.exceptions.BDExcecao;
import com.dh.projetointegradorv1._equipe4.dh_carshop.service.exceptions.RecursoNaoEncontrado;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Transactional(readOnly = true)
    public Page<RoleDto> findAllPage(PageRequest pageRequest) {
        Page<Role> list = roleRepository.findAll(pageRequest);
        return list.map(x -> new RoleDto(x));
    }

    @Transactional(readOnly = true)
    public RoleDto findById(Integer id) throws RecursoNaoEncontrado {
        Optional<Role> obj = roleRepository.findById(id);
        //Categories entidade = obj.get();
        Role entidade = obj.
                orElseThrow(() -> new RecursoNaoEncontrado("Entidade não encontrada."));
        return new RoleDto(entidade);

    }

    @Transactional
    public RoleDto insert(RoleDto dto) {
        Role entity = new Role();
        entity.setNome(dto.getNome());
        entity = roleRepository.save(entity);
        return new RoleDto(entity);
    }

    @Transactional
    public RoleDto update(Integer id, RoleDto dto) throws RecursoNaoEncontrado {
        try {
            Role entity = roleRepository.getById(id.intValue());
            entity.setNome(dto.getNome());
            entity = roleRepository.save(entity);
            return new RoleDto(entity);
        }
        catch (EntityNotFoundException e) {
            throw new RecursoNaoEncontrado("ID NÃO ENCONTRADO: " + id);
        }
    }

    public void delete(Integer id) throws RecursoNaoEncontrado {
        try {
            roleRepository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e) {
            throw new RecursoNaoEncontrado("ID NÃO ENCONTRADO: " + id);
        }
        catch (DataIntegrityViolationException e) {
            throw new BDExcecao("VIOLAÇÃO DE INTEGRIDADE");
        }
    }


}
