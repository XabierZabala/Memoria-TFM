package sia.tfm.dbtester.Classes;

import java.io.BufferedReader;
import java.io.FileReader;

public class FileRead {
	
	/**
	 * Esta clase gestiona los elementos necesarios para abrir
	 * un fichero en modo lectura y cerrarlo al final del proceso.
	 * @version: 06/07/2016
	 * @author Xabier Zabala
	 */
	
	private FileReader fr;
	private BufferedReader br;
	
	public FileRead(FileReader fr, BufferedReader br) {
		super();
		this.fr = fr;
		this.br = br;
	}

	public FileReader getFr() {
		return fr;
	}

	public void setFr(FileReader fr) {
		this.fr = fr;
	}

	public BufferedReader getBr() {
		return br;
	}

	public void setBr(BufferedReader br) {
		this.br = br;
	}	
}
	
	
