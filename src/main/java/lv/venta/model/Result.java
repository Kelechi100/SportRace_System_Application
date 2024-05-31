package lv.venta.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
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
@Table(name = "ResultTable")
public class Result {
	@Setter(value = AccessLevel.NONE)
	@Column(name = "IDRE")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private long idre;
	
	
	@Min(1)
	@Max(1000)
	@Column(name = "TIMEINMINUTES")
	private int timeInMinutes;
	
	// Creating Linkage between two classes(Grades/ Student)
	@ManyToOne // need to specify the varaiable title
	@JoinColumn(name = "IDRU")
	private Runner runner;
	
	// Creating Linkage between two classes(Grades/ Student)
	@ManyToOne // need to specify the varaiable title
	@JoinColumn(name = "IDRA")
	private Race race;
	
	
	public Result(int timeInminutes) {
		setTimeInMinutes(timeInminutes);
	}

}
