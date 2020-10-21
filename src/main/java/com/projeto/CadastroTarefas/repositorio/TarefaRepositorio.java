
package com.projeto.CadastroTarefas.repositorio;

import com.projeto.CadastroTarefas.modelo.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefaRepositorio extends JpaRepository<Tarefa,Long> {
    
    
    
    
}
