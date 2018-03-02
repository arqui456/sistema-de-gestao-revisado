import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import enums.Activities;
import enums.Types;

//import enums.Activities;

public class User {
		
		Scanner input = new Scanner(System.in);
		int options;
		String answer;
		Activity activity = null;
		private String name;
		private String email;
		private Types type;
		private List<Resource> resources = new ArrayList<Resource>();
		private List<Resource> userResources = new ArrayList<Resource>();
		private List<Activity> Activitiess = new ArrayList<Activity>();
		
		public User(Types type) {
			
			System.out.println("Digite o seu nome:");
			this.name = input.nextLine();
			System.out.println("Digite o seu e-mail:");
			this.email = input.nextLine();
			this.type = type;
		}
		
		public User(String name, String email, Types type) {
			this.name = name;
			this.email = email;
			this.type = type;
		}
		
		public String getEmail() {		
			return email;
		}
		
		public void addActivities(){

        	System.out.println("Escolha o recurso que quer adicionar a atividade: ");
        	resourcesList(resources);
        	answer = input.nextLine();
        	for(Resource currentResource: resources)
        	{
        		System.out.println(currentResource.getId());
    			System.out.println(currentResource.getStatus());
        		if (answer.equals(currentResource.getId())&& currentResource.getStatus().equals("Em andamento"))
        		{
        			 activity =	new Activity(this.type, currentResource);
        			 System.out.println("Atividade cadastrada com sucesso!");
        			 System.out.println();
        			 
        			 return;
        		}
        	}
        	System.out.println("erro na alocacao da atividade!");
		}
		
		public void addResource() {

        	Resource newResource = null;
        	
			if(this.type == Types.ALUNO) {
				
	            System.out.println("Recursos disponiveis:");
	            System.out.println("1 - Sala");
	            options = input.nextInt();
	            while(options != 1) {
	            	System.out.println("Entrada invalida, tente novamente: ");
	            	options = input.nextInt();
	            }
	            //System.out.println("Debug");
	            if(options == 1) {
	            	newResource = new Classroom(this.name);
	            	this.resources.add(newResource);
	            	this.userResources.add(newResource);
	            }
	            
			} else {
				
				System.out.println("Recursos disponiveis:");
	            System.out.println("1 - Sala");
	            System.out.println("2 - Laboratorio");
	            System.out.println("3 - Auditorio");
	            System.out.println("4 - Projetor");
	            options = input.nextInt();
	            while(options < 1 || options > 4) {
	            	System.out.println("Entrada invalida, tente novamente: ");
	            	options = input.nextInt();
	            }
	            
				if(options == 1) {
	            	newResource = new Classroom(this.name);
					this.resources.add(newResource);
	            	this.userResources.add(newResource);
				} else if(options == 2) {
	            	newResource = new Laboratory(this.name);
					this.resources.add(newResource);
	            	this.userResources.add(newResource);
				} else if(options == 3) {
	            	newResource = new Auditory(this.name);
					this.resources.add(newResource);
	            	this.userResources.add(newResource);
				} else if(options == 4) {
	            	newResource = new Projector(this.name);
					this.resources.add(newResource);
	            	this.userResources.add(newResource);
				}
			}
		}

		
		public boolean mainMenu(List<User> signedUsers) 
		{			
			System.out.println("*** Menu Principal ***");
			if(this.type == Types.ALUNO) 
			{				
				System.out.println("1 - Alocar Recursos");
				System.out.println("2 - Sair");
				options = input.nextInt();
				while(options != 1 && options != 2) {
					System.out.println("Entrada invalida, tente novamente: ");
					options = input.nextInt();
				}
				
				if(options == 1) this.addResource();
				else
					return false;
				
			} else if(this.type == Types.PROFESSOR || this.type == Types.PESQUISADOR) 
			{				
				System.out.println("1 - Alocar Recursos");
	            System.out.println("2 - Confirmar recurso");
	            System.out.println("3 - Adicionar atividade aos recursos");
	            System.out.println("4 - Sair");
	            options = input.nextInt();
	            while(options < 1 || options > 4) {
	            	System.out.println("Entrada invalida, tente novamente: ");
	            	options = input.nextInt();
	            }
	            
	            if(options == 1)
	            	this.addResource();
	            else if(options == 2)
	            	this.confirmResource(resources);
	            else if(options == 3)
	            {
	            	this.addActivities();
	            }
	            else 
	            	return false;
	            
			} else {				
				System.out.println("Menu de administrador:");
	            System.out.println("1  - Numero de usuarios");
	            System.out.println("2  - Numero de recursos");
	            System.out.println("3  - Numero de atividades");
	            System.out.println("4  - Consulta por usuario");
	            System.out.println("5  - Consulta por recurso/alocacao");
	            System.out.println("6  - Alocar novo recurso");
	            System.out.println("7  - Comepletar alocacao de recurso");
	            System.out.println("8  - Confirmar alocacao de recurso");
	            System.out.println("9  - Finalizar alocacao de recurso");
	            System.out.println("10 - Adicionar atividades as alocacoes");
	            System.out.println("11 - Sair");
	            options = input.nextInt();
	            while(options < 1 || options > 11) {
	            	System.out.println("Entrada invalida, tente novamente: ");
	            	options = input.nextInt();
	            }
            	input.nextLine();
          	            
	            if(options == 1)
	            	this.usersNumber(signedUsers);
	            else if(options == 2)
	            	this.resourcesNumber(resources);
	            else if(options == 3)
	            	this.activitiesNumber(Activitiess);
	            else if(options == 4)	            	
	            {  	
	            	System.out.println("Qual usuario deseja consultar? (nome)");
	            	answer = input.nextLine();
	            	this.userInfo(answer, signedUsers, userResources);	            	
	            }
	            else if(options == 5)
	            {
	            	System.out.println("Qual recurso deseja consultar? (id)");
	            	answer = input.nextLine();
	            	this.resourceInfo(answer, resources);            	
	            }
	            else if(options == 6)
	            	this.addResource();
	            else if(options == 7)
	            	this.startResource(resources);
	            else if(options == 8)
	            	this.confirmResource(resources);
	            else if(options == 9)
	            	this.resourceFinish(resources);
	            else if(options == 10)
		            this.addActivities();
	            else
	            	return false;
			}
			return true;
		}
		
		private void startResource(List<Resource> resources) {
			System.out.println("Lista de recursos: ");
			
			for(Resource current: resources) {
				if(current.getStatus().equals("Em processo de alocacao")) {
					System.out.println("- " + current.getId());
					System.out.println(" ");
				}
			}
			
			System.out.println("Digite o ID do recurso que voce quer alocar:");
			answer = input.nextLine();
			
			for(Resource current: resources) {
				if(current.getId().equals(answer)){
					current.updateStatus("Alocado");
					System.out.println("Status do recurso alterado para "+"Alocado "+"!");					
				} else {
					System.out.println("Falha na edicao do recurso! :(");
				}
			}
		}

		private void resourceFinish(List<Resource> resources) {
			System.out.println("Lista de recursos: ");
			
			for(Resource current: resources) {
				if(current.getStatus().equals("Em andamento")) {
					System.out.println("- " + current.getId());
					System.out.println(" ");
				}
			}
			
			System.out.println("Digite o ID do recurso que voce quer concluir:");
			answer = input.nextLine();
			
			for(Resource current: resources) {
				if(current.getId().equals(answer)){
					current.updateStatus("Concluido");
					System.out.println("Status do recurso alterado para "+"Conclucao "+"!");					
				} else {
					System.out.println("Falha na edicao do recurso! :(");
				}
			}
		}
		
		public void confirmResource(List<Resource> resources) {
			System.out.println("Lista de recursos:");
			
			for(Resource current: resources) {
				if(current.getStatus().equals("Alocado")) {
					System.out.println("- " + current.getId());
					System.out.println(" ");
				}
			}
			
			System.out.println("Digite o ID do recurso que voce quer confirmar:");
			answer = input.nextLine();
			
			for(Resource current: resources) {
				if(current.getId().equals(answer)){
					current.updateStatus("Em andamento");
					System.out.println("Status do recurso alterado para "+"Em andamento "+"!");					
				} else {
					System.out.println("Falha na edicao do recurso! :(");
				}
			}
		}

		private void userInfo(String user, List<User> signedUsers, List<Resource> userResources) {
			System.out.println(user);
			for(User currentUser: signedUsers)
			{
				if(user == currentUser.name)
	            {
					System.out.println("Nome do usuario: "  + currentUser.name);
					System.out.println("Email do usuario: " + currentUser.email);
					System.out.println("Tipo de usuario: "  + currentUser.type);	            	            	
	            }
			}	
			
			System.out.println("Lista de recursos alocados pelo usuario: ");	  
			for(Resource currentUserResource: userResources) //Imprime lista de recursos alocados pelo User
			{
				System.out.println("- "  + currentUserResource.getId());	            	 
			}			
		}
		
		private void resourceInfo(String resource, List<Resource> resources) {
			for(Resource currentResource: resources)
			{
				if(resource.equals(currentResource.getId()))
	            {
					System.out.println("Id do recurso: "  + currentResource.getId());
					System.out.println("Data de inicio do recurso: " + currentResource.getBegin());
					System.out.println("Data do fim do recurso: "  + currentResource.getEnd());	
					System.out.println("Status do recurso: "  + currentResource.getStatus());	
					System.out.println("Responsavel pelo recurso: "  + currentResource.getResponsible());	            	            	
	            }
				System.out.println("");
			}			
		}
		private void usersNumber(List<User> signedUsers) {
			System.out.println("Numero total de usuarios: " + signedUsers.size());
			for (User current: signedUsers) {
				System.out.println(current);
			}
		}
		private void resourcesNumber(List<Resource> resources) {
			System.out.println("Numero total de recursos: " + resources.size());
		}
		private void activitiesNumber(List<Activity> activities) {
			int tradCounter = 0;
			int presentCounter = 0;
			int labCounter = 0;
			for(Activity currentActivity: activities)
			{
				{
					for(int i = 0; i < activities.size(); i++) 
						if(currentActivity.getActivityType() == Activities.AULA_TRADICIONAL)
							tradCounter++;
						if(currentActivity.getActivityType() == Activities.APRESENTACAO)
							presentCounter++;
						if(currentActivity.getActivityType() == Activities.LABORATORIO)
							labCounter++;
	            }
					System.out.println("Aulas tradicionais: "  + tradCounter);
					System.out.println("Apresentacoes: "  + presentCounter);
					System.out.println("Laboratorios: "  + labCounter);					
	          }	
			System.out.println("Numero total de atividades: " + activities.size());				
		}		

		public void resourcesList(List<Resource> list){
			for(Resource name: list)
				System.out.println("- " + name.getId());
		}

		@Override
		public String toString() {
			return "User [name=" + name + ", email=" + email + ", type=" + type + "]";
		}
		
		
}
