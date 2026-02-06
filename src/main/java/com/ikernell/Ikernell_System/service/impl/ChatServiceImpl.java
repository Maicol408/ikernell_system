package com.ikernell.Ikernell_System.service.impl;

import com.ikernell.Ikernell_System.entity.Chat;
import com.ikernell.Ikernell_System.repository.ChatRepository;
import com.ikernell.Ikernell_System.service.ChatService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ChatServiceImpl implements ChatService {

    private final ChatRepository chatRepository;

    public ChatServiceImpl(ChatRepository chatRepository) {
        this.chatRepository = chatRepository;
    }

    @Override
    public Chat crearChat(Chat chat) {
        return chatRepository.save(chat);
    }

    @Override
    public Optional<Chat> buscarPorId(Long id) {
        return chatRepository.findById(id);
    }

    @Override
    public Optional<Chat> buscarPorProyecto(Long proyectoId) {
        return chatRepository.findByProyectoId(proyectoId);
    }
}
