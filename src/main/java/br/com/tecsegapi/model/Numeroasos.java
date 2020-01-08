package br.com.tecsegapi.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "numeroasos")
public class Numeroasos  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
	@Column(name = "total")
	private int total;
	@Column(name = "vencidos")
	private int vencidos;
	@Column(name = "vencer90")
	private int vencer90;
	@Column(name = "vencer90m")
	private int vencer90m;
	
	public Numeroasos() {
	
	}
	
	

	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getVencidos() {
		return vencidos;
	}

	public void setVencidos(int vencidos) {
		this.vencidos = vencidos;
	}

	public int getVencer90() {
		return vencer90;
	}

	public void setVencer90(int vencer90) {
		this.vencer90 = vencer90;
	}

	public int getVencer90m() {
		return vencer90m;
	}

	public void setVencer90m(int vencer90m) {
		this.vencer90m = vencer90m;
	}

	@Override
	public String toString() {
		return "Numeroasos [total=" + total + ", vencidos=" + vencidos + ", vencer90=" + vencer90 + ", vencer90m="
				+ vencer90m + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + total;
		result = prime * result + vencer90;
		result = prime * result + vencer90m;
		result = prime * result + vencidos;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Numeroasos other = (Numeroasos) obj;
		if (total != other.total)
			return false;
		if (vencer90 != other.vencer90)
			return false;
		if (vencer90m != other.vencer90m)
			return false;
		if (vencidos != other.vencidos)
			return false;
		return true;
	}
	
	
	
	
	

}
