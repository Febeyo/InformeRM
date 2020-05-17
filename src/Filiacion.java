import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

@SuppressWarnings("serial")
public class Filiacion extends JPanel implements ChangeListener, ActionListener{
	private JLabel et1,et2, etiq3;
	private JTextField f1,f2, f3,t1,t3;
	private JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8,tf9, tf10, tf11,tf12,tf13,tf14,tf15;
	private JTextField tm1,tm2,tm3,tm4,tm5,tm6,tm7,tm8,tm9, tm10, tm11,tm12,tm13,tm14,tm15, tm16;
	private String a, tabique, im, it, vd, vi, tvi, arco; 
	private JButton calc;
	private int lim1, lim2;
	private JCheckBox ca1, ca2, ca3; 
	private ButtonGroup g1,g2, g3, g4, g5;
	private JRadioButton r1, r2, cb4, cb5, cb6, cb7, cb1, cb2, cb3, r3, r4;
	private double indice, superficie;
	public static double b, m, g;
	public static double total;
	public static String temporal, diastotal, diasestab, edad1 ;
	public static String edad2;
	private String[] fechaacc, fechanac; 
	private JScrollPane barra;
	private Border bor1, bor2, bor3;
	private JPanel pp1, pp2, pp3;

	public Filiacion() {
		// TODO Auto-generated constructor stub
		setLayout(new GridLayout(0,1,0,0));
		//JDOM libreria para genera html desde codigo
		
		JPanel todo =ESwing.panelVertical(); 
		add(todo); 
		barra= new JScrollPane();
		add(barra);
		barra.setViewportView(todo);
		Font titulo= new Font("Tahona",Font.BOLD, 18);
		
		pp1=ESwing.panelBorde(ESwing.panelVertical(), "DATOS DE FILIACION", titulo, bor1);
		todo.add(pp1); 		

		JPanel pa2= ESwing.pLeft(pp1, 20, 10);
		ESwing.nuevosLabel("Numero de historia clinica", pa2);
		f3=ESwing.nuevosTF(10, pa2);
		ESwing.nuevosLabel("Fecha de estudio (DD/MM/AAAA):", pa2); 		
		f1= ESwing.nuevosTF(12, pa2);
		
		JPanel pa1= ESwing.pLeft(pp1, 20, 10);		
		g1= new ButtonGroup();  		
		ESwing.nuevosLabel("Sexo:",pa1); 
		r1=ESwing.nuevoRB(g1, "Femenino", pa1, this);
		r2=ESwing.nuevoRB(g1, "Masculino", pa1, this);
		ESwing.nuevosLabel("Fecha de nacimiento (DD/MM/AAAA):",pa1);
		f2= ESwing.nuevosTF(12, pa1);
		ESwing.nuevosLabel("Peso (Kg)",pa1); 			
		t1 = ESwing.nuevosTF(3, pa1);		
		ESwing.nuevosLabel("Altura (cm)",pa1);		
		t3 = ESwing.nuevosTF(3, pa1);	
		
		
		JPanel pa8= ESwing.pLeft(pp1, 20, 10);
		ESwing.nuevosLabel("Edad del paciente",pa8); 		
		et1= ESwing.nuevosLabel("",pa8); 
		ESwing.nuevosLabel("IMC (Indice de masa corporal)",pa8); 		
		et2= ESwing.nuevosLabel("",pa8);		
		ESwing.nuevosLabel("Superficie corporal total (SCT)",pa8); 	
		etiq3= ESwing.nuevosLabel("",pa8);

		
		pp2=ESwing.panelBorde(ESwing.panelVertical(), "VALORES FUNCIONALES", titulo, bor2);		
		todo.add(pp2); 		
		
		JPanel l1= ESwing.pLeft(pp2, 20, 10);
		
		ESwing.nuevosLabel("Flujo aortico:", l1); 
		ESwing.nuevosLabel("Volumen latido (ml)",l1); 
		tf1=ESwing.nuevosTF(5, l1);
		ESwing.nuevosLabel("% Insuficiencia aortica",l1); 
		tf2=ESwing.nuevosTF(5, l1);
		ESwing.nuevosLabel("Velocidad maxima (m/s)",l1); 
		tf3=ESwing.nuevosTF(5, l1);
		
		JPanel l2=ESwing.pLeft(pp2, 20, 10);
		ESwing.nuevosLabel("Flujo pulmonar:",l2); 
		ESwing.nuevosLabel("Volumen latido (ml)",l2);
		tf4=ESwing.nuevosTF(5, l2);
		ESwing.nuevosLabel("% Insuficiencia aortica",l2); 
		tf5=ESwing.nuevosTF(5, l2);
		ESwing.nuevosLabel("Velocidad maxima (m/s)",l2); 
		tf6=ESwing.nuevosTF(5, l2);
		
		JPanel l3= ESwing.pLeft(pp2, 20, 10);
		ESwing.nuevosLabel("Ventriculo izquierdo:",l3);
		ESwing.nuevosLabel("Fraccion de eyeccion(%)",l3); 
		tf7=ESwing.nuevosTF(5, l3);
		ESwing.nuevosLabel("Volumen telediastolico (ml)",l3);
		tf8=ESwing.nuevosTF(5, l3);
		a= "\u00B2"; 
		ESwing.nuevosLabel("Volumen telediastolico indexado (ml/m"+a+")",l3); 
		tf9=ESwing.nuevosTF(5, l3);
		
		JPanel l4= ESwing.pLeft(pp2, 20, 10);
		JLabel t4= ESwing.nuevosLabel("Ventriculo derecho:",l4); l4.add(t4);
		ESwing.nuevosLabel("Fraccion de eyeccion(%)",l4); 
		tf10=ESwing.nuevosTF(5, l4);
		ESwing.nuevosLabel("Volumen telediastolico (ml)",l4); 
		tf11=ESwing.nuevosTF(5, l4);
		ESwing.nuevosLabel("Volumen telediastolico indexado (ml/m"+a+")",l4); 
		tf12=ESwing.nuevosTF(5, l4);
		
		JPanel l5= ESwing.pLeft(pp2, 20, 10);
		ESwing.nuevosLabel("Rama pulmonar",l5); 
		ESwing.nuevosLabel("Derecha: Volumen latido (ml)",l5); 
		tf13=ESwing.nuevosTF(5, l5);
		ESwing.nuevosLabel("Izquierda: Volumen latido (ml)",l5); 
		tf14=ESwing.nuevosTF(5, l5);
		
		JPanel l6= ESwing.pLeft(pp2, 20, 10);
		ESwing.nuevosLabel("Qp/Qs:",l6); 
		tf15=ESwing.nuevosTF(5, l6);
		
		
		pp3= ESwing.panelBorde(ESwing.panelVertical(), "VALORES MORFOLOGICOS", titulo, bor3);	
		pp3.setBorder(bor3);

		
		JPanel ll1= ESwing.pLeft(pp3, 20, 10);
		ESwing.nuevosLabel("Auricula derecha:",ll1); 
		ESwing.nuevosLabel("Diametro mayor (cm):",ll1);	
		tm1=ESwing.nuevosTF(5, ll1);
		ESwing.nuevosLabel("area(cm"+a+")",ll1);
		tm2=ESwing.nuevosTF(5, ll1);
		
		ESwing.nuevosLabel("Auricula izquierda:",ll1); 
		ESwing.nuevosLabel("Diametro mayor (cm):",ll1);
		tm3=ESwing.nuevosTF(5, ll1);
		ESwing.nuevosLabel("area(cm"+a+")",ll1);
		tm4=ESwing.nuevosTF(5, ll1);
		
		
		JPanel ll2= ESwing.pLeft(pp3, 20, 10);
		g2= new ButtonGroup(); 
		g3= new ButtonGroup();
		ESwing.nuevosLabel("Insuficiencia mitral:",ll2); 
		cb4= ESwing.nuevoRB(g2, "Si", ll2, this);
		cb5= ESwing.nuevoRB(g2, "No", ll2, this);
		ESwing.nuevosLabel("Insuficiencia tricuspidea:",ll2);
		cb6=ESwing.nuevoRB(g3, "Si", ll2, this);
		cb7=ESwing.nuevoRB(g3, "No", ll2, this);
		
		g4= new ButtonGroup(); 
		ESwing.nuevosLabel("Tabique interauricular:",ll2); 
		cb1= ESwing.nuevoRB(g4,"Engrosado", ll2, this); 
		cb2= ESwing.nuevoRB(g4,"Normal",ll2, this); 
		cb3= ESwing.nuevoRB(g4,"Adelgazado", ll2, this);		
		
		JPanel ll3= ESwing.pLeft(pp3, 20, 10);
		ca1= ESwing.nuevoCB("Ventriculo izquierdo dilatado", ll3, this);
		ca2= ESwing.nuevoCB("Ventriculo derecho dilatado", ll3, this); 
		ca3= ESwing.nuevoCB("Tracto salida ventriculo izquierdo dilatado",ll3, this); 
		
		JPanel ll4= ESwing.pLeft(pp3, 20, 10);		
		ESwing.nuevosLabel("Tronco A. pulmonar:", ll4);
		tm5= ESwing.nuevosTF(5,ll4);
		JPanel ll5= ESwing.pLeft(ll4, 5, 0);
		ESwing.nuevosLabel("mm; ", ll5); 
		tm6= ESwing.nuevosTF(5,ll5); 
		ESwing.nuevosLabel("Z-score",ll5);
		
		ESwing.nuevosLabel ("Rama pulmonar derecha:",ll4); 
		JPanel ll6= ESwing.pLeft(ll4, 5, 0);
		tm7= ESwing.nuevosTF(5,ll6);
		ESwing.nuevosLabel("mm; ",ll6); 
		tm8= ESwing.nuevosTF(5,ll6); 
		ESwing.nuevosLabel("Z-score",ll6); 		
		
		
		ESwing.nuevosLabel ("Rama pulmonar izquierda:",ll4); 
		JPanel ll7= ESwing.pLeft(ll4, 5, 0);
		tm9= ESwing.nuevosTF(5,ll7);
		ESwing.nuevosLabel("mm; ",ll7); 
		tm10= ESwing.nuevosTF(5,ll7); 
		ESwing.nuevosLabel("Z-score",ll7); 	

		JPanel ll8= ESwing.pLeft(pp3, 20, 10);
		ESwing.nuevosLabel("Aorta a nivel senos de Valsalva",ll8); 
		JPanel ll9= ESwing.pLeft(ll8, 5, 0); 
		tm11= ESwing.nuevosTF(5,ll9);
		ESwing.nuevosLabel("mm; ",ll9); 
		tm12= ESwing.nuevosTF(5,ll9); 
		ESwing.nuevosLabel("Z-score",ll9);
		
		ESwing.nuevosLabel("Aorta ascendente",ll8);
		JPanel ll10= ESwing.pLeft(ll8, 5, 0); 
		tm13= ESwing.nuevosTF(5,ll10);
		ESwing.nuevosLabel("mm; ",ll10); 
		tm14= ESwing.nuevosTF(5,ll10); 
		ESwing.nuevosLabel("Z-score",ll10);

		ESwing.nuevosLabel("Arco aortico",ll8);
		g5= new ButtonGroup(); 
		r3= ESwing.nuevoRB(g5,"Izquierdo",ll8, this); 
		r4= ESwing.nuevoRB(g5, "Derecho", ll8, this);
		
		
		JPanel ll11= ESwing.pLeft(pp3, 20, 10);
		ESwing.nuevosLabel("Troncos supraorticos:",ll11);
		ESwing.nuevosLabel ("Derecho (mm):", ll11);
		tm15= ESwing.nuevosTF(5,ll11);
		ESwing.nuevosLabel ("Izquierdo (mm):",ll11);
		tm16= ESwing.nuevosTF(5,ll11);
		
		
		JPanel pa7= ESwing.pCentro(todo, 20, 20);	
		calc = new JButton("Generar informe"); 		
		pa7.add(calc); 		
		calc.addActionListener(this);
		
		
	}

	public String calcedad1(String[] a, String[] b) {
		LocalDate fecha1 = LocalDate.of(Integer.valueOf(a[2]),Integer.valueOf(a[1]),Integer.valueOf(a[0]));
		LocalDate fecha2 = LocalDate.of(Integer.valueOf(b[2]),Integer.valueOf(b[1]),Integer.valueOf(b[0]));
			long eini = ChronoUnit.YEARS.between(fecha1, fecha2);
			edad1=String.valueOf(eini);
			return edad1;
	}

		public String mesedad (String[] a, String[] b) {
			LocalDate fecha1 = LocalDate.of(Integer.valueOf(a[2]),Integer.valueOf(a[1]),Integer.valueOf(a[0]));
			LocalDate fecha2 = LocalDate.of(Integer.valueOf(b[2]),Integer.valueOf(b[1]),Integer.valueOf(b[0]));
			long efin = ChronoUnit.MONTHS.between(fecha1, fecha2);
			edad2=String.valueOf(efin);
			return edad2;
		}
	public Double imc() {
		double a= Double.valueOf(t1.getText().toString());
		double b = Double.valueOf(t3.getText().toString());
		indice= a/((b/100)*(b/100));
		System.out.print(String.valueOf(indice));
		return indice;
	}
	public Double sup() {
		double a= Double.valueOf(t1.getText().toString());
		double b = Double.valueOf(t3.getText().toString());
		superficie= 0.024265*Math.pow(a,0.3964)*Math.pow(b,0.5378);
		return superficie; 
		
	}
		@Override
		public void stateChanged(ChangeEvent arg0) {
			// TODO Auto-generated method stub
			if(cb1.isSelected()) {tabique="engrosado";}
			if(cb2.isSelected()) {tabique="normal";}
			if(cb3.isSelected()) {tabique="adelgazado";}
			if(cb4.isSelected()) {im="Existe insuficiencia mitral.";}
			if(cb5.isSelected()) {im="No insuficiencia mitral.";}
			if(cb6.isSelected()) {it="Existe insuficiencia tricuspidea.";}
			if(cb7.isSelected()) {it="No insuficiencia tricuspidea.";}
			if(ca1.isSelected()) {vd="Ventriculo derecho dilatado. ";}
			if(ca1.isSelected()==false) {vd="Ventriculo derecho dilatado. ";}
			if(ca2.isSelected()) {vi="Ventriculo izquierdo dilatado. ";}
			if(ca2.isSelected()==false) {vi="Ventriculo izquierdo no dilatado. ";}
			if(ca3.isSelected()) {tvi="Tracto salida ventriculo izquierdo dilatado. ";}
			if(ca3.isSelected()==false) {tvi="Tracto salida ventriculo izquierdo no dilatado. ";}
			if(r3.isSelected()) {arco="izquierdo";}
			if(r4.isSelected()) {arco="derecho";}
		}
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			if(arg0.getSource()==calc){
				try{
				fechaacc = f1.getText().toString().split("/");
				fechanac = f2.getText().toString().split("/");
				if(Integer.valueOf(calcedad1(fechanac, fechaacc))<1) {
					et1.setText(mesedad(fechanac, fechaacc));
				}else {
				et1.setText(calcedad1(fechanac, fechaacc));}
				et2.setText(String.format("%.2f", imc()));
				etiq3.setText(String.format("%.2f",sup()));
				
			}catch(Exception error){

			}}
			lim1= Integer.valueOf(tf2.getText().toString());
			String limite1="Insuficiencia aortica "+tf2.getText().toString()+"%";
			lim2= Integer.valueOf(tf5.getText().toString());
			String limite2="Insuficiencia pulmonar "+tf5.getText().toString()+"%";
			if(lim1<10) {limite1="No insuficiencia";}
			if(lim2<10) {limite2="No insuficiencia";}

			String titulo="INFORME CARDIO-RM\n"+"\n";
			String fil1= "NHC: "+f3.getText().toString()+"       "+"Fecha del estudio: "+f1.getText().toString()+"\n"+"\n"; 
			String a3= "Se realiza estudio de flujo aortico, arteria pulmonar y ramas, estudio de la funcion "
					+ "ventricular, estudio anatomico con secuencias de cine-RM y estudio vascular tras la "
					+ "administracion de gadolinio intravenoso\n";
			String a4="Se encuentra los siguientes hallazgos:\n";
			String a5="-Estudio funcional\n"+"\n";
			String fun1= "Flujo aortico: Volumen latido "+tf1.getText().toString()+"ml. "+limite1+" Velocidad maxima "+tf3.getText().toString()+" m/s."+"\n";
			String fun2= "Flujo pulmonar: Volumen latido "+tf4.getText().toString()+"ml. "+limite2+" Velocidad maxima "+tf6.getText().toString()+" m/s.\n";
			String fun3= "Rama pulmonar derecha con volumen latido de "+tf13.getText().toString()+ " ml y rama pulmonar izquierda con volumen latido de "+tf14.getText().toString()+" ml.\n";
			String fun4= "Qp / Qs: "+tf15.getText().toString()+".\n";
			String fun5= "VI: FE "+tf7.getText().toString()+"%. Volumen telediastolico "+tf8.getText().toString()+"  ml ("+tf9.getText().toString()+  " ml/m"+a+").\n";
			String fun6="VD: FE "+tf10.getText().toString()+ " %. Volumen telediastolico"+tf11.getText().toString()+" ml ("+tf12.getText().toString()+" ml/m"+a+").\n"+"\n";

			String a6="-Estudio anatomico\n"+"\n";
			String ana1="Auricula derecha "+tm1.getText().toString()+" cm. Auricula izquierda "+tm3.getText().toString()+" cm. Tabique interauricular"+tabique+".\n";
			String ana2=im+"  "+it+"\n";
			String ana3=vd+vi+tvi+"\n";
			String ana4="Tronco A. pulmonar: "+tm5.getText().toString()+" mm ("+tm6.getText().toString()+ " z).\n";
			String ana5="Rama pulmonar derecha "+tm7.getText().toString()+" mm ("+tm8.getText().toString()+ " z).\n";
			String ana6="Rama pulmonar izquierda "+tm9.getText().toString()+" mm ("+tm10.getText().toString()+ " z).\n";
			String ana7="Diametro aortico a nivel de senos Valsalva "+tm11.getText().toString()+" mm ("+tm12.getText().toString()+ " z).\n";
			String ana8= "Diametro aorta ascendente "+tm13.getText().toString()+" mm ("+tm14.getText().toString()+ " z) "+"con arco aortico "+arco+".\n";
			String ana9="Tronco supraaortico derecho de "+tm15.getText().toString()+" mm  e izquierdo  de "+tm16.getText().toString()+ " mm.\n";
			String a7="\n"+"CONCLUSION\n";

			String factor=titulo+fil1+ a3+a4+a5+fun1+fun2+fun3+fun4+fun5+fun6+a6+ana1+ana2+ana3+ana4+ana5+ana6+ana7+ana8+ana9+a7;
			try{
				String nn=f3.getText().toString();
				File doc = new File(nn+".doc");
				FileWriter escribir = new FileWriter(doc, true);
				escribir.write(factor);
				escribir.close();
				//doc.createNewFile();
			}catch(Exception ff){
				//System.out.println("Error al escribir");
				ff.printStackTrace();
			}
		}

}
