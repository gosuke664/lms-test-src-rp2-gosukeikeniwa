package jp.co.sss.lms.ct.f02_faq;

import static jp.co.sss.lms.ct.util.WebDriverUtils.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

/**
 * 結合テスト よくある質問機能
 * ケース06
 * @author holy
 */
@TestMethodOrder(OrderAnnotation.class)
@DisplayName("ケース06 カテゴリ検索 正常系")
public class Case06 {

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
	void test01() {
		// URLを開く
		goTo("http://localhost:8080/lms");
		
		//画面遷移が成功したかの確認
		assertEquals("ログイン | LMS", webDriver.getTitle());
		
		//スクリーンショットを撮影する
		getEvidence(new Object() {});
	}

	@Test
	@Order(2)
	@DisplayName("テスト02 初回ログイン済みの受講生ユーザーでログイン")
	void test02() {
		// DB情報にあるログインID＆パスワードを入力
		webDriver.findElement(By.name("loginId")).sendKeys("StudentAA01");
		webDriver.findElement(By.name("password")).sendKeys("Gosuke0826");
	
		//要素を取得しログインボタンをクリック (click)
		webDriver.findElement(By.cssSelector("input[type='submit']")).click();
		
		//画面遷移が成功したかの確認
		assertEquals("コース詳細 | LMS", webDriver.getTitle());
		
		//スクリーンショットを撮影する
		getEvidence(new Object() {});
	}

	@Test
	@Order(3)
	@DisplayName("テスト03 上部メニューの「ヘルプ」リンクからヘルプ画面に遷移")
	void test03() {
		//機能タブをクリック
		webDriver.findElement(By.linkText("機能")).click();  
		
		//ヘルプリンクをクリックする
		webDriver.findElement(By.linkText("ヘルプ")).click(); 
		
		//画面遷移が成功したかの確認
		assertEquals("ヘルプ | LMS", webDriver.getTitle());
		
		//スクリーンショットを撮影する
		getEvidence(new Object() {});
	}

	@Test
	@Order(4)
	@DisplayName("テスト04 「よくある質問」リンクからよくある質問画面を別タブに開く")
	void test04() {
		//よくある質問リンクをクリック
		webDriver.findElement(By.linkText("よくある質問")).click();  
	    
		//別タブに切り替える
        Object[] windowHandles = webDriver.getWindowHandles().toArray();
        webDriver.switchTo().window((String) windowHandles[1]);
        
        //よくある質問画面を別タブで表示する
        String title = webDriver.getTitle();
        
        //画面遷移が成功したかの確認
        assertEquals("よくある質問 | LMS",title);
		
        //スクリーンショットを撮影する
		getEvidence(new Object() {});
	}

	@Test
	@Order(5)
	@DisplayName("テスト05 カテゴリ検索で該当カテゴリの検索結果だけ表示")
	void test05() {
		//よくある質問リンクをクリック
		webDriver.findElement(By.linkText("【研修関係】")).click(); 
		
		//検索結果がみえるところまでスクロールする
		JavascriptExecutor down = (JavascriptExecutor) webDriver;
		down.executeScript("window.scrollTo(0, document.body.scrollHeight);"); 
		
		//検索結果をresultに代入
		List <String> result = List.of(
				"Q.キャンセル料・途中退校について",
				"Q.研修の申し込みはどのようにすれば良いですか？");
		
		//リストに代入
		List<WebElement> expectedResult = webDriver.findElements(By.className("mb10")); 
		List<String> list = new ArrayList<>();
		
		for(WebElement input : expectedResult) {
		 list.add(input.getText());
		}
		 //検索結果が表示されたかを確認する
		 assertEquals(result,list);
		//スクリーンショットを撮影する
		getEvidence(new Object() {});	
	   
	}

	@Test
	@Order(6)
	@DisplayName("テスト06 検索結果の質問をクリックしその回答を表示")
	void test06() {
		 //1つ目がみえるところまでスクロールする
		 JavascriptExecutor down1 = (JavascriptExecutor) webDriver;
		 down1.executeScript("window.scrollTo(0, document.body.scrollHeight);"); 
		 
		 //検索結果の1つ目の質問をクリック
		 webDriver.findElement(By.id("question-h0")).click(); 
		 
		 //回答が表示されたかの確認(1個目)
		 WebElement answer1 = webDriver.findElement(By.id("answer-h0"));
		 assertTrue(answer1.isDisplayed());
         
         //スクリーンショットを撮影する
		 getEvidence(new Object() {});	
	
	     //2つ目がみえるところまでスクロールする
         JavascriptExecutor down2 = (JavascriptExecutor) webDriver;
         down2.executeScript("window.scrollTo(0, document.body.scrollHeight);"); 
         
         //検索結果の2つ目の質問をクリック
         webDriver.findElement(By.id("question-h1")).click(); 
         
         //回答が表示されたかの確認(2個目)
         WebElement answer2 = webDriver.findElement(By.id("answer-h1"));
		 assertTrue(answer2.isDisplayed());
		 
		 //スクリーンショットを撮影する
		 getEvidence(new Object() {});	
	
	}

}
