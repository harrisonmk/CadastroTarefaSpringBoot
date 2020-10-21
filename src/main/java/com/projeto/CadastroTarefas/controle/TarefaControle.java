package com.projeto.CadastroTarefas.controle;

import com.projeto.CadastroTarefas.modelo.Tarefa;
import com.projeto.CadastroTarefas.repositorio.TarefaRepositorio;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/todos")
@CrossOrigin("http://localhost:4200")
public class TarefaControle {

    @Autowired
    private TarefaRepositorio tarefaRepositorio;

    
    @PostMapping
    public Tarefa salvar(@RequestBody Tarefa tarefa) {

        return tarefaRepositorio.save(tarefa);

    }

    
    @GetMapping
    public List<Tarefa> getAll(){
        
     return tarefaRepositorio.findAll();
        
    }
    
    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        
      tarefaRepositorio.deleteById(id);
        
    }
    
    
    @GetMapping("{id}")
    public Tarefa getById(@PathVariable("id") Long id){
        
     return tarefaRepositorio.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        
    }
    
    @PatchMapping("{id}/concluido") //atualizacao parcial atualiza apenas dois atributos da minha classe
    public Tarefa MarcaTarefaConcluida(@PathVariable Long id){
        
      return tarefaRepositorio.findById(id).map(todo -> {
          todo.setTarefaRealizada(true);
          todo.setHoraTarefaConcluida(LocalDateTime.now());  
          tarefaRepositorio.save(todo);
          return todo;
      }).orElse(null);
        
    }
    
    
    
}
