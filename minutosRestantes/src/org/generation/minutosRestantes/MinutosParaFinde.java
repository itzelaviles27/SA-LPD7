package org.generation.minutosRestantes;
import java.util.Scanner;

public class MinutosParaFinde {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dia = obtenerDia(scanner);
        int[] horaMinutos = obtenerHoraMinutos(scanner);

        while (!esEntradaValida(dia, horaMinutos)) {
            System.out.println("Entrada inválida. Por favor, inténtelo de nuevo.");
            dia = obtenerDia(scanner);
            horaMinutos = obtenerHoraMinutos(scanner);
        }

        int minutosHastaFinDeSemana = calcularMinutosHastaFinDeSemana(dia, horaMinutos);
        System.out.println("Faltan " + minutosHastaFinDeSemana + " minutos para el fin de semana.");
    }

    public static int obtenerDia(Scanner scanner) {
        int dia;
        do {
            System.out.print("Ingrese un día de la semana (1 para lunes, 2 para martes, 3 para miércoles, 4 para jueves y 5 para viernes): ");
            dia = scanner.nextInt();
        } while (dia < 1 || dia > 5);
        return dia;
    }

    public static int[] obtenerHoraMinutos(Scanner scanner) {
        int[] horaMinutos;
        boolean horaValida = false;
        do {
            System.out.print("Ingrese la hora (en formato HH:mm): ");
            String[] partesHora = scanner.next().split(":");
            horaMinutos = new int[2];
            horaMinutos[0] = Integer.parseInt(partesHora[0]);
            horaMinutos[1] = Integer.parseInt(partesHora[1]);
            horaValida = esHoraValida(horaMinutos[0], horaMinutos[1]);
            if (!horaValida) {
                System.out.println("Hora inválida. Por favor, inténtelo de nuevo.");
            }
        } while (!horaValida);
        return horaMinutos;
    }

    public static boolean esEntradaValida(int dia, int[] horaMinutos) {
        return (dia >= 1 && dia <= 5) && esHoraValida(horaMinutos[0], horaMinutos[1]);
    }

    public static boolean esHoraValida(int horas, int minutos) {
        return (horas >= 0 && horas <= 23) && (minutos >= 0 && minutos <= 59);
    }

    public static int calcularMinutosHastaFinDeSemana(int dia, int[] horaMinutos) {
        int minutosHastaFinDeSemana = 0;

        int diaIndice = dia - 1;

        minutosHastaFinDeSemana = ((4 - diaIndice) * 24 * 60) + ((15 - horaMinutos[0]) * 60 - horaMinutos[1]);

        return minutosHastaFinDeSemana;
    }
}


