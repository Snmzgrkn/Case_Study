import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        //ChromeDriver.exe yolunu belirttim
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Gurkan\\IdeaProjects\\CaseStudy\\src\\chromedriver.exe");


        WebDriver driver = new ChromeDriver();

        //Burada ürünlerimiz bir list halinde, ürün eklemek istersek eğer , ile ekleyebiliriz
        List<String> productUrls = List.of(
                "https://www.n11.com/urun/garnier-saftemiz-nemlendiren-temizleyici-250-ml-micellar-kusursuz-makyaj-temizleme-suyu-400-ml-40024434?magaza=loreal",
                "https://www.hepsiburada.com/dreame-v10-pro-dikey-kablosuz-sarjli-supurge-genpa-garantili-p-HBV0000188N7U",
                "https://www.trendyol.com/elseve/amla-bukle-belirginlestirici-sac-bakim-kremi-p-37573990",
                "https://www.amazon.com.tr/Garn%C4%B1er-Temiz-Arada-Temizleme-peeling/dp/B07L7RFQD5/?_encoding=UTF8&pd_rd_w=iqbF1&content-id=amzn1.sym.58151f09-c1f1-4635-be5e-6c4f7f840492%3Aamzn1.symc.afd86303-4a72-4e34-8f6b-19828329e602&pf_rd_p=58151f09-c1f1-4635-be5e-6c4f7f840492&pf_rd_r=BQJ90JDJ3H9KSQKCA56N&pd_rd_wg=rX0F1&pd_rd_r=ac330ba2-945c-41a4-a9ca-c654fff0816f&ref_=pd_gw_ci_mcx_mr_hp_atf_m");

        //Boş bir list tanımladım
        List<String[]> dataList = new ArrayList<>();

        //Her bir ürün için scrarping yapacağız
        for (String url : productUrls) {
            //Thread.sleep(1000);
            scrapeData(driver, url,dataList);
        }

        driver.quit();
        writeToCSV(dataList,"products.csv");
        writeToJSON(dataList,"products.json");

    }
    //Ürünleri scrap etmemiz için bir metod yazdım
    private static void scrapeData(WebDriver driver, String url,List<String[]> dataList) {
        try {
            driver.get(url);
            //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            String html = driver.getPageSource();
            Document doc = Jsoup.parse(html);

            String productTitle = "";
            String productPrice = "";
            String urlImage = "";
            String rating = "";
            String reviewCount = "";

            //Farklı e ticaret siteleri için farklı seçiciler mevcut. Bu yüzden hepsi farklı metodlarda yapmak yerine tek bir metod içerisinde yapıp değerlerini değiştirdim


            if (url.contains("trendyol.com")) {
                productTitle = doc.select(".pr-new-br").text();
                productPrice = doc.select(".featured-prices").text();
                urlImage = doc.select("img").get(2).attr("src");
                rating = doc.select(".pr-rnr-sm-p").text();
                reviewCount = doc.select(".total-review-count").text();
            } else if (url.contains("hepsiburada.com")) {
                productTitle = doc.select(".product-name").text();
                productPrice = doc.select(".price").first().text();
                urlImage = doc.select("img").first().attr("src");
                rating = doc.select(".rating-star").text();
                reviewCount = doc.select(".product-comments").first().text();
            } else if (url.contains("n11.com")) {
                productTitle = doc.select(".proName").text();
                productPrice = doc.select(".newPrice").first().text();
                urlImage = doc.select("img").first().attr("src");
                rating = doc.select(".ratingScore").first().text();
                reviewCount = doc.select(".reviewNum").text();
            } else if (url.contains("amazon.com.tr")) {
                productTitle = doc.select("#title").text();
                productPrice = doc.select(".a-offscreen").first().text();
                urlImage = doc.select(".a-dynamic-image").first().attr("src");
                rating = doc.select(".a-popover-trigger").get(2).text();
                reviewCount = doc.select("#acrCustomerReviewText").first().text();
            }

            // Aynı zamanda her ürünü tanımladığımız boş liste içerisine gönderdim

            dataList.add(new String[]{productTitle, productPrice, urlImage, rating, reviewCount});


            System.out.println("Title : " + productTitle);
            System.out.println("Price : " + productPrice);
            System.out.println("Base Product Image : " + urlImage);
            System.out.println("Rating Score : " + rating);
            System.out.println("Review Count : " + reviewCount);
            System.out.println("-----------------------------------");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //CSV çıktısı alma metodu
    private static void writeToCSV(List<String[]> dataList, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (String[] data : dataList) {
                for (int i = 0; i < data.length; i++) {
                    writer.append(data[i]);
                    if (i < data.length - 1) {
                        writer.append(",");
                    }
                }
                writer.append("\n");
            }
            System.out.println("Veriler başarılı bir şekilde CSV dosyasına yazıldı.");
        } catch (IOException e) {
            System.err.println("CSV dosyasına yazma sırasında bir hata oluştu: " + e.getMessage());
        }
    }
    //JSON çıktısı alma metodu
    private static void writeToJSON(List<String[]> dataList, String filePath) {
        JSONArray jsonArray = new JSONArray();
        for (String[] data : dataList) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("Title", data[0]);
            jsonObject.put("Price", data[1]);
            jsonObject.put("Base Product Image", data[2]);
            jsonObject.put("Rating Score", data[3]);
            jsonObject.put("Review Count", data[4]);
            jsonArray.put(jsonObject);
        }

        try (FileWriter file = new FileWriter(filePath)) {
            file.write(jsonArray.toString());
            System.out.println("Veriler başarılı bir şekilde JSON dosyasına yazıldı.");
        } catch (IOException e) {
            System.err.println("JSON dosyasına yazma sırasında bir hata oluştu: " + e.getMessage());
        }
    }
}