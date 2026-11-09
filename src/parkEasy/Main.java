package parkEasy;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Veiculo[] veiculos = new Veiculo[10];
    static Controle[] controles = new Controle[20];
    static int indexVeiculos;
    static int indexControles;

    public static void main(String[] args) {
        int opcao;

        do {
            System.out.println();
            System.out.println("""
                    #### Estacionamento ParkEasy ####
                    [1] Entrada de veículo
                    [2] Saída de veículo
                    [3] Imprimir veículos estacionados
                    [4] Imprimir a receita
                    [5] Finalizar""");

            System.out.print("Selecione a Opção : ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1 -> registrarEntrada();
                case 2 -> saidaVeiculo();
                case 3 -> veiculosEstacionados();
                case 4 -> imprimirReceita();
                case 5 -> System.out.println("ParkEasy Agradece !!");
                default -> System.out.println("Opção Inválida");

            }
        } while (opcao != 5);
    }


    public static void imprimirReceita(){
        double total = 0;

        for (int i = 0; i < indexControles; i++){
            if (controles[i].horaSaida != null){
                total += controles[i].calcularEstadia();
            }
        }
        System.out.println("Receita até o momento R$ " + total);


    }

    public static Controle PesquisarControle(){
        String placa;
        System.out.println("-- ");
        System.out.print("      Digite a Placa do Veículo que irá sair --> ");
        placa = sc.next().toUpperCase();
        System.out.println();

        for (int i = 0; i < indexControles; i++) {
            if (controles[i].veiculo.placa.equals(placa)) {
                return controles[i];
            }
        }
        System.out.print("Placa Não Encontrada");
        return null;
    }

    public static void saidaVeiculo() {
        DecimalFormat df = new DecimalFormat("#,##0.00");
        double valor;
        String horaSaida;
        Controle controle = PesquisarControle();

        if (controle != null) {
            System.out.println("Informe a hora de saída  (hh:mm) -->");
            horaSaida = sc.next();
            controle.horaSaida = horaSaida;
            valor = controle.calcularEstadia();
            System.out.printf("Valor da Estádia:  R$ "  + df.format(valor));

        }
    }

    public static void veiculosEstacionados() {
        for (int i = 0; i < indexControles; i++) {
            if (controles[i].horaSaida == null) {
                System.out.println(controles[i].veiculo.placa);
                System.out.println(controles[i].veiculo.marca);
                System.out.println(controles[i].veiculo.modelo);
                System.out.println("----------------------");
            }
        }
    }


    public static void registrarEntrada() {
        String marca, modelo, placa;
        String nome;
        String horaEntrada;
        long cpf;

        System.out.println();
        System.out.print("Digite a Placa para a Pesquisa --> ");
        placa = sc.next().toUpperCase();


        Veiculo veiculo = Pesquisar(placa);

        if (veiculo == null) {
            System.out.println("----- ");
            System.out.println("Cadastro do Veículo");
            System.out.println();

            ;
            System.out.print("Modelo -->");
            modelo = sc.next();
            System.out.print("Marca -->");
            marca = sc.next();
            System.out.print("Nome do Proprietário -->");
            nome = sc.next();
            System.out.print("CPF do Proprietário -->");
            cpf = sc.nextLong();
            Proprietario prorpietario = new Proprietario(nome, cpf);
            veiculo = new Veiculo(marca, modelo, placa, prorpietario);
            veiculos[indexVeiculos] = veiculo;
            indexVeiculos++;
        }
        System.out.print("Hora de entrada (hh: mm) -->");
        horaEntrada = sc.next();
        controles[indexControles] = new Controle(veiculo, horaEntrada);
        indexControles++;

    }

    public static Veiculo Pesquisar(String placa) {
        for(int i = 0; i < indexVeiculos; i++) {
            if (veiculos[i].placa.equals(placa)) {
                return veiculos[i];
            }
        }
        System.out.println("------");
        System.out.println("Placa não encontrada");
        return null;
    }



}
