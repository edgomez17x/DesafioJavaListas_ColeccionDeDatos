package mx.com.alura;

import mx.com.alura.modelo.Producto;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * Programa de compras, agregando productos a lista y ordenandolas de menor a mayor por
 * precio
 **/
public class Principal {
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("#0.00");
        Double saldo = 0.0d;
        List<Producto> productoList = new ArrayList<>();
        int option = 1;
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
            *********************************
            *           Bienvenido          *
            *********************************
            Indicanos el límite de la tarjeta de crédito:
            """);
        Double tdcLimite = scanner.nextDouble();
        while(option == 1){
            Producto producto = new Producto();
            System.out.println("Nombre del producto a comprar: ");
            producto.setNombre(scanner.next());
            System.out.println("Precio del producto a comprar: ");
            producto.setPrecio(scanner.nextDouble());
            if(tdcLimite.compareTo(Double.sum(saldo,producto.getPrecio())) < 0){
                System.out.println("Limite de crédito alcanzado.");
                option = 0;
            }else{
                saldo = Double.sum(saldo,producto.getPrecio());
                productoList.add(producto);
                System.out.println("""
                        ¿Desea continuar comprando?
                        1 - Si
                        0 - No
                        """);
                option = scanner.nextInt();
            }
            if(option != 1){
                productoList.sort(Comparator.comparingDouble(Producto::getPrecio));
                System.out.println("*************************************");
                System.out.println("Resumen de compra: ");
                System.out.println("Límite de crédito: $" + df.format(tdcLimite));
                System.out.println("Saldo usado: $" + df.format(saldo));
                System.out.println("Saldo restante: $" + df.format(Double.sum(tdcLimite,(-1) * saldo)));
                System.out.println("""
                        *************************************
                        Lista de productos:
                        *************************************
                        """);
                for(Producto prod:productoList){
                    System.out.println(prod);
                }
                System.out.println("*************************************");
            }
        }
    }
}
