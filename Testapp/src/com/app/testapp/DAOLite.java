/* To organize all the specifications  
 * 
 * 
 */
package com.app.testapp;

public class DAOLite {

	private long erno;
	private String name;
	private String middlename;
	private String lastname;

	public DAOLite() {

	}

	public DAOLite(long erno,String name, String middlename, String lastname) {
		this.erno = erno;
		this.name = name;
		this.middlename = middlename;
		this.lastname = lastname;
	}

	public void setErno(long erno) {
		this.erno = erno;
	}

	public long getErno() {
		return erno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMiddlename() {
		return middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
}
