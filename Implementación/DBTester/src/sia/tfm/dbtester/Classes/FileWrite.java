package sia.tfm.dbtester.Classes;

import java.io.FileWriter;
import java.io.PrintWriter;

public class FileWrite {
	
	/**
	 * Esta clase gestiona los elementos necesarios para abrir
	 * un fichero en modo escritura y cerrarlo al final del proceso.
	 * @version: 07/07/2016
	 * @author Xabier Zabala
	 */
	
	private FileWriter fw;
    private PrintWriter pw;
    
	public FileWrite(FileWriter fw, PrintWriter pw) {
		super();
		this.fw = fw;
		this.pw = pw;
	}

	public FileWriter getFw() {
		return fw;
	}

	public void setFw(FileWriter fw) {
		this.fw = fw;
	}

	public PrintWriter getPw() {
		return pw;
	}

	public void setPw(PrintWriter pw) {
		this.pw = pw;
	}
}
