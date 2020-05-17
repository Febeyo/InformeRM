import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.io.File;
import java.io.FileWriter;
import java.text.AttributedString;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

@SuppressWarnings("serial")
public class Filiacion extends JPanel implements ChangeListener, ActionListener{
	private JLabel etiq1,etiq2,etiq3, e1,e2,e3, e4, etiq4, etiq6, etiq7, etiq8, et1, et2;
	private JTextField f1,f2, f3,t1,t3,t4,res,todo, fecha;
	private JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8,tf9, tf10, tf11,tf12,tf13,tf14,tf15;
	private JTextField tm1,tm2,tm3,tm4,tm5,tm6,tm7,tm8,tm9, tm10, tm11,tm12,tm13,tm14,tm15, tm16;
	private String a, tabique, im, it, vd, vi, tvi, arco; 
	private JButton calc, boton2;
	private int lim1, lim2, lim3, dias;
	private JCheckBox ca1, ca2, ca3; 
	private ButtonGroup g1,g2, g3, g4, g5, g6;
	private JRadioButton r1, r2, cb4, cb5, cb6, cb7, cb1, cb2, cb3, r3, r4;
	private double indice, superficie;
	public static double b, m, g;
	public static double total;
	public static String temporal, diastotal, diasestab, edad1 ;
	public static String edad2;
	private String[] fechaacc, fechanac, fechaest; 
	private JScrollPane barra;

	public Filiacion() {
		// TODO Auto-generated constructor stub
		setLayout(new GridLayout(0,1,0,0));
		//JDOM libreria para genera html desde codigo
		
		JPanel todo= new JPanel(); add(todo); 	todo.setLayout(new BoxLayout(todo, BoxLayout.Y_AXIS));
		barra= new JScrollPane();
		add(barra);
		barra.setViewportView(todo);
		Font a1= new Font("Tahona", Font.PLAIN, 16);
		Font a2= new Font("Times New Roman", Font.BOLD, 18);
		JPanel pp1= new JPanel(); 		todo.add(pp1); 		pp1.setLayout(new BoxLayout(pp1, BoxLayout.Y_AXIS));
		Font titulo= new Font("Tahona",Font.BOLD, 18);
		Border bor1= BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "DATOS FILIACION", TitledBorder.CENTER, TitledBorder.TOP, titulo);
		pp1.setBorder(bor1);
		
		JPanel pa2= new JPanel();
		pp1.add(pa2);
		pa2.setLayout(new FlowLayout(FlowLayout.LEFT,20,10));
		e2= new JLabel("Numero de historia clinica"); pa2.add(e2);
		f3= new JTextField(10); f3.setHorizontalAlignment(JTextField.CENTER); pa2.add(f3);
		etiq1= new JLabel("Fecha de estudio (DD/MM/AAAA):"); 		pa2.add(etiq1);
		f1= new JTextField(12); 		f1.setHorizontalAlignment(JTextField.CENTER); 		pa2.add(f1);
		JPanel pa1= new JPanel(); 		pp1.add(pa1); 		pa1.setLayout(new FlowLayout(FlowLayout.LEFT,20,10));
		g1= new ButtonGroup();  		etiq6= new JLabel("Sexo:"); pa1.add(etiq6);
		r1= new JRadioButton("Femenino"); g1.add(r1); pa1.add(r1); r1.addChangeListener(this);
		r2= new JRadioButton("Masculino"); g1.add(r2); pa1.add(r2); r2.addChangeListener(this);
		etiq2= new JLabel("Fecha de nacimiento (DD/MM/AAAA):");
		pa1.add(etiq2);
		f2= new JTextField(12);
		f2.setHorizontalAlignment(JTextField.CENTER);
		pa1.add(f2);
		etiq4 = new JLabel("Peso (Kg)"); 		pa1.add(etiq4);		
		t1 = new JTextField(3); 		t1.setHorizontalAlignment(JTextField.CENTER);		pa1.add(t1);

		e3= new JLabel("Altura (cm)");		pa1.add(e3);
		t3 = new JTextField(3);		t3.setHorizontalAlignment(JTextField.CENTER);		pa1.add(t3);
		JPanel pa8= new JPanel();
		pp1.add(pa8);
		pa8.setLayout(new FlowLayout(FlowLayout.LEFT,20,10));
		e1= new JLabel("Edad del paciente"); 		pa8.add(e1); 		et1= new JLabel(); pa8.add(et1);
		e4= new JLabel("IMC (Indice de masa corporal)"); 		pa8.add(e4); 		et2= new JLabel(); pa8.add(et2);		
		etiq7= new JLabel("Superficie corporal total (SCT)"); 		pa8.add(etiq7); 		etiq3= new JLabel(); pa8.add(etiq3);

		
		tf1= new JTextField(5);tf2= new JTextField(5);tf3= new JTextField(5);tf4= new JTextField(5);tf1= new JTextField(5);
		tf5= new JTextField(5);tf6= new JTextField(5);tf7= new JTextField(5);tf8= new JTextField(5);
		tf9= new JTextField(5);tf10= new JTextField(5);tf11= new JTextField(5);tf12= new JTextField(5);
		tf13= new JTextField(5);tf14= new JTextField(5);tf15= new JTextField(5);
		JPanel pp2= new JPanel(); 		todo.add(pp2); 		pp2.setLayout(new BoxLayout(pp2, BoxLayout.Y_AXIS));
		Border bor2= BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "VALORES FUNCIONALES", TitledBorder.CENTER, TitledBorder.TOP, titulo);
		pp2.setBorder(bor2);
		
		JPanel l1= new JPanel(); pp2.add(l1); l1.setLayout(new FlowLayout(FlowLayout.LEFT,20,10));
		JLabel t1= new JLabel("Flujo aortico:"); l1.add(t1);
		JLabel tt1=  new JLabel("Volumen latido (ml)"); l1.add(tt1);l1.add(tf1);
		JLabel ttt1= new JLabel("% Insuficiencia aortica"); l1.add(ttt1);l1.add(tf2);
		JLabel tttt1= new JLabel("Velocidad maxima (m/s)"); l1.add(tttt1);l1.add(tf3);
		
		JPanel l2= new JPanel(); pp2.add(l2); l2.setLayout(new FlowLayout(FlowLayout.LEFT,20,10));
		JLabel t2= new JLabel("Flujo pulmonar:"); l2.add(t2);
		JLabel tt2=  new JLabel("Volumen latido (ml)"); l2.add(tt2);l2.add(tf4);
		JLabel ttt2= new JLabel("% Insuficiencia aortica"); l2.add(ttt2);l2.add(tf5);
		JLabel tttt2= new JLabel("Velocidad maxima (m/s)"); l2.add(tttt2);l2.add(tf6);
		
		JPanel l3= new JPanel(); pp2.add(l3); l3.setLayout(new FlowLayout(FlowLayout.LEFT,20,10));
		JLabel t3= new JLabel("Ventriculo izquierdo:"); l3.add(t3);
		JLabel tt3=  new JLabel("Fraccion de eyeccion(%)"); l3.add(tt3);l3.add(tf7);
		JLabel ttt3= new JLabel("Volumen telediastolico (ml)"); l3.add(ttt3);l3.add(tf8);
		a= "\u00B2"; 
		JLabel tttt3= new JLabel("Volumen telediastolico indexado (ml/m"+a+")"); l3.add(tttt3); l3.add(tf9);
		
		JPanel l4= new JPanel(); pp2.add(l4); l4.setLayout(new FlowLayout(FlowLayout.LEFT,20,10));
		JLabel t4= new JLabel("Ventriculo derecho:"); l4.add(t4);
		JLabel tt4=  new JLabel("Fraccion de eyeccion(%)"); l4.add(tt4);l4.add(tf10);
		JLabel ttt4= new JLabel("Volumen telediastolico (ml)"); l4.add(ttt4);l4.add(tf11);
		JLabel tttt4= new JLabel("Volumen telediastolico indexado (ml/m"+a+")"); l4.add(tttt4);l4.add(tf12);
		
		JPanel l5= new JPanel(); pp2.add(l5); l5.setLayout(new FlowLayout(FlowLayout.LEFT,20,10));
		JLabel t5= new JLabel("Rama pulmonar"); l5.add(t5);
		JLabel tt5=  new JLabel("Derecha: Volumen latido (ml)"); l5.add(tt5);l5.add(tf13);
		JLabel ttt5= new JLabel("Izquierda: Volumen latido (ml)"); l5.add(ttt5);l5.add(tf14);
		JPanel l6= new JPanel(); pp2.add(l6); l6.setLayout(new FlowLayout(FlowLayout.LEFT,20,20));
		JLabel t6= new JLabel("Qp/Qs:"); l6.add(t6);l6.add(tf15);
		
		
		JPanel pp3= new JPanel(); 		todo.add(pp3); 		pp3.setLayout(new BoxLayout(pp3, BoxLayout.Y_AXIS));
		Border bor3= BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "VALORES MORFOLOGICOS", TitledBorder.CENTER, TitledBorder.TOP, titulo);
		pp3.setBorder(bor3);
		tm1= new JTextField(5);tm2= new JTextField(5);tm3= new JTextField(5);tm4= new JTextField(5);
		tm5= new JTextField(5);tm6= new JTextField(5);tm7= new JTextField(5);tm8= new JTextField(5);
		tm9= new JTextField(5);tm10= new JTextField(5);tm11= new JTextField(5);tm12= new JTextField(5);
		tm13= new JTextField(5);tm14= new JTextField(5);tm15= new JTextField(5);
		
		JPanel ll1= new JPanel(); pp3.add(ll1); ll1.setLayout(new FlowLayout(FlowLayout.LEFT,20,10));
		JLabel m1= new JLabel("Auricula derecha:"); JLabel mm1= new JLabel("Diametro mayor (cm):");	JLabel mmm1= new JLabel("Area(cm"+a+")");
		ll1.add(m1);ll1.add(mm1);ll1.add(tm1);ll1.add(mmm1);ll1.add(tm2);
		JLabel m2= new JLabel("Auricula izquierda:"); JLabel mm2= new JLabel("Diametro mayor (cm):");	JLabel mmm2= new JLabel("Area(cm"+a+")");
		ll1.add(m2);ll1.add(mm2);ll1.add(tm3);ll1.add(mmm2);ll1.add(tm4);
		JPanel ll2= new JPanel(); pp3.add(ll2); ll2.setLayout(new FlowLayout(FlowLayout.LEFT,20,10));
		JLabel ins= new JLabel("Insuficiencia mitral:"); JLabel inst= new JLabel("Insuficiencia tricuspidea:");
		g2= new ButtonGroup(); g3= new ButtonGroup();
		cb4=new JRadioButton("Si"); cb5=new JRadioButton("No"); cb6=new JRadioButton("Si");cb7=new JRadioButton("No");
		ll2.add(ins); ll2.add(cb4); ll2.add(cb5); ll2.add(inst); ll2.add(cb6);  ll2.add(cb7); cb4.addChangeListener(this);cb5.addChangeListener(this);cb6.addChangeListener(this);cb7.addChangeListener(this);
		g2.add(cb4);g2.add(cb5); g3.add(cb6); g3.add(cb7);
		
		g4= new ButtonGroup(); 
		JLabel m3=new JLabel("Tabique interauricular:"); ll2.add(m3); cb1= new JRadioButton("Engrosado"); cb2= new JRadioButton("Normal"); cb3= new JRadioButton("Adelgazado");
		g4.add(cb1); g4.add(cb2);g4.add(cb3);
		ll2.add(cb1);ll2.add(cb2);ll2.add(cb3);cb1.addChangeListener(this); cb2.addChangeListener(this); cb3.addChangeListener(this);
		JPanel ll3= new JPanel(); pp3.add(ll3); ll3.setLayout(new FlowLayout(FlowLayout.LEFT,20,10));
		ca1= new JCheckBox("Ventriculo izquierdo dilatado"); ll3.add(ca1); ca1.addChangeListener(this);
		ca2= new JCheckBox("Ventriculo derecho dilatado"); ll3.add(ca2); ca2.addChangeListener(this);
		ca3= new JCheckBox("Tracto salida ventriculo izquierdo dilatado"); ll3.add(ca3); ca3.addChangeListener(this);
		JPanel ll4= new JPanel(); pp3.add(ll4); ll4.setLayout(new FlowLayout(FlowLayout.LEFT,20,10));
		
		JLabel tp1= new JLabel("Tronco A. pulmonar:"); ll4.add(tp1); tm5= new JTextField(5);JLabel tp2= new JLabel("mm; "); tm6= new JTextField(5); JLabel tp3 = new JLabel("Z-score");
		JPanel ll5= new JPanel(); ll4.add(ll5); ll5.setLayout(new FlowLayout(FlowLayout.LEFT,5,0)); ll5.add(tm5);ll5.add(tp2);ll5.add(tm6);ll5.add(tp3);
		JLabel tr1= new JLabel ("Rama pulmonar derecha:"); ll4.add(tr1);tm7= new JTextField(5);JLabel tr2= new JLabel("mm; "); tm8= new JTextField(5); JLabel tr3 = new JLabel("Z-score"); 		
		JPanel ll6= new JPanel(); ll4.add(ll6); ll6.setLayout(new FlowLayout(FlowLayout.LEFT,5,0));ll6.add(tm7); ll6.add(tr2);ll6.add(tm8); ll6.add(tr3);
		JLabel tri1= new JLabel ("Rama pulmonar izquierda:"); ll4.add(tri1);tm9= new JTextField(5);JLabel tri2= new JLabel("mm; "); tm10= new JTextField(5); JLabel tri3 = new JLabel("Z-score"); 	
		JPanel ll7= new JPanel(); ll4.add(ll7); ll7.setLayout(new FlowLayout(FlowLayout.LEFT,5,0));ll7.add(tm9); ll7.add(tri2);ll7.add(tm10); ll7.add(tri3);
		JPanel ll8= new JPanel(); pp3.add(ll8); ll8.setLayout(new FlowLayout(FlowLayout.LEFT,20,10));
		JLabel ta1= new JLabel("Aorta a nivel senos de Valsalva");ll8.add(ta1); tm11= new JTextField(5);JLabel ta2= new JLabel("mm; "); tm12= new JTextField(5); JLabel ta3 = new JLabel("Z-score");
		JPanel ll9= new JPanel(); ll8.add(ll9); ll9.setLayout(new FlowLayout(FlowLayout.LEFT,5,0)); ll9.add(tm11); ll9.add(ta2);ll9.add(tm12); ll9.add(ta3);
		JLabel ta11= new JLabel("Aorta ascendente");ll8.add(ta11);tm13= new JTextField(5);JLabel ta21= new JLabel("mm; "); tm14= new JTextField(5); JLabel ta31 = new JLabel("Z-score");
		JPanel ll10= new JPanel(); ll8.add(ll10); ll10.setLayout(new FlowLayout(FlowLayout.LEFT,5,0));ll10.add(tm13); ll10.add(ta21);ll10.add(tm14); ll10.add(ta31);
		JLabel ta12= new JLabel("Arco aortico"); ll8.add(ta12);
		g5= new ButtonGroup(); r3= new JRadioButton("Izquierdo"); r4= new JRadioButton("Derecho");g5.add(r3); g5.add(r4);ll8.add(r3); ll8.add(r4);
		r3.addChangeListener(this); r4.addChangeListener(this);
		JPanel ll11= new JPanel(); pp3.add(ll11); ll11.setLayout(new FlowLayout(FlowLayout.LEFT,20,10));
		JLabel ts1= new JLabel("Troncos supraorticos:"); ll11.add(ts1); JLabel tsd = new JLabel ("Derecho (mm):"); ll11.add(tsd);tm15= new JTextField(5);ll11.add(tm15);
		JLabel tsi= new JLabel ("Izquierdo (mm):"); ll11.add(tsi);tm16= new JTextField(5);ll11.add(tm16);
		
		
		JPanel pa7= new JPanel(); 		todo.add(pa7); 		pa7.setLayout(new FlowLayout(FlowLayout.CENTER,20,20));
		calc = new JButton("Generar informe"); 		pa7.add(calc); 		calc.addActionListener(this);
		
		
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
			//Font fuente1 = new Font("LucidaSans", Font.BOLD, 18);
			//JLabel tit1= new JLabel ("INFORME CARDIO-RM");
			//tit1.setFont(fuente1);
			String titulo="INFORME CARDIO-RM\n"+"\n";
			//String titulo= tit1.getText().toString();
			//AttributedString ftitulo = new AttributedString(titulo);
			//ftitulo.addAttribute(TextAttribute.FONT, fuente1);
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
			/*String a2="\nLesiones permanentes\n"+Pes2.tsecuela+"\n"+"Puntuacion total secuelas concurrentes: "+Pes2.rconcurrentes+" puntos; Puntuacion secuelas estéticas:  "+Pes2.restetica+" puntos\n"+"Indemnizacion por lesiones permanentes (incluido factor corrector por perjuicio economico): "+t2.getText().toString()+"\n";
			if(Pes3.valorado.length()==2) {corr="Factores correctores de lesiones permanentes: No\n";
			tot="Indemnizacion total: "+String.format("%.2f", indemtotal1);}
			else {
			corr="Factores correctores de lesiones permanentes\n"+Pes3.valorado+"\n"; 
			tot= "Indemnizacion total: "+t4.getText().toString();}
			titulo= "Valoracion del daño corporal-Indemnizacion por accidente de trafico antes de año 2016\n\n"; */
			String factor=titulo+fil1+ a3+a4+a5+fun1+fun2+fun3+fun4+fun5+fun6+a6+ana1+ana2+ana3+ana4+ana5+ana6+ana7+ana8+ana9+a7;
			try{
				//String nn= f1.getText().toString()+"--"+ f3.getText().toString();
				String nn=f3.getText().toString();
				File doc = new File(nn+".doc");
				//File doc = new File("C:\\Users\\Febechi-Héctor\\Downloads\\Valoracion pericial.txt");
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
