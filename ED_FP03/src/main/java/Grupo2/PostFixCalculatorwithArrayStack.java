/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grupo2;

import Grupo1.ArrayStack;
import Grupo1.EmptyCollectionException;

/**
 *
 * @author Leona
 */
public class PostFixCalculatorwithArrayStack {
    
    /**
     * Metodo para verificar se a string inserida pode ser usada
     * para fazer operacoes matematicas
     * @param token
     * @return 
     * Retorna true se for possivel e false se nao for possivel
     */
    private static boolean isOperand(String token){
        try{
            Double.valueOf(token);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }
    
    /**
     * Metodo para verificar se sao utilizados corretamente as operacoes
     * matematicas possiveis
     * @param token
     * @return 
     */
    private static boolean isOperator(String token){
        return "+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token);
    }
    
    /**
     * Metodo para fazer a operacao matematica desejada
     * @param operand1
     * @param operand2
     * @param operator
     * @return 
     * Retorna o valor do resultado se tudo tiver sido feito corretamente, caso
     * isso nao aconteca retorna uma exception
     */
    private static double performOperation(double operand1, double operand2, String operator){
        switch(operator){
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                if(operand2 == 0){
                    throw new ArithmeticException("Divisao por zero");
                }
                return operand1 / operand2;
                default:
                    throw new IllegalArgumentException("Operador invalido");
        } 
    }
    
    /**
     * Metodo para utilizar a expressao matematica fornecida, seperar em diferentes strings 
     * mais pequenas e adicionar a stack e fazer as contas necessarias
     * @param expression
     * @return
     *  Retorna o resultado da equcao fornecida
     * @throws EmptyCollectionException 
     */
    public double PostFixExpression(String expression) throws EmptyCollectionException{
        ArrayStack<Double> stack = new ArrayStack<>();
        
        String[] tokens = expression.split(" ");
        
        for(String token : tokens){
            if(isOperand(token)){ //verifica se e um numero se for adiciona na stack
                stack.push(Double.valueOf(token));
            }else if(isOperator(token)){ // verifica se e um operador se for ira fazer contas
                if(stack.size() < 2){ // verifica se o tamanho da stack e maior que 2
                    throw new IllegalArgumentException("Expressão inválida");
                }
                double operand2 = stack.pop();
                double operand1 = stack.pop();
                double result = performOperation(operand1, operand2, token);
                stack.push(result);
            }
        }
        if (stack.size() != 1) {
            throw new IllegalArgumentException("Expressão inválida");
        }

        return stack.pop();
    }
}
