package cn.edu.zjut.daoImpl;

import cn.edu.zjut.dao.UserDao;
import cn.edu.zjut.db.BaseHibernateDAO;
import cn.edu.zjut.po.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.query.Query;

import java.util.List;

/**
 * @author 鲍锋雄
 * UserDao接口实现类
 */
public class UserDaoImpl extends BaseHibernateDAO implements UserDao {
    private Log log = LogFactory.getLog(UserDaoImpl.class);

    @Override
    public List findByHql(String hql) {
        log.debug("finding User instance by hql");
        try {
            String queryString = hql;
            Query queryObject = getSession().createQuery(queryString);
            return queryObject.list();
        } catch (RuntimeException re) {
            log.error("find by hql failed", re);
            throw re;
        }
    }

    @Override
    public void save(User user) {
        log.debug("saving User instance");
        try {
            getSession().save(user);
            log.debug("save successful");
        } catch (RuntimeException e) {
            log.error("save failed", e);
            throw e;
        }
    }

    /**
     * 根据指定属性查询用户
     *
     * @param property
     * @param value
     * @return
     */
    public List findByProperty(String property, Object value) {
        log.debug("finding User instance with property: " + property + ", value: " + value);
        try {
            String queryString = "from User as user where user." + property + "= ?1";
            Query queryObject = getSession().createQuery(queryString);
            queryObject.setParameter(1, value);
            List list = queryObject.list();
            return list;
        } catch (RuntimeException re) {
            log.error("find by property failed", re);
            throw re;
        }
    }

    @Override
    public User findById(int id) {
        log.debug("finding User instance by Id");
        try {
            String queryString = "from User as user where user.id = :id ";
            Query queryObject = getSession().createQuery(queryString);
            queryObject.setInteger("id", id);
            return (User) queryObject.list().get(0);
        } catch (RuntimeException re) {
            log.error("find by id failed", re);
            throw re;
        }
    }

    @Override
    public User findByEmail(String email) {
        log.debug("finding User instance by email");
        List<User> users = findByProperty("email", email);
        if (users != null && users.size() > 0) {
            return users.get(0);
        } else {
            return null;
        }
    }

    @Override
    public User findByUsername(String username) {
        log.debug("finding User instance by username");
        List<User> users = findByProperty("username", username);
        if (users != null && users.size() > 0) {
            return users.get(0);
        } else {
            return null;
        }
    }

}