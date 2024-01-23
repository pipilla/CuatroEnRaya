package org.iesalandalus.programacion.cuatroenraya;

import org.iesalandalus.programacion.cuatroenraya.modelo.CuatroEnRaya;
import org.iesalandalus.programacion.cuatroenraya.modelo.Ficha;
import org.iesalandalus.programacion.cuatroenraya.modelo.Jugador;
import org.iesalandalus.programacion.cuatroenraya.vista.Consola;

import javax.naming.OperationNotSupportedException;

public class MainApp {
	
	public static void main(String[] args) throws OperationNotSupportedException {
		Jugador jugador1 = Consola.leerJugador();
		Jugador jugador2 = Consola.leerJugador(jugador1.colorFichas() == Ficha.AZUL ? Ficha.VERDE : Ficha.AZUL);
		CuatroEnRaya cuatroEnRaya = new CuatroEnRaya(jugador1, jugador2);
		cuatroEnRaya.jugar();
	}
	
}
