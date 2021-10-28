package com.integrated.finance.rest.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Exchange Rate Model documentation", description = "Model")
public class ExchangeRateModel {
	@ApiModelProperty(value = "Source currency that you want to convert to.")
	String source;
	@ApiModelProperty(value = "Target currency that you want to convert from.")
	String target;

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

}
