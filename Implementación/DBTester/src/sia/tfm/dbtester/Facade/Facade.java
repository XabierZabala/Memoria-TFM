package sia.tfm.dbtester.Facade;

import java.util.ArrayList;
import java.util.HashMap;

import sia.tfm.dbtester.DB.Cassandra;
import sia.tfm.dbtester.DB.MySQL;


public class Facade {
	
	/**
	 * Clase intermediaria entre la lógica de la aplicación y
	 * las bases de datos
	 * @version: 10/07/2016
	 * @author Xabier Zabala
	 */
	
	private Facade(){}
	
	/**
	 * Método que resuelve el destino de la petición realizada desde la lógica
	 * de la aplicación
	 * @param hm Mapa de pares parametro/valor obtenidos del fichero de configuración.
	 * @return Array<String> Arreglo de String que representan el tiempo
	 * necesitado para realizar cada accion
	 */
	
	public static ArrayList<String> dbResolver(HashMap<String, String> hm){
		
		String db = hm.get("selectedDB");
		
		if(db.equals("0")){
			// MySQL
			return MySQL.operationResolver(hm);
		}else if(db.equals("1")){
			// Cassandra
			//return Cassandra.operationResolver(hm);
			return null; // EZABATZEKO
		}else{
			System.out.println("La base de datos seleccionada no existe");
			System.exit(0);
			return null;
		}
	}
}
