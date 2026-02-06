package com.ikernell.Ikernell_System.service;

import com.ikernell.Ikernell_System.entity.BibliotecaDocumento;
import com.ikernell.Ikernell_System.repository.BibliotecaDocumentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BibliotecaDocumentoService {

    private final BibliotecaDocumentoRepository repository;

    public BibliotecaDocumentoService(BibliotecaDocumentoRepository repository) {
        this.repository = repository;
    }

    public BibliotecaDocumento guardar(BibliotecaDocumento documento) {
        return repository.save(documento);
    }

    public List<BibliotecaDocumento> listarActivos() {
        return repository.findByActivoTrue();
    }

    public Optional<BibliotecaDocumento> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public void desactivar(Long id) {
        BibliotecaDocumento doc = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Documento no encontrado"));
        doc.setActivo(false);
        repository.save(doc);
    }
}
