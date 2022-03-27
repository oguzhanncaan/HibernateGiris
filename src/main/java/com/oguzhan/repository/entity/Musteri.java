package com.oguzhan.repository.entity;

import javax.persistence.*;

/**
 * @ -> Annotation
 * Emtity, sınıfın bir veritabanı varlığı olduğunu niteliyoruz.
 */
@Entity
/**
 * Bu sınıfın bir tablo olduğunu ve özelliklerinin neler olduğunu belirtmek için kullanıyoruz.
 * Eğer name property kullanılmaz ise sınıf adı tablo adı olarak kullanılır.
 * name --> sınıfın veritabanındaki adının ne olacağını bildiririz.
 */
@Table(name = "tblmusteri")
public class Musteri {
    /**
     * @Id bir değişkenin primary key olduğunu işaretlemek için kullanılır.
     */
    @Id
    /**
     * Id nin otamatik sayı olarak kullanılabilmesi için 2 farklı yöntem vardır;
     * 1- Bize sunulan otamatik sayı üreten Strategy Type
     * @GeneratedValue(strategy = GenerationType.AUTO)
     * 2- Elle Sequence oluşturulabilir ve bunu generate edebiliriz.
     *  @SequenceGenerator(name = "sq_tblmusteri_id",
     *                        sequenceName = "sq_tblmusteri_id",
     *                        initialValue = 1,
     *                        allocationSize = 5)
     *     @GeneratedValue(generator = "sq_tblmusteri_id")
     */
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    /**
     * Eğer alanlarımızı hiçbir annotation eklemeden bırakırsak default değerler ile devam eder.
     * String bir alan -> varchar olur ve max uzunluğu 255 karakter olarak atanır.
     */
    @Column(name = "musteriadi",length = 100,nullable = false)
    String ad;
    String soyad;
    @Column(length = 500)
    String adres;

    public Musteri() {
    }

    public Musteri(String ad, String soyad, String adres) {
        this.ad = ad;
        this.soyad = soyad;
        this.adres = adres;
    }

    public Musteri(long id, String ad, String soyad, String adres) {
        this.id = id;
        this.ad = ad;
        this.soyad = soyad;
        this.adres = adres;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    @Override
    public String toString() {
        return "Musteri{" +
                "id=" + id +
                ", ad='" + ad + '\'' +
                ", soyad='" + soyad + '\'' +
                ", adres='" + adres + '\'' +
                '}';
    }
}
