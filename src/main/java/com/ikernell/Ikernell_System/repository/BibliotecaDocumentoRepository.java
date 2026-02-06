package com.ikernell.Ikernell_System.repository;

import com.ikernell.Ikernell_System.entity.BibliotecaDocumento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BibliotecaDocumentoRepository
        extends JpaRepository<BibliotecaDocumento, Long> {

    List<BibliotecaDocumento> findByActivoTrue();
}
