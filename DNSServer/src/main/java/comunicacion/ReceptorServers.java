package comunicacion;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;

import modelo.Administrador;
import modelo.Server;
import modeloInfo.InfoConsultaFuncionalidad;
import modeloInfo.InfoServer;

public class ReceptorServers implements Runnable {

	@Override
	public void run() {
		ArrayList<Server> servers;
		Server actual;
		Socket socket;
		Long milisegundos1 = (long) 0,milisegundos2 = (long) 0;
		ObjectOutputStream oos;
		ObjectInputStream ois;
		while(true) {
			servers = Administrador.getInstance().getServers();
			Iterator<Server> it = servers.iterator();
			while(it.hasNext()) {
				actual = it.next();
				try {
					socket = new Socket();
					socket.connect(new InetSocketAddress(actual.getIpServer(),actual.getPuertoServer()), 300);
					socket.setSoTimeout(300);
					if(socket.isConnected()) {
						oos = new ObjectOutputStream(socket.getOutputStream());
						oos.writeObject(new InfoConsultaFuncionalidad());
						ois = new ObjectInputStream(socket.getInputStream());
						InfoServer infoFuncional = (InfoServer) ois.readObject();
						milisegundos2 = System.currentTimeMillis();
						if((milisegundos2 - milisegundos1) < socket.getSoTimeout())
						    actual.setFuncional(true);
						else
							actual.setFuncional(false);
					}else {
						actual.setFuncional(false);
					}
					socket.close();
				} catch (UnknownHostException e) {
					actual.setFuncional(false);
				} catch (IOException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
