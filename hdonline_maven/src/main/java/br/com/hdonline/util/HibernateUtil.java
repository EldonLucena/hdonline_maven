
package br.com.hdonline.util;

import com.mysql.cj.x.protobuf.Mysqlx;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    
    private static final SessionFactory sessionfactory;
    public static final String HIBERNATE_SESSION = "hibernate_sassion";
    
    static{
        try {
            System.out.println("Configurando SessionFactory");
            Configuration configuration = new Configuration().configure();
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().
                    applySettings(configuration.getProperties()).getBootstrapServiceRegistry();
            
            sessionfactory = configuration.buildSessionFactory(serviceRegistry);
        
            System.out.println("SessionFactory criado com sucesso!");
        } catch (Exception ex) {
            System.out.println("Ocorreu um erro ao iniciar a sessionFactory: "+ex);
            throw new ExceptionInInitializerError(ex);
        }
        
    }

    public static SessionFactory getSessionfactory() {
        return sessionfactory;
    }
}
