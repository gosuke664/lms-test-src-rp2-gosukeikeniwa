package jp.co.sss.lms.ct.f01_login1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

/**
 * 結合テスト ログイン機能①
 * ケース01
 * @author holy
 */
@TestMethodOrder(OrderAnnotation.class)
@DisplayName("ケース01 ログイン画面への遷移")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class Case01 {

	@LocalServerPort
	private int port;

	private WebDriver driver;
	
	/** 前処理 */
	@BeforeEach
	void setUp() {
		ChromeOptions options = new ChromeOptions();
		driver = new ChromeDriver(options);
	}
	// URLを開く
	@Test
	void testLoginPage() {
		driver.get("http://localhost:" + port + "/lms");
      }
	
}