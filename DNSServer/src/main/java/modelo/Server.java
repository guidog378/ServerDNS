package modelo;

public class Server {
    private String ipServer;
    private int puertoServer,puertoServerEmpleado,puertoServerMonitor,puertoServerTotem;
    private boolean isPrimario;
    private boolean isFuncional;
     
    
	public Server(String ipServer, int puertoServer, int puertoServerEmpleado, int puertoServerMonitor,
			int puertoServerTotem, boolean isPrimario) {
		super();
		this.ipServer = ipServer;
		this.puertoServer = puertoServer;
		this.puertoServerEmpleado = puertoServerEmpleado;
		this.puertoServerMonitor = puertoServerMonitor;
		this.puertoServerTotem = puertoServerTotem;
		this.isPrimario = isPrimario;
	}
	
	public int getPuertoServerEmpleado() {
		return puertoServerEmpleado;
	}
	public void setPuertoServerEmpleado(int puertoServerEmpleado) {
		this.puertoServerEmpleado = puertoServerEmpleado;
	}
	public int getPuertoServerMonitor() {
		return puertoServerMonitor;
	}
	public void setPuertoServerMonitor(int puertoServerMonitor) {
		this.puertoServerMonitor = puertoServerMonitor;
	}
	public int getPuertoServerTotem() {
		return puertoServerTotem;
	}
	public void setPuertoServerTotem(int puertoServerTotem) {
		this.puertoServerTotem = puertoServerTotem;
	}
	public boolean isFuncional() {
		return isFuncional;
	}
	public void setFuncional(boolean isFuncional) {
		this.isFuncional = isFuncional;
	}
	public boolean isPrimario() {
		return isPrimario;
	}
	public void setPrimario(boolean isPrimario) {
		this.isPrimario = isPrimario;
	}
	public String getIpServer() {
		return ipServer;
	}
	public void setIpServer(String ipServer) {
		this.ipServer = ipServer;
	}
	public int getPuertoServer() {
		return puertoServer;
	}
	public void setPuertoServer(int puertoServer) {
		this.puertoServer = puertoServer;
	}
}
