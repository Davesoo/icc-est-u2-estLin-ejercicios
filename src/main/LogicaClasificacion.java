package main;

import java.util.*;

public class LogicaClasificacion {

    /**
     * Invierte una cadena de texto utilizando una pila (Stack).
     *
     * @param texto Cadena original a invertir.
     * @return Cadena invertida.
     *
     *         Ejemplo:
     *         Entrada: "Hola Mundo"
     *         Salida: "odnuM aloH"
     */
    public String invertirCadena(String texto) {
        Stack<Character> pila = new Stack();

        for (int i = 0; i < texto.length(); i++){
            pila.push(texto.charAt(i));
        }

        StringBuilder invertida = new StringBuilder();

        while (!pila.isEmpty()) {
            invertida.append(pila.pop());
        }

        return invertida.toString();
    }

    /**
     * Verifica si los símbolos de paréntesis, corchetes y llaves están bien
     * balanceados.
     *
     * @param expresion Cadena con símbolos.
     * @return true si está balanceada, false en caso contrario.
     *
     *         Ejemplo:
     *         Entrada: "{[()]}"
     *         Salida: true
     */
    public boolean validarSimbolos(String expresion) {
        Stack<Character> pila = new Stack<>();
        Map<Character, Character> pares = new HashMap<>();

        pares.put(')', '(');
        pares.put('}', '{');
        pares.put(']', '[');

        for(int i=0; i < expresion.length(); i++){
            char sA = expresion.charAt(i);
            if (sA == '(' || sA == '{' || sA == '['){
                pila.push(expresion.charAt(i));
            }else{
                if (pila.isEmpty()){
                    return false;
                }
                char tope = pila.pop();
                if(tope != pares.get(sA)){
                    return false;
                }
            }
        }
        return pila.isEmpty();
    }

    /**
     * Ordena una pila de enteros en orden ascendente usando otra pila auxiliar.
     *
     * @return Lista ordenada.
     *
     *         Ejemplo:
     *         Entrada: [3, 1, 4, 2]
     *         Salida: [1, 2, 3, 4]
     */
    public List<Integer> ordenarPila(Stack<Integer> pila) {
        Stack<Integer> auxiliar = new Stack<>();

        while (!pila.isEmpty()) {
            int temp = pila.pop();

            while (!auxiliar.isEmpty() && auxiliar.peek() > temp) {
                pila.push(auxiliar.pop());
            }

            auxiliar.push(temp);
        }

        List<Integer> resultado = new ArrayList<>();
        while (!auxiliar.isEmpty()) {
            resultado.add(0, auxiliar.pop());
        }

        return resultado;
    }

    /**
     * Clasifica una lista de enteros separando pares e impares.
     * Usa LinkedList para mantener el orden de inserción.
     *
     * @return Lista con pares primero, luego impares.
     *
     *         Ejemplo:
     *         Entrada: [1, 2, 3, 4, 5, 6]
     *         Salida: [2, 4, 6, 1, 3, 5]
     */
    public List<Integer> clasificarPorParidad(LinkedList<Integer> original) {
        LinkedList<Integer> pares = new LinkedList<>();
        LinkedList<Integer> impares = new LinkedList<>();

        for (Integer num : original) {
            if (num % 2 == 0) {
                pares.add(num);
            } else {
                impares.add(num);
            }
        }

        // Primero agregamos todos los pares
        LinkedList<Integer> resultado = new LinkedList<>(pares);
        // Luego agregamos todos los impares
        resultado.addAll(impares);

        return resultado;
    }
}
