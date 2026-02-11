import java.util.Scanner;

public class InvertirCadena {
    public static void main(String[] args) {
        // Creamos un objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingresa el texto que deseas invertir: ");
        String original = scanner.nextLine();

        // Usamos StringBuilder para invertir la cadena de forma eficiente
        String invertida = new StringBuilder(original).reverse().toString();

        // Mostramos el resultado
        System.out.println("Texto invertido: " + invertida);
        
        scanner.close();
    }
}