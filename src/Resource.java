import java.util.List;
import java.util.Scanner;

public class Resource {
	
	protected static String id;
	protected static String begin;
	protected static String end;
	protected static String status;
	protected static String responsible;
	protected static String user;
	Scanner input = new Scanner(System.in);

	public Resource()
	{
		System.out.println("Defina a id do recurso: ");
		this.id = input.nextLine();
		System.out.println("Digite a data inicial do recurso: ");
		this.begin = input.nextLine();
		System.out.println("Digite a data final do recurso: ");
		this.end = input.nextLine();
		System.out.println("Digite o respons�vel pelo recurso: ");
		this.responsible = input.nextLine();
		this.status = "Em processo de aloca��o";
	}	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setBegin(String begin) {
		this.begin = begin;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public void setResponsible(String responsible) {
		this.responsible = responsible;
	}
	public void changeStatus(String status) {
		this.status = status;
	}
	
	public void addResource (){
		
	}
	
	public void updateStatus(String update){
		this.status = update;
	}
	
	

}
