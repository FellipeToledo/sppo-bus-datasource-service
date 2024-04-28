package com.azvtech.busdatasourceservice.repository;

import com.azvtech.busdatasourceservice.model.Bus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Fellipe Toledo
 */
@Repository
public interface BusRepository extends JpaRepository<Bus, Long> {
}
