package org.restapi.crud.musichall.control;

import java.util.List;

import org.restapi.crud.musichall.model.Musicien;
import org.restapi.crud.musichall.service.MusicienService;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;


@Path ("/musicien")
public class MusicienController {

		@GET
	    @Produces(MediaType.TEXT_PLAIN)
		public String getIt() {
	        return "Got Musicien!!!!";
	    }
	
	
private MusicienService service = new MusicienService();
	
		//cette methode a definit la partie de l'url d'acces a webservice sous path /insertionMusicien
		//elle s'utilise avec POST
		//elle prend du JSON en entree
		@Path ("/insertionMusicien")
		@POST  
		@Consumes(MediaType.APPLICATION_JSON) 
		public Musicien addMusicien (Musicien musicien) throws Exception {
			// On demande au service d'executer la methode "insertMusicien" et retour user
			return service.insertMusicien(musicien);
			
		}	

		//cette methode a definit la partie de l'url d'acces a webservice sous path /getAllMusiciens
		//elle s'utilise avec GET
		//elle prend du JSON en entree
		@Path ("/getAllMusiciens")
		@GET  
		@Produces(MediaType.APPLICATION_JSON) 
		public List<Musicien> getAllMusicien () throws Exception {
		// On demande au service d'executer la methode "getAll" et retour la liste
		return service.getAll();
		
	}
	
		//cette methode a definit la partie de l'url d'acces a webservice sous path //findbyIDMusicien/{id}
		//elle s'utilise avec GET
		//elle prend du JSON en entree
		@Path("/findbyIDMusicien/{id}")
		@GET
		@Produces(MediaType.APPLICATION_JSON)
		public Musicien getMusicien (@PathParam("id") int id) throws Exception {
			// On demande au service d'executer la methode "findById(id)" et retour la musicien avec id recherche
			return service.findById(id);
		}
		
		//cette methode a definit la partie de l'url d'acces a webservice sous path /updateMusicien
		//elle s'utilise avec POST
		//elle prend du JSON en entree
		@Path("/updateMusicien/{id}")
		@POST
		@Consumes(MediaType.APPLICATION_JSON)
		public void updateMusicien (Musicien musicien, @PathParam("id") int id) throws Exception {
			// On demande au service d'executer la methode "update" 
			service.update(musicien, id);
		}
		
		//cette methode a definit la partie de l'url d'acces a webservice sous path /deleteMusicien/{id}
		//elle s'utilise avec DELETE
		//elle prend du JSON en entree
		@Path ("/deleteMusicien/{id}")
		@DELETE  
		@Consumes(MediaType.APPLICATION_JSON) 
		public void deleteMusicien (@PathParam("id") int id) throws Exception {
			// On demande au service d'executer la methode "remove" 
			service.removeMusicien(id);
			
		}
}
