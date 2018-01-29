package com.example.magneto.Repository;

import com.example.magneto.Model.DNA.DNA;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class DNARepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void add(DNA dna) {
        entityManager.persist(dna);
    }
}
