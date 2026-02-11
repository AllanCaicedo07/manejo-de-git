import java.util.Scanner;

/**
 * Calculadora Básica en Java
 * Programa que utiliza estructuras de control para realizar operaciones matemáticas básicas
 * @author Claude
 * @version 1.0
 */
public class CalculadoraBasica {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;
        
        System.out.println("╔════════════════════════════════════╗");
        System.out.println("║   CALCULADORA BÁSICA EN JAVA       ║");
        System.out.println("╚════════════════════════════════════╝");
        
        // Bucle principal - permite realizar múltiples operaciones
        while (continuar) {
            try {
                // Mostrar menú de opciones
                mostrarMenu();
                
                // Leer la opción del usuario
                System.out.print("Seleccione una opción: ");
                int opcion = scanner.nextInt();
                
                // Validar que la opción esté en el rango correcto
                if (opcion < 1 || opcion > 5) {
                    System.out.println(" Opción inválida. Por favor, seleccione entre 1 y 5.");
                    continue;
                }
                
                // Si elige salir
                if (opcion == 5) {
                    System.out.println("\n✓ ¡Gracias por usar la calculadora! Hasta pronto.");
                    continuar = false;
                    continue;
                }
                
                // Solicitar los números
                System.out.print("Ingrese el primer número: ");
                double numero1 = scanner.nextDouble();
                
                System.out.print("Ingrese el segundo número: ");
                double numero2 = scanner.nextDouble();
                
                // Realizar la operación según la opción seleccionada
                double resultado = 0;
                boolean operacionValida = true;
                
                // Estructura switch para seleccionar la operación
                switch (opcion) {
                    case 1:
                        resultado = sumar(numero1, numero2);
                        System.out.println("\n✓ Resultado: " + numero1 + " + " + numero2 + " = " + resultado);
                        break;
                        
                    case 2:
                        resultado = restar(numero1, numero2);
                        System.out.println("\n✓ Resultado: " + numero1 + " - " + numero2 + " = " + resultado);
                        break;
                        
                    case 3:
                        resultado = multiplicar(numero1, numero2);
                        System.out.println("\n✓ Resultado: " + numero1 + " × " + numero2 + " = " + resultado);
                        break;
                        
                    case 4:
                        // Validación especial para la división
                        if (numero2 == 0) {
                            System.out.println("\n✗ Error: No se puede dividir entre cero.");
                            operacionValida = false;
                        } else {
                            resultado = dividir(numero1, numero2);
                            System.out.println("\n✓ Resultado: " + numero1 + " ÷ " + numero2 + " = " + resultado);
                        }
                        break;
                        
                    default:
                        System.out.println("Opción no válida.");
                        operacionValida = false;
                }
                
                // Mostrar información adicional si la operación fue válida
                if (operacionValida && opcion != 4) {
                    mostrarInformacionAdicional(resultado);
                }
                
            } catch (Exception e) {
                System.out.println("\n✗ Error: Entrada inválida. Por favor, ingrese valores numéricos.");
                scanner.nextLine(); // Limpiar el buffer
            }
            
            System.out.println("\n" + "─".repeat(40) + "\n");
        }
        
        scanner.close();
    }
    
    /**
     * Muestra el menú de opciones de la calculadora
     */
    public static void mostrarMenu() {
        System.out.println("\n┌─── MENÚ DE OPERACIONES ───┐");
        System.out.println("│ 1. Suma                   │");
        System.out.println("│ 2. Resta                  │");
        System.out.println("│ 3. Multiplicación         │");
        System.out.println("│ 4. División               │");
        System.out.println("│ 5. Salir                  │");
        System.out.println("└───────────────────────────┘");
    }
    
    /**
     * Realiza la suma de dos números
     * @param a primer número
     * @param b segundo número
     * @return resultado de la suma
     */
    public static double sumar(double a, double b) {
        return a + b;
    }
    
    /**
     * Realiza la resta de dos números
     * @param a primer número
     * @param b segundo número
     * @return resultado de la resta
     */
    public static double restar(double a, double b) {
        return a - b;
    }
    
    /**
     * Realiza la multiplicación de dos números
     * @param a primer número
     * @param b segundo número
     * @return resultado de la multiplicación
     */
    public static double multiplicar(double a, double b) {
        return a * b;
    }
    
    /**
     * Realiza la división de dos números
     * @param a primer número (dividendo)
     * @param b segundo número (divisor)
     * @return resultado de la división
     */
    public static double dividir(double a, double b) {
        return a / b;
    }
    
    /**
     * Muestra información adicional sobre el resultado
     * @param resultado el resultado de la operación
     */
    public static void mostrarInformacionAdicional(double resultado) {
        // Estructura if-else para determinar propiedades del resultado
        if (resultado > 0) {
            System.out.println("  → El resultado es positivo");
        } else if (resultado < 0) {
            System.out.println("  → El resultado es negativo");
        } else {
            System.out.println("  → El resultado es cero");
        }
        
        // Verificar si es entero
        if (resultado == (int) resultado) {
            System.out.println("  → El resultado es un número entero");
        } else {
            System.out.println("  → El resultado es un número decimal");
        }
    }
}