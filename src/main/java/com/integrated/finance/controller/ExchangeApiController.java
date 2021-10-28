package com.integrated.finance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.integrated.finance.constants.Constants;
import com.integrated.finance.rest.model.ExchangeModel;
import com.integrated.finance.rest.model.ConvertResponseModel;
import com.integrated.finance.service.ConvertResponseService;
import com.integrated.finance.utility.UtilityFunctions;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "Currency Amount Conversion API Documentation")
public class ExchangeApiController {
	
	@Autowired
	ConvertResponseService convertResponseService;

	@PostMapping(
	        value = "/convert",
	        consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
	        produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	
	@ApiOperation(value = "Convert currency amount operation")
	public ResponseEntity<ConvertResponseModel> exchangeRateApi(@RequestBody ExchangeModel model) {

		String checkAmount = UtilityFunctions.checkAmountFormat(model.getAmount());
		
		if(checkAmount.equals(model.getAmount()))
		{
			
			return convertResponseService.sendConvertRequest(Constants.CURRENCY_USD + model.getSource() , Constants.CURRENCY_USD + model.getTarget(), checkAmount);
			
		} else {
			
			ConvertResponseModel responseModel= new ConvertResponseModel();
			responseModel.setResponse(checkAmount);
			return new ResponseEntity<ConvertResponseModel>(responseModel, HttpStatus.GONE);
		
		}
		
	}
	
}
