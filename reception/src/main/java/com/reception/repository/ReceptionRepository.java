package com.reception.repository;
import com.reception.model.Reception;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceptionRepository extends JpaRepository<Reception, Long>{
}
