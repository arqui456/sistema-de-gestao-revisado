import java.util.List;

public class Classroom extends Resource {
	
	int type;
		
	public Classroom(String userAloc)
	{	
		super();
		this.user = userAloc; 
		System.out.println("Recurso alocado com sucesso," + this.user + "!" + Classroom.status );
	}
}
