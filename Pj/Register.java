import java.util.ArrayList;
import java.util.Scanner;

public class Register
{
    Scanner input = new Scanner(System.in);

    Profile entire = new Profile();
    String email, password;

    public String getEmail()
    {
        return email;
    }

    public String getPassword()
    {
        return password;
    }

    public void setUser()
    {
        System.out.println("Digite o seu E-mail: ");
        email = input.nextLine();
    }

    public void setPassword()
    {
        System.out.println("Qual sua senha?");
        password = input.nextLine();
    }
    
    
    public void setRegister(ArrayList<Register> accounts, Register new_register)
    {
        setUser();

        if(!accounts.isEmpty())
        {
            for(int i = 0; i < accounts.size(); i++)
            {
                if(email.intern() == (accounts.get(i).getEmail()).intern())
                {
                    System.out.println("Esse usuário já estar cadastrado.");
                }
            }
        }
        setPassword();
        accounts.add(new_register);
        System.out.println("Parabéns!!, agora você faz parte do nozamA.");

    }
}