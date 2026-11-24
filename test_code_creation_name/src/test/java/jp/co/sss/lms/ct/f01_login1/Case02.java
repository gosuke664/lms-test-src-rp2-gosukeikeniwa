package jp.co.sss.lms.ct.f01_login1;

import static jp.co.sss.lms.ct.util.WebDriverUtils.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import jp.co.sss.lms.ct.util.WebDriverUtils;

/**
 * 結合テスト ログイン機能①
 * ケース02
 * @author holy
 */

@TestMethodOrder(OrderAnnotation.class)
@DisplayName("ケース02 受講生 ログイン 認証失敗")
public class Case02 {

	        private WebDriver driver;
	
	
			/** 前処理 */
			@BeforeAll
			static void before() {
				createDriver();
			}
			
			/** 後処理 */
			@AfterAll
			static void after() {
				closeDriver();
			}
			
			@Test
			@Order(1)
			@DisplayName("テスト01 トップページURLでアクセス")
			public void testLoginDisplay1() throws Exception {
			
				// URLを開く
				WebDriverUtils.goTo("http://localhost:8080/lms");
			
				//スクリーンショットを撮影する
				WebDriverUtils.getEvidence(new Object() {});
			}
			
			@Test
			@Order(2)
			@DisplayName("テスト02 DBに登録されていないユーザーでログイン")
			public void testLoginDisplay2() throws Exception {
				
				// DB情報にないログインID＆パスワードを入力
				webDriver.findElement(By.name("loginId")).sendKeys("XXX");
				webDriver.findElement(By.name("password")).sendKeys("XXX");
			
				//要素を取得しログインボタンをクリック (click)
				webDriver.findElement(By.cssSelector("input[type='submit']")).click();
			
				// エラーメッセージが表示されるまで待機
				visibilityTimeout(By.className("error"), 10);
				WebElement errorMsg = webDriver.findElement(By.className("error"));
			
				//スクリーンショットを撮影する
				WebDriverUtils.getEvidence(new Object() {});
			}

  }