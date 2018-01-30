package com.example.magneto.Repository;

import com.example.magneto.Model.Stats;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface StatsRepository extends CrudRepository<Stats,Long> {

}
