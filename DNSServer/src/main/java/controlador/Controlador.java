package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.Administrador;
import ventana.VentanaMonitor;

public class Controlador implements ActionListener {
	private VentanaMonitor ventana;

	public void actionPerformed(ActionEvent evento) {
		switch(evento.getActionCommand()) {
		   case "AgregarServidor":String ip = ventana.getTextField().getText();
		                          int p1 = Integer.parseInt(ventana.getTextField_1().getText());
		                          int p2 = Integer.parseInt(ventana.getTextField_2().getText());
		                          int p3 = Integer.parseInt(ventana.getTextField_3().getText());
		                          int p4 = Integer.parseInt(ventana.getTextField_4().getText());
		                          String prioridadS = (String)ventana.getComboBox().getSelectedItem();
		                          boolean prioridad = false;
		                          if(prioridadS.compareTo("Primario") == 0)
		                        	  prioridad = true;
		                          Administrador.getInstance().agregarServer(ip, p1, p2, p3, p4, prioridad);
			                      break;
		}
	}

	public void setVentana(VentanaMonitor ventana) {
		this.ventana = ventana;
	}
}
