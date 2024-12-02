package com.floristeria.v1.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.floristeria.v1.model.Flores;
@Repository
public interface florRepository extends JpaRepository<Flores,Long>{
    //Que va aqui adentro
 
}
