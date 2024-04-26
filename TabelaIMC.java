import java.util.Scanner;

public class TabelaIMC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitação dos dados do usuário
        System.out.println("Digite o nome:");
        String nome = scanner.nextLine();

        char genero = lerGenero(scanner);

        double altura = lerAltura(scanner);

        double peso = lerPeso(scanner);

        // Calcula e obtém as classificações
        String classificacaoPeso = getClassificacaoPeso(genero, peso);
        String classificacaoAltura = getClassificacaoAltura(altura);

        // Exibe os resultados
        System.out.println("Nome: " + nome);
        System.out.println("Gênero: " + ((genero == 'M') ? "Masculino" : "Feminino"));
        System.out.println("Altura: " + altura + " metros");
        System.out.println("Peso: " + peso + " quilogramas");
        System.out.println("Classificação de Peso: " + classificacaoPeso);
        System.out.println("Classificação de Altura: " + classificacaoAltura);

        scanner.close();
    }

    private static char lerGenero(Scanner scanner) {
        while (true) {
            try {
                System.out.println("Digite o gênero (M para Masculino, F para Feminino, N para não informar):");
                String input = scanner.next().toUpperCase();
                char genero = input.charAt(0);
                if (genero == 'M' || genero == 'F' || genero == 'N') {
                    return genero;
                } else {
                    System.out.println("Digite M para Masculino, F para Feminino, ou N para não informar.");
                }
            } catch (Exception e) {
                System.out.println("Digite M para Masculino, F para Feminino, ou N para não informar.");
                scanner.nextLine(); // Limpa o buffer
            }
        }
    }

    private static double lerAltura(Scanner scanner) {
        while (true) {
            try {
                System.out.println("Digite a altura (em metros):");
                double altura = Double.parseDouble(scanner.next());
                if (altura > 0) {
                    return altura;
                } else {
                    System.out.println("Digite uma altura válida (maior que zero).");
                }
            } catch (NumberFormatException e) {
                System.out.println("Digite um valor numérico válido para a altura.");
            }
        }
    }

    private static double lerPeso(Scanner scanner) {
        while (true) {
            try {
                System.out.println("Digite o peso (em quilogramas):");
                double peso = Double.parseDouble(scanner.next());
                if (peso > 0) {
                    return peso;
                } else {
                    System.out.println("Digite um peso válido (maior que zero).");
                }
            } catch (NumberFormatException e) {
                System.out.println("Digite um valor numérico válido para o peso.");
            }
        }
    }

    private static String getClassificacaoPeso(char genero, double peso) {
        if (genero == 'M') {
            if (peso < 20)
                return "Abaixo do normal";
            else if (peso <= 24.9)
                return "Normal";
            else if (peso <= 29.9)
                return "Obesidade leve";
            else if (peso <= 39.9)
                return "Obesidade moderada";
            else
                return "Obesidade mórbida";
        } else {
            if (peso < 19)
                return "Abaixo do normal";
            else if (peso <= 23.9)
                return "Normal";
            else if (peso <= 28.9)
                return "Obesidade leve";
            else if (peso <= 34.9)
                return "Obesidade moderada";
            else
                return "Obesidade mórbida";
        }
    }

    private static String getClassificacaoAltura(double altura) {
        if (altura < 1.55)
            return "Baixa estatura";
        else if (altura <= 1.70)
            return "Estatura média";
        else
            return "Alta estatura";
    }
}
