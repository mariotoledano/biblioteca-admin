package com.mariots.biblioteca.bibliotecaadmin.api.enums;

public enum EnumLongitud {
    BREVE("breve"),LARGO("largo");

    String valor;

    private EnumLongitud(String valor){
        this.valor= valor;
    }

    public String getValor() {
        return valor;
    }

}
