package sia.tfm.dbtester.Launcher;

import sia.tfm.dbtester.ConfigManager.ConfigFile;

public class Launcher {

	public static void main(String[] args) {
		
		if(ConfigFile.configFileValidFormat("../DBTester/config/config.txt")){
			System.out.println("YES");
		}else{
			System.out.println("NO");
		}
		

	}

}
