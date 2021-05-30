package comunicacion;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import modelo.Administrador;
import modelo.Server;
import modeloInfo.InfoServerFuncional;
import modeloInfo.Informable;

public class ReceptorClientes implements Runnable {

	@Override
	public void run() {
	     try {
			ServerSocket sv = new ServerSocket(9180);
			Server server = null;
			ObjectOutputStream oos;
			ObjectInputStream ois;
			while(true) {
				Socket socket = sv.accept();
				ois = new ObjectInputStream(socket.getInputStream());
				Informable solicitud = (Informable)ois.readObject();
                server = Administrador.getInstance().buscaServerPrimario();
				if(server == null)
					  server = Administrador.getInstance().buscaServerSecundario();
				InfoServerFuncional info = new InfoServerFuncional();
				info.setIpServer(server.getIpServer());
				switch(solicitud.getIdOperacion()) {
				    case 1:info.setPuertoServer(server.getPuertoServerEmpleado());
				           break;
				    case 2:info.setPuertoServer(server.getPuertoServerMonitor());
				           break;
				    case 3:info.setPuertoServer(server.getPuertoServerTotem());
				           break;
				}
				oos = new ObjectOutputStream(socket.getOutputStream());
				oos.writeObject(info);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
