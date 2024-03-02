/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grupo2;

/**
 *
 * @author Leona
 */
public class Livro implements MediaTitle {
    
        private String nome;
        
        private String autor;
        
        private String data_lancamento;
        
        private int numero_paginas;

    public Livro(String nome, String autor, String data_lancamento, int numero_paginas) {
        this.nome = nome;
        this.autor = autor;
        this.data_lancamento = data_lancamento;
        this.numero_paginas = numero_paginas;
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

    public String getData_lancamento() {
        return data_lancamento;
    }

    public void setData_lancamento(String data_lancamento) {
        this.data_lancamento = data_lancamento;
    }

    public int getNumero_paginas() {
        return numero_paginas;
    }

    public void setNumero_paginas(int numero_paginas) {
        this.numero_paginas = numero_paginas;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Livro{");
        sb.append("nome=").append(nome);
        sb.append(", autor=").append(autor);
        sb.append(", data_lancamento=").append(data_lancamento);
        sb.append(", numero_paginas=").append(numero_paginas);
        sb.append('}');
        return sb.toString();
    }
        
        
        
}
