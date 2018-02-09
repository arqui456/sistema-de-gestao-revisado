import java.util.Scanner;

public class Activity {
	
	Scanner input = new Scanner(System.in);
	int numberQuestions;
	
	private String title;
	private String info;
	private String members;
	private String support;
	public int getActivityType() {
		return activityType;
	}

	private int activityType;	
	
	public Activity(int type, Resource resource) {
		System.out.println("Insira título da sua atividade: ");
		this.title = input.nextLine();
		System.out.println("Descreva as informações da atividade: ");
		this.info = input.nextLine();
		System.out.println("Digite os participantes da atividade: ");
		this.members = input.nextLine();
		System.out.println("Digite o acesso ao material de apoio: ");
		this.support = input.nextLine();
		
		if(type == 2){
			System.out.println("Qual o tipo da atividade?");
			System.out.println("1 - Aula tradicional");
			System.out.println("2 - Apresentação");
			System.out.println("3 - Laboratório");
			this.activityType = input.nextInt();
		}	
		else {
			System.out.println("Qual o tipo da atividade?");
			System.out.println("1 - Apresentação");
			this.activityType = input.nextInt();
		}
	}
	
	public void activityConsult() {
		System.out.println("Informações sobre a atividade:");
		System.out.println(this.title);
		System.out.println(this.info);
		System.out.println(this.members);
		System.out.println(this.support);
		System.out.println(this.activityType);
	}
}
