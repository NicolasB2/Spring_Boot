package co.edu.icesi;

import lombok.*;

@Getter // Create getters for all fields
@Setter // Create getters for all fields
@AllArgsConstructor // Create a constructor with all fields
@EqualsAndHashCode // Generate the equals and hashCode methods
public class User{

	//this field can´t be null otherwise return null pointer exception with a message
	@NonNull private String firstName;
	//this field appear in auto generated constructor
	@NonNull private String lastName;
	private int age;
}
