package org.restapi.crud.musichall.resource;

import java.util.List;

import org.restapi.crud.musichall.model.Concert;
import org.restapi.crud.musichall.service.ConcertService;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;


@Path ("/concert")
public class ConcertResource {
	
		private ConcertService service = new ConcertService();

		@GET
	    @Produces(MediaType.TEXT_PLAIN)
		public String getIt() {
	        return "Got concert!!!!";
	    }
	
		//cette methode a definit la partie de l'url d'acces a webservice sous path /getAllConcerts
		//elle s'utilise avec GET
		//elle prend du JSON en entree
		@Path ("/getAllConcerts")
		@GET  
		@Produces(MediaType.APPLICATION_JSON) 
		public List<Concert> getAllConcert () throws Exception {
			// On demande au service d'executer la methode "getAll" et retour la liste
			return service.getAllConcert();

		}

	
		//cette methode a definit la partie de l'url d'acces a webservice sous path /insertionConcert
		//elle s'utilise avec POST
		//elle prend du JSON en entree
		@Path ("/insertionConcert")
		@POST  
		@Consumes(MediaType.APPLICATION_JSON) 
		public Concert addConcert (Concert concert) throws Exception {
			// On demande au service d'executer la methode "insertConcert" et retour concert
			return service.insertConcert(concert);
			
		}	
		
		//cette methode a definit la partie de l'url d'acces a webservice sous path /updateConcert
		//elle s'utilise avec POST
		//elle prend du JSON en entree
		@Path("/updateConcert/{id}")
		@POST
		@Consumes(MediaType.APPLICATION_JSON)
		public void updateConcert (Concert concert, @PathParam("id") int id) throws Exception {
			// On demande au service d'executer la methode "update" 
			service.updateConcert(concert, id);
		}
		
		//cette methode a definit la partie de l'url d'acces a webservice sous path /deleteConcert/{id}
		//elle s'utilise avec DELETE
		//elle prend du JSON en entree
		@Path ("/deleteConcert/{id}")
		@DELETE  
		@Consumes(MediaType.APPLICATION_JSON) 
		public void deleteConcert (@PathParam("id") int id) throws Exception {
			// On demande au service d'executer la methode "remove" 
			service.removeConcert(id);
			
		}
		

		//cette methode a definit la partie de l'url d'acces a webservice sous path //findbyIDConcert/{id}
		//elle s'utilise avec GET
		//elle prend du JSON en entree
		@Path("/findbyIDConcert/{id}")
		@GET
		@Produces(MediaType.APPLICATION_JSON)
		public Concert getConcert (@PathParam("id") int id) throws Exception {
			// On demande au service d'executer la methode "findById(id)" et retour la concert avec id recherche
			return service.findById(id);
		}
}
