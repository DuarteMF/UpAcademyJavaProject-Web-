package io.altar.jeeproject.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import io.altar.jeeproject.model.EntityModel;

public class EntityRepository<E extends EntityModel> {
	@PersistenceContext(unitName="database")
	private EntityRepository<E> er;
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("database");
	EntityManager em = emf.createEntityManager();
	
	public void addToDb(E entity){
//		er.getTransaction().begin();
//		er.persist(entity);
		em.persist(entity);
	}
	
	public void removeFromDb(Integer id){
		E entity = em.find(, id);
		em.remove(entity);
	}
	
	public void alterInDb(E entity){
		E entity = em.find(, entity.getId());
		em.merge(entity);
	}
	
//	private Integer id = 0;
//	private LinkedHashMap<Integer,E> entityList = new LinkedHashMap<>();
//	
//	public Integer getNextId(){
//		return ++id;
//	}
//	
//	public void addToList(E entity){
//		entity.setId(getNextId());
//		entityList.put(entity.getId(),entity);
//	 }
//	
//	public void removeElement(Integer id){
//		entityList.remove(id);
//	}
//	
//	public void alterElement(){}
//	
//	public EntityModel get(Integer id){
//		return entityList.get(id);
//	}
//	
//	public boolean isEmpty(){
//		return entityList.isEmpty();
//	}
//	
//	public Set<Integer> keySet(){
//		return entityList.keySet();
//	}
//	
//	public Collection<E> values(){
//		return entityList.values();
//	}
//	
//	public boolean containsKey(Integer key){
//		return entityList.containsKey(key);
//	}
//	
//	public void displayElement(Integer key){
//		System.out.println(entityList.get(key).toString());
//	}
//	
//	public String getList(String listType){
//		String text = String.format("Lista de %s:\n", listType);
//		if (!entityList.isEmpty()) {
//			for (Integer ID : entityList.keySet()) {
//				text += entityList.get(ID).toString();
//			}
//		} else {
//			text += "Vazia!\n";
//		}
//		return text;
//	}
}


