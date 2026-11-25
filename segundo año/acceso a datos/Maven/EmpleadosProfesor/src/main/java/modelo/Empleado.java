package modelo;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="emp")
public class Empleado {
	
	
	@Id
    @Column(name="EMPNO")
	private int id;
	
	@Column(name="ename")
	private String ename;
	@Column(name="JOB")
	private String job;
	
	@Column(name="MGR")
	private int mgr;
	
	@Column(name="hiredate")
	private Date hireDate;
	
	@Column(name="sal")
	private int sal;
	
	@Column(name="COMM")
	private Double comm;
	
	//@Column(name="deptno")
	@ManyToOne
	@JoinColumn(name = "DEPTNO")
	private Departamento deptno;

	public Empleado() {};
	
	public Empleado(int id, String ename, String job, int mgr, Date hireDate, int sal, Double comm, Departamento deptno) {
		super();
		this.id = id;
		this.ename = ename;
		this.job = job;
		this.mgr = mgr;
		this.hireDate = hireDate;
		this.sal = sal;
		this.comm = comm;
		this.deptno = deptno;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public int getMrg() {
		return mgr;
	}

	public void setMrg(int mrg) {
		this.mgr = mrg;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

	public Double getComm() {
		return comm;
	}

	public void setComm(Double comm) {
		this.comm = comm;
	}

	public Departamento getDepno() {
		return deptno;
	}

	public void setDepno(Departamento deptno) {
		this.deptno= deptno;
	}

	@Override
	public String toString() {
		return "Empleado [id=" + id + ", ename=" + ename + ", job=" + job + ", mrg=" + mgr + ", hireDate=" + hireDate
				+ ", sal=" + sal + ", comm=" + comm + ", depno=" + deptno + "]";
	}
	
	
}
