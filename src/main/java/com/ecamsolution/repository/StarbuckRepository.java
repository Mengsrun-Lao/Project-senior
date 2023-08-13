package com.ecamsolution.repository;

import com.ecamsolution.entity.Starbucks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface StarbuckRepository  extends JpaRepository<Starbucks,Long> , JpaSpecificationExecutor<Starbucks> {
}
