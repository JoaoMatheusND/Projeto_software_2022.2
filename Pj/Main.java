package nozama;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        Scanner input = new Scanner(System.in);
        Login login = new Login();

        ArrayList<Profile> accounts = new ArrayList<Profile>();
        ArrayList<UserAdmin> admins = new ArrayList<UserAdmin>();
        ArrayList<Product> feed = new ArrayList<Product>();

        boolean active = true;
        int choise, index;

        UserAdmin novoAdmin = new UserAdmin(feed, accounts, "admin", "admin", "admin"); 
        admins.add(novoAdmin);

        while(active)
        {
            System.out.println("\nBem-vindo ao nozamA!");
            System.out.println("1 - Login;\n2 - Cadastro;\n3 - Administrar;\n4 - Sair.");            
        
            choise = input.nextInt();

            switch(choise)
            {
                case 1: index = login.checkLogin(accounts);
                        if(index > -1) accounts.get(index).menuUser(feed);
                        break;
                case 2: login.setRegister(accounts); break;
                case 3: index = login.checkLoginAdmin(admins);
                        if(index > -1) admins.get(index).menuUserAdmin(admins, feed);
                        break;
                case 4: active = false; break;
                default: System.out.println("Insira uma opção válida.\n"); break;
            }
        }
        input.close();
    }
}
