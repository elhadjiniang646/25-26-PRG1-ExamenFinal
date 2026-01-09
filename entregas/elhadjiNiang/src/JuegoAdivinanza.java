import java.util.Scanner;

public class JuegoAdivinanza {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        mostrarTitulo();

        int minimoNumero = 1;
        int maximoNumero = 100;
        int maximoIntentos = 10;
        int dificultad = pedirDificultad(scanner);
        int[] configuaracion = configurarDificultad(dificultad);
        maximoNumero = configuaracion[0];
        maximoIntentos = configuaracion[1];

        System.out.println();
        System.out.println("Adivina el numero entre " + minimoNumero + " y " + maximoNumero);

        int numeroBuscado = generarNumero(minimoNumero, maximoNumero);

        int intentosRealizados = 0;
        boolean adivinado = false;

        int[] historialNumeros = new int[maximoIntentos];
        String[] historialPistas = new String[maximoIntentos];
        int indice = 0;

        while (intentosRealizados < maximoIntentos && !adivinado) {
            mostrarMenuIntento(intentosRealizados, maximoIntentos);
            int opcionJuego = scanner.nextInt();
            if (opcionJuego == 2) {
                if (intentosRealizados >= maximoIntentos - 1) {
                    System.out.println("No puedes pedir mas pistas, es tu ultimo intento.");
                    guardarHistorial(historialNumeros, historialPistas, indice++, 0, "Pista denegada");
                } else {
                    intentosRealizados++;
                    mostrarPista(numeroBuscado);
                    guardarHistorial(historialNumeros, historialPistas, indice++, 0, "Pista solicitada");
                }
                continue;
            }

            if (opcionJuego == 1) {
                System.out.print("Tu numero: ");
                int numeroPropuesto = scanner.nextInt();

                if (!numeroEnRango(numeroPropuesto, minimoNumero, maximoNumero)) {
                    System.out.println("El numero debe estar entre " + minimoNumero + " y " + maximoNumero);
                    guardarHistorial(historialNumeros, historialPistas, indice++, numeroPropuesto, "Fuera de rango");
                    continue;
                }

                intentosRealizados++;

                String resultado = comprobarNumero(numeroPropuesto, numeroBuscado);
                System.out.println(resultado);

                if (numeroPropuesto == numeroBuscado) {
                    adivinado = true;
                    System.out.println("¡Felicidades! ¡Has adivinado el numero!");
                    System.out.println("Lo lograste en " + intentosRealizados + " intentos");
                    resultado = "¡Adivinado!";
                }

                guardarHistorial(historialNumeros, historialPistas, indice++, numeroPropuesto, resultado);
            } else {
                System.out.println("Opcion invalida.");
            }

        }

        if (!adivinado) {
            System.out.println();
            System.out.println("¡Se acabaron los intentos!");
            System.out.println("El numero era: " + numeroBuscado);
        }

        mostrarHistorial(historialNumeros, historialPistas, indice);

        System.out.println();
        System.out.println("Fin del juego");
        scanner.close();
    }

    static void mostrarTitulo() {
        System.out.println("Juego de Adivinanza - Adivina el Numero Secreto");
    }

    static int pedirDificultad(Scanner scanner) {

        System.out.println();
        System.out.println("Selecciona Dificultad:");
        System.out.println("1. Facil (1-50, 10 intentos)");
        System.out.println("2. Normal (1-100, 7 intentos)");
        System.out.println("3. Dificil (1-200, 8 intentos)");
        System.out.print("Opcion: ");
        return scanner.nextInt();

    }

    static int[] configurarDificultad(int dificultad) {
        if (dificultad == 1)
            return new int[] { 50, 10 };
        if (dificultad == 2)
            return new int[] { 100, 7 };
        if (dificultad == 3)
            return new int[] { 200, 8 };

        System.out.println("Opcion no valida, usando dificultad Normal.");
        return new int[] { 100, 7 };

    }

    static int generarNumero(int minimo, int maximo) {
        return (int) (Math.random() * (maximo - minimo + 1)) + minimo;
    }

    static void mostrarMenuIntento(int intento, int maximo) {
        System.out.println();
        System.out.println("Intento " + (intento + 1) + "/" + maximo + ": ");
        System.out.println("[1] Adivinar [2] Pedir Pista");
        System.out.print("Opcion: ");
    }

    static void mostrarPista(int numeroBuscado) {
        System.out.print("PISTA: ");
        System.out.println(numeroBuscado % 2 == 0 ? "El numero es par." : "El numero es impar.");
        if (numeroBuscado % 3 == 0) {
            System.out.println("El numero es multiplo de 3.");
        }
    }

    static boolean numeroEnRango(int numero, int minimo, int maximo) {
        return numero >= minimo && numero <= maximo;
    }

    static String comprobarNumero(int propuesto, int buscado) {
        if (propuesto < buscado) {
            if (Math.abs(propuesto - buscado) < 5)
                return "El numero es MAYOR\n¡Muy cerca!";
            return "El numero es MAYOR";
        } else if (propuesto > buscado) {
            if (Math.abs(propuesto - buscado) < 5)
                return "El numero es MENOR\n¡Muy cerca!";
            return "El numero es MENOR";
        }
        return "";
    }

    static void guardarHistorial(int[] numeros, String[] pistas, int i, int numero, String texto) {
        if (i < numeros.length) {
            numeros[i] = numero;
            pistas[i] = texto;
        }
    }

    static void mostrarHistorial(int[] numeros, String[] pistas, int total) {
        System.out.println();
        System.out.println("Historial de Intentos");
        for (int i = 0; i < total; i++) {
            System.out.println((i + 1) + ". " + numeros[i] + " -> " + pistas[i]);
        }
        if (total == 0) {
            System.out.println("(No hubo intentos)");
        }

    }

}
