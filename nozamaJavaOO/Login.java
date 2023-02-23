import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/*      Classe dedicada a administração de login(usuário e admin) */
class Login {

    Bd bancoDados = Bd.getInstance();
    Scanner input = new Scanner(System.in);
    int i;

    //Checklogin de usuário comum retornanod sua posição no array.
    public int checkLogin(){

        //  Analisa se existe conta de usuário simples registrada
        if(bancoDados.getUsers().isEmpty()){
            System.out.printf("Não existem contas registradas ainda. Gostaria de registar?\n1 - SIM\n2 - NÃO\n=>");
            int choises = input.nextInt();

            if(choises != 1) {return -1;}
            else{
                this.setRegister(); // Registra um novo usuário.
                return -1;
            }
        }

        String email, password;

        System.out.printf("Digite seu E-mail:\n=>");
        email = input.nextLine(); System.out.println();

        System.out.printf("Digite sua senha:\n=>");
        password = input.nextLine(); System.out.println();

        Iterator<Profile> itr = bancoDados.getUsers().Iterator();
        i = 0;

        while(itr.hasNext()){
            Profile e = itr.next();

            if(e.getEmail().intern()    == email.intern() &&
               e.getPassword().intern() == password.intern()) return i;
            i++;
        }
        System.out.println("E-mail ou senha incorretos. Tente novamente.");
        return -1;
    } 

    //Checklogin de usuário admin retorna sua posição no array.
    public int checkLoginAdmin(){

        String email, password;

        System.out.printf("Digite seu E-mail:\n=>");
        email = input.nextLine(); System.out.println();

        System.out.printf("Digite sua senha:\n=>");
        password = input.nextLine(); System.out.println();

        Iterator<UserAdmin> itr = bancoDados.getUserAdmin().iterator();
        i = 0;

        while(itr.hasNext()){
            UsersAdmin e = itr.next();

            if(e.get(i).getEmail().intern() == email.intern() && 
               e.get(i).getPassword().intern() == password.intern()) return i;
            i++;   
        }
        System.out.println("E-mail ou senha incorretos. Tente novamente.");
        return -1;
    } 
    

    //Inicia um novo registro e adciona ao sistema
    public void setRegister(){
        Profile novoUsuario = new Profile();
        novoUsuario.setEmail();

        Iterator<Profile> itr = bancoDados.getUsers().iterator();

        while(itr.hasNext()){
            Profile e = itr.next();

            if(e.getEmail().equals(novoUsuario.getEmail())){
                System.out.println("\nE-mail já cadastrado. Tente novamente mais tarde.\n");
            }
        }

        novoUsuario.setUsers();
        System.out.println(novoUsuario.toString());
        bancoDados.getUsers().add(novoPerfil);
    }
}