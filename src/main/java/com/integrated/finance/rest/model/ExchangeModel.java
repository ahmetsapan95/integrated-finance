package com.integrated.finance.rest.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Exchange Model documentation", description = "Model")
public class ExchangeModel {
	@ApiModelProperty(value = "Source currency that you want to convert to.")
	String source;
	@ApiModelProperty(value = "Target currency that you want to convert from.")
	String target;
	@ApiModelProperty(value = "Amount of money that you want to convert.")
	String amount;

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

}
