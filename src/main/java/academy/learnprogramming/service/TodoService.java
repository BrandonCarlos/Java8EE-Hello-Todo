/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package academy.learnprogramming.service;

import academy.learnprogramming.entity.Todo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional //ou seja todos os métodos aqui dentro farão transações no Banco de dados
public class TodoService {
    //TodoService responsável pelo SELECT, UPDATE, INSERT E DELETE
    
    @PersistenceContext //com está anotação poderemos usar o EntityManager e também usar os ciclos de vida de uma entidade
    EntityManager entityManager;
    
    public Todo createTodo(Todo todo) {
        entityManager.persist(todo);//método persist vai INSERIR dados dentro do banco de dados
        return todo;
    }
    
    public Todo updateTodo(Todo todo) {
        entityManager.merge(todo);//merge recupera dados do banco de dados atráves do SELECT e faz a atualização UPDATE
        return todo;//e retorna esse registro atualizado#
    }
    
    public Todo findToDoById(Long id) {//fazendo a busca na tabela Todo por ID e retornando o registro
        return entityManager.find(Todo.class, id);
    }
    
    public List<Todo> getTodos() {
        return entityManager.createQuery("SELECT t from Todo t", Todo.class).getResultList();//retornando a tabela Todo inteira
    }  
    
}
