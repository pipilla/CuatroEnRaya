package org.iesalandalus.programacion.cuatroenraya.modelo;

import org.iesalandalus.programacion.cuatroenraya.vista.Consola;

import javax.naming.OperationNotSupportedException;
import java.util.Objects;

public class CuatroEnRaya {
    private static final int NUMERO_JUGADORES = 2;
    private Jugador[] jugadores;
    private Tablero tablero;
    public CuatroEnRaya(Jugador jugador1, Jugador jugador2) {
        Objects.requireNonNull(jugador1, "El jugador 1 no puede ser nulo.");
        Objects.requireNonNull(jugador2, "El jugador 2 no puede ser nulo.");
        jugadores = new Jugador[NUMERO_JUGADORES];
        jugadores[0] = jugador1;
        jugadores[1] = jugador2;
        tablero = new Tablero();
    }

    private boolean tirar(Jugador jugador) throws OperationNotSupportedException {
        boolean jugadaGanadora = false;
        boolean jugadaValida = false;
        do {
            try {
                jugadaGanadora = tablero.introducirFicha(Consola.leerColumna(jugador), jugador.colorFichas());
                jugadaValida = true;
            } catch (OperationNotSupportedException e) {
                System.out.println(e.getMessage());
            }
        } while (!jugadaValida);
        System.out.println(tablero);
        return jugadaGanadora;
    }

    public void jugar() throws OperationNotSupportedException {
        int turno = 0;
        Jugador jugadorQueJuega = jugadores[turno];
        boolean hayGanador = false;
        while (!tablero.estaLleno() && !hayGanador) {
            jugadorQueJuega = jugadores[turno++ % NUMERO_JUGADORES];
            hayGanador = tirar(jugadorQueJuega);
        }
        if (hayGanador) {
            System.out.println("El jugador ganador es: " + jugadorQueJuega.nombre());
        } else {
            System.out.println("Ha habido empate.");
        }


    }


}
