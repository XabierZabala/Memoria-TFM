package sia.tfm.dbtester.Facade;

import sia.tfm.dbtester.DB.Cassandra;
import sia.tfm.dbtester.DB.MySQL;
import sia.tfm.dbtester.DB.MySQLCluster;

public class Facade {
	
	/**
	 * Clase intermediaria entre la l�gica de la aplicaci�n y
	 * las bases de datos
	 * @version: 10/07/2016
	 * @author Xabier Zabala
	 */
	
	private Facade(){}
	
	/**
	 * M�todo que resuelve el destino de la petici�n realizada desde la l�gica
	 * de la aplicaci�n
	 * @param bd Identificador de la base de datos seleccionada.
	 * @param op Identificador de la operaci�n seleccionada.
	 * @return Array<String> Arreglo de String que representan el tiempo
	 * necesitado para realizar cada accion
	 */
	
	public static String actionResolver(String db, String op){
		
		
		if(db.equals("0")){
			// MySQL
			MySQL mysql = new MySQL(op);
		}else if(db.equals("1")){
			// Cassandra
			Cassandra css = new Cassandra(op);	
		}else if(db.equals("2")){
			// MySQL Cluster
			MySQLCluster mysqlCluster = new MySQLCluster(op);
		}else{
			System.out.println("La base de datos seleccionada no existe");
			System.exit(0);
		}
		
		return null; // FALTAR SEGUIR IMPLEMENTANDO
		
	}

}
