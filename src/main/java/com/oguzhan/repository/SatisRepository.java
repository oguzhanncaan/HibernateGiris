package com.oguzhan.repository;

import com.oguzhan.repository.entity.Musteri;
import com.oguzhan.repository.entity.Satis;
import com.oguzhan.utitiliy.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class SatisRepository {

    private Session session;
    private Transaction transaction;

    private void Open(){
        session = HibernateUtility.getSessionFactory().openSession();
        transaction = session.beginTransaction();
    }
    private void CloseCommit(){
        transaction.commit();
        session.close();
    }
    private void CloseRollBack(){
        transaction.rollback();
        session.close();
    }

    public void save(Satis satis){
        try{
            Open();
            session.save(satis); // Eğer kayıt sırasında sorun olursa rollback yapar.
            CloseCommit();
        } catch (Exception exception){
            CloseRollBack();
        }
    }
    public void update(Satis satis){
        try{
            Open();
            session.update(satis); // Eğer kayıt sırasında sorun olursa rollback yapar.
            CloseCommit();
        } catch (Exception exception){
            CloseRollBack();
        }
    }
    public void delete(Satis satis){
        try{
            Open();
            session.delete(satis); // Eğer kayıt sırasında sorun olursa rollback yapar.
            CloseCommit();
        } catch (Exception exception){
            CloseRollBack();
        }
    }
    public List<Satis> findAll(Satis satis){
        List<Satis> result = null;
        Open();
        /**
         * Verilen sorguyu çalıştıracak...
         */
        Query query = session.createSQLQuery("FROM tblsatis ");
        /**
         * Sorgu neticesinde dönen değeri bir listeye atacak...
         */
        result = query.getResultList();
        return result;
    }
}
