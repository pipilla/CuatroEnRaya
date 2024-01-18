package org.iesalandalus.programacion.cuatroenraya.modelo;

import javax.naming.OperationNotSupportedException;
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
        return casillas[FILAS][columna] == null;
    }

    public boolean estaVacio(){
        boolean vacio = true;
        for (int i = 0; i < COLUMNAS && vacio; i++) {
            vacio = columnaVacia(i);
        }
        return vacio;
    }

    private boolean columnaLlena(int columna){
        return casillas[0][columna] != null;
    }

    public boolean estaLleno(){
        boolean lleno = true;
        for (int i = 0; i < COLUMNAS && lleno; i++) {
            lleno = columnaLlena(i);
        }
        return lleno;
    }

    private void comprobarFicha(Ficha ficha){
        Objects.requireNonNull(ficha, "La ficha no puede ser nula.");
    }

    private void comprobarColumna(int columna){
        if (columna > COLUMNAS || columna < 0){
            throw new IllegalArgumentException("La columna indicada no existe");
        }
    }

    private int getPrimeraFilaVacia(int columna) throws OperationNotSupportedException {
        if (columnaLlena(columna)){
            throw new OperationNotSupportedException("La columna está llena");
        }
        int nFila = -1;
        for (int i = 0; i < FILAS; i++){
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
        int contadorFichasIguales = 0;
        for (int i = 0; i < COLUMNAS && !objetivoAlcanzado(contadorFichasIguales); i++){
            if (casillas[fila][i].estaOcupada() && casillas[fila][i].getFicha().equals(ficha)) {
                contadorFichasIguales++;
            } else {
                contadorFichasIguales = 0;
            }
        }
        return (objetivoAlcanzado(contadorFichasIguales));
    }

    private boolean comprobarVertical(int columna, Ficha ficha){
        int contadorFichasIguales = 0;
        for (int i = 0; i < FILAS && !objetivoAlcanzado(contadorFichasIguales); i++){
            if (casillas[i][columna].estaOcupada() && casillas[i][columna].getFicha().equals(ficha)) {
                contadorFichasIguales++;
            } else {
                contadorFichasIguales = 0;
            }
        }
        return (objetivoAlcanzado(contadorFichasIguales));
    }
    private int menor(int fila, int columna){
        return Math.min(fila, columna);
    }

    private boolean comprobarDiagonalNE(int filaSemilla, int columnaSemilla, Ficha ficha) {
        int desplazamiento = menor(filaSemilla, columnaSemilla);
        for (){

        }
    }

}
