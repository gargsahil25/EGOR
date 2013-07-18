package com.egor.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table (name="LOGIN_DETAILS")
public class Groups {
	
	private int groupId;
	private String groupName;
	
	private Date creationDate;
	private Date lastUpdationDate;
	
	@Id
	@Column(name="GROUP_ID")
	public int getGroupId() {
		return groupId;
	}
	
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	
	@Column(name="GROUP_NAME")
	public String getGroupName() {
		return groupName;
	}
	
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	
	@Column(name="CREATION_DATE")
	public Date getCreationDate() {
		return creationDate;
	}
	
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	@Column(name="LAST_UPDATION_DATE")
	public Date getLastUpdationDate() {
		return lastUpdationDate;
	}
	
	public void setLastUpdationDate(Date lastUpdationDate) {
		this.lastUpdationDate = lastUpdationDate;
	}
	
}
