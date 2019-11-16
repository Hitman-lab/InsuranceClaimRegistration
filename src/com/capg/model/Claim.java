package com.capg.model;

public class Claim {

	private long claimNumber;
	private String claimReason;
	private String accidentLocation;
	private String accidentCity;
	private String accidentState;
	private long accidentZip;
	private String claimType;
	private long policyNumber;

	public Claim() {
	}

	public Claim(Long claimNumber, String claimReason, String claimType, Long policyNumber) {
		super();
		this.claimNumber = claimNumber;
		this.claimReason = claimReason;
		this.claimType = claimType;
		this.policyNumber = policyNumber;
	}

	public Claim(String claimReason, String accidentLocation, String accidentCity, String accidentState,
			Long accidentZip, String claimType, Long policyNumber) {
		super();
		this.claimReason = claimReason;
		this.accidentLocation = accidentLocation;
		this.accidentCity = accidentCity;
		this.accidentState = accidentState;
		this.accidentZip = accidentZip;
		this.claimType = claimType;
		this.policyNumber = policyNumber;
	}

	public Claim(long claimNumber, String claimReason, String accidentLocation, String accidentCity,
			String accidentState, long accidentZip, String claimType, long policyNumber) {
		super();
		this.claimNumber = claimNumber;
		this.claimReason = claimReason;
		this.accidentLocation = accidentLocation;
		this.accidentCity = accidentCity;
		this.accidentState = accidentState;
		this.accidentZip = accidentZip;
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

	public String getAccidentLocation() {
		return accidentLocation;
	}

	public void setAccidentLocation(String accidentLocation) {
		this.accidentLocation = accidentLocation;
	}

	public String getAccidentCity() {
		return accidentCity;
	}

	public void setAccidentCity(String accidentCity) {
		this.accidentCity = accidentCity;
	}

	public String getAccidentState() {
		return accidentState;
	}

	public void setAccidentState(String accidentState) {
		this.accidentState = accidentState;
	}

	public long getAccidentZip() {
		return accidentZip;
	}

	public void setAccidentZip(long accidentZip) {
		this.accidentZip = accidentZip;
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
		return "Claim [claimNumber=" + claimNumber + ", claimReason=" + claimReason + ", accidentLocation="
				+ accidentLocation + ", accidentCity=" + accidentCity + ", accidentState=" + accidentState
				+ ", accidentZip=" + accidentZip + ", claimType=" + claimType + ", policyNumber=" + policyNumber + "]";
	}
}
