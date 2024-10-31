package com.pizzaria.rafa.data.response;

import java.util.Objects;

public class ErroResponse {
    public String codigo;
    public String mensagem;

    public ErroResponse(String codigo, String mensagem) {
        this.codigo = Objects.requireNonNull(codigo);
        this.mensagem = Objects.requireNonNull(mensagem);
    }

    public String getCodigo() {
        return codigo;
    }

    public String getMensagem() {
        return mensagem;
    }
}
