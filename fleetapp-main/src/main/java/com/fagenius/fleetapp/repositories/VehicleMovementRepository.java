package com.fagenius.fleetapp.repositories;

import com.fagenius.fleetapp.models.VehicleHire;
import com.fagenius.fleetapp.models.VehicleMovement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleMovementRepository extends JpaRepository<VehicleMovement, Integer> {
}
