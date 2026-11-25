package modelo;

import java.nio.channels.IllegalBlockingModeException;
import java.util.List;

import javax.naming.CompoundName;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="dept")
public class Departamento {

	
	@Id
	@Column(name="deptno")
	private int deptno;
	
	@Column(name="dname")
	private String dname;

	@Column(name="loc")
	private String loc;

	@OneToMany(mappedBy = "deptno")
    private List<Empleado> empleados;
	
	
	public Departamento() {}
	 
	public Departamento(int deptno, String dname, String loc) {
		super();
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}
	
	

	@Override
	public String toString() {
		return "Departamento [deptno=" + deptno + ", dname=" + dname + ", loc=" + loc + "]";
	}
	
	
	
}
