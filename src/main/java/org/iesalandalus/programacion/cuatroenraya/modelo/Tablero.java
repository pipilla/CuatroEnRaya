package org.iesalandalus.programacion.cuatroenraya.modelo;

import java.util.Objects;

public class Tablero {
    public static final int FILAS = 6;
    public static final int COLUMNAS = 7;
    public static final int FICHAS_IGUALES_CONSECUTIVAS_NECESARIAS = 4;
    private Casilla[][] casillas;

    public Tablero(){
        casillas = new Casilla[FILAS][COLUMNAS];
    }

    private boolean columnaVacia(int columna){
        return casillas[0][columna] == null;
    }

    public boolean estaVacio(){
        boolean vacio = true;
        for (int i = 0; i < COLUMNAS; i++) {
            if (columnaVacia(i)){
                vacio = false;
                break;
            }
        }
        return vacio;
    }

    private boolean columnaLlena(int columna){
        return casillas[0][columna] != null;
    }

    public boolean estaLleno(){

    }

    private void comprobarFicha(Ficha ficha){
        Objects.requireNonNull(ficha, "La ficha no puede ser nula.");
    }

    private void comprobarColumna(int columna){
        if (columna > COLUMNAS || columna < 0){
            throw new IllegalArgumentException("La columna indicada no existe");
        }
    }

    private int getPrimeraFilaVacia(int columna){
        int nFila = -1;
        for (int i = 0; i < casillas.length; i++){
            if (casillas[i][columna] == null){
                nFila = i;
                break;
            }
        }
        return nFila;
    }

    private boolean objetivoAlcanzado(int fichasIgualesConsecutivas){
        return fichasIgualesConsecutivas >= FICHAS_IGUALES_CONSECUTIVAS_NECESARIAS;
    }

    private boolean comprobarHorizontal(int fila, Ficha ficha){
        int ContadorFichasIguales = 0;
        for (int i = 0; i < casillas.length; i++){
            ContadorFichasIguales = 0;
            for (int j = 0; j < casillas[i].length; j++){
                if (casillas[j][i].getFicha() == ficha){
                    ContadorFichasIguales++;
                    if (ContadorFichasIguales >= FICHAS_IGUALES_CONSECUTIVAS_NECESARIAS){
                        break;
                    }
                } else {
                    ContadorFichasIguales = 0;
                }
            }
        }
        return (ContadorFichasIguales >= FICHAS_IGUALES_CONSECUTIVAS_NECESARIAS);
    }

    private boolean comprobarVertical(int fila, Ficha ficha){
        int ContadorFichasIguales = 0;
        for (int i = 0; i < casillas.length; i++){
            ContadorFichasIguales = 0;
            for (int j = 0; j < casillas[i].length; j++){
                if (casillas[i][j].getFicha() == ficha){
                    ContadorFichasIguales++;
                    if (ContadorFichasIguales >= FICHAS_IGUALES_CONSECUTIVAS_NECESARIAS){
                        break;
                    }
                } else {
                    ContadorFichasIguales = 0;
                }
            }
        }
        return (ContadorFichasIguales >= FICHAS_IGUALES_CONSECUTIVAS_NECESARIAS);
    }




}
