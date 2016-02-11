package com.bemach.aep.cukes.stepdef.page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import com.bemach.aep.cukes.stepdef.util.PaymentInfo;

public class PaymentPage {
	@FindBy (how = How.XPATH, using = "//*[@id='content']/div[2]/fieldset/legend")
	private WebElement paymentPageLabelElmt;
	
	@FindBy (how = How.XPATH, using = "//input[@id='order_name']")
	private WebElement orderNameElmt;
	
	@FindBy (how = How.XPATH, using = "//textarea[@id='order_address']")
	private WebElement orderAddressElmt;
	
	@FindBy (how = How.XPATH, using = "//input[@id='order_email']") 
	private WebElement orderEmailElmt;
	
	@FindBy (how = How.XPATH, using = "//select[@id='order_pay_type']")
	private WebElement payTypeElmt;
	
	@FindBy (how = How.XPATH, using = "//input[@name='commit']")
	private WebElement placeOrderButtonElmt;
	
	@FindBy (how = How.XPATH, using = "//*[@id='error_explanation']/ul/li")
	private List<WebElement> errorMessageElmts;
	
	@FindBy (how = How.XPATH, using = "//*[@id='error_explanation']/h2")
	private WebElement errorMessagesTitleElmt;
	
	@FindBy (how = How.CLASS_NAME, using = "field_with_errors")
	private List<WebElement> fieldWithErrorElmts;

	private WebDriver driver;
	
	public PaymentPage (WebDriver driver) {
		this.driver = driver;
	}
	
	public Object getPageLabel() {
		return paymentPageLabelElmt.getText();
	}

	public void fillOutPayment(PaymentInfo paymentInfo) {
		orderNameElmt.sendKeys(paymentInfo.getName());
		orderAddressElmt.sendKeys(paymentInfo.getAddress());
		orderEmailElmt.sendKeys(paymentInfo.getEmail());
		Select select = new Select(payTypeElmt);
		List<WebElement> options = select.getOptions();
		for (WebElement option: options) {
			if (option.getText().equals(paymentInfo.getPayType())) {
				option.click();
				break;
			}
		}
	}
	
	public void placeOrder() {
		placeOrderButtonElmt.click();
	}

	public List<String> getErrorMessages() {
		List<String> errorMessages = new ArrayList<String>();
		for (WebElement errorMessageElmt: errorMessageElmts) {
			errorMessages.add(errorMessageElmt.getText());
		}
		return errorMessages;
	}

	public String getErrorMessagesTitle() {
		return errorMessagesTitleElmt.getText();
	}

	public List<String> getErrorFields() {
		List<String> errorFields = new ArrayList<String>();
		for (WebElement fieldWithErrorElmt: fieldWithErrorElmts) {
			errorFields.add(fieldWithErrorElmt.getText());
		}
		return errorFields;
	}

}
