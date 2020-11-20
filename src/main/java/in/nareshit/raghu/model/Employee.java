package in.nareshit.raghu.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="emptab")
public class Employee {
	@Id
	@GeneratedValue
	private Integer eid;
	
	private String ename;
	private String email;
	
	private Double esal;
	private String dept;
	
	private Double hra;
	private Double da;
	
}
