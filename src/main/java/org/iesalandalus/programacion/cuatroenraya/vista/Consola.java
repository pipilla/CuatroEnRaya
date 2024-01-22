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
        System.out.print("Dime el nombre: ");
        return Entrada.cadena();
    }

    public static Ficha elegirColorFichas() {
        String color;
        do {
            System.out.print("Dime el color de la ficha (AZUL o VERDE): ");
            color = Entrada.cadena();
        } while (!("AZUL".equals(color) || "VERDE".equals(color)));
        return Ficha.valueOf(color);
    }

    public static Jugador leerJugador(){
        return new Jugador(leerNombre(), elegirColorFichas());
    }
    public static Jugador leerJugador(Ficha ficha){
        return new Jugador(leerNombre(), ficha);
    }

    public static int leerColumna(Jugador jugador){
        int columna;
        do {
            System.out.print(jugador + " elige la columna en la que introducir la ficha: ");
            columna = Entrada.entero();
            if (columna >= COLUMNAS || columna < 0){
                System.out.println("La columna no es válida.");
            }
        } while (columna >= COLUMNAS || columna < 0);
        return columna;
    }
}
