package com.cjp.model;

public class Company {

	private String shortcut;
	private String name;

	@Override
	public String toString() {
		return "Company [Shortcut=" + shortcut + "]";
	}

	public String getShortcut() {
		return shortcut;
	}

	public void setShortcut(String shortcut) {
		this.shortcut = shortcut;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
