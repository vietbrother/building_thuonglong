package com.api.thuonglongjsc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sp_LoadChiNhanhDaiLy")
public class Sp_LoadChiNhanhDaiLy {
	private String ID;
	private String Ten;

	public Sp_LoadChiNhanhDaiLy() {
		super();
	}

	public Sp_LoadChiNhanhDaiLy(String iD, String ten) {
		super();
		ID = iD;
		Ten = ten;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	@Column(name = "Ten")
	public String getTen() {
		return Ten;
	}

	public void setTen(String ten) {
		Ten = ten;
	}

	@Override
	public String toString() {
		return "Sp_LoadChiNhanhDaiLy [ID=" + ID + ", Ten=" + Ten + "]";
	}

}
