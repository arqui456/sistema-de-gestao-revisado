import java.util.*;

import inputChecker.Checker;
import enums.Types;

public class Main {
	public static void main(String[] args) {
		
		List<User> signedUsers = new ArrayList<User>();
		
		// Usuarios para testes //
		signedUsers.add(new User("Derpino","D@ic.ufal.br",Types.ALUNO));
		signedUsers.add(new User("Ambrosino","A@ic.ufal.br", Types.PROFESSOR));
		signedUsers.add(new User("Bob", "B@ic.ufal.br", Types.PESQUISADOR));
		signedUsers.add(new User("Ademir","Ad@ic.ufal.br", Types.ADMINISTRADOR));
		//////////////////////////
		
		boolean logged = false;
		boolean running = true;
		Checker choice;
		String userEmail;
		Scanner input = new Scanner(System.in);
		Checker signUp;
		User current = null;
		while(running)
		{	
			System.out.println("Seja bem vindo ao sistema de gestao de recursos!");
			System.out.println();
			System.out.println("Voce ja esta cadastrado?");
			System.out.println("1 - sim");
			System.out.println("2 - nao");
			System.out.println("3 - Sair");
			System.out.println();
			signUp = new Checker();
			userEmail = null;
			if(signUp.signCheck() == 1) {
				
				System.out.println("Digite o seu email: ");
            	//input.nextLine();
            	userEmail = input.nextLine();
            	System.out.println(userEmail);
            	
            	for(User count: signedUsers) {            		
            		if(count.getEmail().equals(userEmail)) current = count; 
            	}
            	if(current == null) System.out.println("Falha no login. Email nao encontrado!");
            	else
            	{
            		System.out.println("Login efetuado com sucesso!");
            		logged = true;
            		while(logged)
            		{
            			current.mainMenu(signedUsers);
            			System.out.println("Voce deseja deslogar? (1 = sim / 0 = nao)");
            			choice = new Checker();
                        //check = input.nextBoolean();
                        
                        if(choice.logoutCheck() == 1) {
                        	logged = false;
                        	current = null;
                        } 
            		}
            		
            	}
			}
			else if(signUp.signCheck() == 2) {
            	System.out.println("Qual o seu nivel de acesso?");
            	System.out.println("1 - Aluno");
            	System.out.println("2 - Professor");
            	System.out.println("3 - Pesquisador");
            	System.out.println("4 - Administrador");
            	choice = new Checker();
            	
            	if(choice.typeCheck() == 1)
            	{
                	System.out.println("1 - graduacao");
                	System.out.println("2 - mestrado");
                	System.out.println("3 - doutorado");
                	int subtype = input.nextInt();
            	}
            	
            	
            	Types type = choice.getType();
            	boolean done = signedUsers.add(new User(type));
            	if(done) System.out.println("Cadastro feito com sucesso.");
            	else System.out.println("Cadastro deu errado, tente novamente mais tarde.");
			}
			else 
				running = false;
			//System.out.println("Deseja continuar? (true or false)");
			//running = input.nextBoolean();
		}
		input.close();
	}
}
