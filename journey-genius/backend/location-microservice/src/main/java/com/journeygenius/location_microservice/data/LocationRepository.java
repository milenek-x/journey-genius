package com.journeygenius.location_microservice.data;


import com.journeygenius.location_microservice.data.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
}
