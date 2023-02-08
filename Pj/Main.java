import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        ArrayList<Profile> accounts = new ArrayList<Profile>();
        ArrayList<Product> feed = new ArrayList<Product>();

        boolean active = true;
        int choise;


        while(active)
        {
            System.out.println("Bem-vindo ao app");
            System.out.println("1 ==> Login\n2 ==> cadastro\n3 ==> Sair");
        
            choise = input.nextInt();
            input.nextLine();

            switch(choise)
            {
                case 1:
                        Login login = new Login();
                        int index = login.checkLogin(accounts);
                        
                        if(index > -1)
                        {
                            login.Menu(accounts, feed, index);
                        }
                        break;
                case 2:
                        Profile registro = new Profile();
                        registro.setRegister(accounts, registro);
                        break;
                default:
                active = false;
            }
        }

        System.out.printf("\n Usuarios cadastrados [%s]", accounts.size());
        for(int i=0; i< accounts.size(); i++)
        {
            System.out.println(accounts.get(i).getEmail());
        }
        input.close();
    }
}