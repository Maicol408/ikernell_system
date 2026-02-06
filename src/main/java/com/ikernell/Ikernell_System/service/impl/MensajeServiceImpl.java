package com.ikernell.Ikernell_System.service.impl;

import com.ikernell.Ikernell_System.entity.Mensaje;
import com.ikernell.Ikernell_System.repository.MensajeRepository;
import com.ikernell.Ikernell_System.service.MensajeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MensajeServiceImpl implements MensajeService {

    private final MensajeRepository mensajeRepository;

    public MensajeServiceImpl(MensajeRepository mensajeRepository) {
        this.mensajeRepository = mensajeRepository;
    }

    @Override
    public Mensaje enviarMensaje(Mensaje mensaje) {
        return mensajeRepository.save(mensaje);
    }

    @Override
    public List<Mensaje> listarPorChat(Long chatId) {
        return mensajeRepository
                .findByChatIdOrderByFechaEnvioAsc(chatId);
    }

    @Override
    public List<Mensaje> listarPorUsuario(Long usuarioId) {
        return mensajeRepository.findByRemitenteId(usuarioId);
    }
}
