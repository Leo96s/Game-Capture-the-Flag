/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grupo2;

/**
 *
 * @author Leona
 */
public class Video implements MediaTitle {
    
        private String nome;
        
        private String duracao;
        
        private String genero;

    public Video(String nome, String duracao, String genero) {
        this.nome = nome;
        this.duracao = duracao;
        this.genero = genero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Video{");
        sb.append("nome=").append(nome);
        sb.append(", duracao=").append(duracao);
        sb.append(", genero=").append(genero);
        sb.append('}');
        return sb.toString();
    }
        
        
}
