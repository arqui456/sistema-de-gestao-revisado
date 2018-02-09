import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User {
		
		Scanner input = new Scanner(System.in);
		int options;
		String answer;
		Activity activity = null;
		private String name;
		private String email;
		private int type;
		private List<Resource> resources = new ArrayList<Resource>();
		private List<Resource> userResources = new ArrayList<Resource>();
		private List<Activity> Activities = new ArrayList<Activity>();
		public User(int type) {
			
			System.out.println("Digite o seu nome:");
			this.name = input.nextLine();
			System.out.println("Digite o seu e-mail:");
			this.email = input.nextLine();
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
        		if (answer == currentResource.id && currentResource.status == "Em andamento")
        		{
        			 activity =	new Activity(this.type, currentResource);
        			 System.out.println("Atividade cadastrada com sucesso!");
        			 System.out.println();
        		}
        		else{
        			System.out.println("erro na aloca��o da atividade!");
        		}
        	}
		}
		
		public void addResource() {

        	Resource newResource = null;
        	
			if(this.type == 1) {
				
	            System.out.println("Recursos dispon�veis:");
	            System.out.println("1 - Sala");
	            options = input.nextInt();
	            System.out.println("Degub");
	            if(options == 1) {
	            	newResource = new Classroom(this.name);
	            	this.resources.add(newResource);
	            	this.userResources.add(newResource);
	            }
	            
			} else {
				
				System.out.println("Recursos dispon�veis:");
	            System.out.println("1 - Sala");
	            System.out.println("2 - Laborat�rio");
	            System.out.println("3 - Audit�rio");
	            System.out.println("4 - Projetor");
	            options = input.nextInt();
	            
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

		
		public void mainMenu(List<User> signedUsers) 
		{			
			System.out.println("*** Menu Principal ***");
			if(this.type == 1) 
			{				
				System.out.println("1 - Alocar Recursos");
				System.out.println("2 - Sair");
				options = input.nextInt();
				
				if(options == 1) this.addResource();
				
			} else if(this.type == 2 || this.type == 3) 
			{				
				System.out.println("1 - Alocar Recursos");
	            System.out.println("2 - Confirmar recurso");
	            System.out.println("3 - Adicionar atividade aos recursos");
	            System.out.println("4 - Sair");
	            options = input.nextInt();
	            
	            if(options == 1)
	            	this.addResource();
	            else if(options == 2)
	            	this.confirmResource(resources);
	            else if(options == 3)
	            {
	            	this.addActivities();
	            }
	            
			} else {				
				System.out.println("Menu de administrador:");
	            System.out.println("1  - N�mero de usu�rios");
	            System.out.println("2  - N�mero de recursos");
	            System.out.println("3  - N�mero de atividades");
	            System.out.println("4  - Consulta por usu�rio");
	            System.out.println("5  - Consulta por recurso/aloca��o");
	            System.out.println("6  - Alocar novo recurso");
	            System.out.println("7  - Come�ar aloca��o de recurso");
	            System.out.println("8  - Confirmar aloca��o de recurso");
	            System.out.println("9  - Finalizar aloca��o de recurso");
	            System.out.println("10 - Adicionar atividades as aloca��es");
	            System.out.println("11 - Sair");
	            options = input.nextInt();
            	input.nextLine();
          	            
	            if(options == 1)
	            	this.usersNumber(signedUsers);
	            else if(options == 2)
	            	this.resourcesNumber(resources);
	            else if(options == 3)
	            	this.activitiesNumber(Activities);
	            else if(options == 4)	            	
	            {  	
	            	System.out.println("Qual usu�rio deseja consultar? (nome)");
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
			}
		}

		private void startResource(List<Resource> resources) {
			// TODO Auto-generated method stub
			System.out.println("Lista de recursos: ");
			
			for(Resource current: resources) {
				if(current.getStatus().equals("Em processo de aloca��o")) {
					System.out.println("- " + current.id);
					System.out.println(" ");
				}
			}
			
			System.out.println("Digite o ID do recurso que voc� quer alocar:");
			answer = input.nextLine();
			
			for(Resource current: resources) {
				if(current.getId().equals(answer)){
					current.updateStatus("Alocado");
					System.out.println("Status do recurso alterado para "+"Alocado "+"!");					
				} else {
					System.out.println("Falha na edi��o do recurso! :(");
				}
			}
		}

		private void resourceFinish(List<Resource> resources) {
			System.out.println("Lista de recursos: ");
			
			for(Resource current: resources) {
				if(current.getStatus().equals("Em andamento")) {
					System.out.println("- " + current.id);
					System.out.println(" ");
				}
			}
			
			System.out.println("Digite o ID do recurso que voc� quer concluir:");
			answer = input.nextLine();
			
			for(Resource current: resources) {
				if(current.getId().equals(answer)){
					current.updateStatus("Concluido");
					System.out.println("Status do recurso alterado para "+"Conclu�do "+"!");					
				} else {
					System.out.println("Falha na edi��o do recurso! :(");
				}
			}

		}
		
		
		public void confirmResource(List<Resource> resources) {
			System.out.println("Lista de recursos:");
			
			for(Resource current: resources) {
				if(current.getStatus().equals("Alocado")) {
					System.out.println("- " + current.id);
					System.out.println(" ");
				}
			}
			
			System.out.println("Digite o ID do recurso que voc� quer confirmar:");
			answer = input.nextLine();
			
			for(Resource current: resources) {
				if(current.getId().equals(answer)){
					current.updateStatus("Em andamento");
					System.out.println("Status do recurso alterado para "+"Em andamento "+"!");					
				} else {
					System.out.println("Falha na edi��o do recurso! :(");
				}
			}

		}

		private void userInfo(String user, List<User> signedUsers, List<Resource> userResources) {
			// TODO Auto-generated method stub
			System.out.println(user);
			for(User currentUser: signedUsers)
			{
				if(user == currentUser.name)
	            {
					System.out.println("Nome do usu�rio: "  + currentUser.name);
					System.out.println("Email do usu�rio: " + currentUser.email);
					System.out.println("Tipo de usu�rio: "  + currentUser.type);	            	            	
	            }
			}	
			System.out.println("Lista de recursos alocados pelo usu�rio: ");	  
			for(Resource currentUserResource: userResources) //Imprime lista de recursos alocados pelo User
			{
				System.out.println("- "  + currentUserResource.id);	            	 
			}			
		}
		
		// BUG AQUI>>> N�O T� MOSTRANDO AS INFORMA��ES DOS RECURSOS!!!!
		private void resourceInfo(String resource, List<Resource> resources) {
			// TODO Auto-generated method stub
			for(Resource currentResource: resources)
			{
				if(resource.equals(currentResource.id))
	            {
					System.out.println("Id do recurso: "  + currentResource.id);
					System.out.println("Data de in�cio do recurso: " + currentResource.begin);
					System.out.println("Data do fim do recurso: "  + currentResource.end);	
					System.out.println("Status do recurso: "  + currentResource.status);	
					System.out.println("Respons�vel pelo recurso: "  + currentResource.responsible);	            	            	
	            }
				System.out.println("");
			}			
		}
		private void usersNumber(List<User> signedUsers) {
			System.out.println("N�mero total de usu�rios: " + signedUsers.size());
		}
		private void resourcesNumber(List<Resource> resources) {
			System.out.println("N�mero total de recursos: " + resources.size());
		}
		private void activitiesNumber(List<Activity> activities) {
			int tradCounter = 0;
			int presentCounter = 0;
			int labCounter = 0;
			for(Activity currentActivity: activities)
			{
				{
					for(int i = 0; i < activities.size(); i++)
						if(currentActivity.getActivityType() == 1)
							tradCounter++;
						if(currentActivity.getActivityType() == 2)
							presentCounter++;
						if(currentActivity.getActivityType() == 3)
							labCounter++;
	            }
					System.out.println("Aulas tradicionais: "  + tradCounter);
					System.out.println("Apresenta��es: "  + presentCounter);
					System.out.println("Laborat�rios: "  + labCounter);					
	          }	
			System.out.println("N�mero total de atividades: " + activities.size());				
		}		

		public void resourcesList(List<Resource> list){
			for(Resource name: list)
				System.out.println("- " + name.id);
		}
}
