package sia.tfm.dbtester.ConfigManager;

import java.io.File;
import java.util.HashMap;
import java.util.regex.Pattern;

import sia.tfm.dbtester.Classes.FileRead;
import sia.tfm.dbtester.FileManager.FileManager;

/**
 * Esta clase engloba los m�todos necesarios para gestionar
 * el fichero de configuraci�n.
 * @version: 05/07/2016
 * @author Xabier Zabala
 */

public class ConfigFile {
	
	/**
	 * Constructor privado de la clase {@link} ConfigFile
	 */
	
	private static Pattern item = Pattern.compile("^[a-zA-Z0-9]+[!][a-zA-Z0-9./:]+$");
	private static Pattern empty = Pattern.compile("^\\s*$");
	private static Pattern comment = Pattern.compile("^#.*$");
	
	private ConfigFile(){}
	
	/**
	 * M�todo que comprueba si todas las l�neas del fichero
	 * de configuraci�n cumplen con el formato requerido.
	 * @param path Directorio del fichero de configuraci�n.
	 * @return boolean Devuelve true si el fichero est� 
	 * correctamente formado o vac�o, en caso contrario,
	 * devuelve false.
	 */
	
	public static boolean configFileValidFormat(String path){
		
		File f = new File(path);
		
		if(f.length() == 0){
			return true;
		}else{	
			try {
		         
			 FileRead fr = FileManager.accessFileRead(f);
	
	         String linea;
	         while((linea = fr.getBr().readLine())!=null){
	        	 if(!lineValidFormat(linea)){
	        		 
	        		 FileManager.closeFileRead(fr);
	        		 return false;
	        	 }
	         }
	         	FileManager.closeFileRead(fr);
	         	return true;
		     }
		     catch(Exception e){
		    	 
		        e.printStackTrace(); 
		        return false; 
		     }	
		}
	}
	
	/**
	 * M�todo privado que comprueba si una l�nea de fichero 
	 * cumple con el formato requerido:
	 * <ul>
  		<li>Cadenas de caracteres en formato clave:valor
  		<li>L�nea vac�a
  		<li>Comentario empezado por #
	   <p>
	 * @param linea Cada una de las l�neas que forman 
	 * parte del fichero de configuraci�n.
	 * @return boolean Devuelve true si la l�nea cumple con
	 * el formato exigido, en caso contrario devuelve false.
	 */
	
	private static boolean lineValidFormat(String linea){
		
		return item.matcher(linea).find() || empty.matcher(linea).find() ||
			   comment.matcher(linea).find();	
	}
	
	/**
	 * M�todo que genera una mapa de los atributos y valores
	 * obtenidos del fichero de configuraci�n
	 * @param path Directorio del fichero de configuraci�n.
	 * @return HashMap<String, String> Devuelve las pares 
	 * clave/valor estructuradas en una HashMap
	 */
	
	public static HashMap<String, String> pairFromConfig(String path){
		
		HashMap<String, String> hm = new HashMap<String, String>();
		File f = new File(path);
		
		try {
	         
			 FileRead fr = FileManager.accessFileRead(f);
	         String linea;
	         
	         while((linea = fr.getBr().readLine())!=null){
	        	 if(item.matcher(linea).find()){
	        		 hm = lineToMap(hm, linea);
	        	 } 
	         }
	         
         	FileManager.closeFileRead(fr);
         	return hm;
		     }
		     catch(Exception e){
		    	 
		        e.printStackTrace(); 
		        return null; 
		     }
	}
	
	/**
	 * M�todo que mapea una l�nea del fichero de configuraci�n.
	 * @param configPair Contenedor de las clave/valor.
	 * @param linea L�nea a insertar en el contenedor.
	 * @return HashMap<String, String> Devuelve el contenedor 
	 * una vez a�adido la l�nea obtenido como parametro.
	 */
	
	private static HashMap<String, String> lineToMap(HashMap<String, String> configPair, String linea){
		
		String[] pairArray = linea.split("!");
		
		if(configPair.containsKey(pairArray[0])){
			System.out.println("Atributo repetido en la configuraci�n");
			System.exit(0);
			return null;
		}else{
			configPair.put(pairArray[0], pairArray[1]);
			return configPair;
		}
	}

}
