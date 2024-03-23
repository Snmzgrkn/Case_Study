import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Before {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Gurkan\\IdeaProjects\\CaseStudy\\src\\chromedriver.exe");


        WebDriver driver = new ChromeDriver();

        List<String> productUrls = List.of(
                "https://www.n11.com/urun/garnier-saftemiz-nemlendiren-temizleyici-250-ml-micellar-kusursuz-makyaj-temizleme-suyu-400-ml-40024434?magaza=loreal");

        // Her bir URL için veri kazıma işlemlerini gerçekleştirin
        for (String url : productUrls) {
            Thread.sleep(1000);
            if (url.startsWith("https://www.trendyol.com")) {
                scrapeDataFromTrendyol(driver, url);
            } else if (url.startsWith("https://www.hepsiburada.com")) {
                scrapeDataFromHepsiburada(driver, url);
            }
            else if (url.startsWith("https://www.n11.com")) {
                scrapeDataFromN11(driver, url);
            }
            else if (url.startsWith("https://www.amazon.com.tr")) {
                scrapeDataFromAmazon(driver, url);
            }
        }

        // Tarayıcıyı kapatın
        driver.quit();

    }
    private static void scrapeDataFromTrendyol(WebDriver driver, String url) {
        // URL'ye gidin
        driver.get(url);

        // Web sayfasının tam olarak yüklenmesini bekleyin (10 saniye)
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Web sayfasının kaynak kodunu alın
        String html = driver.getPageSource();

        // Jsoup ile sayfanın kaynak kodunu parse edin
        Document doc = Jsoup.parse(html);

        // Artık Jsoup ile veri kazıma işlemlerini gerçekleştirebilirsiniz
        // Örnek: String productTitle = doc.select(".pr-new-br").text();
        String productTitle = doc.select(".pr-new-br").text();
        String productPrice = doc.select(".featured-prices").text();
        Element baseProductImage = doc.select("img").get(2);
        String urlImage = baseProductImage.attr("src");
        String rating = doc.select(".pr-rnr-sm-p").text();
        String reviewCount = doc.select(".total-review-count").text();

        System.out.println("Title : " +productTitle);
        System.out.println("Price : " + productPrice);
        System.out.println("Base Product Image : "+urlImage);
        System.out.println("Rating Score : "+rating);
        System.out.println("Review Count : "+reviewCount);

    }
    private static void scrapeDataFromHepsiburada(WebDriver driver, String url) {
        // URL'ye gidin
        driver.get(url);

        // Web sayfasının tam olarak yüklenmesini bekleyin (10 saniye)
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Web sayfasının kaynak kodunu alın
        String html = driver.getPageSource();

        // Jsoup ile sayfanın kaynak kodunu parse edin
        Document doc = Jsoup.parse(html);

        // Artık Jsoup ile veri kazıma işlemlerini gerçekleştirebilirsiniz
        // Örnek: String productTitle = doc.select(".pr-new-br").text();
        String productTitle = doc.select(".product-name").text();
        String productPrice = doc.select(".price").first().text();
        Element baseProductImage = doc.select("img").first();
        String urlImage = baseProductImage.attr("src");
        String rating = doc.select(".rating-star").text();
        String reviewCount = doc.select(".product-comments").first().text();

        System.out.println("Title : " +productTitle);
        System.out.println("Price : " + productPrice);
        System.out.println("Base Product Image : "+urlImage);
        System.out.println("Rating Score : "+rating);
        System.out.println("Review Count : "+reviewCount);

    }
    private static void scrapeDataFromN11(WebDriver driver, String url) {
        // URL'ye gidin
        driver.get(url);

        // Web sayfasının tam olarak yüklenmesini bekleyin (10 saniye)
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Web sayfasının kaynak kodunu alın
        String html = driver.getPageSource();

        // Jsoup ile sayfanın kaynak kodunu parse edin
        Document doc = Jsoup.parse(html);

        // Artık Jsoup ile veri kazıma işlemlerini gerçekleştirebilirsiniz
        // Örnek: String productTitle = doc.select(".pr-new-br").text();
        String productTitle = doc.select(".proName").text();
        String productPrice = doc.select(".newPrice").first().text();
        Element baseProductImage = doc.select("img").first();
        String urlImage = baseProductImage.attr("src");
        String rating = doc.select(".ratingScore").first().text();
        String reviewCount = doc.select(".reviewNum").text();

        System.out.println("Title : " +productTitle);
        System.out.println("Price : " + productPrice);
        System.out.println("Base Product Image : "+urlImage);
        System.out.println("Rating Score : "+rating);
        System.out.println("Review Count : "+reviewCount);

    }
    private static void scrapeDataFromAmazon(WebDriver driver, String url) {
        // URL'ye gidin
        driver.get(url);

        // Web sayfasının tam olarak yüklenmesini bekleyin (10 saniye)
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Web sayfasının kaynak kodunu alın
        String html = driver.getPageSource();

        // Jsoup ile sayfanın kaynak kodunu parse edin
        Document doc = Jsoup.parse(html);

        // Artık Jsoup ile veri kazıma işlemlerini gerçekleştirebilirsiniz
        // Örnek: String productTitle = doc.select(".pr-new-br").text();
        String productTitle = doc.select("#title").text();
        String productPrice = doc.select(".a-offscreen").first().text();
        Element baseProductImage = doc.select(".a-dynamic-image").first();
        String urlImage = baseProductImage.attr("src");
        String rating = doc.select(".a-popover-trigger").get(2).text();
        String reviewCount = doc.select("#acrCustomerReviewText").first().text();

        System.out.println("Title : " +productTitle);
        System.out.println("Price : " + productPrice);
        System.out.println("Base Product Image : "+urlImage);
        System.out.println("Rating Score : "+rating);
        System.out.println("Review Count : "+reviewCount);

    }


}