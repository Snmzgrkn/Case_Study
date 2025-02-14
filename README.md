<br/>
<p align="center">
  <a href="https://github.com/Snmzgrkn/CaseStudy">
  </a>

  <h3 align="center">Mindsite Interview Task - Case Study Projesi
</h3>

  <p align="center">
    <a href="https://github.com/Snmzgrkn/CaseStudy"><strong>Explore the docs »</strong></a>
    <br/>
    <br/>
  </p>
</p>


Bu proje,  bir Interview Task projesidir. E-ticaret sitelerinden ürün verilerini çekmek ve işlemek için geliştirilmiştir. Java dilinde yazılmıştır ve Selenium, Jsoup, Apache POI ve JSON Simple kütüphanelerini kullanır.

## Kullanılan Teknolojiler

* Java(21): Projeyi temel olarak Java dilinde geliştirdim.
* Selenium(Stable 4.18.1): Web tarayıcısını otomatikleştirmek için Selenium kütüphanesini kullandım. Proje için ChromeDriver gereklidir.
* Jsoup: Web sayfalarından veri kazımak için Jsoup kütüphanesini kullandım.
* Apache POI: Excel dosyaları oluşturmak için Apache POI kütüphanesini kullandım.
* JSON Simple: Verileri JSON formatına dönüştürmek için JSON Simple kütüphanesini kullandım.

## Retailer Listesi
Proje, aşağıdaki e-ticaret sitelerinden veri çekmek için tasarlanmıştır:

* Trendyol
* Hepsiburada
* N11
* Amazon

## Output Formatları
* CSV
* JSON
  
## Proje Örnek Görüntüsü
![1](https://github.com/Snmzgrkn/CaseStudy/assets/56911478/4718aff9-ff8e-46f9-a23d-c99c3e8f3c91)
![2](https://github.com/Snmzgrkn/CaseStudy/assets/56911478/f91cc855-354c-4b00-85d9-d0f405b64a88)

## Kullanıcı Girişi
Programı çalıştırmadan önce, kullanıcı istediği ürünleri Main.java dosyasındaki productUrls listesine eklemelidir.

## ChromeDriver Uyumluluğu
Projeyi çalıştırmadan önce, kullanılan Chrome tarayıcı sürümü ile ChromeDriver sürümünün birbirleriyle uyumlu olduğundan emin olunmalıdır. Uyumlu olmayan sürümler programın çalışmasını engelleyebilir. ChromeDriver'ı indirmek için bu bağlantıya gidin ve uygun sürümü indirerek projenin kök dizinine ekleyin. Ardından, Main.java dosyasında System.setProperty("webdriver.chrome.driver", "chromedriver.exe"); satırını güncelleyerek ChromeDriver'ın yolunu belirtin.

### Projeyi Çalıştırma

Projeyi klonlayın:
bash
```
git clone https://github.com/kullanici_adi/CaseStudy.git
```
Gerekli bağımlılıkları yükleyin:
```
mvn install
```
Main.java dosyasını çalıştırarak projeyi başlatın. Program otomatik olarak belirtilen ürün URL'lerinden veri çekecek, çıktıyı deneme.csv ve deneme.json adlarında dosyalara kaydedecektir.

## License

Distributed under the MIT License. See [LICENSE](https://github.com/Snmzgrkn/CaseStudy/blob/main/LICENSE.md) for more information.

## Not
Bu projenin bir önceki versiyonu, daha uzun ve performans açısından daha az optimize edilmiş bir şekilde "Before" adı altında bu depoda bulunmaktadır. Güncellenmiş kod, daha az satır kod kullanır ve performans kaybını azaltır.
* Selenium kullanılmadan veri çekmeye yönelik olarak geliştirilmiştir. Ancak, Trendyol web sitesi için tam veri çekimini gerçekleştirebilmek için ChromeDriver kullanımına ihtiyaç duyulmuştur. Trendyol web sitesinin scriptleri yavaş yüklenmesi nedeniyle, veri çekiminin tamamlanabilmesi için sayfanın tamamen yüklenmesini beklemek gerekmektedir. Bu durum, Selenium'un dinamik içerikleri işleme yeteneği sayesinde başarıyla gerçekleştirilmiştir.

## Authors

* **Gürkan Sönmez** - *Comp Eng* - [Gürkan Sönmez](https://github.com/Snmzgrkn/)



