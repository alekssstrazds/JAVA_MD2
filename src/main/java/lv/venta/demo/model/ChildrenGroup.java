package lv.venta.demo.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.ManyToAny;

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
public class ChildrenGroup {
    @Column(name = "IdGr")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter(value = AccessLevel.NONE)
	private int id_gr;

	@Column(name= "Title")  
    @Pattern(regexp="[A-Z]{1}[a-z\\s]+", message="Must be first capital letter and others small")
	private String title;

    @Column(name = "Year") 
	@Min(2010)
	@Max(2030)
	private int year;

	@ManyToOne
	@JoinColumn(name = "IdTe")
    private Teacher teacher;

	@OneToMany(mappedBy = "group")
	@ToString.Exclude
	private Collection<Child> children;
	
	public ChildrenGroup(String title, int year) {
		this.title = title;
		this.year = year;
	}
}
