package org.iesalandalus.programacion.cuatroenraya;

import org.iesalandalus.programacion.cuatroenraya.modelo.CuatroEnRaya;
import org.iesalandalus.programacion.cuatroenraya.modelo.Ficha;
import org.iesalandalus.programacion.cuatroenraya.vista.Consola;

import javax.naming.OperationNotSupportedException;

public class MainApp {
	
	public static void main(String[] args) throws OperationNotSupportedException {

		CuatroEnRaya cuatroEnRaya = new CuatroEnRaya(Consola.leerJugador(), Consola.leerJugador(Ficha.VERDE));
		cuatroEnRaya.jugar();
	}
	
}
