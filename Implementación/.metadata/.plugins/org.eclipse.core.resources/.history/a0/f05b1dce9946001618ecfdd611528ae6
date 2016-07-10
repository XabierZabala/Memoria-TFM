package sia.tfm.dbtester.ResultManager;

import java.io.File;

public class ResultManager {
	
	/**
	 * Esta clase engloba los métodos necesarios para gestionar
	 * los resultados de las pruebas realizadas.
	 * @version: 09/07/2016
	 * @author Xabier Zabala
	 */
	
	private ResultManager(){};
	
	/**
	 * Método que genera un array con directorios donde se almacenan los resultados.
	 * @param dirs Conjunto de directorios donde se almacenaran los resultados.
	 * @return String[] Arreglo de directorios en formato String
	 */
	
	public static String[] directoryArray(String... dirs){
		
		return dirs.clone();
	
	}
	
	/**
	 * Método que comprueba la existencia de los directorios donde se
	 * almacenan los resultados de los test y en caso no existir los crea.
	 * @param paths Listado de rutas donde se almacenan los resultados de los test.
	 */
	
	public static void configureDirectories(String[] paths){
		
		for(String path: paths){
			
			File dir = new File(path);
			if(!dir.exists() || !dir.isDirectory()){
				dir.mkdirs();
			}
		}	
	}
	
	/**
	 * Método que crea el fichero de resultados correspondiente a la BD
	 * seleccionada
	 * @param bd Identificador de la base de datos seleccionada.
	 * @return File El fichero de resultados.
	 */
	
	public static File createResultFile(String bd, String[] dirs){
		
		int selectedDB = Integer.parseInt(bd);
		Long now = System.currentTimeMillis();
		
		try{
			
			String filePath = dirs[selectedDB] + '/' + "result_" + now + ".txt";
			File f = new File(filePath);
			f.createNewFile();
			
			return f;
			
		}catch(Exception e){
			System.out.println("La base de datos seleccionada no existe");
			System.exit(0);
			return null;
		}
		
		
		
		
	}

}
