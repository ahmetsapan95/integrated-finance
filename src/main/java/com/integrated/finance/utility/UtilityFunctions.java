package com.integrated.finance.utility;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.UUID;

import org.apache.commons.lang3.math.NumberUtils;

public class UtilityFunctions {

	public static String checkAmountFormat(String amount) {
		if (!NumberUtils.isParsable(amount)) {
			return "Invalid Transaction Amount";
		}
		
		BigDecimal amountBig = new BigDecimal (amount);
		if(amountBig.doubleValue() < 0) {
			return "Transaction amount cannot be negative.";
		}
		
		return amount;
	
	}
	
	public static String prepareConvertExchangeAmount(Double source, Double target, String amount) {
		
		BigDecimal sourceCurrency = BigDecimal.valueOf(source);
		BigDecimal targetCurrency = BigDecimal.valueOf(target);
		return String.valueOf((targetCurrency.divide(sourceCurrency, 4, RoundingMode.CEILING)).multiply(new BigDecimal(amount)));
	}
	
	public static String generateTransactionID()
	{
		return UUID.randomUUID().toString();
	}
	
}
