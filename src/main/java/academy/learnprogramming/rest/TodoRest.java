package academy.learnprogramming.rest;

import academy.learnprogramming.entity.Todo;
import academy.learnprogramming.service.TodoService;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("todo")//localhost:8080/api/v1/todo <- acessamos por esta URL
@Consumes(MediaType.APPLICATION_JSON) //Vamos consumir dados do tipo JSON
@Produces(MediaType.APPLICATION_JSON)// vamos produzir pro usuário dados JSON
public class TodoRest {
    
    @Inject //CDI = evita o acoplamento com o banco de dados, por tanto nem fizemos instânciação e já temos a referência e podemos usar
    TodoService todoService;
    
    @Path("new")//localhost:8080/api/v1/todo/new
    @POST
    public Response createTodo(Todo todo) {
        todoService.createTodo(todo);
        return Response.ok(todo).build();//retornando para o usuário status de 200 e Todo que foi cadastrado no banco de dados
    }
    
    @Path("update")
    @PUT
    public Response updateTodo(Todo todo) {
        todoService.updateTodo(todo);
        return Response.ok(todo).build();
    }  
    
    @Path("{id}")
    @GET
    public Todo getTodo(@PathParam("id") Long id) {
        return todoService.findToDoById(id);//vai fazer um SELECT dentro do banco de dados e retornam 1 registro
    }
    
    @Path("list")
    @GET
    public List<Todo> getTodos() {
        return todoService.getTodos();
    }
        
}
