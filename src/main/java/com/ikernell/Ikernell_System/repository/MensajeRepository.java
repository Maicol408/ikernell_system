package com.ikernell.Ikernell_System.repository;

import com.ikernell.Ikernell_System.entity.Mensaje;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MensajeRepository extends JpaRepository<Mensaje, Long> {

    // 📩 Listar mensajes de un chat
    List<Mensaje> findByChatIdOrderByFechaEnvioAsc(Long chatId);

    // 📩 Listar mensajes enviados por un usuario
    List<Mensaje> findByRemitenteId(Long usuarioId);
}
