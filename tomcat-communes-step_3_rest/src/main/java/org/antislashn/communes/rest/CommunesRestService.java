package org.antislashn.communes.rest;

import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.antislashn.communes.entities.Commune;
import org.antislashn.communes.services.CommuneServices;
import org.antislashn.communes.servlets.Constantes;


@Path("/communes")
public class CommunesRestService {
	@Inject ServletContext application;
	
	@Path("/id/{id}")
	@GET @Produces(MediaType.APPLICATION_JSON)
	public Commune getCommuneById(@PathParam("id") long id) {
		CommuneServices service = (CommuneServices) application.getAttribute(Constantes.COMMUNE_SERVICE);
		return service.findById(id);
	}
	
	@Path("/cp/{cp}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Commune> getCommunesByDebutCodePostal(@PathParam("cp") String codePostal){
		CommuneServices service = (CommuneServices) application.getAttribute(Constantes.COMMUNE_SERVICE);
		return service.getCommunesByCodePostal(codePostal);				
	}
}
