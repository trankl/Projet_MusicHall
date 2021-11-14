package org.restapi.crud.musichall.resource;

import java.util.List;

import org.restapi.crud.musichall.model.Slogan;
import org.restapi.crud.musichall.service.SloganService;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;


@Path ("/slogan")
public class SloganResource {
	
		private SloganService service = new SloganService();

		@GET
	    @Produces(MediaType.TEXT_PLAIN)
		public String getIt() {
	        return "Got slogan!!!!";
	    }
	
		//cette methode a definit la partie de l'url d'acces a webservice sous path /getAllSlogans
		//elle s'utilise avec GET
		//elle prend du JSON en entree
		@Path ("/getAllSlogans")
		@GET  
		@Produces(MediaType.APPLICATION_JSON) 
		public List<Slogan> getAllSlogan () throws Exception {
			// On demande au service d'executer la methode "getAll" et retour la liste
			return service.getAllSlogan();

		}

	
		//cette methode a definit la partie de l'url d'acces a webservice sous path /insertionSlogan
		//elle s'utilise avec POST
		//elle prend du JSON en entree
		@Path ("/insertionSlogan")
		@POST  
		@Consumes(MediaType.APPLICATION_JSON) 
		public Slogan addSlogan (Slogan slogan) throws Exception {
			// On demande au service d'executer la methode "insertSlogan" et retour slogan
			return service.insertSlogan(slogan);
			
		}	
		
		//cette methode a definit la partie de l'url d'acces a webservice sous path /updateSlogan
		//elle s'utilise avec POST
		//elle prend du JSON en entree
		@Path("/updateSlogan/{id}")
		@POST
		@Consumes(MediaType.APPLICATION_JSON)
		public void updateSlogan (Slogan slogan, @PathParam("id") int id) throws Exception {
			// On demande au service d'executer la methode "update" 
			service.updateSlogan(slogan, id);
		}
		
		//cette methode a definit la partie de l'url d'acces a webservice sous path /deleteSlogan/{id}
		//elle s'utilise avec DELETE
		//elle prend du JSON en entree
		@Path ("/deleteSlogan/{id}")
		@DELETE  
		@Consumes(MediaType.APPLICATION_JSON) 
		public void deleteSlogan (@PathParam("id") int id) throws Exception {
			// On demande au service d'executer la methode "remove" 
			service.removeSlogan(id);
			
		}
		

		//cette methode a definit la partie de l'url d'acces a webservice sous path //findbyIDSlogan/{id}
		//elle s'utilise avec GET
		//elle prend du JSON en entree
		@Path("/findbyIDSlogan/{id}")
		@GET
		@Produces(MediaType.APPLICATION_JSON)
		public Slogan getSlogan (@PathParam("id") int id) throws Exception {
			// On demande au service d'executer la methode "findById(id)" et retour la slogan avec id recherche
			return service.findById(id);
		}
}
