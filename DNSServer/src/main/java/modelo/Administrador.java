package modelo;

import java.util.ArrayList;
import java.util.Iterator;

public class Administrador {
      private static Administrador administrador = null;
      private ArrayList<Server> servers;
      
      private Administrador() {
    	  this.servers = new ArrayList<Server>();
      }
      
      public void agregarServer(String ip,int p1,int p2,int p3,int p4, boolean primario) {
    	  this.servers.add(new Server(ip,p1,p2,p3,p4,primario));
    	  System.out.println("Agregue un sv.");
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
      
      public ArrayList<Server> getServers() {
		return servers;
	  }

	  public static Administrador getInstance() {
    	  if(Administrador.administrador == null)
    		  Administrador.administrador = new Administrador();
    	  return Administrador.administrador;
      }
}
