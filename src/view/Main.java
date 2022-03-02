package view;



import javax.swing.JOptionPane;

import controller.KillController;

public class Main {
	 public static void main (String []args) {
		 
		 KillController Kill = new KillController();

	//	String os = Kill.os();	
	//	System.out.println(os);
		
		
		
		  int option = 0;
			 do { 
				 option = Integer.parseInt(JOptionPane.showInputDialog(null, "1 - Mostrar Lista de Processos\n" +
			                                                                 "2 - Matar Processo por pid\n"+
			                                                                 "3 - Matar Processo por nome\n"+
	                                                                         "3 - Sair"));
						 
	         	switch(option) {
	         	case 1: 
	         		 String process ="";
	        		 Kill.readProcess(process);
	        		 break;
	            
	         	case 2: 
	         		String Pid = "";
					Kill.KillPid(Pid);
	        		break;
	        		
	         	case 3:
	         		String Nome = "";
	         		Kill.KillNome(Nome);	         		
	         		break;
	         		
	         		
	         	case 4:	
	         		JOptionPane.showInputDialog(null,"Encerrado");
	         		break;
	         		
	   }
	         	} while (option != 3);
	        	
			 }
		 }