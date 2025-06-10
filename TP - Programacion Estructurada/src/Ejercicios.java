import java.util.Scanner;

public class Ejercicios{

    static final double DESCUENTO_ESPECIAL = 0.10;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Ejercicio 1: Año bisiesto
        System.out.print("Ingrese un año: ");
        int anio = sc.nextInt();
        if ((anio % 4 == 0 && anio % 100 != 0) || (anio % 400 == 0)) {
            System.out.println("El año " + anio + " es bisiesto.");
        } else {
            System.out.println("El año " + anio + " no es bisiesto.");
        }

        // Ejercicio 2: Mayor de tres números
        System.out.print("Ingrese el primer número: ");
        int num1 = sc.nextInt();
        System.out.print("Ingrese el segundo número: ");
        int num2 = sc.nextInt();
        System.out.print("Ingrese el tercer número: ");
        int num3 = sc.nextInt();
        int mayor = Math.max(num1, Math.max(num2, num3));
        System.out.println("El mayor es: " + mayor);

        // Ejercicio 3: Clasificación de edad
        System.out.print("Ingrese su edad: ");
        int edad = sc.nextInt();
        if (edad < 12) {
            System.out.println("Eres un Niño.");
        } else if (edad <= 17) {
            System.out.println("Eres un Adolescente.");
        } else if (edad <= 59) {
            System.out.println("Eres un Adulto.");
        } else {
            System.out.println("Eres un Adulto mayor.");
        }

        // Ejercicio 4: Calculadora de descuento
        System.out.print("Ingrese el precio del producto: ");
        double precio = sc.nextDouble();
        System.out.print("Ingrese la categoría del producto (A, B o C): ");
        char categoria = sc.next().toUpperCase().charAt(0);
        double descuento = 0;
        switch (categoria) {
            case 'A': descuento = 0.10; break;
            case 'B': descuento = 0.15; break;
            case 'C': descuento = 0.20; break;
            default: System.out.println("Categoría inválida."); return;
        }
        double precioFinal = precio - (precio * descuento);
        System.out.println("Descuento aplicado: " + (descuento * 100) + "%");
        System.out.println("Precio final: " + precioFinal);

        // Ejercicio 5: Suma de números pares
        int sumaPares = 0, num;
        do {
            System.out.print("Ingrese un número (0 para terminar): ");
            num = sc.nextInt();
            if (num % 2 == 0 && num != 0) {
                sumaPares += num;
            }
        } while (num != 0);
        System.out.println("La suma de los números pares es: " + sumaPares);

        // Ejercicio 6: Contador de positivos, negativos y ceros
        int positivos = 0, negativos = 0, ceros = 0;
        for (int i = 1; i <= 10; i++) {
            System.out.print("Ingrese el número " + i + ": ");
            int n = sc.nextInt();
            if (n > 0) positivos++;
            else if (n < 0) negativos++;
            else ceros++;
        }
        System.out.println("Positivos: " + positivos);
        System.out.println("Negativos: " + negativos);
        System.out.println("Ceros: " + ceros);

        // Ejercicio 7: Validación de nota
        int nota;
        do {
            System.out.print("Ingrese una nota (0-10): ");
            nota = sc.nextInt();
            if (nota < 0 || nota > 10) {
                System.out.println("⚠️ Error: Nota inválida. Ingrese una nota entre 0 y 10.");
            }
        } while (nota < 0 || nota > 10);
        System.out.println("✅ Nota guardada correctamente.");

        // Ejercicio 8: Calcular precio final
        System.out.print("Ingrese el precio base del producto: ");
        double base = sc.nextDouble();
        System.out.print("Ingrese el impuesto en %: ");
        double impuesto = sc.nextDouble();
        System.out.print("Ingrese el descuento en %: ");
        double desc = sc.nextDouble();
        System.out.println("El precio final del producto es: " +
                calcularPrecioFinal(base, impuesto / 100, desc / 100));

        // Ejercicio 9: Costo de envío
        System.out.print("Ingrese el precio del producto: ");
        double precioProducto = sc.nextDouble();
        System.out.print("Ingrese el peso del paquete en kg: ");
        double peso = sc.nextDouble();
        System.out.print("Ingrese la zona de envío (Nacional/Internacional): ");
        sc.nextLine();
        String zona = sc.nextLine();
        double costoEnvio = calcularCostoEnvio(peso, zona);
        System.out.println("El costo de envío es: " + costoEnvio);
        System.out.println("El total a pagar es: " + calcularTotalCompra(precioProducto, costoEnvio));

        // Ejercicio 10: Actualizar stock
        System.out.print("Ingrese el stock actual del producto: ");
        int stock = sc.nextInt();
        System.out.print("Ingrese la cantidad vendida: ");
        int vendida = sc.nextInt();
        System.out.print("Ingrese la cantidad recibida: ");
        int recibida = sc.nextInt();
        System.out.println("El nuevo stock del producto es: " +
                actualizarStock(stock, vendida, recibida));

        // Ejercicio 11: Descuento especial
        System.out.print("Ingrese el precio del producto: ");
        double precioDescuento = sc.nextDouble();
        calcularDescuentoEspecial(precioDescuento);

        // Ejercicio 12 y 13: Arrays y recursividad
        double[] precios = {199.99, 299.5, 149.75, 399.0, 89.99};
        System.out.println("Precios originales:");
        mostrarArrayRecursivo(precios, 0);
        precios[2] = 129.99;
        System.out.println("Precios modificados:");
        mostrarArrayRecursivo(precios, 0);
    }

    public static double calcularPrecioFinal(double base, double impuesto, double descuento) {
        return base + (base * impuesto) - (base * descuento);
    }

    public static double calcularCostoEnvio(double peso, String zona) {
        if (zona.equalsIgnoreCase("Nacional")) return peso * 5;
        else if (zona.equalsIgnoreCase("Internacional")) return peso * 10;
        else return 0;
    }

    public static double calcularTotalCompra(double precio, double envio) {
        return precio + envio;
    }

    public static int actualizarStock(int stock, int vendida, int recibida) {
        return stock - vendida + recibida;
    }

    public static void calcularDescuentoEspecial(double precio) {
        double descuentoAplicado = precio * DESCUENTO_ESPECIAL;
        System.out.println("El descuento especial aplicado es: " + descuentoAplicado);
        System.out.println("El precio final con descuento es: " + (precio - descuentoAplicado));
    }

    public static void mostrarArrayRecursivo(double[] arr, int i) {
        if (i < arr.length) {
            System.out.println("Precio: $" + arr[i]);
            mostrarArrayRecursivo(arr, i + 1);
        }
    }
}