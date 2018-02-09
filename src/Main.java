import java.util.*;



public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		List<User> signedUsers = new ArrayList<User>();
		boolean logged = false;
		boolean running = true;
		boolean check;
		String userEmail;
		Scanner input = new Scanner(System.in);
		int signUp;
		User current = null;
		while(running)
		{
			System.out.println("Seja bem vindo ao sistema de gestao de recursos!");
			System.out.println();
			System.out.println("Você ja esta cadastrado?");
			System.out.println("1 - sim");
			System.out.println("2 - nao");
			System.out.println();
			signUp = input.nextInt();
			userEmail = null;
			if(signUp == 1) {
				
				System.out.println("Digite o seu email:");
            	input.nextLine();
            	userEmail = input.nextLine();
            	System.out.println(userEmail);
            	
            	for(User count: signedUsers) {            		
            		if(count.getEmail().equals(userEmail)) current = count; 
            	}
            	if(current == null) System.out.println("Falha no login. Email não encontrado! :(");
            	else
            	{
            		System.out.println("Login efetuado com sucesso! yayyy :D");
            		logged = true;
            		while(logged)
            		{
            			current.mainMenu(signedUsers);
            			
            			System.out.println("Você deseja deslogar? (true = sim / false = nÃ£o)");
                        check = input.nextBoolean();
                        
                        if(check) {
                        	logged = false;
                        	current = null;
                        } 
            		}
            		
            	}
			}
			else {
            	System.out.println("Qual o seu nível de acesso?");
            	System.out.println("1 - Aluno");
            	System.out.println("2 - Professor");
            	System.out.println("3 - Pesquisador");
            	System.out.println("4 - Administrador");
            	signUp = input.nextInt();
            	if(signUp == 1)
            	{
                	System.out.println("1 - graduação");
                	System.out.println("2 - mestrado");
                	System.out.println("3 - doutorado");
            	}
            	boolean done = signedUsers.add(new User(signUp));
            	if(done) System.out.println("Cadastro feito com sucesso.");
            	else System.out.println("Cadastro deu errado, tente novamente mais tarde.");
			}
			//System.out.println("Deseja continuar? (true or false)");
			//running = input.nextBoolean();
		
		}

	}

}
