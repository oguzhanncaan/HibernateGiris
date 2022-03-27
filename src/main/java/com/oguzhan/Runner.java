package com.oguzhan;

import com.oguzhan.repository.MusteriRepository;
import com.oguzhan.repository.entity.Musteri;
import com.oguzhan.utitiliy.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Runner {
    public static void main(String[] args) {
        /** kayıt v1
         * Musteri mst = new Musteri();
         *         mst.setAd("Ahmet");
         *         mst.setSoyad("Baş");
         *         mst.setAdres("İzmir");
         *         MusteriRepository dbmusteri = new MusteriRepository();
         *         dbmusteri.save(mst);
         */

        // Kayıt V2:
        new MusteriRepository().save(new Musteri("Mehmet","Atak","Samsun"));


    }

    private static void saveHibernate(){
        /**
         * Hibernate ile Veri Eklemek
         * 1-Bağlantıyı Aç (Oturum oluşturmak,Başlatmak)
         * Hibernate yönetici dosyası olan utility, bağlantıyı açar ve yeni bir oturum oluşturur.
         */
        Session session = HibernateUtility.getSessionFactory().openSession();
        /**
         * 2-Transaction oluştur ve sistemi izlemeye başla.
         */
        Transaction transaction = session.beginTransaction();
        Musteri musteri1 = new Musteri("Oğuzhan", "Can","Ankara");
        session.save(musteri1);
        transaction.commit();
        session.close();
    }
}
