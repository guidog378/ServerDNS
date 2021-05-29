package comunicacion;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import modelo.Administrador;
import modelo.Server;
import modeloInfo.InfoServer;
import modeloInfo.InfoServerFuncional;

public class ReceptorClientes implements Runnable {

	@Override
	public void run() {
	     try {
			ServerSocket sv = new ServerSocket(9090);
			Server server = null;
			ObjectOutputStream oos;
			ObjectInputStream ois;
			while(true) {
				Socket socket = sv.accept();
				ois = new ObjectInputStream(socket.getInputStream());
				InfoServer solicitud = (InfoServer)ois.readObject();
				switch(solicitud.getIdOperacion()) {
				   case 1:server = Administrador.getInstance().buscaServerPrimario();
				       if(server == null)
					       server = Administrador.getInstance().buscaServerSecundario();
				       InfoServerFuncional info = new InfoServerFuncional();
				       info.setIpServer(server.getIpServer());
				       info.setPuertoServer(server.getPuertoServer());
				       oos = new ObjectOutputStream(socket.getOutputStream());
				       oos.writeObject(info);
				       break;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
