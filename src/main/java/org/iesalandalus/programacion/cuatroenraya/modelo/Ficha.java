package org.iesalandalus.programacion.cuatroenraya.modelo;

public enum Ficha {
    AZUL('A'),
    VERDE('V');

    private final char letraFicha;

    Ficha(char letraFicha) {
        this.letraFicha = letraFicha;
    }

    @Override
    public String toString() {
        return String.format("%s", this.letraFicha);
    }
}
