/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import controller.ClienteDAO;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import model.Cliente;
/**
 *
 * @author DiegoL
 */
@Path("/cliente")
public class ClienteService {

    @Path("/hello")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello World com Jersey!";
    }

    @Path("/hellohtml")
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String helloHtml() {
        return "<html><head><title>Hello</title>"
                + "</head><body><h1 style='color:blue'>Hello World com Jersey!"
                + "</h1></body></html>";
    }

    @Path("/listar")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String listar() {
        List<Cliente> lista = new ClienteDAO().listar();
        return new Gson().toJson(lista,
                new TypeToken<ArrayList<Cliente>>() 
                    {}.getType()
        );
    }

    @Path("/get/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@PathParam("id")int id) {
        Cliente aluno = new ClienteDAO().get(id);
        return new Gson().toJson(aluno,Cliente.class); 
    }

    @Path("/query")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String query(@QueryParam("id")int id) {
        Cliente aluno = new ClienteDAO().get(id);
        return new Gson().toJson(aluno,Cliente.class); 
    }
    
    @Path("/inserir")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public long inserir(String aluno){
        Cliente a = new Gson().fromJson(aluno, 
                Cliente.class);  
        return new ClienteDAO().inserir(a);
    }     
    
    @Path("/atualizar")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
     @Produces(MediaType.TEXT_PLAIN)
    public long atualizar(String aluno){
        Cliente a = new Gson().fromJson(aluno, 
                Cliente.class);  
        return new ClienteDAO().atualizar(a);
    }     
    
    @Path("/deletar/{id}")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public long deletar(@PathParam("id")int id){
        return new ClienteDAO().deletar(id);
    }     

}
