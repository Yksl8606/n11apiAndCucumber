package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Favori;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.JSutils;
import utilities.ReusableMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.time.Duration;
import java.util.List;
//import java.sql.Driver;


//import static io.github.bonigarcia.wdm.WebDriverManager.getDriver;
import static java.sql.Driver.*;
import static utilities.Driver.getDriver;

public class FavoriUrun {

    Favori favoriurun = new Favori();
    WebDriverWait wait;
    Actions actions;

    @Given("n11 com sitesi acilir.")
    public void n11_com_sitesi_acilir() {
        Driver.getDriver().navigate().to(ConfigReader.getProperty("url"));
   favoriurun.ClearBrowserCache();
    }

    @Given("Ana sayfanin acildigi kontrol edilir.")
    public void ana_sayfanin_acildigi_kontrol_edilir() {
        wait=new WebDriverWait(Driver.getDriver(),Duration.ofSeconds(20));
        wait.until(webDriver -> ((JavascriptExecutor) Driver.getDriver()).executeScript("return document.readyState").equals("complete"));

        String actualurl = Driver.getDriver().getCurrentUrl();
        String expectedurl = "https://www.n11.com/";
        Assert.assertEquals(expectedurl, actualurl);
    }
    @Given("Ana sayfanin header bolumunde giris buttonuna basilir.")
    public void ana_sayfanin_header_bolumunde_giris_buttonuna_basilir() {
        favoriurun.anaSayfaGirisButton.click();
    }
    @Then("Giris yap sayfanin acildigi dogrulanir.")
    public void giris_yap_sayfanin_acildigi_dogrulanir() {
        ReusableMethods.waitFor(2);
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("giris-yap"));

    }
    @Then("Giris yap sayfasinda e posta adresi input box ina e posta adresi girilir.")
    public void giris_yap_sayfasinda_e_posta_adresi_input_box_ina_e_posta_adresi_girilir() {
       favoriurun.girisYapMailKutusu.sendKeys("n11fakeadresi@gmail.com");
    }
    @Then("Giris yap sayfasinda ??ifre input box ina sifre girilir.")
    public void giris_yap_sayfasinda_??ifre_input_box_ina_sifre_girilir() {

        favoriurun.girisYapSifreKutusu.sendKeys("n1190807060");
   // ReusableMethods.waitFor(2);
    }
    @Then("Giris yap sayfasinda giris yap butonuna basilir.")
    public void giris_yap_sayfasinda_giris_yap_butonuna_basilir() {
        favoriurun.anaSayfaGirisButton.click();
        ReusableMethods.waitFor(2);
    }
    @Then("kullanici Login oldugunu dogrular")
    public void kullanici_login_oldugunu_dogrular() {
       wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));
        wait.until(webDriver -> ((JavascriptExecutor) Driver.getDriver()).executeScript("return document.readyState").equals("complete"));
       Assert.assertTrue(favoriurun.myAccountButton.isDisplayed());
    }
    @Then("kullanici arama kutusuna	iphone kelimesi yazar ve arama tusuna basar .")
    public void kullanici_arama_kutusuna_iphone_kelimesi_yazar_ve_arama_tusuna_basar() {
        favoriurun.searchButonu.clear();
        favoriurun.searchButonu.sendKeys("Iphone",Keys.ENTER);
    }
    @Then("iphone kelimesi aratildi??i dogrulanir")
    public void iphone_kelimesi_aratildi??i_dogrulanir() {
        ReusableMethods.waitFor(2);
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("Iphone"));
    }
    @Then("Arama sonu??lari sayfasindan ikinci sayfa a??ilir.")
    public void arama_sonu??lari_sayfasindan_ikinci_sayfa_a??ilir() {
        favoriurun.ikinciSayfaButonu.click();
        ReusableMethods.waitFor(2);
    }
    @Then("{int}. sayfanin a??ildi??i kontrol edilir.")
    public void sayfanin_a??ildi??i_kontrol_edilir(Integer int1) {
        ReusableMethods.waitFor(3);
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("pg=2"));
    }
    @Then("Sayfadaki {int}. ??r??n favorilere eklenir.")
    public void sayfadaki_??r??n_favorilere_eklenir(Integer int1) {
favoriurun.favoriEklemeButonu.click();
    }
    @Then("Hesabim istek Listem Favorilerim sayfasina gidilir.")
    public void hesabim_istek_listem_favorilerim_sayfasina_gidilir() {
JSutils.scrollIntoVIewJS(favoriurun.myAccountButton);
ReusableMethods.hover(favoriurun.myAccountButton);
ReusableMethods.waitFor(2);
favoriurun.favoriSayfaFavorilerimButton.click();
    }
    @Then("???Favorilerim??? sayfasi a??ildi??i kontrol edilir.")
    public void favorilerim_sayfasi_a??ildi??i_kontrol_edilir() {
        ReusableMethods.waitFor(2);
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("istek-listelerim"));

    }
    @Then("Eklenen ??r??n favorilerden silinir ve silme i??lemi kontrol edilir.")
    public void eklenen_??r??n_favorilerden_silinir_ve_silme_i??lemi_kontrol_edilir() {
favoriurun.favoriSayfaFavorilerimButton.click();
ReusableMethods.waitFor(3);
String ucuncuUrun=favoriurun.favoriListemIlkUrun.get(0).getText();
        System.out.println("Favori listesine eklenen urun :"+ ucuncuUrun);
        favoriurun.confirmSilmeButonu.click();
        ReusableMethods.waitFor(2);
        favoriurun.confirmSilmeButonu.click();
        ReusableMethods.waitFor(2);
        Assert.assertTrue(ucuncuUrun +"urun silindi",favoriurun.favoriListemIlkUrun.size()==0);
    }
    @Then("??ye ??iki?? i??lemi yapilir.")
    public void ??ye_??iki??_i??lemi_yapilir() {

        ReusableMethods.hover(favoriurun.myAccountButton);
        ReusableMethods.waitFor(2);
        favoriurun.cikisYapButonu.click();

    }

}


