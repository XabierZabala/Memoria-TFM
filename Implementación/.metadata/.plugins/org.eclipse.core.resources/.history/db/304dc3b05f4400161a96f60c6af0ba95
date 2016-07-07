package sia.tfm.dbtester.FileManager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import sia.tfm.dbtester.Classes.FileRead;

public class FileManager {
	
	/**
	 * Esta clase engloba los métodos necesarios para gestionar
	 * el acceso a ficheros.
	 * @version: 06/07/2016
	 * @author Xabier Zabala
	 */
	
	private FileManager(){}
	
	/**
	 * Método que accede a un fichero y devuelve el buffer
	 * de lectura
	 * @param File Fichero que se desea leer.
	 * @return BufferedReader Devuelve el buffer de lectura 
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

}
