package sia.tfm.dbtester.Launcher;

import java.util.HashMap;
import java.util.Set;

import sia.tfm.dbtester.ConfigManager.ConfigFile;

public class Launcher {

	public static void main(String[] args) {
		
		String config = "../DBTester/config/config.txt";
		
		if(!ConfigFile.configFileExists(config)){
			errorMessage("El fichero de configuración no existe");
		}else if(!ConfigFile.configFileValidFormat(config)){
			errorMessage("Formato incorrecto del fichero de configuración");
		}else{
			HashMap<String, String> hm = ConfigFile.pairFromConfig(config);
			Set<String> a = hm.keySet();
			for(String key: a){
				System.out.println(key);
			}
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
