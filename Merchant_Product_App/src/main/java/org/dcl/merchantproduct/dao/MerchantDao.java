package org.dcl.merchantproduct.dao;

import javax.persistence.*;
import org.dcl.merchantproduct.dto.Merchant;

public class MerchantDao {
	
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("dev");
	EntityManager man=emf.createEntityManager();
	public Merchant saveMerchant(Merchant m) {
		EntityTransaction tran=man.getTransaction();
		tran.begin();
		man.persist(m);
		tran.commit();
		return m;
	}
	public Merchant updateMerchant(Merchant m) {
		EntityTransaction tran=man.getTransaction();
		tran.begin();
		Merchant mdb=man.find(Merchant.class, m.getId());
		if (mdb!=null) {
			mdb.setName(m.getName());
			mdb.setGstNum(m.getGstNum());
			mdb.setPhone(m.getPhone());
			mdb.setEmail(m.getEmail());
			mdb.setPassword(m.getPassword());
			tran.commit();
			return mdb;
		}else {
			return null;
		}
	}
	public Merchant findMerchantById(int  id) {
		Merchant mdb=man.find(Merchant.class, id);
		if(mdb!=null) {
			return mdb;
		}else {
			return null;
		}
	}
	public Merchant verifyMerchantByEmailAndPassword(String emailId, String pwd) {
		Query q=man.createQuery("select m from Merchant m where email=?1 and password=?2");
		q.setParameter(1, emailId);
		q.setParameter(2, pwd);
		Merchant mdb=(Merchant) q.getSingleResult();
		if(mdb!=null) {
			return mdb;
		}else {
			return null;
		}
	}
	public Merchant verifyMerchantByPhoneAndPassword(long phone, String pwd) {
		Query q=man.createQuery("select m from Merchant m where m.phone=?1 and m.password=?2");
		q.setParameter(1, phone);
		q.setParameter(2, pwd);
		Merchant mdb=(Merchant) q.getSingleResult();
		if(mdb!=null) {
			return mdb;
		}else {
			return null;
		}
	}

}
