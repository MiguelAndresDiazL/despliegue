package com.usta.despliegue.Service;

import com.usta.despliegue.Entity.PersonaEntity;

import java.util.List;
import java.util.Optional;

public interface IPersonaService {
    public List<PersonaEntity> findAll();
    public void save(PersonaEntity persona);
    public PersonaEntity update(PersonaEntity persona);
    public void delete(Long id);

}
