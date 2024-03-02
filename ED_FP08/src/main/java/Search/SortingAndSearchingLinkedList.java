/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Search;

import Grupo1.Ex2.DoubleLinkedList;
import Grupo1.Ex2.DoubleNode;
import Interfaces.ListADT;
import Throws.EmptyCollectionException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Leona
 */
public class SortingAndSearchingLinkedList {
    /**
     * Searches the specified array of objects using a linear search algorithm.
     *
     * @param <T>
     * @param data the array to be sorted
     * @param min the integer representation of the min value
     * @param max the integer representation of the max value
     * @param target the element being searched for
     * @return true if the desired element is found
     */
    public static <T extends Comparable<? super T>> boolean
            linearSearchList(ListADT<T> data, T target) {
        boolean found = false;
        Iterator<T> iterator = data.iterator();
        while (!found) {
            if (iterator.next().compareTo(target) == 0) {
                found = true;
            }
        }
        return found;
    }

    /**
     * Método auxiliar que retorna o elemento na posição index na lista data
     * @param <T> the type of the element
     * @param data the array to be sorted
     * @param index midpoint
     * @return midpoint element 
     */
    private static <T extends Comparable<? super T>> T getMidPoint(ListADT<T> data, int index) {
        // Se o índice for inválido, retorna null
        if (index < 0 || index >= data.size()) {
            return null;
        }
        
        // Cria um iterador para percorrer a lista
        Iterator<T> iterator = data.iterator();
        // Contador para armazenar o número de elementos visitados
        int count = 0;
        // Loop até encontrar o elemento desejado ou chegar ao fim da lista
        while (iterator.hasNext()) {
            // Obtém o próximo elemento da lista
            T element = iterator.next();
            // Se o contador for igual ao índice, retorna o elemento
            if (count == index) {
                return element;
            }
            // Incrementa o contador
            count++;
        }
        
        // Se o loop terminar sem encontrar o elemento, retorna null
        return null;
    }

    /**
     * Searches the specified array of objects using a binary search algorithm.
     *
     * @param <T> the type of the element
     * @param data the array to be sorted
     * @param min the integer representation of the minimum value
     * @param max the integer representation of the maximum value
     * @param target the element being searched for
     * @return true if the desired element is found
     */
    public static <T extends Comparable<? super T>> boolean
            binarySearchList(ListADT<T> data, int min, int max, T target) {
        boolean found = false;
        // Se os limites forem válidos, continua a pesquisa
        if (min <= max) {
            // Calcula o índice do meio da lista
            int midpoint = (min + max) / 2;
            // Obtém o elemento do meio da lista usando o método auxiliar
            T element = getMidPoint(data, midpoint);
            // Se o elemento for igual ao alvo, a pesquisa termina com sucesso
            if (element.compareTo(target) == 0) {
                found = true;
            } // Se o elemento for maior que o alvo, pesquisa na metade esquerda da lista
            else if (element.compareTo(target) > 0) {
                found = binarySearchList(data, min, midpoint - 1, target);
            } // Se o elemento for menor que o alvo, pesquisa na metade direita da lista
            else {
                found = binarySearchList(data, midpoint + 1, max, target);
            }
        }
        // Retorna o resultado da pesquisa
        return found;
    }

    /**
     * Sorts the specified array of integers using the selection sort algorithm.
     *
     * @param data the array to be sorted
     */
    public static <T extends Comparable<? super T>> void
            selectionSort(ListADT data) {
        try {
            DoubleNode<T> minNode, tempNode;
            for (DoubleNode<T> current = (DoubleNode<T>) data.first(); current != null; current = current.getNext()) {
                minNode = current;
                
                for (DoubleNode<T> scan = current.getNext(); scan != null; scan = scan.getNext()) {
                    if (scan.getElement().compareTo(minNode.getElement()) < 0) {
                        minNode = scan;
                    }
                }
                
                /**
                 * Swap the values
                 */
                T temp = current.getElement();
                current.setElement(minNode.getElement());
                minNode.setElement(temp);
            }   } catch (EmptyCollectionException ex) {
            Logger.getLogger(SortingAndSearchingLinkedList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Sorts the specified array of objects using an insertion sort algorithm.
     *
     * @param data the array to be sorted
     */
    public static <T extends Comparable<? super T>> void
            insertionSort(T[] data) {
        for (int index = 1; index < data.length; index++) {
            T key = data[index];
            int position = index;
            /**
             * Shift larger values to the right
             */
            while (position > 0 && data[position - 1].compareTo(key) > 0) {
                data[position] = data[position - 1];
                position--;
            }
            data[position] = key;
        }
    }

    /**
     * Sorts the specified array of objects using a bubble sort algorithm.
     *
     * @param data the array to be sorted
     */
    public static <T extends Comparable<? super T>> void
            bubbleSort(T[] data) {
        int position, scan;
        T temp;
        for (position = data.length - 1; position >= 0; position--) {
            for (scan = 0; scan <= position - 1; scan++) {
                if (data[scan].compareTo(data[scan + 1]) > 0) {
                    /**
                     * Swap the values
                     */
                    temp = data[scan];
                    data[scan] = data[scan + 1];
                    data[scan + 1] = temp;
                }
            }
        }
    }

    /**
     * Sorts the specified array of objects using the quick sort algorithm.
     *
     * @param data the array to be sorted
     * @param min the integer representation of the minimum value
     * @param max the integer representation of the maximum value
     */
    public static <T extends Comparable<? super T>> void
            quickSort(T[] data, int min, int max) {
        int indexofpartition;
        if (max - min > 0) {
            /**
             * Create partitions
             */
            indexofpartition = findPartition(data, min, max);
            /**
             * Sort the left side
             */
            quickSort(data, min, indexofpartition - 1);
            /**
             * Sort the right side
             */
            quickSort(data, indexofpartition + 1, max);
        }
    }

    /**
     * Used by the quick sort algorithm to find the partition.
     *
     * @param data the array to be sorted
     * @param min the integer representation of the minimum value
     * @param max the integer representation of the maximum value
     */
    private static <T extends Comparable<? super T>> int
            findPartition(T[] data, int min, int max) {
        int left, right;
        T temp, partitionelement;
        int middle = (min + max) / 2;
// use middle element as partition
        partitionelement = data[middle];
        left = min;
        right = max;
        while (left < right) {
            /**
             * search for an element that is > the partitionelement
             */
            while (data[left].compareTo(partitionelement) < 0) {
                left++;
            }
            /**
             * search for an element that is < the partitionelement
             */
            while (data[right].compareTo(partitionelement) > 0) {
                right--;
            }
            /**
             * swap the elements
             */
            if (left < right) {
                temp = data[left];
                data[left] = data[right];
                data[right] = temp;
            }
        }
        /**
         * move partition element to partition index
         */
        temp = data[min];
        data[min] = data[right];
        data[right] = temp;
        return right;
    }

    /**
     * Sorts the specified array of objects using the merge sort algorithm.
     *
     * @param data the array to be sorted
     * @param min the integer representation of the minimum value
     * @param max the integer representation of the maximum value
     */
    public static <T extends Comparable<? super T>> void
            mergeSort(T[] data, int min, int max) {
        T[] temp;
        int index1, left, right;
        /**
         * return on list of length one
         */
        if (min == max) {
            return;
        }
        /**
         * find the length and the midpoint of the list
         */
        int size = max - min + 1;
        int pivot = (min + max) / 2;
        temp = (T[]) (new Comparable[size]);
        mergeSort(data, min, pivot); // sort left half of list
        mergeSort(data, pivot + 1, max); // sort right half of list
        /**
         * copy sorted data into workspace
         */
        for (index1 = 0; index1 < size; index1++) {
            temp[index1] = data[min + index1];
        }
        /**
         * merge the two sorted lists
         */
        left = 0;
        right = pivot - min + 1;
        for (index1 = 0; index1 < size; index1++) {
            if (right <= max - min) {
                if (left <= pivot - min) {
                    if (temp[left].compareTo(temp[right]) > 0) {
                        data[index1 + min] = temp[right++];
                    } else {
                        data[index1 + min] = temp[left++];
                    }
                } else {
                    data[index1 + min] = temp[right++];
                }
            } else {
                data[index1 + min] = temp[left++];
            }
        }
    }
}
