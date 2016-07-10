package sia.tfm.dbtester.ResultManager;

import java.io.File;
import java.io.PrintWriter;

import sia.tfm.dbtester.Classes.FileWrite;
import sia.tfm.dbtester.Facade.Facade;
import sia.tfm.dbtester.FileManager.FileManager;

public class ResultManager {
	
	/**
	 * Esta clase engloba los m�todos necesarios para gestionar
	 * los resultados de las pruebas realizadas.
	 * @version: 09/07/2016
	 * @author Xabier Zabala
	 */
	
	private ResultManager(){};
	
	/**
	 * M�todo que genera un array con directorios donde se almacenan los resultados.
	 * @param dirs Conjunto de directorios donde se almacenaran los resultados.
	 * @return String[] Arreglo de directorios en formato String
	 */
	
	public static String[] directoryArray(String... dirs){
		
		return dirs.clone();
	
	}
	
	/**
	 * M�todo que genera un array con operaciones descritas en la configuraci�n.
	 * @param ops Conjunto de operaciones que se realizar�n durante las pruebas.
	 * @return String[] Arreglo de operaciones en formato String
	 */
	
	public static String[] operationArray(String... ops){
		
		return ops.clone();
	
	}
	
	/**
	 * M�todo que comprueba la existencia de los directorios donde se
	 * almacenan los resultados de los test y en caso no existir los crea.
	 * @param paths Listado de rutas donde se almacenan los resultados de los test.
	 * @param ops Listado de operaciones que se van a realizar durante las pruebas
	 */
	
	public static void configureDirectories(String[] paths, String[] ops){
		
		for(String path: paths){
			
			for(String operation: ops){
				
				String filename = path + "/" + operation; 
				
				File dir = new File(filename);
				if(!dir.exists() || !dir.isDirectory()){
					dir.mkdirs();
				}
			}	
		}	
	}
	
	/**
	 * M�todo que crea el fichero de resultados correspondiente a la BD
	 * seleccionada
	 * @param bd Identificador de la base de datos seleccionada.
	 * @return File El fichero de resultados.
	 */
	
	public static File createResultFile(String bd, String[] dirs, String op, String[] ops){
		
		int selectedDB = Integer.parseInt(bd);
		int selectedOp = Integer.parseInt(op);
		Long now = System.currentTimeMillis();
		
		try{
			
			String filePath = dirs[selectedDB] + '/' + ops[selectedOp] + "/" + "result_" + now + ".txt";
			File f = new File(filePath);
			f.createNewFile();
			
			return f;
			
		}catch(Exception e){
			System.out.println("La base de datos seleccionada no existe");
			System.exit(0);
			return null;
		}	
	}
	
	/**
	 * M�todo que escribe los resultados obtenidos por la operaci�n seleccionada en el fichero
	 * correspondiente a la base de datos sobre el cual ha ejecutado.
	 * @param file Fichero donde se han de escribir los resultados
	 * @param bd Identificador de la base de datos seleccionada.
	 * @param op Identificador de la operaci�n seleccionada.
	 */
	
	public static void resultWriter(File file, String bd, String op){
		
		FileWrite fw = FileManager.accessFileWrite(file);
		PrintWriter pw = fw.getPw();
		
		Facade.actionResolver(bd, op); // Devuelve un string
		
		FileManager.closeFileWrite(fw);
		
	}

}
