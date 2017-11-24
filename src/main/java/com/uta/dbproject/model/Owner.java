package com.uta.dbproject.model;

public class Owner {

	
	private int ownerId;
	private String ownerName;
	private int ownerTypeId;
	
	public int getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public int getOwnerTypeId() {
		return ownerTypeId;
	}
	public void setOwnerTypeId(int ownerTypeId) {
		this.ownerTypeId = ownerTypeId;
	}
	
	@Override
	public String toString() {
		return "Owner [ownerId=" + ownerId + ", ownerName=" + ownerName + ", ownerTypeId=" + ownerTypeId + "]";
	}
	
}
