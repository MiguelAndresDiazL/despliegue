package com.usta.despliegue.Repository;

import com.usta.despliegue.Entity.PersonaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<PersonaEntity,Long> {
}
