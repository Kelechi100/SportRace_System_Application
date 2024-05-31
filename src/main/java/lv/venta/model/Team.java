package lv.venta.model;

import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
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
@Table(name = "TeamTable")
public class Team {
	// Variables
	@Setter(value = AccessLevel.NONE)
	@Column(name = "IDT")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long  idt;

	@NotNull
	@Pattern(regexp = "[A-Za-z ]+")
	@Size(min = 5, max = 20)
	@Column(name = "Name")
	private String name;
			
	
	@OneToMany(mappedBy = "team") // need to specify title of variable
	@ToString.Exclude // Used to stop unending loop between linked classes
	private Collection<Runner> runner;
	
	@Min(1)
	@Max(1000)
	@Column(name = "POINTS")
	private double points;
	
	public Team(String name, double points) {
		setName(name);
		setPoints(points);
	}
	

}
