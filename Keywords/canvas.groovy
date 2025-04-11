import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.JavascriptExecutor

import internal.GlobalVariable

class DrawOnCanvas {

	@Keyword
def drawSignature(String canvasSelector) {
    def driver = DriverFactory.getWebDriver()
    JavascriptExecutor js = (JavascriptExecutor) driver

    // Script menggambar tanda tangan (zig-zag)
    String script = """
        let canvas = document.querySelector('${canvasSelector}');
        // Kalau yang terseleksi bukan canvas langsung, cari canvas di dalamnya
        if (canvas.tagName.toLowerCase() !== 'canvas') {
            canvas = canvas.querySelector('canvas');
        }
        const ctx = canvas.getContext('2d');
        ctx.beginPath();
        ctx.moveTo(20, 20);
        ctx.lineTo(60, 30);
        ctx.lineTo(100, 10);
        ctx.lineTo(140, 40);
        ctx.stroke();
    """

    js.executeScript(script)
}
}