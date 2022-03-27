package com.oguzhan.utitiliy;

import com.oguzhan.repository.entity.Musteri;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Java Generic Types
 */
public class VTİsletimcisi<T> {
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

    public void save(T t){
        try{
            Open();
            session.save(t); // Eğer kayıt sırasında sorun olursa rollback yapar.
            CloseCommit();
        } catch (Exception exception){
            CloseRollBack();
        }
    }
    public void update(T t){
        try{
            Open();
            session.update(t); // Eğer kayıt sırasında sorun olursa rollback yapar.
            CloseCommit();
        } catch (Exception exception){
            CloseRollBack();
        }
    }
    public void delete(T t){
        try{
            Open();
            session.delete(t); // Eğer kayıt sırasında sorun olursa rollback yapar.
            CloseCommit();
        } catch (Exception exception){
            CloseRollBack();
        }
    }
    public List<T> findAll(T t){
        List<T> result = null;
        Open();
        /**
         * Verilen sorguyu çalıştıracak...
         */
        Query query = session.createSQLQuery("FROM tblmusteri ");
        /**
         * Sorgu neticesinde dönen değeri bir listeye atacak...
         */
        result = query.getResultList();
        return result;
    }
}
