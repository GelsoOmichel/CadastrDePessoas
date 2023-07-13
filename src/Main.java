// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static List<Person> students = new ArrayList<>();

    public static void main(String[] args) {

        boolean exit = true;
        while (exit){

            //Abaixo, menu - Below, menu
            System.out.println("Insira a opção desejada:");
            System.out.println("1 - Cadastrar novo aluno");
            System.out.println("2 - Buscar aluno");
            System.out.println("3 - Remover aluno");
            System.out.println("4 - Editar aluno");
            System.out.println("5 - Exibir todos os alunos");
            System.out.println("6 - Quantidade de alunos");
            System.out.println("7 - Sair");
            int option = scanner.nextInt();
            switch (option){
                case 1:
                    signStudent(students);
                    break;
                case 2:
                    System.out.println("Qual o nome que deseja buscar?");
                    String nameToFind = scanner.next();
                    findStudent(students, nameToFind);
                    break;

                case 3:
                    delStudent();
                    break;

                case 4:
                    editStudent();
                    break;

                case 5:
                    listStudent();
                    break;

                case 6:
                    genderStudent();
                    break;

                case 7:
                    exit = false;
                    break;
            }
        }
    }

    //Cadastrar estudante - Register student
    private static void signStudent(List<Person> students){
        Person student = new Person();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome completo do estudante:");
        student.name = scanner.next();
        System.out.println("Qual a idade do estudante?");
        student.idade = Integer.parseInt(scanner.next());
        System.out.println("Qual o sexo do estudante?");
        student.sexo = scanner.next();
        students.add(student);
        System.out.println("Obrigado por digitar os dados do " + student.name + ".");
    }

    //Buscar estudante - Search student
    private static Integer findStudent(List<Person> students, String studentName){
        boolean finding = true;
        Integer position = null;

        for(int count = 0; count < students.size(); count++){
            Person student = students.get(count);
            if(student.name.equals(studentName)){
                position = count;

                System.out.println("Consegui encontrar o " + studentName);
                finding = false;
            }
        }
        if(finding) {
            System.out.println("Não foi possível encontrar o " + studentName + ".");
        }
        return position;
    }
    //Deletar estudante - Remove student
    private static void delStudent() {
        System.out.println("Qual estudante gostaria de remover?");
        String name = scanner.next();
        Integer position = findStudent(students, name);
        if(position != null){
            students.remove(position.intValue());
            System.out.println("Estudante removido com sucesso.");
        }
    }

    //Editar estudante - Edit student
    private static void editStudent(){
        System.out.println("Qual o nome que deseja editar?");
        String name = scanner.next();
        Integer position = findStudent(students, name);
        if(position != null){
            Person p1 = students.get(position.intValue());
            System.out.println("Qual é o novo nome?");
            name = scanner.next();
            //studants.get(position.intValue()).name = name;
            p1.name = name;
        }
    }

    //Exibir todos os estudantes - Show all students
    private static void listStudent(){
        for(int i = 0; i < students.size(); i++) {
            System.out.println(students.get(i).name + " " + students.get(i).idade + " " + students.get(i).sexo);
        }
    }

    //Exibe a quantidade de alunos por sexo e o total - Displays the number of students by gender and the total
    private static void genderStudent(){
        int m = 0;
        int f = 0;
        int t = 0;
        for(int i = 0; i < students.size(); i++){
            if(students.get(i).sexo.equals("Masculino")){
                m++;
                t++;
            }else{
                f++;
                t++;
            }
        }
        if(m >= 2){
            System.out.println("Temos " + m + " homens");
        } else if( m == 1){
            System.out.println("Temos " + m + " homem");
        } else{
            System.out.println("Não temos homens");
        }
        if(f >= 2){
            System.out.println("Temos " + f + " mulheres");
        } else if( f == 1){
            System.out.println("Temos " + f + " mulher");
        } else{
            System.out.println("Não temos mulheres");
        }
        if(t >= 2){
            System.out.println("Temos um total de " + t + " alunos");
        } else if( t == 1){
            System.out.println("Temos um aluno");
        } else{
            System.out.println("Não temos alunos");
        }
    }
}