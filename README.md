<br/>
<p align="center">
  <a href="https://github.com/Snmzgrkn/CaseStudy">
    <img src="images/mindsite.png" alt="Logo" width="80" height="80">
  </a>

  <h3 align="center">Mindsite Interview Task - Case Study Projesi
</h3>

  <p align="center">
    <a href="https://github.com/Snmzgrkn/CaseStudy"><strong>Explore the docs »</strong></a>
    <br/>
    <br/>
  </p>
</p>

![Contributors](https://img.shields.io/github/contributors/Snmzgrkn/CaseStudy?color=dark-green) 


Bu proje, Mindsite şirketinin bana yönlendirdiği bir Interview Task projesidir. E-ticaret sitelerinden ürün verilerini çekmek ve işlemek için geliştirilmiştir. Java dilinde yazılmıştır ve Selenium, Jsoup, Apache POI ve JSON Simple kütüphanelerini kullanır.

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
* 
## Proje Örnek Görüntüsü
![CaseStudyMain java2024-03-2422-19-01-ezgif com-video-to-gif-converter](https://github.com/Snmzgrkn/CaseStudy/assets/56911478/5ae362c2-6c37-40de-9e3a-15cbf44f71b8)
![GarnierSafTemizNemlendirenTemizleyici250MLMicellarKusursuzMakyajTemizlemeSuyu400MLFiyatlarvezellikleri-GoogleChrome2024-03-2422-45-31-ezgif com-video-to-gif-converter](https://github.com/Snmzgrkn/CaseStudy/assets/56911478/cfd7b0a4-4f38-413c-9ba3-56f79fb3cf5c)

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
Main.java dosyasını çalıştırarak projeyi başlatın. Program otomatik olarak belirtilen ürün URL'lerinden veri çekecek, çıktıyı deneme.csv, deneme.xlsx ve deneme.json adlarında dosyalara kaydedecektir.

## License

Distributed under the MIT License. See [LICENSE](https://github.com/Snmzgrkn/CaseStudy/blob/main/LICENSE.md) for more information.

## Authors

* **Gürkan Sönmez** - *Comp Eng* - [Gürkan Sönmez](https://github.com/Snmzgrkn/) 

