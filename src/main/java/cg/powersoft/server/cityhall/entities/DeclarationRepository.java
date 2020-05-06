package cg.powersoft.server.cityhall.entities;

import cg.powersoft.server.cityhall.dao.Declaration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface DeclarationRepository extends JpaRepository<Declaration,Long> {
}
