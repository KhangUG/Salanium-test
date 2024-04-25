package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Thiết lập đường dẫn đến chromedriver.exe
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ADMIN\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");

        // Khởi tạo WebDriver
        WebDriver driver = new ChromeDriver();

        // Mở trang web của Google
        driver.get("https://www.google.com");

        // Tìm ô tìm kiếm và nhập "youtube" vào ô đó
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("youtube");
        searchBox.sendKeys(Keys.ENTER);

        // Đợi một chút để kết quả tìm kiếm được tải
        Thread.sleep(3000);

        // Nhấp vào kết quả đầu tiên liên quan đến Youtube
        WebElement youtubeLink = driver.findElement(By.xpath("//h3[contains(text(),'YouTube')]"));
        youtubeLink.click();

        // Đợi một chút để trang YouTube được tải
        Thread.sleep(3000);

        // Tìm ô tìm kiếm trên YouTube và nhập tên bài hát (ví dụ: "Despacito")
        WebElement searchYoutube = driver.findElement(By.name("search_query"));
        searchYoutube.sendKeys("Despacito");
        searchYoutube.sendKeys(Keys.ENTER);

        // Đợi một chút để kết quả tìm kiếm được tải
        Thread.sleep(3000);

        // Nhấp vào video đầu tiên
        List<WebElement> videoResults = driver.findElements(By.id("video-title"));
        if (!videoResults.isEmpty()) {
            videoResults.get(0).click();

            // Đợi một chút để video được phát
            Thread.sleep(5000);

            // Thêm video vào danh sách yêu thích (ví dụ: nhấn nút "Thích")
            WebElement likeButton = driver.findElement(By.xpath("//button[@aria-label='Thích video này']"));
            likeButton.click();
        } else {
            System.out.println("Không tìm thấy kết quả video.");
        }

        // Đóng trình duyệt
        driver.quit();
    }
}
