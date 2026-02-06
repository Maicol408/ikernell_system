package com.ikernell.Ikernell_System.service;

import com.ikernell.Ikernell_System.entity.Chat;

import java.util.Optional;


public interface ChatService {

    Chat crearChat(Chat chat);

    Optional<Chat> buscarPorId(Long id);

    Optional<Chat> buscarPorProyecto(Long proyectoId);
}
