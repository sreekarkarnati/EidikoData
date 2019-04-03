package com.ibm.eidikoemp;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SubmitRequest
{
	@JsonProperty("StatusCode")
	Integer statusCode;
	
	@JsonProperty("StatusName")
	String statusName;
	
	@JsonProperty("ItemsCount")
	Integer itemsCount;
	
	@JsonProperty("ErrorDetails")
	String errorDetails;
	
	@JsonProperty("ErrorList")
	List<String> errorList;
	
	@JsonProperty("HttpRequestId")
	String httpRequestId;
	
	
	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public Integer getItemsCount() {
		return itemsCount;
	}

	public void setItemsCount(Integer itemsCount) {
		this.itemsCount = itemsCount;
	}

	public String getErrorDetails() {
		return errorDetails;
	}

	public void setErrorDetails(String errorDetails) {
		this.errorDetails = errorDetails;
	}

	public List<String> getErrorList() {
		return errorList;
	}

	public void setErrorList(List<String> errorList) {
		this.errorList = errorList;
	}

	public String getHttpRequestId() {
		return httpRequestId;
	}

	public void setHttpRequestId(String httpRequestId) {
		this.httpRequestId = httpRequestId;
	}

	
	
}
