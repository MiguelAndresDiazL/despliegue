package com.usta.despliegue.Service;

import com.usta.despliegue.Entity.PersonaEntity;
import com.usta.despliegue.Repository.PersonaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaServiceImplement implements IPersonaService{
    @Autowired
    private PersonaRepository personaRepository;
    @Override
    public List<PersonaEntity> findAll() {
        return personaRepository.findAll();
    }
    @Override
    public void save(PersonaEntity persona) {
        personaRepository.save(persona);
    }
    @Override
    @Transactional
    public PersonaEntity update(PersonaEntity persona) {
        return  personaRepository.save(persona);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        personaRepository.deleteById(id);
    }
}
