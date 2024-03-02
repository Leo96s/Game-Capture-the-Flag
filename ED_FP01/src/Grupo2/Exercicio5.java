/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Grupo2;

/**
 *
 * @author Leona
 */
public class Exercicio5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         Libraria  libraria =  new Libraria<>();
         
         libraria.addMedia(new Livro("Livro1", "Leo",  "09/10/2023",  1));
         libraria.addMedia(new Livro("Livro1", "Lucas",  "09/10/2023",  5));
         libraria.addMedia(new Video("Star Apocalipse", "Leo", "2:23:56"));
         libraria.addMedia(new CD_Musica("Trilha",  "Leo",  "09/10/2023",  "1:10:34"));
         
         System.out.println("Mídias na biblioteca:");
        for (Object media : libraria.getAllmedia()) {
            if (media instanceof MediaTitle) {
                System.out.println(((MediaTitle) media).toString());
            }
        }

        // Remover uma mídia pelo título
        libraria.removeMedia("Star Apocalipse");
        System.out.println("Mídias após a remoção:");
        for (Object media : libraria.getAllmedia()) {
            if (media instanceof MediaTitle) {
                System.out.println(((MediaTitle) media).toString());
            }
        }
        
        System.out.println("Midia escolhida atraves do nome:");
        String nome;
        nome = "Livro1";
        System.out.println(libraria.getMedia(nome).toString());
    
    }
    
}
