/**
 * 
 */
package br.ufu.bau.util;

import org.hibernate.SessionFactory; 
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

/**
 * @author artur.rodrigues
 *
 */
public class ConnectDB {
	private final static SessionFactory sf;
	private  final static ThreadLocal<Session> th = new ThreadLocal<Session>();	
	static{
		try{
			Configuration conf = new Configuration().configure("/conf/hibernate.cfg.xml");
			 SchemaExport se = new SchemaExport(conf);
	         se.create(true, false);
	         sf = conf.buildSessionFactory();
		}catch(Throwable e){
			System.out.println("Session Factory não inicializada" + e);
			throw new ExceptionInInitializerError(e); 
		}
	}
	
	public static Session getSession(){
		Session session = th.get();
		session = sf.openSession();
		th.set(session);
		return session;
	}
}
