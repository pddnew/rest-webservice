package br.edu.pddnew.rest.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import br.edu.pddnew.rest.model.Person;

@Path("/person")
public class PersonResource {

	private Person	person = new Person();
	@Context
	UriInfo uriInfo;
	@Context
	Request request;
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String respondAsReady(){
		return "Demo service is ready!";
	}
	
	@GET
	@Path("sample")
	@Produces(MediaType.APPLICATION_JSON)
	public Person getSamplePerson(){
		return person;
	}
	
	@GET
	@Path("xml/sample/{age}")
	@Produces(MediaType.APPLICATION_ATOM_XML)
	public Person getSamplePersonXml(@PathParam("age") int age){
		person.setAge(age);
		return person;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(value={"application/json; charset=UTF-8"})
	public Person postPerson(MultivaluedMap<String, String> personParams){
		person.setFirstName(personParams.getFirst("firstName"));
		person.setLastName(personParams.getFirst("lastName"));
		person.setEmail(personParams.getFirst("email"));
		return person;
	}
}
