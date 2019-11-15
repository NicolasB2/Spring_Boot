package co.edu.icesi;

import lombok.*;

@Getter // Create getters for all fields
@Setter // Create getters for all fields
@NoArgsConstructor // Create an empty constructor
@ToString(includeFieldNames=true) // create the ToString methods whit the name of fields 
public class Stuff {
	
	//This field can't appear in toString method
	@ToString.Exclude private double price;
	private String name;
	private String clasification;
}
