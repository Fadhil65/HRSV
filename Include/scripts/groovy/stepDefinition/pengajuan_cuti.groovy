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

class pengajuan_cuti {

	@Then("User click menu Cuti dan Lembur")
	public void user_click_menu_Cuti_dan_Lembur() {
		WebUI.click(findTestObject('Page_home/btn_cuti_dan_lembur'), FailureHandling.STOP_ON_FAILURE)
	}

	@When("User click menu Pengajuan Cuti")
	public void user_click_menu_Pengajuan_Cuti() {
		WebUI.click(findTestObject('Page_home/menu_pengajuan_cuti'), FailureHandling.STOP_ON_FAILURE)
	}

	@Then("User click button Ajukan Cuti")
	public void user_click_button_Ajukan_Cuti() {
		WebUI.click(findTestObject('Page_home/btn_ajukan_cuti'), FailureHandling.STOP_ON_FAILURE)
	}

	@When("User filling form ajukan cuti sebanyak {int} kali")
	public void user_filling_form_ajukan_cuti_sebanyak_kali(Integer jumlah) {
		for (int i = 0; i < 2; i++) {
			WebUI.comment("Iterasi ke-${i + 1}")

			if (i == 0) {
				WebUI.click(findTestObject('Page_home/form_pengajuan_cuti/field_tgl_cuti'))
				WebUI.click(findTestObject('Page_home/form_pengajuan_cuti/18_apr_2025'))
				WebUI.click(findTestObject('Page_home/form_pengajuan_cuti/25_apr_2025'))
				WebUI.selectOptionByValue(findTestObject('Page_home/form_pengajuan_cuti/field_jenis_cuti'), 'Cuti Tahunan', false)
				WebUI.selectOptionByValue(findTestObject('Page_home/form_pengajuan_cuti/field_nama_pic'), 'c64be11f-ca8e-45fd-8b91-f673abc79236', false)
				WebUI.sendKeys(findTestObject('Page_home/form_pengajuan_cuti/field_keterangan_cuti'), 'Libur')
				WebUI.click(findTestObject('Page_home/form_pengajuan_cuti/canvas'), FailureHandling.OPTIONAL)
				WebUI.click(findTestObject('Page_home/form_pengajuan_cuti/btn_submit'))
				WebUI.verifyElementVisible(findTestObject('Page_home/form_pengajuan_cuti/popup_success'))
				WebUI.click(findTestObject('Page_home/form_pengajuan_cuti/btn_OK'))
			} else {
				WebUI.comment("Tanggal tidak diisi pada iterasi ke-${i}")
				WebUI.click(findTestObject('Page_home/btn_ajukan_cuti'), FailureHandling.STOP_ON_FAILURE)
				WebUI.click(findTestObject('Page_home/form_pengajuan_cuti/btn_submit'))
				
				if (WebUI.verifyElementVisible(findTestObject('Page_home/form_pengajuan_cuti/popup_error'), FailureHandling.OPTIONAL)) {
					WebUI.comment("✅ Validasi error muncul saat tidak isi form - Iterasi ${i + 1}")
				} else {
					WebUI.comment("❌ Tidak ada error saat tidak isi form - Kemungkinan BUG")
				}
			}
			}
			WebUI.delay(1)
			WebUI.closeBrowser()
		}
		
	}
