package com.bjsxt.pojo;

import java.util.ArrayList;

public class User {
	private String uname;
	private int age;
	private ArrayList<String> fav;
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public ArrayList<String> getFav() {
		return fav;
	}
	public void setFav(ArrayList<String> fav) {
		this.fav = fav;
	}
	@Override
	public String toString() {
		return "User [uname=" + uname + ", age=" + age + ", fav=" + fav + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((fav == null) ? 0 : fav.hashCode());
		result = prime * result + ((uname == null) ? 0 : uname.hashCode());
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
		User other = (User) obj;
		if (age != other.age)
			return false;
		if (fav == null) {
			if (other.fav != null)
				return false;
		} else if (!fav.equals(other.fav))
			return false;
		if (uname == null) {
			if (other.uname != null)
				return false;
		} else if (!uname.equals(other.uname))
			return false;
		return true;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String uname, int age, ArrayList<String> fav) {
		super();
		this.uname = uname;
		this.age = age;
		this.fav = fav;
	}
	
	
}
