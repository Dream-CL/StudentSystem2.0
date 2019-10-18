package com.cl.model;

import java.sql.Date;

/**
 * 	学生.model
 * @author 24829
 *
 */
public class Student {

	private String id;
	private String name;
	private Date birth;
	private int age;
	private String sex;
	private String phone;
	private String umber;
	private String major;
	
	public Student() {
		super();
	}
	
	public Student(String id, String name, Date birth, int age, String sex, String phone, String umber,
			String major) {
		super();
		this.id = id;
		this.name = name;
		this.birth = birth;
		this.age = age;
		this.sex = sex;
		this.phone = phone;
		this.umber = umber;
		this.major = major;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((major == null) ? 0 : major.hashCode());
		result = prime * result + age;
		result = prime * result + ((birth == null) ? 0 : birth.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((umber == null) ? 0 : umber.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((sex == null) ? 0 : sex.hashCode());
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
		Student other = (Student) obj;
		if (major == null) {
			if (other.major != null)
				return false;
		} else if (!major.equals(other.major))
			return false;
		if (age != other.age)
			return false;
		if (birth == null) {
			if (other.birth != null)
				return false;
		} else if (!birth.equals(other.birth))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (umber == null) {
			if (other.umber != null)
				return false;
		} else if (!umber.equals(other.umber))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (sex == null) {
			if (other.sex != null)
				return false;
		} else if (!sex.equals(other.sex))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", birth=" + birth + ", age=" + age + ", sex=" + sex
				+ ", phone=" + phone + ", umber=" + umber + ", major=" + major + "]";
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getumber() {
		return umber;
	}
	public void setumber(String umber) {
		this.umber = umber;
	}
	public String getmajor() {
		return major;
	}
	public void setmajor(String major) {
		this.major = major;
	}
	
}
