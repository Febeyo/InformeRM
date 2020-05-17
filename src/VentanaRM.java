
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import java.awt.Font;

@SuppressWarnings("serial")
public class VentanaRM extends JFrame {


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaRM frame = new VentanaRM();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaRM() {
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 11));
		setIconImage(Toolkit.getDefaultToolkit().getImage("Imagen/Icononuevo.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(10, 10, 1024, 800);
	}

}

