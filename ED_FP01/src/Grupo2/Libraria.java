/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grupo2;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Leona
 */
public class Libraria<T> {

    private List<T> libraria;

    public Libraria() {
        this.libraria = new ArrayList<>();
    }
    
    public void addMedia(T media){
         this.libraria.add(media);
    }
    
    public List<T> getAllmedia(){
        return libraria;
    }
    
    public T getMedia(String title) {
        for (T media : libraria) {
                if (media instanceof MediaTitle && ((MediaTitle) media).getNome().equals(title)) {
                return media;
            }
        }
        return null; // Retorna null se a mídia não for encontrada
    }

    // Método para remover uma mídia específica pelo título
    public void removeMedia(String title) {
        T mediaToRemove = getMedia(title);
        if (mediaToRemove != null) {
            libraria.remove(mediaToRemove);
        }
    }
    
    // Método para verificar se a biblioteca está vazia
    public boolean isEmpty() {
        return libraria.isEmpty();
    }

    // Método para obter o número total de mídias na biblioteca
    public int size() {
        return libraria.size();
    }

}
