import java.time.LocalDate;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class GestaoFuncionario {

    Funcionario funcionarios[][] = new Funcionario[50][7];

    public void criar() {
        boolean vagaEncontrada = false;
        System.out.println("Criando funcionário...");
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 7; j++) {
                if (funcionarios[i][j] == null) {
                    funcionarios[i][j] = new Funcionario();
                    funcionarios[i][j].setId(i + 1);
                    funcionarios[i][j].setNome(JOptionPane.showInputDialog("Digite o nome do Funcionário: "));
                    funcionarios[i][j].setMatricula("00" + (i + 10));
                    funcionarios[i][j].setAdmissao(LocalDate.parse(JOptionPane.showInputDialog("Digite a data de Admissão (aaaa-mm-dd): ")));
                    funcionarios[i][j].setDemissao(LocalDate.parse(JOptionPane.showInputDialog("Digite a data de Demissão (aaaa-mm-dd): ")));
                    funcionarios[i][j].setSalario(
                            Float.parseFloat(JOptionPane.showInputDialog("Digite o Salário: ")));
                    funcionarios[i][j].setHorario(JOptionPane.showInputDialog("Digite o Horário de serviço(HH:MM): "));
                    vagaEncontrada = true;
                    break;
                }
            }
            break;
        }
        if (vagaEncontrada == false) {
            System.out.println("Vaga ja ocupada");
        }
    }

    public void exibir() {
        System.out.println("Exibindo funcionário...");
        boolean funcionarioEncontrado = false;
        String procurarMatricula = JOptionPane
                .showInputDialog("Digite a Matricula do funcinário que deseja procurar: ");
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 7; j++) {
                if (funcionarios[i][j] != null && funcionarios[i][j].getMatricula() != null
                        && funcionarios[i][j].getMatricula().equals(procurarMatricula)) {
                    System.out.println("Funcionário encontrado: " + funcionarios[i][j].toString());
                    funcionarioEncontrado = true;
                    break;
                }
            }
        }
        if (funcionarioEncontrado == false) {
            System.out.println("Funcionário não encontrado");
        }
    }

    public void remover() {
        System.out.println("Removendo aluno...");
        boolean funcionarioEncontrado = false;
        String procurarMatricula = JOptionPane.showInputDialog("Digite a Matricula do funcinário que deseja remover: ");
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 7; j++) {
                if (funcionarios[i][j] != null && funcionarios[i][j].getMatricula() != null
                        && funcionarios[i][j].getMatricula().equals(procurarMatricula)) {
                    System.out.println("Aluno encontrado: " + funcionarios[i][j].toString());
                    funcionarios[i][j] = null;
                    System.out.println("Funcionário removido com sucesso");
                    funcionarioEncontrado = true;
                    break;
                }
            }
            if (funcionarioEncontrado == false) {
                System.out.println("Funcionário não encontrado");
            }
        }
    }

    public void atualizar() {
        System.out.println("Atualizando aluno...");
        boolean funcionarioEncontrado = false;
        String procurarMatricula = JOptionPane.showInputDialog("Digite o RA do aluno que deseja atualizar: ");
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 7; j++) {
                if (funcionarios[i][j] != null && funcionarios[i][j].getMatricula() != null
                        && funcionarios[i][j].getMatricula().equals(procurarMatricula)) {
                    System.out.println("Funcionário encontrado: " + funcionarios[i][j].toString());
                    funcionarios[i][j] = new Funcionario();
                    funcionarios[i][j].setId(i + 1);
                    funcionarios[i][j].setNome(JOptionPane.showInputDialog("Digite o nome do Funcionário: "));
                    funcionarios[i][j].setMatricula("00" + (i + 10));
                    funcionarios[i][j].setAdmissao(LocalDate.parse(JOptionPane.showInputDialog("Digite a data de Admissão (aaaa-mm-dd): ")));
                    funcionarios[i][j].setDemissao(LocalDate.parse(JOptionPane.showInputDialog("Digite a data de Demissão (aaaa-mm-dd): ")));
                    funcionarios[i][j].setSalario(
                            Float.parseFloat(JOptionPane.showInputDialog("Digite o Salário: ")));
                    funcionarios[i][j].setHorario(JOptionPane.showInputDialog("Digite o Horário de serviço(HH:MM): "));
                    System.out.println("Aluno atualizado com sucesso");
                    funcionarioEncontrado = true;
                    break;
                }

            }
        }
        if (funcionarioEncontrado == false) {
            System.out.println("Funcionário não encontrado");
        }
    }

    public void menu() {

        GestaoFuncionario skeep = new GestaoFuncionario();
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println(
                    "============================================================================================================================================================================================================================");
            System.out.println(
                    "|                                                                                                ESCOLHA UMA AÇÃO :                                                                                                         |");
            System.out.println(
                    "|                                                                                                                                                                                                                           |");
            System.out.println(
                    "|                                                                                   (C)riar           (E)xibir         (R)emover                                                                                            |");
            System.out.println(
                    "|                                                                                                                                                                                                                           |");
            System.out.println(
                    "|                                                                                           (A)tualizar          (S)air                                                                                                     |");
            System.out.println(
                    "|                                                                                                                                                                                                                           |");
            System.out.println(
                    "============================================================================================================================================================================================================================");

            String textoMaiusculo = scan.nextLine().toUpperCase();
            char letra = textoMaiusculo.charAt(0);

            switch (letra) {
                case 'C':
                    skeep.criar();
                    break;
                case 'E':
                    skeep.exibir();
                    break;
                case 'R':
                    skeep.remover();
                    break;
                case 'A':
                    skeep.atualizar();
                    break;
                case 'S':
                    System.out.println("Saindo...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Ação inválida!");
            }

        }
    }

    public static void main(String[] args) {

        GestaoFuncionario gestao = new GestaoFuncionario();
        gestao.menu();
    }

}
