import java.awt.Font;

import javax.swing.JTabbedPane;

@SuppressWarnings("serial")
public class InicioRM  extends VentanaRM{
	public Filiacion p1;
	

	public InicioRM() {
		// TODO Auto-generated constructor stub
		setTitle("RM CARDIACA");
		JTabbedPane parte = new JTabbedPane(); 
		parte.setFont(new Font("Arial Black", Font.PLAIN, 15));
		p1 = new Filiacion(); parte.addTab("CARDIORM", p1);
		
		getContentPane().add(parte);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InicioRM uno = new InicioRM();
		uno.setBounds(10,20, 1100,700);
		uno.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		uno.setVisible(true);
		uno.setResizable(true);
	}

}
