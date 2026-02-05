package com.ikernell.Ikernell_System.repository;

import com.ikernell.Ikernell_System.entity.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ChatRepository extends JpaRepository<Chat, Long> {

    // 🔎 Obtener el chat de un proyecto
    Optional<Chat> findByProyectoId(Long proyectoId);
}
