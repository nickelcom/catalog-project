package com.elcom.catalog.dataservice.web;

import java.util.stream.Collectors;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import com.elcom.catalog.dataservice.root.DataServiceResponse;

public class BaseController {

	protected final String DELETE_OPERATION = "delete";
	protected final String ADD_OPERATION = "add";
	
	protected ResponseEntity<DataServiceResponse> buildResponse(Object object) {
		
		DataServiceResponse response = DataServiceResponse.builder().build();
		
		if (object != null) {
			response.setDto(object);
		}
		else {
			response.setResponseMessage("Data could not be retrieved");
			response.setIsSuccess(false);
		}
		
		return ResponseEntity
			.ok()
			.contentType(MediaType.APPLICATION_JSON)
			.body(response);
	}
	
	protected ResponseEntity<DataServiceResponse> buildResponse(String message) {
		
		DataServiceResponse response = DataServiceResponse.builder().build();
		response.setResponseMessage(message);
		
		return ResponseEntity
			.ok()
			.contentType(MediaType.APPLICATION_JSON)
			.body(response);
	}
	
	
	protected ResponseEntity<DataServiceResponse> buildBadRequestResponse(Object object, BindingResult bindingResult) {

		DataServiceResponse response = DataServiceResponse.builder().build();
		
		response.setDto(object);
		response.setResponseMessage(bindingResult.getAllErrors().stream().map(br -> br.getDefaultMessage()).collect(Collectors.joining(", ")));
		response.setIsSuccess(false);
		
		return ResponseEntity
			.badRequest()
			.contentType(MediaType.APPLICATION_JSON)
			.body(response);
	}

	protected ResponseEntity<DataServiceResponse> buildBadRequestResponse(String message) {

		DataServiceResponse response = DataServiceResponse.builder().build();
		
		response.setResponseMessage(message);
		response.setIsSuccess(false);
		
		return ResponseEntity
			.badRequest()
			.contentType(MediaType.APPLICATION_JSON)
			.body(response);
	}

	
}
