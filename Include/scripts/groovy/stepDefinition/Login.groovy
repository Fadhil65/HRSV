package stepDefinition

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When



class Login {
	@Given("The User go to login page")
	public void the_User_go_to_login_page() {
		WebUI.openBrowser('')
		WebUI.navigateToUrl(GlobalVariable.url)
		WebUI.maximizeWindow(FailureHandling.STOP_ON_FAILURE)
	}

	@Then("User input valid username")
	public void user_input_valid_username() {
		WebUI.sendKeys(findTestObject('Page_login/field_username'), GlobalVariable.valid_username)
	}

	@Then("User input invalid password")
	public void user_input_invalid_password() {
		WebUI.sendKeys(findTestObject('Page_login/field_password'), GlobalVariable.invalid_password)
	}

	@When("User click button login")
	public void user_click_button_login() {
		WebUI.click(findTestObject('Page_login/btn_login'), FailureHandling.STOP_ON_FAILURE)
	}

	@Then("Notification appear")
	public void notification_appear() {
		WebUI.verifyElementVisible(findTestObject('Page_login/validate_login_error'))
	}

	@Given("The User input valid password")
	public void the_User_input_valid_password() {
		WebUI.clearText(findTestObject('Page_login/field_password'))
		WebUI.sendKeys(findTestObject('Page_login/field_password'), GlobalVariable.valid_password)
	}
	@Then("Username appear")
	public void Username_appear() {
		WebUI.verifyElementPresent(findTestObject('Page_home/wording_username'), 0)
		WebUI.delay(1)
		WebUI.closeBrowser(FailureHandling.STOP_ON_FAILURE)
	}
	@When("User performs two login attempts")
	public void User_performs_two_login_attempts() {
		for (int i = 0; i < 2; i++) {
			WebUI.comment("Iterasi ke-${i + 1}")


			WebUI.sendKeys(findTestObject('Page_login/field_username'), GlobalVariable.valid_username)

			if (i == 0) {
				// Iterasi pertama - valid login
				WebUI.sendKeys(findTestObject('Page_login/field_password'), GlobalVariable.valid_password)
				WebUI.click(findTestObject('Page_login/btn_login'), FailureHandling.STOP_ON_FAILURE)

				// Logout
				WebUI.click(findTestObject('Page_home/icon_user'), FailureHandling.STOP_ON_FAILURE)
				WebUI.click(findTestObject('Page_home/btn_sign_out'), FailureHandling.STOP_ON_FAILURE)
			} else {
				// Iterasi kedua - invalid login
				WebUI.comment("Password invalid pada iterasi ke-${i + 1}")
				WebUI.sendKeys(findTestObject('Page_login/field_password'), GlobalVariable.invalid_password)
				WebUI.click(findTestObject('Page_login/btn_login'), FailureHandling.STOP_ON_FAILURE)

				// Validasi error muncul
				if (WebUI.verifyElementVisible(findTestObject('Page_login/validate_login_error'), FailureHandling.OPTIONAL)) {
					WebUI.comment("✅ Validasi error muncul saat password invalid - Iterasi ${i + 1}")
				} else {
					WebUI.comment("❌ Tidak ada error saat password invalid - Kemungkinan BUG")
				}
			}

			WebUI.delay(1)

		}
		WebUI.closeBrowser()
	}
}