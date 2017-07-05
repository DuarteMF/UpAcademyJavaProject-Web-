package io.altar.jeeproject.repository;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.UserTransaction;

import io.altar.jeeproject.model.EntityModel;

public class EntityRepository<E extends EntityModel> {
	@PersistenceContext(unitName="database")
	private EntityManager em;
	
	@Resource
    private UserTransaction userTransaction;
	
	public EntityManager getDb(){
		return em;
	}
	
	@Transactional
	public void addToDb(E entity){
		em.persist(entity);
	}
	
//	public List<E> getDbElements() {
//		Query query = em.createQuery("FROM Product");
//		List<E> dbElements = (List<E>) query.getResultList();
//		return dbElements;
//	}
	
//	public void removeFromDb(Integer id){
//		E entity = em.find(EntityModel.class, id);
//		em.remove(entity);
//	}
	
	@Transactional
	public void removeFromDb(E entity){
//		E entityToRemove = em.find((Class<E>) EntityModel.class, entity.getId());
//		em.remove(entityToRemove);
	}
//	
	@Transactional
	public void alterInDb(E newEntity){
//		E dbEntity = em.find(E.class, entity.getId());
		em.merge(newEntity);
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


