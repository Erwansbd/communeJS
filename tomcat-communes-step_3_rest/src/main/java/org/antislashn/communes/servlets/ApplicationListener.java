package org.antislashn.communes.servlets;

import java.util.logging.Logger;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.antislashn.communes.services.CommuneServices;
import org.apache.tomcat.util.bcel.classfile.Constant;


@WebListener
public class ApplicationListener implements ServletContextListener {
	private static final Logger LOG = Logger.getLogger("communes");
	
	public void contextInitialized(ServletContextEvent sce)  { 
		LOG.info(">>> application démarrée");
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("communes");
		LOG.info(">>> EMF : "+emf);
		ServletContext application = sce.getServletContext();
		application.setAttribute(Constantes.EMF, emf);
		CommuneServices service = new CommuneServices(emf);
		LOG.info(">>> service : "+service);
		application.setAttribute(Constantes.COMMUNE_SERVICE, service);
	}

    public void contextDestroyed(ServletContextEvent sce)  { 
         EntityManagerFactory emf = (EntityManagerFactory) sce.getServletContext().getAttribute(Constantes.EMF);
         emf.close();
         LOG.info(">>> EMF closed");
         LOG.info(">>> application retirée");
    }


	
}
