package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class Favori {

    public Favori() {

            PageFactory.initElements(Driver.getDriver(), this);
        }


        @FindBy(xpath = "//*[@alt='hayat sana gelir']")
        public WebElement anaGirisSayfasiYaziDogrulama;

        @FindBy(xpath = "//*[@title='Giriş Yap']")
        public WebElement girisYapSekmesi;

        @FindBy(css = "[id=\"email\"]")
        public WebElement girisYapMailKutusu;

        @FindBy(xpath = "//*[@name='password']")
        public WebElement girisYapSifreKutusu;

       @FindBy (xpath ="//div[@id='loginButton']")
       public WebElement girisyapButtonu;

      @FindBy (css = "[class=\"btnSignIn\"]")
       public WebElement anaSayfaGirisButton;

        @FindBy(xpath = "//input[@type='text']")
        public WebElement searchButonu;

        @FindBy(xpath = "//body/div[@id='wrapper']/div[@id='contentListing']/div[1]/div[1]/div[2]/div[5]/a[2]")
        public WebElement ikinciSayfaButonu;

        @FindBy(xpath = "//h1[contains(text(),'Iphone,')]")
        public WebElement iphoneAramaDogrulama;

        @FindBy(xpath = "//body/div[@id='wrapper']/div[@id='contentListing']/div[1]/div[1]/div[2]/section[2]/div[2]/ul[1]/li[3]/div[1]/div[1]")
        public WebElement ikinciSayfaUcuncuUrun;

        @FindBy(xpath = "//*[@class='menuTitle']")
        public WebElement hesabimSekmesi;
        @FindBy(xpath = "//a[contains(text(),'Favorilerim / Listelerim')]")
        public WebElement hesabimFavorimIstekListelerimSekmesi;

        @FindBy(xpath = "//h2[contains(text(),'Favorilerim / Listelerim')]")
        public WebElement favorimDogrulama;

        @FindBy(xpath = "//body/div[@id='wrapper']/div[@id='contentListing']/div[1]/div[1]/div[2]/section[2]/div[2]/ul[1]/li[3]/div[1]/div[1]/span[1]")
        public WebElement favoriEklemeButonu;

        @FindBy(xpath = "//span[@class='message']")
        public WebElement UrunEklendiYaziElementi;

        @FindBy(xpath = "//span[contains(text(),'Sil')]")
        public WebElement favoriUrunSilme;


        @FindBy(xpath = "//span[contains(text(),'Ürününüz listeden silindi.')]")
        public WebElement urunSilindiYazisi;

        @FindBy(xpath = "//span[@class='Tamam']")
        public WebElement urunSilindiTamamButonu;

        @FindBy(xpath = " //a[contains(text(),'Çıkış Yap')]")
        public WebElement cikisYapButonu;

        @FindBy(xpath = "//*[@class='icon iconSearch']")
        public WebElement searchIkonElementi;

        @FindBy(xpath = "//body/div[@id='wrapper']/div[@id='']/div[1]/div[2]/div[2]/ul[1]/li[1]/div[1]/a[1]/h4[1]")
        public WebElement favoriEklenmisKutusu;

        @FindBy(xpath = "//body/div[@id='wrapper']/div[@id='']/div[1]/div[2]/div[2]/ul[1]/li[1]/div[1]/ul[1]/li[1]/a[1]/img[1]")
        public WebElement favoriUruneTikla;
        @FindBy(xpath = "//span[@class='closeBtn']")
        public WebElement kapatmaikonu;
        @FindBy(xpath = "(//h4[@class=\"listItemTitle\"])[1]")
        public WebElement favoriSayfaFavorilerimButton;

        @FindBy(css = "[title=\"Favorilerim / Listelerim\"]")
        public WebElement baslikAltiFavorilerimButonu;

        @FindBy(xpath = "//span[@class='closeBtn']")
        public WebElement kapatIkonu;
    @FindBy(css = "[class=\"logoutBtn\"]")
    public WebElement LogincikisYapButonu;
        @FindBy(css = "[class=\"btn btnBlack confirm\"]")
        public WebElement confirmSilmeButonu;
        @FindBy(xpath = "(//a[@title='Hesabım'])[1]")
        public WebElement myAccountButton;
        @FindBy(css = "[title=\"Favorilerim / Listelerim\"]")
        public WebElement headerLoginUnderFavorilerimButonu;
        @FindBy(xpath = "(//h3[@class=\"productName \"])[1]")
        public List<WebElement> favoriListemIlkUrun;
    @FindBy(css = "[class=\"deleteProFromFavorites\"]")
    public WebElement favoripageDeleteProductButon;

    public void ClearBrowserCache()  {
        Driver.getDriver().manage().deleteAllCookies();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
