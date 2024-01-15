package org.iesalandalus.programacion.cuatroenraya.modelo;

import java.util.Objects;

public class Casilla {
    private Ficha ficha;
    public Casilla(){
        ficha = null;
    }

    public Ficha getFicha(){
        return ficha;
    }

    public void setFicha(Ficha ficha){
        Objects.requireNonNull(ficha, "La ficha no puede tener un valor nulo.");
        this.ficha = ficha;
    }

    public boolean estaOcupada(){
        return !(ficha == null);
    }

    @Override
    public String toString() {
        String resultado;
        if (this.ficha == null){
            resultado = " ";
        } else if (this.ficha == Ficha.AZUL) {
            resultado = "V";
        } else {
            resultado = "A";
        }
        return String.format("%s", resultado);
    }
}
