package modelo;

public class Server {
    private String ipServer;
    private int puertoServer;
    private boolean isPrimario;
    private boolean isFuncional;
     
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
