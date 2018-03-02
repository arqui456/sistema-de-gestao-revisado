package inputChecker;

import java.util.Scanner;

import enums.Types;

public class Checker {
	
	Scanner input = new Scanner(System.in);
	private int choice;
	private int typeChoice;
	private int signChoice;
	
	public Checker() {
		
	}
	
	public int signCheck(){
		
		signChoice = input.nextInt();
		
		while(signChoice != 1 && signChoice != 2 && signChoice != 3) {
			System.out.println("Entrada invalida, tente novamente");
			signChoice = input.nextInt();
		}
		
		return signChoice; 
		
	}
	
	public int logoutCheck() {
		
		choice = input.nextInt();
		
		while(choice != 1 && choice != 0) {
			System.out.println("Entrada invalida, tente novamente: ");
			choice = input.nextInt(); 
		}
		return choice;
	}
	
	public int typeCheck() {
		
		int choice = input.nextInt();
		
		while(choice < 1 || choice > 4) {
			System.out.println("Entrada invalida, tente novamente: ");
			choice = input.nextInt();
		}
		this.typeChoice = choice;
		return choice;
	}
	
	public Types getType() {
		Types type = null;
		
		switch (this.typeChoice){
			case 1:
			type = Types.ALUNO;
			break;
			case 2:
			type = Types.PROFESSOR;
			break;
			case 3:
			type = Types.PESQUISADOR;
			break;
			case 4:
			type = Types.ADMINISTRADOR;
			break;
		}
		
		return type;
	}
}
