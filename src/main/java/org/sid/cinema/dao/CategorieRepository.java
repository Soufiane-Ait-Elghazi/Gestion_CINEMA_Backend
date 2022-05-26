package org.sid.cinema.dao;
import org.sid.cinema.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
@RepositoryRestResource
public interface CategorieRepository extends JpaRepository<Categorie,Long> {

}