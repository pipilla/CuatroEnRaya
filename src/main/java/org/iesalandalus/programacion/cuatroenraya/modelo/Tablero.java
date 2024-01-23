package org.iesalandalus.programacion.cuatroenraya.modelo;

import javax.naming.OperationNotSupportedException;
import java.util.Objects;

public class Tablero {
    public static final int FILAS = 6;
    public static final int COLUMNAS = 7;
    public static final int FICHAS_IGUALES_CONSECUTIVAS_NECESARIAS = 4;
    private Casilla[][] casillas;

    public Tablero() {
        casillas = new Casilla[FILAS][COLUMNAS];
        for (int i = 0; i < FILAS; i++){
            for (int j = 0; j < COLUMNAS; j++){
                casillas[i][j] = new Casilla();
            }
        }
    }

    private boolean columnaVacia(int columna){
        return !casillas[0][columna].estaOcupada();
    }

    public boolean estaVacio(){
        boolean vacio = true;
        for (int i = 0; i < COLUMNAS && vacio; i++) {
            vacio = columnaVacia(i);
        }
        return vacio;
    }

    private boolean columnaLlena(int columna){
        return casillas[FILAS - 1][columna].estaOcupada();
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

    public void comprobarColumna(int columna){
        if (columna >= COLUMNAS || columna < 0){
            throw new IllegalArgumentException("Columna incorrecta.");
        }
    }

    private int getPrimeraFilaVacia(int columna) throws OperationNotSupportedException {
        if (columnaLlena(columna)){
            throw new OperationNotSupportedException("Columna llena.");
        }
        int fila = 0;
        while (fila < FILAS && casillas[fila][columna].estaOcupada()) {
            fila++;
        }
        return fila;
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
        int fichasIgualesConsecutivas = 0;
        for (int i = 0; i < FILAS && !objetivoAlcanzado(fichasIgualesConsecutivas); i++){
            if (casillas[i][columna].estaOcupada() && casillas[i][columna].getFicha().equals(ficha)) {
                fichasIgualesConsecutivas++;
            } else {
                fichasIgualesConsecutivas = 0;
            }
        }
        return (objetivoAlcanzado(fichasIgualesConsecutivas));
    }
    private int menor(int fila, int columna){
        return Math.min(fila, columna);
    }

    private boolean comprobarDiagonalNE(int filaSemilla, int columnaSemilla, Ficha ficha) {
        int desplazamiento = menor(filaSemilla, columnaSemilla);
        int filaInicial = filaSemilla - desplazamiento;
        int columnaInicial = columnaSemilla - desplazamiento;
        int contadorFichasIguales = 0;
        for (int fila = filaInicial, columna = columnaInicial; fila < FILAS && columna < COLUMNAS && !objetivoAlcanzado(contadorFichasIguales); fila++, columna++){
            if (casillas[fila][columna].estaOcupada() && casillas[fila][columna].getFicha().equals(ficha)) {
                contadorFichasIguales++;
            } else {
                contadorFichasIguales = 0;
            }
        }
        return (objetivoAlcanzado(contadorFichasIguales));
    }

    private boolean comprobarDiagonalNO(int filaSemilla, int columnaSemilla, Ficha ficha) {
        int desplazamiento = menor(filaSemilla, COLUMNAS - 1 - columnaSemilla);
        int filaInicial = filaSemilla - desplazamiento;
        int columnaInicial = columnaSemilla + desplazamiento;
        int contadorFichasIguales = 0;
        for (int fila = filaInicial, columna = columnaInicial; fila < FILAS && columna >= 0 && !objetivoAlcanzado(contadorFichasIguales); fila++, columna--){
            if (casillas[fila][columna].estaOcupada() && casillas[fila][columna].getFicha().equals(ficha)) {
                contadorFichasIguales++;
            } else {
                contadorFichasIguales = 0;
            }
        }
        return (objetivoAlcanzado(contadorFichasIguales));
    }

    private boolean comprobarTirada(int fila, int columna){
        Ficha ficha = casillas[fila][columna].getFicha();
        return (comprobarHorizontal(fila, ficha) || comprobarVertical(columna, ficha) || comprobarDiagonalNE(fila, columna, ficha) || comprobarDiagonalNO(fila, columna, ficha));
    }

    public boolean introducirFicha(int columna, Ficha ficha) throws OperationNotSupportedException {
        if (estaLleno()) {
            throw new IllegalArgumentException("Tablero lleno.");
        }
        comprobarColumna(columna);
        comprobarFicha(ficha);
        if (columnaLlena(columna)) {
            throw new OperationNotSupportedException("Columna llena.");
        }

        int fila = getPrimeraFilaVacia(columna);
        casillas[fila][columna].setFicha(ficha);
        return comprobarTirada(fila, columna);
    }

    @Override
    public String toString() {
        StringBuilder tablero = new StringBuilder();
        for (int i = FILAS - 1; i >= 0; i--){
            tablero.append("|");
            for (int j = 0; j < COLUMNAS; j++){
                if (casillas[i][j].getFicha() == null) {
                    tablero.append(" ");
                } else {
                    tablero.append(casillas[i][j].getFicha());
                }
            }
            tablero.append("|\n");
        }
        tablero.append(" ");
        tablero.append("-".repeat(COLUMNAS));
        tablero.append("\n");

        return String.format(tablero.toString());
    }
}
