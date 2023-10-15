package com.juaracoding;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class FinancialTest {

    private AndroidDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {

        // Desired Capabilities
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("deviceName", "Pixel 2 API 30");
        desiredCapabilities.setCapability("udid", "emulator-5554");
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("appPackage", "com.chad.financialrecord");
        desiredCapabilities.setCapability("appActivity", "com.rookie.catatankeuangan.feature.splash.SplashActivity");
        desiredCapabilities.setCapability("noReset", true);

        // URL
        URL url = new URL("http://127.0.0.1:4723/wd/hub");

        // Instance AndroidDriver
        driver = new AndroidDriver(url, desiredCapabilities);

    }

    @AfterClass
    public void finish() {
        driver.quit();
    }

    @Test
    public void testAdd(){
        MobileElement tambah = (MobileElement) driver.findElementById("com.chad.financialrecord:id/fabMenu");
        tambah.click();
        MobileElement pemasukan = (MobileElement) driver.findElementById("com.chad.financialrecord:id/btnIncome");
        pemasukan.click();
        MobileElement tglMasuk = (MobileElement) driver.findElementById("com.chad.financialrecord:id/tvDate");
        tglMasuk.click();
        MobileElement pilihTanggalMasuk = (MobileElement) driver.findElementByXPath("//android.view.View[@content-desc=\"16 Oktober 2023\"]");
        pilihTanggalMasuk.click();
        MobileElement simpanTanggalMasuk = (MobileElement) driver.findElementById("android:id/button1");
        simpanTanggalMasuk.click();
        MobileElement kategoriPemasukan = (MobileElement) driver.findElementById("com.chad.financialrecord:id/tvName");
        kategoriPemasukan.click();
        MobileElement pilihKategoriMasuk = (MobileElement) driver.findElementByXPath("//android.widget.ListView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.TextView");
        pilihKategoriMasuk.click();
        MobileElement jumlahMasuk = (MobileElement) driver.findElementById("com.chad.financialrecord:id/etAmount");
        jumlahMasuk.sendKeys("100000");
        MobileElement keterangan = (MobileElement) driver.findElementById("com.chad.financialrecord:id/etNote");
        keterangan.sendKeys("Gaji Bulanan");
        MobileElement btSimpan = (MobileElement) driver.findElementById("com.chad.financialrecord:id/btSave");
        btSimpan.click();
        String txtKeterangan = keterangan.getText();
        System.out.println(txtKeterangan);
        Assert.assertEquals(txtKeterangan,"Gaji Bulanan");

    }

    @Test
    public void testSub(){
        MobileElement tambahDua = (MobileElement) driver.findElementById("com.chad.financialrecord:id/fabMenu");
        tambahDua.click();
        MobileElement pengeluaran = (MobileElement) driver.findElementById("com.chad.financialrecord:id/btnExpense");
        pengeluaran.click();
        MobileElement tglKeluar = (MobileElement) driver.findElementById("com.chad.financialrecord:id/tvDate");
        tglKeluar.click();
        MobileElement pilihTanggalKeluar = (MobileElement) driver.findElementByXPath("//android.view.View[@content-desc=\"17 Oktober 2023\"]");
        pilihTanggalKeluar.click();
        MobileElement simpanTanggalKeluar = (MobileElement) driver.findElementById("android:id/button1");
        simpanTanggalKeluar.click();
        MobileElement kategoriPengeluaran = (MobileElement) driver.findElementById("com.chad.financialrecord:id/tvName");
        kategoriPengeluaran.click();
        MobileElement pilihKategoriPengeluaran = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[12]/android.widget.LinearLayout/android.widget.TextView");
        pilihKategoriPengeluaran.click();
        MobileElement jumlahKeluar = (MobileElement) driver.findElementById("com.chad.financialrecord:id/etAmount");
        jumlahKeluar.sendKeys("50000");
        MobileElement keteranganKeluar = (MobileElement) driver.findElementById("com.chad.financialrecord:id/etNote");
        keteranganKeluar.sendKeys("Pengeluaran Tagihan Listrik");
        MobileElement btnSimpan = (MobileElement) driver.findElementById("com.chad.financialrecord:id/btSave");
        btnSimpan.click();
        /*String txtKeteranganKeluar = keteranganKeluar.getText();
        System.out.println(txtKeteranganKeluar);
        Assert.assertEquals(txtKeteranganKeluar,"Pengeluaran Tagihan Listrik");*/

    }

}
