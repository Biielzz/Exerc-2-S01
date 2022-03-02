package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class KillController {
	
	public String os() {
		String os = System.getProperty("os.name");
		return os;
	}
	
	public void initProcess(String process) {
		try {
			Runtime.getRuntime().exec(process);
		} catch (Exception e) {
			String erro = e.getMessage();
			if (erro.contains("2")) {
				System.err.println("Aplicação não encontrada");
			}
			if (erro.contains("740")) {
				StringBuffer buffer = new StringBuffer();
				buffer.append("cmd /c");
				buffer.append(" ");
				buffer.append(process);

				String cmdCred = buffer.toString();

				try {
					Runtime.getRuntime().exec(cmdCred);
				} catch (Exception e1) {
					System.err.println("Chamada de aplicação inválida");
				
				}
			}
		}
		
		}
			public void readProcess(String process) {
			  	try {
			  		Process p = Runtime.getRuntime().exec(process);
			  		InputStream fluxo = p.getInputStream();
			  		InputStreamReader leitor = new InputStreamReader(fluxo);
			  		BufferedReader buffer = new BufferedReader(leitor);
			  		String linha = buffer.readLine();
			  		while (linha != null) {
			  			System.out.println(linha);
			  			linha = buffer.readLine();
			  		}
			  		buffer.close();
			  		leitor.close();
			  		fluxo.close();
			  	} catch (IOException e) {
			  		System.err.println("Chamada inválida");
			  		e.printStackTrace();
			  	}
			  	}
	
public void KillPid(String pid) {
	String os = System.getProperty("os.name");
	String cmdPid = "";
	if (os().contains("Windows")) {
		cmdPid = "TASKKILL /PID " + pid;
	
	
	if(os().contains("Linux")) {
		cmdPid = "kill -9 " + pid;
				
					
}
	
	StringBuffer buffer = new StringBuffer();
	try {
		buffer.append(cmdPid);
		//buffer.append(pid);
	}
	catch
	(NumberFormatException e) {
		System.out.println("Erro de formatacao: "+ e.getMessage());
		buffer.append(pid);
		buffer.append(os);
		
	}
	initProcess(buffer.toString());
    }
}




public void KillNome (String Nome) {
	
	 String os = System.getProperty("os.name");
	 String cmdNome = "";
	 if (os.contains("Windows")) {
		 cmdNome = "TASKKILL /IM " + Nome; 
		 
	 }
	 if (os.contains("Linux")) {
		 cmdNome = "pkill -f" + Nome;
		 
	 }
	   
	   StringBuffer buffer = new StringBuffer();
	   try{
		
		  // buffer.append(cmdPid );
		 //  buffer.append(pid);
		  buffer.append(cmdNome);
	   }
	   catch(NumberFormatException e) {
		   System.out.println("Erro de formatacao: "+ e.getMessage());
		   buffer.append(Nome);
		   buffer.append(os);
	   }
	   
	   initProcess(buffer.toString());
} 

}




