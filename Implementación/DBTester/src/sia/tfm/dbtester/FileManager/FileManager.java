package sia.tfm.dbtester.FileManager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import sia.tfm.dbtester.Classes.FileRead;
import sia.tfm.dbtester.Classes.FileWrite;

public class FileManager {
	
	/**
	 * Esta clase engloba los métodos necesarios para gestionar
	 * el acceso a ficheros y directorios.
	 * @version: 06/07/2016
	 * @author Xabier Zabala
	 */
	
	private FileManager(){}
	
	/**
	 * Método que comprueba la existencia de un fichero
	 * en la ruta especificada
	 * @param path Ruta del fichero.
	 * @return boolean Devuelve true si el fichero existe,
	 * false en caso contrario.
	 */
	
	public static boolean fileExists(String path){
		
		File f = new File(path);
		return f.exists() && !f.isDirectory();
		
	}
	
	/**
	 * Método que accede a un fichero y devuelve el buffer
	 * de lectura
	 * @param File Fichero que se desea leer.
	 * @return FileRead Devuelve el buffer de lectura 
	 * del fichero accedido.
	 */
	
	public static FileRead accessFileRead(File file){
		
		try {
			
			FileReader fr = new FileReader (file);
			BufferedReader br = new BufferedReader(fr);
			
			return new FileRead(fr,br);
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
			return null;
		}	
	}
	
	/**
	 * Método que cierra a un fichero de lectura
	 * @param FileRead Objeto que contine la información
	 * del lector de ficheros y buffer.
	 */
	
	public static void closeFileRead(FileRead fileRead){
		
		try {
			fileRead.getBr().close();
			fileRead.getFr().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Método que accede a un fichero y devuelve el buffer
	 * de escritura
	 * @param File Fichero en el que se desea escribir.
	 * @return BufferedReader Devuelve el buffer de lectura 
	 * del fichero accedido.
	 */
	
	public static FileWrite accessFileWrite(File file){
		
		try {
			
			FileWriter fw = new FileWriter (file);
			PrintWriter pw = new PrintWriter(fw);
			
			return new FileWrite(fw, pw);
			
		} catch (IOException e) {
			
			e.printStackTrace();
			return null;
		}	
	}
	
	/**
	 * Método que cierra a un fichero de escritura
	 * @param FileWrite Objeto que contine la información
	 * del escritor de ficheros y buffer.
	 */
	
	public static void closeFileWrite(FileWrite fileWrite){
		
		try {
			fileWrite.getPw().close();
			fileWrite.getFw().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
