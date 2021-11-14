package org.restapi.crud.musichall.resource;

import java.util.List;

import org.restapi.crud.musichall.model.Instrument;
import org.restapi.crud.musichall.service.InstrumentService;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;


@Path ("/instrument")
public class InstrumentResource {
	
		private InstrumentService service = new InstrumentService();

		@GET
	    @Produces(MediaType.TEXT_PLAIN)
		public String getIt() {
	        return "Got instrument!!!!";
	    }
	
		//cette methode a definit la partie de l'url d'acces a webservice sous path /getAllInstruments
		//elle s'utilise avec GET
		//elle prend du JSON en entree
		@Path ("/getAllInstruments")
		@GET  
		@Produces(MediaType.APPLICATION_JSON) 
		public List<Instrument> getAllInstrument () throws Exception {
			// On demande au service d'executer la methode "getAll" et retour la liste
			return service.getAllInstrument();

		}

	
		//cette methode a definit la partie de l'url d'acces a webservice sous path /insertionInstrument
		//elle s'utilise avec POST
		//elle prend du JSON en entree
		@Path ("/insertionInstrument")
		@POST  
		@Consumes(MediaType.APPLICATION_JSON) 
		public Instrument addInstrument (Instrument instrument) throws Exception {
			// On demande au service d'executer la methode "insertInstrument" et retour instrument
			return service.insertInstrument(instrument);
			
		}	
		
		//cette methode a definit la partie de l'url d'acces a webservice sous path /updateInstrument
		//elle s'utilise avec POST
		//elle prend du JSON en entree
		@Path("/updateInstrument/{id}")
		@POST
		@Consumes(MediaType.APPLICATION_JSON)
		public void updateInstrument (Instrument instrument, @PathParam("id") int id) throws Exception {
			// On demande au service d'executer la methode "update" 
			service.updateInstrument(instrument, id);
		}
		
		//cette methode a definit la partie de l'url d'acces a webservice sous path /deleteInstrument/{id}
		//elle s'utilise avec DELETE
		//elle prend du JSON en entree
		@Path ("/deleteInstrument/{id}")
		@DELETE  
		@Consumes(MediaType.APPLICATION_JSON) 
		public void deleteInstrument (@PathParam("id") int id) throws Exception {
			// On demande au service d'executer la methode "remove" 
			service.removeInstrument(id);
			
		}
		

		//cette methode a definit la partie de l'url d'acces a webservice sous path //findbyIDInstrument/{id}
		//elle s'utilise avec GET
		//elle prend du JSON en entree
		@Path("/findbyIDInstrument/{id}")
		@GET
		@Produces(MediaType.APPLICATION_JSON)
		public Instrument getInstrument (@PathParam("id") int id) throws Exception {
			// On demande au service d'executer la methode "findById(id)" et retour la instrument avec id recherche
			return service.findById(id);
		}
}
