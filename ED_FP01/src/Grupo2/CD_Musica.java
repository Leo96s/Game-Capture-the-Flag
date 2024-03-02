/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grupo2;

/**
 *
 * @author Leona
 */
public class CD_Musica implements MediaTitle{
        private String nome;
        
        private String autor;
        
        private String data;
        
        private String duracao;

    public CD_Musica(String nome, String autor, String data, String duracao) {
        this.nome = nome;
        this.autor = autor;
        this.data = data;
        this.duracao = duracao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CD_Musica{");
        sb.append("nome=").append(nome);
        sb.append(", autor=").append(autor);
        sb.append(", data=").append(data);
        sb.append(", duracao=").append(duracao);
        sb.append('}');
        return sb.toString();
    }

    
        
        
}
