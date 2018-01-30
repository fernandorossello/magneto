package com.example.magneto.Repository;

import com.example.magneto.Model.DNA.DNA;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public interface DNARepository extends CrudRepository<DNA,String> {

}
