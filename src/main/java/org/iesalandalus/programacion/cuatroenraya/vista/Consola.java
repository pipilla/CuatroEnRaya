package org.iesalandalus.programacion.cuatroenraya.vista;

import org.iesalandalus.programacion.cuatroenraya.modelo.Ficha;
import org.iesalandalus.programacion.cuatroenraya.modelo.Jugador;
import org.iesalandalus.programacion.cuatroenraya.modelo.Tablero;
import org.iesalandalus.programacion.utilidades.Entrada;

import java.util.Objects;

import static org.iesalandalus.programacion.cuatroenraya.modelo.Tablero.COLUMNAS;

public class Consola {
    private Consola(){}

    public static String leerNombre(){
        String nombre;
        do {
            System.out.print("Dime el nombre: ");
            nombre = Entrada.cadena();
        } while (nombre.isBlank());
        return nombre;
    }

    public static Ficha elegirColorFichas() {
        int color;
        do {
            System.out.print("Dime el color de la ficha (0. AZUL o 1.VERDE): ");
            color = Entrada.entero();
        } while (color < 0 || color > 1);
        return Ficha.values()[color];
    }

    public static Jugador leerJugador(){
        return new Jugador(leerNombre(), elegirColorFichas());
    }
    public static Jugador leerJugador(Ficha ficha){
        Objects.requireNonNull(ficha, "La ficha no puede ser nula.");
        return new Jugador(leerNombre(), ficha);
    }

    public static int leerColumna(Jugador jugador){
        Objects.requireNonNull(jugador, "El jugador no puede ser nulo.");
        int columna;
        do {
            System.out.printf("%s, elige la columna en la que introducir la ficha (0 - %s): ", jugador, COLUMNAS - 1);
            columna = Entrada.entero();
            if (columna >= COLUMNAS || columna < 0){
                System.out.println("La columna no es válida.");
            }
        } while (columna >= COLUMNAS || columna < 0);
        return columna;
    }
}
