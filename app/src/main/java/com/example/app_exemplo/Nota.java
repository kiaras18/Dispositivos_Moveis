package com.example.app_exemplo;

import androidx.annotation.NonNull;

public class Nota {
    private final int id;
    private final String titulo;
    private final String texto;

    public Nota(int id, String titulo, String texto) {
        this.id = id;
        this.titulo = titulo;
        this.texto = texto;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getTexto() {
        return texto;
    }

    @NonNull
    @Override
    public String toString() {
        return titulo + "\n" + texto;
    }
}
