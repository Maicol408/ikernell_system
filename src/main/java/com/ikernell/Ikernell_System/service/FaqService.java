package com.ikernell.Ikernell_System.service;

import com.ikernell.Ikernell_System.entity.Faq;
import com.ikernell.Ikernell_System.repository.FaqRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FaqService {

    private final FaqRepository repository;

    public FaqService(FaqRepository repository) {
        this.repository = repository;
    }

    // Crear FAQ
    public Faq crear(Faq faq) {
        return repository.save(faq);
    }

    // Listar FAQs activas
    public List<Faq> listarActivas() {
        return repository.findByActivoTrue();
    }

    // Buscar por ID
    public Optional<Faq> buscarPorId(Long id) {
        return repository.findById(id);
    }

    // Borrado lógico
    public void desactivar(Long id) {
        Faq faq = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("FAQ no encontrada"));

        faq.setActivo(false);
        repository.save(faq);
    }
}
