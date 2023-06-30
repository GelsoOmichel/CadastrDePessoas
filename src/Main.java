// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        List<Person> studants = new ArrayList<Person>();
        boolean exit = true;
        while (exit){
            Scanner scanner = new Scanner(System.in);

            System.out.println("Seleciona a opção Desejada");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Buscar");
            System.out.println("3 - Sair");
            int option = scanner.nextInt();
            switch (option){
                case 1 :
                    addStudant(studants);
                    break;
                case 2 :
                    System.out.println("Qual nome você deseja buscar?");
                    String nameToFind = scanner.next();
                    findStudant(studants, nameToFind);
                    break;
                case 3 :
                    exit = false;
                    break;
            }
        }
    }

    private static void addStudant(List<Person> studants){
        Person studant = new Person();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome completo do estudante que deseja 2");
        studant.name = scanner.next();
        studants.add(studant);
        System.out.println("Obrigado por digitar o nome completo do " + studant.name);
    }

    private static void findStudant(List<Person> studants, String studantName) {

        for(int count = 0; count < studants.size(); count++){
            Person student = studants.get(count);
            if(student.name.equals(studantName)){
                System.out.println("Encontrei o " + studantName);
            }
        }
    }
}