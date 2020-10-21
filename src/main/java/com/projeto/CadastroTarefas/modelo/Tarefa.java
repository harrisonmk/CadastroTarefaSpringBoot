package com.projeto.CadastroTarefas.modelo;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;

@Entity
public class Tarefa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    private boolean tarefaRealizada;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm") //formata o json gerado
    private LocalDateTime horaCriacaoTarefa;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm") //formata o json gerado
    private LocalDateTime horaTarefaConcluida;

    @PrePersist
    public void beforeSave() {

        setHoraCriacaoTarefa(LocalDateTime.now());

    }

    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isTarefaRealizada() {
        return tarefaRealizada;
    }

    public void setTarefaRealizada(boolean tarefaRealizada) {
        this.tarefaRealizada = tarefaRealizada;
    }

    public LocalDateTime getHoraCriacaoTarefa() {
        return horaCriacaoTarefa;
    }

    public void setHoraCriacaoTarefa(LocalDateTime horaCriacaoTarefa) {
        this.horaCriacaoTarefa = horaCriacaoTarefa;
    }

    public LocalDateTime getHoraTarefaConcluida() {
        return horaTarefaConcluida;
    }

    public void setHoraTarefaConcluida(LocalDateTime horaTarefaConcluida) {
        this.horaTarefaConcluida = horaTarefaConcluida;
    }

    
    
    
}
