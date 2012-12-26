package org.jboss.jdf.example.ticketmonster.rest;


import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.jdf.example.ticketmonster.model.Event;


@Path("/events-ejb")
@Stateless
public class EventResourceRESTServiceBean {
	
	@Inject
	private EntityManager em;
	
	@GET
	@Path("/xml")
	@Produces(MediaType.APPLICATION_XML)
	public List<Event> getAllEventsXML(){
		return getAllEvents();		
	}

	
	
	@GET
	@Path("/json")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Event> getAllEventsJSON(){
		return getAllEvents();	
	}
	
	
	private List<Event> getAllEvents() {
		final List<Event> results = em.createQuery("select e from Event e order by e,name").getResultList();
		return results;
	}

}
