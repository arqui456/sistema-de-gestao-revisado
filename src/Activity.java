import java.util.Scanner;

import enums.Activities;
import enums.Types;

public class Activity {
	
	Scanner input = new Scanner(System.in);
	int numberQuestions;
	
	private String title;
	private String info;
	private String members;
	private String support;
	
	private int choice;
	
	private Activities activityType;
	
	Types type;
	
	public Activities getActivityType() {
		return activityType;
	}

	public Activity(Types type, Resource resource) {
		System.out.println("Insira titulo da sua atividade: ");
		this.title = input.nextLine();
		System.out.println("Descreva as informacoes da atividade: ");
		this.info = input.nextLine();
		System.out.println("Digite os participantes da atividade: ");
		this.members = input.nextLine();
		System.out.println("Digite o acesso ao material de apoio: ");
		this.support = input.nextLine();
		
		if(type == Types.PROFESSOR){
			System.out.println("Qual o tipo da atividade?");
			System.out.println("1 - Aula tradicional");
			System.out.println("2 - Apresentacao");
			System.out.println("3 - Laboratorio");
			
			this.choice = input.nextInt();
			while(choice < 1 || choice > 3) {
				System.out.println("Entrada invalida, tente novamente: ");
				this.choice = input.nextInt();
			}
			
			switch (choice) {
			    case 1:
			    	this.activityType = Activities.AULA_TRADICIONAL;
			    	break;
			    case 2:
			    	this.activityType = Activities.APRESENTACAO;
			    	break;
			    case 3:
			    	this.activityType = Activities.LABORATORIO;
			    	break;
			}
		}	
		else {
			System.out.println("Qual o tipo da atividade?");
			System.out.println("1 - Apresentacao");
			
			this.choice = input.nextInt();
			while(choice != 1) {
				System.out.println("Entrada invalida, tente novamente: ");
				this.choice = input.nextInt();
			}
			this.activityType = Activities.APRESENTACAO;
		}
	}
	
	public void activityConsult() {
		System.out.println("Informacoes sobre a atividade:");
		System.out.println(this.title);
		System.out.println(this.info);
		System.out.println(this.members);
		System.out.println(this.support);
		System.out.println(this.activityType);
	}
}
