package com.lbg.demo.domain;

import java.util.Objects;

public class Family {
	@Override
	public int hashCode() {
		return Objects.hash(name, profession, relation);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Family other = (Family) obj;
		return Objects.equals(name, other.name) && Objects.equals(profession, other.profession)
				&& Objects.equals(relation, other.relation);
	}

	private String name;
	private String relation;
	private String profession;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	@Override
	public String toString() {
		return "Family [name=" + name + ", relation=" + relation + ", profession=" + profession + "]";
	}

}
