package org.iesalandalus.programacion.cuatroenraya.modelo;

import org.iesalandalus.programacion.cuatroenraya.vista.Consola;

import javax.naming.OperationNotSupportedException;
import java.util.Objects;

public class CuatroEnRaya {
    private static final int NUMERO_JUGADORES = 2;
    private Jugador[] jugador;
    private Tablero tablero;
    public CuatroEnRaya(Jugador jugador1, Jugador jugador2) {
        Objects.requireNonNull(jugador1, "El jugador 1 no puede ser nulo.");
        Objects.requireNonNull(jugador2, "El jugador 2 no puede ser nulo.");
        jugador = new Jugador[NUMERO_JUGADORES];
        jugador[0] = jugador1;
        jugador[1] = jugador2;
        tablero = new Tablero();
    }

    private boolean tirar(Jugador jugador) throws OperationNotSupportedException {
        boolean tirada = false;
        do {
            try {
                tirada = tablero.introducirFicha(Consola.leerColumna(jugador), jugador.colorFichas());
            } catch (IllegalArgumentException e) {
                System.out.println(e);
            }
        } while (!tirada);

        return tirada;
    }

    public void jugar() throws OperationNotSupportedException {
        boolean partidaFinalizada = false;
        int jugadorGanador = 1;
        for (int i = 0; !partidaFinalizada; i++) {
            partidaFinalizada = tirar(jugador[i]);
            jugadorGanador = i;
        }
        System.out.println("El jugador ganador es: " + jugador[jugadorGanador]);

    }


}