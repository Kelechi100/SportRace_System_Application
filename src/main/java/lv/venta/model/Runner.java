package lv.venta.model;

import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@Table(name = "RunnerTable")
public class Runner {
	// Variables
		@Setter(value = AccessLevel.NONE)
		@Column(name = "IDRU")
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private long  idru;

		@NotNull
		@Pattern(regexp = "[A-Z]{1}[a-z]+")
		@Size(min = 2, max = 20)
		@Column(name = "Name")
		private String name;
		
		// Creating Linkage between two classes(Grades/ Student)
		@ManyToOne // need to specify the varaiable title
		@JoinColumn(name = "IDT")
		private Team team;
		
		@OneToMany(mappedBy = "runner") // need to specify title of variable
		@ToString.Exclude // Used to stop unending loop between linked classes
		private Collection<Result> results;

		@NotNull
		@Pattern(regexp = "[A-Z]{1}[a-z]+")
		@Size(min = 2, max = 10)
		@Column(name = "Surname")
		private String Surname;
		
		public Runner(String name, String surname) {
			setName(name);
			setSurname(surname);
		}
	


}
