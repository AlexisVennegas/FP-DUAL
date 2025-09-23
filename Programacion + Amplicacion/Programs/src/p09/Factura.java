package p09;

import java.util.ArrayList;
import java.util.Scanner;

public class Factura {
	
	public static void menu() {
		
		System.out.println("1.- registra producto");
		System.out.println("2.- salir");
	}
	
	
	public static void calcular(ArrayList<String> productos, ArrayList<Double> precios, ArrayList<Integer> cantidades) {
		
		int 	cantidad;
		double	descuento = 0,
				subTotal = 0,
				iva,
				total,
				precio;
		
		for(int i = 0; i < productos.size(); i++) {
			precio = precios.get(i);
			cantidad = cantidades.get(i);	
			subTotal = subTotal + (precio * cantidad);
		}
		
		iva = subTotal * 0.12;
		total = subTotal + iva;
		if(total < 50000) {
			descuento = (total * 0.05);	
			total -= descuento;
		}
		else total = subTotal + iva;
		
	
		generarFactura(productos, precios, cantidades, total, iva, descuento);
	}
	
	
	public static void generarFactura(ArrayList<String> productos, ArrayList<Double> precios, ArrayList<Integer> cantidades, double totalCuenta, double iva, double descuento) {
		System.out.println("***********Factura*************");

		for(int i = 0; i < productos.size(); i++) {
			System.out.println(productos.get(i) + "........" + cantidades.get(i) + "........" + precios.get(i));
			
			
		}
	
		System.out.println("total: .........." + totalCuenta);
		System.out.println("Iva: ............" + iva);
		System.out.println("Descuento: ............" + descuento);
		
	
	}
	
	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		ArrayList<String> productos = new ArrayList<>();
		ArrayList<Double> precios = new ArrayList<>();
		ArrayList<Integer> cantidades = new ArrayList<>();
		int 	opcion;
			
		
		
		while (true) {
		    menu();
		    System.out.print("Opción: ");
		    opcion = teclado.nextInt();
		    teclado.nextLine();

		    if (opcion == 1) {
		        System.out.print("Nombre del producto: ");
		        String producto = teclado.nextLine();
		        productos.add(producto);
		        System.out.println("precio del producto: ");
		        double precio = teclado.nextInt();
		        precios.add(precio);
		        System.out.println("cantidad por producto");
		        int cantidad = teclado.nextInt();
		        cantidades.add(cantidad);
		    } else {
		        break;
		    }
		}

		calcular(productos, precios, cantidades);
		teclado.close();
	}
}
