package jp.co.sss.lms.ct.f01_login1;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.web.server.LocalServerPort;

import jp.co.sss.lms.ct.util.WebDriverUtils;

/**
 * 結合テスト ログイン機能①
 * ケース02
 * @author holy
 */

@TestMethodOrder(OrderAnnotation.class)
@DisplayName("ケース02 受講生 ログイン 認証失敗")
public class Case02 {

			@LocalServerPort
			private int port;
			
			
			private WebDriver driver;
			
			private WebDriverWait wait;
			
			/** 前処理 */
			@BeforeEach
			void setUp() {
				ChromeOptions options = new ChromeOptions();
				driver = new ChromeDriver(options);
				driver = WebDriverUtils.webDriver;  
				wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			}
			
			/** 後処理 */
			@AfterEach
			void tearDown() {
				if (driver != null) {
					driver.quit();
				}
			}
			
			@Test
			@Order(1)
			@DisplayName("テスト01 トップページURLでアクセス")
			public void testLoginDisplay1() throws Exception {
			
				// URLを開く
				driver.get("http://localhost:8080/lms");
			
				// 待機時間
				wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.cssSelector("input[type='submit'][value='ログイン']")));
			
				//スクリーンショットを撮影する
				WebDriverUtils.getEvidence(new Object() {});
			}
			
			@Test
			@Order(2)
			@DisplayName("テスト02 DBに登録されていないユーザーでログイン")
			public void testLoginDisplay2() throws Exception {
			
				// URLを開く
				driver.get("http://localhost:8080/lms");
			
				// 待機時間
				wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.name("loginId")));
			
				// DB情報にないログインID＆パスワードを入力
				driver.findElement(By.name("loginId")).sendKeys("XXX");
				driver.findElement(By.name("password")).sendKeys("XXX");
			
				//要素を取得しログインボタンをクリック (click)
				driver.findElement(By.cssSelector("input[type='submit']")).click();
			
				// エラーメッセージが表示されるまで待機
				WebElement errorMessage = wait.until(
						ExpectedConditions.visibilityOfElementLocated(
								By.cssSelector("span.help-inline.error")));
			
				//スクリーンショットを撮影する
				WebDriverUtils.getEvidence(new Object() {});
			}

  }