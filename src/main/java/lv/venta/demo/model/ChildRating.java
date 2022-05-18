package lv.venta.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Table
@Entity
public class ChildRating {
    @Column(name = "IdRat")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter(value = AccessLevel.NONE)
	private int id_rat;

    @Column(name= "EvaluationTitle")  
    @Pattern(regexp="[A-Z]{1}[a-z\\s]+", message="Must be first capital letter and others small")
	private String evaluation_title;

    @Column(name= "Value") 
	@Min(0)
	@Max(10)
	private int value;

    public ChildRating(String evaluation_title, int value) {
        this.evaluation_title = evaluation_title;
        this.value = value;
    }
}
