package co.edu.icesi.model;

import lombok.Data;
import lombok.NonNull;

@Data
public class Student {
	@NonNull
	private String id;
	private String firstName;
	private String lastName;
}
