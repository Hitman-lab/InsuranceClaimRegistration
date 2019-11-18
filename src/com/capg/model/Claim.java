package com.capg.model;

public class Claim {
	private Long claimNumber;
	private String claimReason;
	private String incidentLocation;
	private String incidentCity;
	private String incidentState;
	private int incidentZip;
	private String claimType;
	private Long policyNumber;

	public Claim() {
	}

	public Claim(Long claimNumber, String claimReason, String claimType, Long policyNumber) {
		super();
		this.claimNumber = claimNumber;
		this.claimReason = claimReason;
		this.claimType = claimType;
		this.policyNumber = policyNumber;
	}

	public Claim(Long claimNumber, String incidentLocation, String incidentCity, String incidentState, int incidentZip,
			String claimType, Long policyNumber) {
		super();
		this.claimNumber = claimNumber;
		this.incidentLocation = incidentLocation;
		this.incidentCity = incidentCity;
		this.incidentState = incidentState;
		this.incidentZip = incidentZip;
		this.claimType = claimType;
		this.policyNumber = policyNumber;
	}

	public Claim(Long claimNumber, String claimReason, String incidentLocation, String incidentCity,
			String incidentState, int incidentZip, String claimType, Long policyNumber) {
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
			int accidentZip, String claimType, Long policyNumber) {
		super();
		this.claimReason = claimReason;
		this.incidentLocation = incidentLocation;
		this.incidentCity = incidentCity;
		this.incidentState = incidentState;
		this.incidentZip = accidentZip;
		this.claimType = claimType;
		this.policyNumber = policyNumber;
	}

	public Long getClaimNumber() {
		return claimNumber;
	}

	public void setClaimNumber(Long claimNumber) {
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

	public int getIncidentZip() {
		return incidentZip;
	}

	public void setIncidentZip(int incidentZip) {
		this.incidentZip = incidentZip;
	}

	public String getClaimType() {
		return claimType;
	}

	public void setClaimType(String claimType) {
		this.claimType = claimType;
	}

	public Long getPolicyNumber() {
		return policyNumber;
	}

	public void setPolicyNumber(Long policyNumber) {
		this.policyNumber = policyNumber;
	}

	@Override
	public String toString() {
		return "Claim [claimNumber=" + claimNumber + ", claimReason=" + claimReason + ", incidentLocation="
				+ incidentLocation + ", incidentCity=" + incidentCity + ", incidentState=" + incidentState
				+ ", incidentZip=" + incidentZip + ", claimType=" + claimType + ", policyNumber=" + policyNumber + "]";
	}
}
