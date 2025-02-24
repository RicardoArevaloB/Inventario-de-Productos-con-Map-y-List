package com.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class InventarioProductos {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, List<String>> inventario = new HashMap<>();

    
        System.out.print("Ingrese la cantidad de categorías: ");
        int cantidadCategorias = sc.nextInt();
        sc.nextLine(); 


        for (int i = 0; i < cantidadCategorias; i++) {
            System.out.print("Ingrese el nombre de la categoría " + (i + 1) + ": ");
            String categoria = sc.nextLine();

            List<String> productos = new ArrayList<>();
            System.out.print("¿Cuántos productos desea agregar a la categoría '" + categoria + "'? ");
            int cantidadProductos = sc.nextInt();
            sc.nextLine(); 

            for (int j = 0; j < cantidadProductos; j++) {
                System.out.print("Ingrese el nombre del producto " + (j + 1) + ": ");
                String producto = sc.nextLine();
                productos.add(producto);
            }

            inventario.put(categoria, productos); 
        }

      
        while (true) {
            System.out.println("\n--- Menú de opciones ---");
            System.out.println("1. Mostrar todos los productos de una categoría");
            System.out.println("2. Agregar un nuevo producto a una categoría existente");
            System.out.println("3. Mostrar la lista completa de categorías y productos");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = sc.nextInt();
            sc.nextLine(); 

            switch (opcion) {
                case 1:
                    
                    System.out.print("Ingrese el nombre de la categoría: ");
                    String categoriaBuscar = sc.nextLine();
                    if (inventario.containsKey(categoriaBuscar)) {
                        System.out.println("Productos de la categoría '" + categoriaBuscar + "':");
                        for (String producto : inventario.get(categoriaBuscar)) {
                            System.out.println("- " + producto);
                        }
                    } else {
                        System.out.println("La categoría '" + categoriaBuscar + "' no existe.");
                    }
                    break;

                case 2:
                    
                    System.out.print("Ingrese el nombre de la categoría: ");
                    String categoriaAgregar = sc.nextLine();
                    if (inventario.containsKey(categoriaAgregar)) {
                        System.out.print("Ingrese el nombre del nuevo producto: ");
                        String nuevoProducto = sc.nextLine();
                        inventario.get(categoriaAgregar).add(nuevoProducto);
                        System.out.println("Producto agregado con éxito.");
                    } else {
                        System.out.println("La categoría '" + categoriaAgregar + "' no existe.");
                    }
                    break;

                case 3:
                    
                    System.out.println("\nLista completa de categorías y productos:");
                    for (Map.Entry<String, List<String>> entry : inventario.entrySet()) {
                        System.out.println("Categoría: " + entry.getKey());
                        for (String producto : entry.getValue()) {
                            System.out.println("  - " + producto);
                        }
                    }
                    break;

                case 4:
                    System.out.println("Saliendo del programa...");
                    sc.close();
                    return;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
        
    }
}
