package com.capg.model;

public class Claim {
	private long claimNumber;
	private String claimReason;
	private String incidentLocation;
	private String incidentCity;
	private String incidentState;
	private String incidentZip;
	private String claimType;
	private long policyNumber;

	public Claim() {
	}

	public Claim(long claimNumber, String claimReason, String claimType, long policyNumber) {
		super();
		this.claimNumber = claimNumber;
		this.claimReason = claimReason;
		this.claimType = claimType;
		this.policyNumber = policyNumber;
	}

	public Claim(long claimNumber, String incidentLocation, String incidentCity, String incidentState,
			String incidentZip, String claimType, long policyNumber) {
		super();
		this.claimNumber = claimNumber;
		this.incidentLocation = incidentLocation;
		this.incidentCity = incidentCity;
		this.incidentState = incidentState;
		this.incidentZip = incidentZip;
		this.claimType = claimType;
		this.policyNumber = policyNumber;
	}

	public Claim(long claimNumber, String claimReason, String incidentLocation, String incidentCity,
			String incidentState, String incidentZip, String claimType, long policyNumber) {
		super();
		this.claimNumber = claimNumber;
		this.claimReason = claimReason;
		this.incidentLocation = incidentLocation;
		this.incidentCity = incidentCity;
		this.incidentState = incidentState;
		this.incidentZip = incidentZip;
		this.claimType = claimType;
		this.policyNumber = policyNumber;
	}

	public Claim(String claimReason, String incidentLocation, String incidentCity, String incidentState,
			String incidentZip, String claimType, long policyNumber) {
		super();
		this.claimReason = claimReason;
		this.incidentLocation = incidentLocation;
		this.incidentCity = incidentCity;
		this.incidentState = incidentState;
		this.incidentZip = incidentZip;
		this.claimType = claimType;
		this.policyNumber = policyNumber;
	}

	public long getClaimNumber() {
		return claimNumber;
	}

	public void setClaimNumber(long claimNumber) {
		this.claimNumber = claimNumber;
	}

	public String getClaimReason() {
		return claimReason;
	}

	public void setClaimReason(String claimReason) {
		this.claimReason = claimReason;
	}

	public String getIncidentLocation() {
		return incidentLocation;
	}

	public void setIncidentLocation(String incidentLocation) {
		this.incidentLocation = incidentLocation;
	}

	public String getIncidentCity() {
		return incidentCity;
	}

	public void setIncidentCity(String incidentCity) {
		this.incidentCity = incidentCity;
	}

	public String getIncidentState() {
		return incidentState;
	}

	public void setIncidentState(String incidentState) {
		this.incidentState = incidentState;
	}

	public String getIncidentZip() {
		return incidentZip;
	}

	public void setIncidentZip(String incidentZip) {
		this.incidentZip = incidentZip;
	}

	public String getClaimType() {
		return claimType;
	}

	public void setClaimType(String claimType) {
		this.claimType = claimType;
	}

	public long getPolicyNumber() {
		return policyNumber;
	}

	public void setPolicyNumber(long policyNumber) {
		this.policyNumber = policyNumber;
	}

	@Override
	public String toString() {
		return "Claim [claimNumber=" + claimNumber + ", claimReason=" + claimReason + ", incidentLocation="
				+ incidentLocation + ", incidentCity=" + incidentCity + ", incidentState=" + incidentState
				+ ", incidentZip=" + incidentZip + ", claimType=" + claimType + ", policyNumber=" + policyNumber + "]";
	}
}
