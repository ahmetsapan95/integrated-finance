package com.integrated.finance.service;

//necessary components are imported
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.integrated.finance.constants.Constants;
import com.integrated.finance.rest.model.ConvertResponseModel;
import com.integrated.finance.utility.UtilityFunctions;

@Service
public class ConvertResponseService {

	// essential URL structure is built using constants
	public static final String ACCESS_KEY = Constants.ACCESS_KEY;
	public static final String BASE_URL = Constants.BASE_URL;
	public static final String ENDPOINT = Constants.ENDPOINT_LIVE;

	// this object is used for executing requests to the (REST) API
	static CloseableHttpClient httpClient = HttpClients.createDefault();

	// sendLiveRequest() function is created to request and retrieve the data
	public ResponseEntity<ConvertResponseModel> sendConvertRequest(String source, String target, String amount) {

		// The following line initializes the HttpGet Object with the URL in order to
		// send a request
		HttpGet get = new HttpGet(BASE_URL + ENDPOINT + "?access_key=" + ACCESS_KEY);
		ConvertResponseModel responseModel = new ConvertResponseModel();
		try {
			CloseableHttpResponse response = httpClient.execute(get);
			HttpEntity entity = response.getEntity();
			JSONObject exchangeRates = new JSONObject(EntityUtils.toString(entity));
			response.close();
			responseModel.setResponse(UtilityFunctions.prepareConvertExchangeAmount(exchangeRates.getJSONObject("quotes").getDouble(source), 
					exchangeRates.getJSONObject("quotes").getDouble(target),amount));
			responseModel.setTransactionId(UtilityFunctions.generateTransactionID());
			return new ResponseEntity<ConvertResponseModel>(responseModel, HttpStatus.OK);

		} catch (ClientProtocolException e) {
	         e.printStackTrace();
	         responseModel.setResponse(e.getMessage());
	         return new ResponseEntity<ConvertResponseModel>(responseModel, HttpStatus.GONE);
	     } catch (IOException e) {
	         e.printStackTrace();
	         responseModel.setResponse(e.getMessage());
	         return new ResponseEntity<ConvertResponseModel>(responseModel, HttpStatus.BAD_REQUEST);
	     } catch (ParseException e) {
	         e.printStackTrace();
	         responseModel.setResponse(e.getMessage());
	         return new ResponseEntity<ConvertResponseModel>(responseModel, HttpStatus.EXPECTATION_FAILED);
	     } catch (JSONException e) {
	         e.printStackTrace();
	         responseModel.setResponse(e.getMessage());
	         return new ResponseEntity<ConvertResponseModel>(responseModel, HttpStatus.BAD_REQUEST);
	     }
	}

}