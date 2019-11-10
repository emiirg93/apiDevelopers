package com.api.developers.repository;

import com.api.developers.model.Developer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface DeveloperRepository extends JpaRepository<Developer,Long> {
}
