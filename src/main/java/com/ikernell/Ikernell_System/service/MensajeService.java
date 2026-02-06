package com.ikernell.Ikernell_System.service;

import com.ikernell.Ikernell_System.entity.Mensaje;

import java.util.List;

public interface MensajeService {

    Mensaje enviarMensaje(Mensaje mensaje);

    List<Mensaje> listarPorChat(Long chatId);

    List<Mensaje> listarPorUsuario(Long usuarioId);
}
