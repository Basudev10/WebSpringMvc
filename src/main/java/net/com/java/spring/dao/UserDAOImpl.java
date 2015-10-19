package net.com.java.spring.dao;

import java.util.List;

//import org.hibernate.SessionFactory;

import net.com.java.spring.model.User;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;


public class UserDAOImpl implements UserDAO {

	private SessionFactory mSessionFactory;
	
	public UserDAOImpl(SessionFactory _SessionFactory) {
		// TODO Auto-generated constructor stub
		this.mSessionFactory = _SessionFactory;
	}
	
	@Override
    @Transactional
 public List<User> list() {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<User> listUser = (List<User>) mSessionFactory.getCurrentSession()
                .createCriteria(User.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
 
        return listUser;

	}

}
