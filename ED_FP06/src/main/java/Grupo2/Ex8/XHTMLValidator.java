/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grupo2.Ex8;

import Grupo1.Ex1.ArrayStack;
import Throws.EmptyCollectionException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leona
 */
public class XHTMLValidator {
    private final ArrayStack<String> tagStack;

    public XHTMLValidator() {
        // Inicializa a pilha de tags
        tagStack = new ArrayStack<>();
    }

    public boolean validateXHTML(String input) {
        // Divide a string de entrada por espaços
        String[] tokens = input.split("\\s+");

        // Loop através de cada token na string de entrada
        for (String token : tokens) {
            // Verifica se o token é uma tag de abertura
            if (token.startsWith("<") && !token.endsWith("/>")) {
                // Extrai o nome da tag
                String tagName = token.substring(1, token.length() - 1);
                // Adiciona a tag à pilha
                tagStack.push(tagName);
            }
            // Verifica se o token é uma tag de fechamento
            else if (token.startsWith("</")) {
                // Extrai o nome da tag
                String tagName = token.substring(2, token.length() - 1);
                try {
                    // Verifica se a pilha não está vazia e se a tag de fechamento corresponde à última tag aberta
                    if (!tagStack.isEmpty() && tagStack.peek().equals(tagName)) {
                        try {
                            // Remove a última tag aberta da pilha
                            tagStack.pop();
                        } catch (EmptyCollectionException ex) {
                            Logger.getLogger(XHTMLValidator.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        // A tag de fechamento não corresponde à última tag aberta
                        return false;
                    }
                } catch (EmptyCollectionException ex) {
                    Logger.getLogger(XHTMLValidator.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        // O documento é válido se a pilha estiver vazia no final
        return tagStack.isEmpty();
    }
}
