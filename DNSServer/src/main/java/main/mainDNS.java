package main;

import comunicacion.ReceptorClientes;
import comunicacion.ReceptorServers;
import modelo.Administrador;

public class mainDNS {

	public static void main(String[] args) {
		Administrador.getInstance();
		Thread t1 = new Thread(new ReceptorClientes());
		Thread t2 = new Thread(new ReceptorServers());
		t1.start();
		t2.start();
	}

}
