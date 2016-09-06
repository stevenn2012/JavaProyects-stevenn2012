package Fanfid;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class franfid {

	private String nombreClase;
	private HashMap<Integer, AtribDat> datosAtributos = new HashMap<Integer, AtribDat>();
	
	public franfid(String rutaDescriptor) throws IOException{
		BufferedReader leer = new BufferedReader(new FileReader(rutaDescriptor));
		String cadena="";
		int index=0;
		while((cadena=leer.readLine())!=null){
			boolean fin=false;
			String[] datos = cadena.split(" ");
			switch (datos[1]) {
				case "Class":this.nombreClase=datos[2];break;
				case "Attrib":datosAtributos.put(index++, new AtribDat(datos[2], datos[3], Integer.parseInt(datos[4])));break;
				case "/":fin=true;break;
				default:System.out.println("Linea Desconocida en descriptor");;break;
			}
			if(fin){break;}
		}
		leer.close();
	}
	
	public ArrayList<Object> leerArchivo(String rutaArchivo) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException, ParseException{
		ArrayList<Object> datos = new ArrayList<Object>();
		BufferedReader leer = new BufferedReader(new FileReader(rutaArchivo));
		Class<?> cls = Class.forName(nombreClase);
		String cadena="";
		while((cadena=leer.readLine())!=null){
			Object inst = cls.newInstance();
			int indexAtrib = cls.getDeclaredFields().length;
			for (int i = 0; i < indexAtrib; i++) {
				AtribDat datAtrib = datosAtributos.get(i);
				String info="";
				if(i==(indexAtrib-1)){
					info = cadena.substring(0, datAtrib.getAncho()).trim();
				}else{
					info = cadena.substring(0, datAtrib.getAncho()-1).trim();
				}
				cadena= cadena.substring(datAtrib.getAncho());
				retorno datMethod = getClass(datAtrib.getTipo(), info);
				Method m = cls.getMethod("set"+datAtrib.getNombre(), datMethod.getClase());
				m.invoke(inst, datMethod.getDato());
			}
			datos.add(inst);
		}
		leer.close();
		return datos;
	}
	
	public retorno getClass(String tipo, String dato) throws ParseException{
		Class<?> cls = null;
		Object d = null;
		if(tipo.equalsIgnoreCase("boolean")){
			cls = boolean.class;
			d = Boolean.parseBoolean(dato);
		}
		
		if(tipo.equalsIgnoreCase("int")){
			cls = int.class;
			d = Integer.parseInt(dato);
		}
		
		if(tipo.equalsIgnoreCase("integer")){
			cls = java.lang.Integer.class;
			d = Integer.parseInt(dato);
		}
		
		if(tipo.equalsIgnoreCase("long")){
			cls = long.class;
			d = Long.parseLong(dato);
		}
		
		if(tipo.equalsIgnoreCase("char")){
			cls = char.class;
			d = (dato+"").charAt(0);
		}
		
		if(tipo.equalsIgnoreCase("string")){
			cls = java.lang.String.class;
			d = (dato+"");
		}
		
		if(tipo.equalsIgnoreCase("double")){
			cls = double.class;
			d = Double.parseDouble(dato);
		}
		
		if(tipo.equalsIgnoreCase("float")){
			cls = float.class;
			d = Float.parseFloat(dato);
		}
		
		if(tipo.equalsIgnoreCase("date")){
			cls = Date.class;
			SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
		    d = formato.parse(dato);	     
		}
		return new retorno(cls, d);
	}

	public class retorno{
		private Class<?> clase;
		private Object dato;
		
		public retorno(Class<?> clase, Object dato){
			this.clase=clase;
			this.dato=dato;
		}

		public Class<?> getClase() {
			return clase;
		}

		public void setClase(Class<?> clase) {
			this.clase = clase;
		}

		public Object getDato() {
			return dato;
		}

		public void setDato(Object dato) {
			this.dato = dato;
		}
	}

	public void escribirArchivo(String rutaArchivo, ArrayList<Object>datos) throws IOException, NoSuchMethodException, SecurityException, ClassNotFoundException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		datos=reordenarArray(datos);
		Class<?> cls = Class.forName(nombreClase);
		BufferedWriter escribir = new BufferedWriter(new FileWriter(rutaArchivo));
			for (int i = 0; i < datos.size(); i++) {
				String info="";
				for (int j = 0; j < datosAtributos.size(); j++) {
					Method m = cls.getMethod("get"+datosAtributos.get(j).getNombre());
					if(!datosAtributos.get(j).getTipo().equalsIgnoreCase("date")){
						info+=String.format("%1$-"+datosAtributos.get(j).getAncho()+"s", m.invoke(datos.get(i)));
					}else{
						SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
						info+=String.format("%1$-"+datosAtributos.get(j).getAncho()+"s", formato.format(m.invoke(datos.get(i))));
					}
				}
				System.out.println("Guardando --> "+info);
				escribir.write(info);
				escribir.newLine();
			}
		escribir.close();
	}
	
	public ArrayList<Object> reordenarArray(ArrayList<Object> datos){
		for (int i = 0; i < (datos.size()/2); i++) {
			System.out.println("Cambiando posicion --> "+datos.get(i));
			datos.add(datos.remove(i));
		}
		return datos;
	}
}
