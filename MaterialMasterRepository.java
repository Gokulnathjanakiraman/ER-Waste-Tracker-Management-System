package com.erapp23.repository;

import com.erapp23.entity.MaterialMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialMasterRepository extends JpaRepository<MaterialMaster, Long> {
}
