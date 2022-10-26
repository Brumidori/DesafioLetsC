import com.sun.source.tree.SwitchTree;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Deasfio {


    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);

        System.out.println("Olá, bem vindo! Neste programa podemos calcular a média aritimética ou harmonica de uma lista de números.");
        System.out.println("\nPrimeiro, digite a quantidade de números que deseja calcular a média:");

        int size = input.nextInt();
        double[] arr = new double[size];

        System.out.println("Agora nos diga quais os números que deseja calcular a média:");

        for (int i = 0; i < arr.length; i++) {
            arr[i] = getNumber(input);
        }

        System.out.println("Muito bem, agora nos diga se você deseja calcular.");
        String type;
        int media = 0;

        do {
            type = getType(input);
            if (type.equalsIgnoreCase("ARITIMETICA")) {
                media = 1;
            } else if (type.equalsIgnoreCase("HARMONICA")) {
                media = 2;
            }
        } while ((! type.equalsIgnoreCase("ARITIMETICA") && ! type.equalsIgnoreCase("HARMONICA")));


        switch (media) {
            case 1:
                System.out.println("Os numeros digitados foram: ");
                for (int i = 0; i < size; i++) {
                    System.out.print(arr[i] + " | ");
                }
                System.out.println("\nA media escolhida foi: " + type);
                System.out.println("O valor da media: " + aritimetica(arr, size));
                break;
            case 2:
                System.out.println("Os numeros digitados foram: ");
                for (int i = 0; i < size; i++) {
                    System.out.print(arr[i] + " | ");
                }
                System.out.println("\nA media escolhida foi: " + type);
                System.out.println("O valor da media: " + harmonica(arr, size));
                break;
            default:
                System.out.println("Não foi possivel rodar o programa, tente novamente mais tarde.");
        }

    }

    static float harmonica(double[] arr, int size) {
        float sum = 0;
        for (int i = 0; i < size; i++) {
            sum = (float) (sum + (float) 1 / arr[i]);
        }
        return size / sum;
    }

    static float aritimetica(double[] arr, int size) {
        float sum = 0;
        for (int i = 0; i < size; i++) {
            sum += arr[i];
        }

        return sum / size;
    }

    static double getNumber(Scanner input) {

        try{
            System.out.println("Digite um numero inteiro:");
            return Integer.parseInt(input.next());
        } catch (InputMismatchException e) {
            System.out.println("O tipo digitado está incorreto. Tente novamente.");
            return getNumber(input);
        } catch (Exception e) {
            System.out.println("Não foi possivel obeter o número");
            return getNumber(input);
        }
    }

    static String getType(Scanner input) {
        try {

            System.out.println("Digite ARITIMETICA ou HARMONICA:");
            return input.next();
        } catch (Exception e) {
            System.out.println("Não foi possivel obeter o tipo.");
            return getType(input);
        }
    }


}


