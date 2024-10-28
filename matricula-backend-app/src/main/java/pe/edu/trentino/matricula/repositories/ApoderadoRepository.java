package pe.edu.trentino.matricula.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.trentino.matricula.models.Apoderado;


import java.util.Optional;

public interface ApoderadoRepository extends JpaRepository<Apoderado, Long> {
    Page<Apoderado> findByNombreContainingIgnoreCase(String nombre, Pageable pageable);
    Optional<Apoderado> findByNombre(String nombre);
}