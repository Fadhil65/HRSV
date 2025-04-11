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


public class Logbook {
	@Then("User login with valid credentials")
	public void user_login_with_valid_credentials() {
		WebUI.sendKeys(findTestObject('Page_login/field_username'), GlobalVariable.valid_username)
		WebUI.sendKeys(findTestObject('Page_login/field_password'), GlobalVariable.valid_password)
		WebUI.click(findTestObject('Page_login/btn_login'), FailureHandling.STOP_ON_FAILURE)
		WebUI.delay(1)
	}

	@Then("User click button tambah logbook")
	public void user_click_button_tambah_logbook() {
		WebUI.click(findTestObject('Page_home/btn_logbook'), FailureHandling.STOP_ON_FAILURE)
	}

	@Then("User input date {string}")
	public void user_input_date(String date) {
		WebUI.setText(findTestObject('Page_home/form_logbook/logbook_tanggal'), date)
	}

	@Then("User select {int} am jam mulai")
	public void user_select_am_jam_mulai(Integer int1) {
		WebUI.click(findTestObject('Page_home/form_logbook/logbook_jam_mulai'), FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('Page_home/form_logbook/logbook_8_am'), FailureHandling.STOP_ON_FAILURE)
	}

	@Then("User Select {int} pm jam selesai")
	public void user_Select_pm_jam_selesai(Integer int1) {
		WebUI.click(findTestObject('Page_home/form_logbook/logbook_jam_selesai'), FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject('Page_home/form_logbook/logbook_8_pm'), FailureHandling.STOP_ON_FAILURE)
	}

	@Then("User select WFO on field mode kerja")
	public void user_select_WFO_on_field_mode_kerja() {
		WebUI.selectOptionByValue(findTestObject('Page_home/form_logbook/logbook_mode_kerja'), 'WFO', false)
	}

	@Then("User input {string} on field Project")
	public void user_input_on_field_Project(String project) {
		WebUI.sendKeys(findTestObject('Page_home/form_logbook/logbook_field_project'), project)
	}

	@Then("User input {string} on field Nama Tim")
	public void user_input_on_field_Nama_Tim(String nama_tim) {
		WebUI.sendKeys(findTestObject('Page_home/form_logbook/logbook_field_nama_tim'), nama_tim)
	}

	@Then("User input {string} on field Use Case")
	public void user_input_on_field_Use_Case(String Use_case) {
		WebUI.sendKeys(findTestObject('Page_home/form_logbook/logbook_field_use_case'), Use_case)
	}

	@Then("User select Belajar Materi on field Kegiatan")
	public void user_select_Belajar_Materi_on_field_Kegiatan() {
		WebUI.selectOptionByValue(findTestObject('Page_home/form_logbook/logbook_field_kegiatan'), 'Belajar Materi', false)
	}

	@Then("User input {string} on field hasil")
	public void user_input_on_field_hasil(String hasil) {
		WebUI.sendKeys(findTestObject('Page_home/form_logbook/logbook_field_hasil'), hasil)
	}

	@Then("User input {string} on field Capaian")
	public void user_input_on_field_Capaian(String capaian) {
		WebUI.sendKeys(findTestObject('Page_home/form_logbook/logbook_field_capaian'), capaian)
	}

	@Then("User select continue on field Next Step")
	public void user_select_continue_on_field_Next_Step() {
		WebUI.selectOptionByValue(findTestObject('Page_home/form_logbook/logbook_field_next_step'), 'Continue', false)
	}

	@Then("User input {string} on field Path\\/Filename")
	public void user_input_on_field_Path_Filename(String file_name) {
		WebUI.sendKeys(findTestObject('Page_home/form_logbook/logbook_field_file_name'), file_name)
	}

	@Then("User input {string} on field Detail pekerjaan")
	public void user_input_on_field_Detail_pekerjaan(String detail_pekerjaan) {
		WebUI.sendKeys(findTestObject('Page_home/form_logbook/logbook_field_detail_pekerjaan'), detail_pekerjaan)
	}

	@Then("User select Jam lembur on field Waktu Kerja")
	public void user_select_Jam_lembur_on_field_Waktu_Kerja() {
		WebUI.selectOptionByValue(findTestObject('Page_home/form_logbook/logbook_field_waktu_kerja'), 'Jam Lembur', false)
	}

	@Then("User click button Submit")
	public void user_click_button_Submit() {
		WebUI.click(findTestObject('Page_home/form_logbook/logbook_btn_submit'))
	}
	@Then("popup Success appear")
	public void popup_Success_appear() {
		WebUI.verifyElementVisible(findTestObject('Page_home/form_logbook/popup_success'))
	}
	@Then("User click button ok")
	public void User_click_button_ok() {
		WebUI.click(findTestObject('Page_home/form_logbook/logbook_btn_ok'))
		WebUI.delay(1)
	}
	@Given("User click button cancel")
	public void user_click_button_cancel() {
		WebUI.click(findTestObject('Page_home/form_logbook/logbook_btn_cancel'))
		WebUI.delay(3)
	}

	@Then("User click icon delete")
	public void user_click_icon_delete() {
		WebUI.click(findTestObject('Page_home/btn_delete_1'))
	}

	@Then("User click button OK")
	public void user_click_button_OK() {
		WebUI.click(findTestObject('Page_home/btn_ok(delete)'))
		WebUI.delay(2)
		WebUI.closeBrowser(FailureHandling.STOP_ON_FAILURE)
	}
}
