package sia.tfm.dbtester.Launcher;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import sia.tfm.dbtester.ConfigManager.ConfigFile;
import sia.tfm.dbtester.Facade.Facade;
import sia.tfm.dbtester.FileManager.FileManager;
import sia.tfm.dbtester.ResultManager.ResultManager;

public class Launcher {

	public static void main(String[] args) {
		
		// Ruta del fichero de configuración
		final String config = "../DBTester/config/config.txt";
		
		// Comprobar la existencia y el formato del fichero de configuración
		if(!FileManager.fileExists(config)){
			errorMessage("El fichero de configuración no existe");
		}else if(!ConfigFile.configFileValidFormat(config)){
			errorMessage("Formato incorrecto del fichero de configuración");
		}else{
			
			// Mapea los pares parametro/valor del fichero de configuración	
			HashMap<String, String> hm = ConfigFile.pairFromConfig(config);
			
			// Generar array con directorios donde se almacenan los resultados
			String[] paths = ResultManager.directoryArray(hm);
			
			// Generar array con operaciones disponibles
			String[] operations = ResultManager.operationArray(hm);
			
			// Crear directorios para almacenar los resultados
			ResultManager.configureDirectories(paths, operations);
			
			// Obtener el fichero de resultados segun la DB  y operación seleccionada
			File resultFile = ResultManager.createResultFile(hm, paths, operations);
				
			// Calcular el tiempo necesario para realizar la operación en la DB seleccionada
			ArrayList<String> opElapsedTime = Facade.dbResolver(hm);
			
			// Escribir los tiempos obtenidos en el fichero correspondiente
			ResultManager.resultWriter(resultFile, opElapsedTime);
			
		}
		
	}
	
	/**
	 * Método que imprime en consola el mensaje de error
	 * proporcionado como parámetro y termina el proceso.
	 * @param String Mensaje de error.
	 */
	
	private static void errorMessage(String message){
		System.out.println(message);
		System.exit(0);
	}

}
