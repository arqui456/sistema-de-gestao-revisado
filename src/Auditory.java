
public class Auditory extends Resource {
	
	public Auditory(String userAloc)
	{		
		super();
		this.user = userAloc; 
		System.out.println("Recurso alocado com sucesso! (auditory): " + this.user + "!" +  Auditory.status );
	}
}
