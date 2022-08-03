/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package academy.learnprogramming.entity;

import java.time.LocalDate;
import javax.json.bind.annotation.JsonbDateFormat;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity //Create persistence unit
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)//id vai aumentar de 1 em 1
    private Long id;

    //Abaixo temos 2 Annotation validations
    @NotEmpty(message = "Task must be set")//faz com que este campo não permite valor vázio
    @Size(min = 10, message = "Task should not be less than characters")//no minimo usuário precisa colocar 10 caracteres
    private String task;
    
    @NotNull(message = "Due must be set")//Ou seja não podemos esquecer de colocar o "dueDate"
    @FutureOrPresent(message = "Dude must be in the present or future")
    @JsonbDateFormat(value = "yyyy-MM-dd")//usuário vai enviar o dueDate neste formato JSON = "yyyy-MM-dd"
    private LocalDate dueDate;
    private boolean isCompleted;
    private LocalDate dateCompleted;
    private LocalDate dateCreated;

    @PrePersist //Antes de inserir no banco de dados chame este método, ou seja este campo vai ser preenchido automáticamente
    private void init() {
        setDateCreated(LocalDate.now());//que no caso vai colocar a Date atual e vai inserir no Banco de dados
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    public LocalDate getDateCompleted() {
        return dateCompleted;
    }

    public void setDateCompleted(LocalDate dateCompleted) {
        this.dateCompleted = dateCompleted;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

}
