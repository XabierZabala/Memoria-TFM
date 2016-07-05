package sia.tfm.dbtester.ConfigManager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.regex.Pattern;

/**
 * Esta clase engloba los métodos necesarios para gestionar
 * el fichero de configuración.
 * @version: 05/07/2016
 * @author Xabier Zabala
 */

public class ConfigFile {
	
	/**
	 * Constructor privado de la clase {@link} ConfigFile
	 */
	
	private ConfigFile(){}
	
	/**
	 * Método que comprueba la existencia del fichero
	 * de configuración.
	 * @param path Directorio del fichero de configuración.
	 * @return boolean Devuelve true si el fichero existe,
	 * false en caso contrario.
	 */
	
	public static boolean configFileExists(String path){
		
		File f = new File(path);
		return f.exists() && !f.isDirectory();
		
	}
	
	/**
	 * Método que comprueba si el fichero de configuración
	 * esta formado correctamente.
	 * @param path Directorio del fichero de configuración.
	 * @return boolean Devuelve true si el fichero está 
	 * correctamente configurado o vacío, en caso contrario,
	 * devuelve false.
	 */
	
	public static boolean configFileValidFormat(String path){
		
		File f = new File(path);
		FileReader fr = null;
	    BufferedReader br = null;
	    
		if(f.length() == 0){
			return true;
		}else{	
			try {
		         
	         fr = new FileReader (f);
	         br = new BufferedReader(fr);
	
	         String linea;
	         while((linea=br.readLine())!=null){
	        	 if(!lineValidFormat(linea)){
	        		 br.close();
	        		 fr.close();
	        		 return false;
	        	 }
	         }
	         	br.close();
	         	fr.close();
	         	return true;
		     }
		     catch(Exception e){
		        e.printStackTrace();
		        try{
		        	br.close();
	        		fr.close();
		        }catch(Exception e2){
		        	e.printStackTrace();
		        }
		        return false; 
		     }	
		}
	}
	
	/**
	 * Método privado que comprueba si el string obtenido 
	 * cumple con el formato exigido para ser parte del
	 * fichero de configuración. Se aceptan las expresiones
	 * cuya clave y valor sean valores alfanuméricos y 
	 * estén separados por ':' 
	 * @param linea Línea que forma parte del fichero de
	 * configuración.
	 * @return boolean Devuelve true si la línea cumple con
	 * el formato exigido, en caso contrario devuelve false.
	 */
	
	private static boolean lineValidFormat(String linea){
		Pattern r = Pattern.compile("^[a-zA-Z0-9]+[:][a-zA-Z0-9]+$");
		return r.matcher(linea).find();	
	}
	

}
