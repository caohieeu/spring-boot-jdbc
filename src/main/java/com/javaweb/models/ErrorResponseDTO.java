package com.javaweb.models;

import java.util.ArrayList;
import java.util.List;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class ErrorResponseDTO {
	String error;
	List<String> details = new ArrayList<String>();
	public String getError() {
		return error;
	}
	public void setError(String message) {
		this.error = message;
	}
	public List<String> getDetails() {
		return details;
	}
	public void setDetails(List<String> details) {
		this.details = details;
	}
}
