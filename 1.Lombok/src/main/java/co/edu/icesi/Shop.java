package co.edu.icesi;

import java.io.*;
import java.util.ArrayList;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.*;

@SpringBootApplication
@Data // Direct access for: @ToString, @EqualsAndHashCode, @Getteren, @Setteren y @RequiredArgsConstructor
public class Shop {
	
	private BufferedReader br;
	private ArrayList<User> users;
	private ArrayList<Stuff> stuffs;
	
	public Shop() throws IOException{
		
		// A given resource is automatically cleaned up before the code execution
		@Cleanup 
		InputStreamReader in = new InputStreamReader(System.in);
		this.br = new BufferedReader(new InputStreamReader(System.in));
		this.users = new ArrayList<>();
		this.stuffs = new ArrayList<>();
	}
	
	public Stuff generate_Stuff() {
		Stuff s = new Stuff();
		s.setClasification("videoGame");
		s.setName("PlayStation4");
		s.setPrice(1000000.0);
		return s;
	}
	
	public User generate_User() {
		User u = new User("Nicolas", "Biojo", 18);
		return u;
	}
	
	public String toString_Example() {
		return generate_Stuff().toString();
	}
	
	public boolean equals_Example() {
		User a = generate_User();
		User b = a;
		return a.equals(b);
	}
	
	public void nonNull_Example() {
		User u = new User(null, null, 0);
		u.getFirstName();
	}
	
	public static void main(String[] args) {
		try {
			
			Shop shop = new Shop();
			System.out.println(shop.equals_Example());
			System.out.println(shop.toString_Example());
			shop.nonNull_Example();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}
