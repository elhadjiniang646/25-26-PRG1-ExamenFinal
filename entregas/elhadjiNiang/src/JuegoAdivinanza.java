import java.util.Scanner;

public class JuegoAdivinanza {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Juego de Adivinanza - Adivina el Numero Secreto");
        
        int minimoNumero = 1;
        int maximoNumero = 100;
        int maximoItento = 10; // Max intentos

        System.out.println(); // espacio
        System.out.println("Selecciona Dificultad:");
        System.out.println("1. Facil (1-50, 10 intentos)");
        System.out.println("2. Normal (1-100, 7 intentos)");
        System.out.println("3. Dificil (1-200, 8 intentos)");
        System.out.print("Opcion: ");
        int dificultad = scanner.nextInt();

        if (dificultad == 1) {
            maximoNumero = 50;
            maximoItento = 10;
        } else if (dificultad == 2) {
            maximoNumero = 100;
            maximoItento = 7;
        } else if (dificultad == 3) {
            maximoNumero = 200;
            maximoItento = 8;
        } else {
            System.out.println("Opcion no valida, usando dificultad Normal.");
        }

        System.out.println(); // espacio
        System.out.println("Adivina el numero entre " + minimoNumero + " y " + maximoNumero);

        int numeroBuscado = (int)(Math.random() * (maximoNumero - minimoNumero + 1)) + minimoNumero;
        int intentosRealizados = 0;
        boolean adivinado = false;

        // Historial
        int[] historialNumeros = new int[maximoItento];
        String[] historialPista = new String[maximoItento];
        int indice = 0; // Indice

        while (intentosRealizados < maximoItento && !adivinado) {
            System.out.println(); // espacio
            System.out.println("Intento " + (intentosRealizados + 1) + "/" + maximoItento + ": ");
            System.out.println("[1] Adivinar [2] Pedir Pista");
            System.out.print("Opcion: ");
            int opcionJuego = scanner.nextInt();

            String pistaActual = "";

            if (opcionJuego == 2) { // Pista
                if (intentosRealizados >= maximoItento - 1) { // Ultimo intento no hay pista
                    System.out.println("No puedes pedir mas pistas, es tu ultimo intento.");
                    pistaActual = "Pista denegada";
                } else {
                    intentosRealizados++; // La pista cuesta
                    System.out.print("PISTA: ");
                    if (numeroBuscado % 2 == 0) { // Duplicado
                        System.out.println("El numero es par.");
                    } else {
                        System.out.println("El numero es impar.");
                    }
                    if (numeroBuscado % 3 == 0) { // Otra
                        System.out.println("El numero es multiplo de 3.");
                    }
                    pistaActual = "Pista solicitada";
                    // Guardar en historial
                    if (indice < maximoItento) {
                        historialNumeros[indice] = 0; // 0 para pista
                        historialPista[indice] = pistaActual;
                        indice++;
                    }
                }
                continue; // Volver a empezar
            } else if (opcionJuego == 1) { // Adivinar
                System.out.print("Tu numero: ");
                int numeroPropuesto = scanner.nextInt();
                
                // Valida rango
                if (numeroPropuesto < minimoNumero || numeroPropuesto > maximoNumero) {
                    System.out.println("El numero debe estar entre " + minimoNumero + " y " + maximoNumero);
                    pistaActual = "Fuera de rango";
                    // Guardar en historial
                    if (indice < maximoItento) {
                        historialNumeros[indice] = numeroPropuesto;
                        historialPista[indice] = pistaActual;
                        indice++;
                    }
                    continue; // Saltar intento
                }
                
                intentosRealizados++;

                if (numeroPropuesto == numeroBuscado) {
                    adivinado = true;
                    System.out.println("¡Felicidades! ¡Has adivinado el numero!");
                    System.out.println("Lo lograste en " + intentosRealizados + " intentos");
                    pistaActual = "¡Adivinado!";
                } else if (numeroPropuesto < numeroBuscado) {
                    System.out.println("El numero es MAYOR");
                    if (numeroPropuesto > numeroBuscado - 5 && numeroPropuesto < numeroBuscado + 5) { // Cerca
                        System.out.println("¡Muy cerca!");
                        pistaActual = "MAYOR, ¡Muy cerca!";
                    } else {
                        pistaActual = "MAYOR";
                    }
                } else { // n > ns
                    System.out.println("El numero es MENOR");
                    if (numeroPropuesto > numeroBuscado - 5 && numeroPropuesto < numeroBuscado + 5) { // Cerca
                        System.out.println("¡Muy cerca!");
                        pistaActual = "MENOR, ¡Muy cerca!";
                    } else {
                        pistaActual = "MENOR";
                    }
                }
                
                // Guardar en historial
                if (indice < maximoItento) {
                    historialNumeros[indice] = numeroPropuesto;
                    historialPista[indice] = pistaActual;
                    indice++;
                }
            } else {
                System.out.println("Opcion invalida.");
                pistaActual = "Opcion invalida";
                // No hay intento consumido
            }
        }

        if (!adivinado) {
            System.out.println(); // espacio
            System.out.println("¡Se acabaron los intentos!");
            System.out.println("El numero era: " + numeroBuscado);
        }

        System.out.println(); // espacio
        System.out.println("Historial de Intentos");
        for (int k = 0; k < indice; k++) {
            System.out.println((k + 1) + ". " + historialNumeros[k] + " -> " + historialPista[k]);
        }
        if (indice == 0) {
            System.out.println("(No hubo intentos)");
        }

        System.out.println(); // espacio
        System.out.println("Fin del juego");
        scanner.close();
    }
}
