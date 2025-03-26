package com.vimal.demorest;

import java.util.List;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("aliens")
public class AlienResource {

   AlienRepository repo=new AlienRepository();
@GET
@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
public List<Alien> getAliens() {
	System.out.println("getAlien called...");
	return repo.getAliens();
}
@GET
@Path("alien/{id}")
@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
public Alien getAlien(@PathParam("id") int id) {
	System.out.println("getAlien called...");
	return repo.getAlien(id);
}
@POST
@Path("alien")
@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON}) // Accepts XML and JSON
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON}) // Returns XML or JSON
public Alien createAlien(Alien a1) {
    System.out.println(a1);
    repo.create(a1);
    return a1;
}
@PUT
@Path("alien")
@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON}) // Accepts XML and JSON
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON}) // Returns XML or JSON
public Alien updateAlien(Alien a1) {
    System.out.println(a1);
    if(repo.getAlien(a1.getId()).getId()==0) {
    return null;	
    }else {
    repo.update(a1);
    return a1;
    }
}
@DELETE
@Path("alien/{id}")
@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
public Alien deleteAlien(@PathParam("id") int id) {
	System.out.println("deleteAlien called...");
	Alien res=new Alien();
	if(repo.getAlien(id).getId()==0) {
	    return null;	
	}
	else {
		res=repo.getAlien(id);
		repo.deleteAlien(id);
	}
	return res;
}
}
