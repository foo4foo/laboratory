package lab.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "chemicals")
public class Chemical {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private  Long id;
	@NotNull
	private  Long shelf; 
	@NotNull
	private  Long sub_id;
	@NotNull
	@Column(unique = true)
	private  String name;
	@NotNull
	private  String latin_name;
	@NotNull
	@Column(unique = true)
	private  String formula;
	@NotNull
	private  String type;
	@NotNull
	private  double molecular_mass;
	@NotNull
	private  double amount;
	@NotNull
	private  String unit;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getShelf() {
		return shelf;
	}
	public void setShelf(Long shelf) {
		this.shelf = shelf;
	}
	public Long getSub_id() {
		return sub_id;
	}
	public void setSub_id(Long sub_id) {
		this.sub_id = sub_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLatin_name() {
		return latin_name;
	}
	public void setLatin_name(String latin_name) {
		this.latin_name = latin_name;
	}
	public String getFormula() {
		return formula;
	}
	public void setFormula(String formula) {
		this.formula = formula;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getMolecular_mass() {
		return molecular_mass;
	}
	public void setMolecular_mass(double molecular_mass) {
		this.molecular_mass = molecular_mass;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	
}
