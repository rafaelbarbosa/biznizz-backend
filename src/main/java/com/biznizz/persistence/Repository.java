package com.biznizz.persistence;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class Repository<T,I> {

    @PersistenceContext
    protected EntityManager em;

    public T getById(I id){
        return (T)em.find(Object.class,id);
    }


    public List<T> getAll(){
        return (List<T>)em.createQuery("from T t").getResultList();
    }



    public T save(T obj){
        if(em.contains(obj)){
            em.merge(obj);
        }
        else{
            em.persist(obj);
        }
        return  obj;
    }

}
