package modelo;

import java.util.ArrayList;
import java.util.Iterator;

public class Administrador {
      private static Administrador administrador = null;
      private ArrayList<Server> servers;
      private boolean ocupado;
      
      private Administrador() {
    	  this.servers = new ArrayList<Server>();
    	  this.servers.add(new Server("localhost",9090,9696,9797,9595,true));
    	  this.servers.add(new Server("localhost",9191,8686,8787,8585,false));
      }
      
      public Server buscaServerPrimario() {
    	  Server primario = null;
    	  Server actual = null;
    	  Iterator<Server> it = this.servers.iterator();
    	  while(it.hasNext() && primario == null) {
    		  actual = it.next();
    		  if(actual.isPrimario() && actual.isFuncional())
    			  primario = actual;
    	  }
    	  return primario;
      }
      
      public Server buscaServerSecundario() {
    	  Server secundario = null;
    	  Server actual = null;
    	  Iterator<Server> it = this.servers.iterator();
    	  while(it.hasNext() && secundario == null) {
    		  actual = it.next();
    		  if(!actual.isPrimario() && actual.isFuncional())
    			  secundario = actual;
    	  }
    	  return secundario;
      }
      
      public synchronized ArrayList<Server> getServers() {
		  return servers;
	  }

	  public static Administrador getInstance() {
    	  if(Administrador.administrador == null)
    		  Administrador.administrador = new Administrador();
    	  return Administrador.administrador;
      }
}
