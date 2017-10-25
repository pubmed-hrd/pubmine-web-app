package com.pubmine.model;

public class Abstract {

	private String label;
	private Integer textOrder;
	private Integer pmid;
	private String text;

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Integer getTextOrder() {
		return textOrder;
	}

	public void setTextOrder(Integer textOrder) {
		this.textOrder = textOrder;
	}

	public Integer getPmid() {
		return pmid;
	}

	public void setPmid(Integer pmid) {
		this.pmid = pmid;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "Abstract [label=" + label + ", textOrder=" + textOrder + ", pmid=" + pmid + ", text=" + text + "]";
	}
}
