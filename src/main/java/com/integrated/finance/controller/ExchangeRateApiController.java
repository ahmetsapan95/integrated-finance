package com.integrated.finance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.integrated.finance.rest.model.ExchangeRateModel;
import com.integrated.finance.rest.model.ExchangeResponseModel;
import com.integrated.finance.service.LiveResponseService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "Currency Conversion API Documentation")
public class ExchangeRateApiController {
	
	@Autowired
	LiveResponseService liveResponseService;

	@PostMapping(
	        value = "/exchange-rate",
	        consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
	        produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@ApiOperation(value = "Convert Currency Operation")
	public ResponseEntity<ExchangeResponseModel> exchangeRateApi(@RequestBody ExchangeRateModel model) {

		return liveResponseService.sendLiveRequest(model.getSource() + model.getTarget()); 
	}
	
}
