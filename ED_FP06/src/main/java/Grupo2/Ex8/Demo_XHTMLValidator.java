/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Grupo2.Ex8;

/**
 *
 * @author Leona
 */
public class Demo_XHTMLValidator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         // Exemplo de uso
        XHTMLValidator validator = new XHTMLValidator();
        String input = "<body> <h1> Titulo </h1> <p> Corpo com <a>link</a> </p> </body>";
        boolean isValid = validator.validateXHTML(input);

        if (isValid) {
            System.out.println("Documento XHTML válido!");
        } else {
            System.out.println("Documento XHTML inválido!");
        }
    }
    
}
