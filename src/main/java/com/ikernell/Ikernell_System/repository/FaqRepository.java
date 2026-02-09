package com.ikernell.Ikernell_System.repository;

import com.ikernell.Ikernell_System.entity.Faq;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FaqRepository extends JpaRepository<Faq, Long> {

    // Listar solo FAQs activas
    List<Faq> findByActivoTrue();

    // Buscar por palabra clave en la pregunta (útil para buscador)
    List<Faq> findByPreguntaContainingIgnoreCase(String palabra);
}
