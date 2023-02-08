import java.util.ArrayList;
import java.util.Scanner;

public class Profile
{
    Scanner input = new Scanner(System.in);

    ArrayList<Product> myProduct = new ArrayList<Product>();
    ArrayList<Product> myCart = new ArrayList<Product>();

    private String user = "[edit_user]",
            age = "[edit_age]",
            gender = "[edit_gender]",
            cpf = "[edit_cpf]",
            adress = "[edit_adress]",
            email = "[edit_email]",
            password = "[edit_password]";
    boolean aux = false;


    public void setProfile()
    {
        setUser();
        setAge();
        setGender();
        setCpf();
        setAdress();
        setPassword();
    }
                                                                                                 
    public String my_profile()
    {
        return "Olar, "+this.user+", este é seu perfil:\n"+"Genero: "+this.gender+", Idade: "+this.age+", E-mail: "+email;
    }

    public void setUser()
    {
        System.out.println("Digite seu username:\n=>");
        user = input.nextLine();
    }

    public String getUser() {return this.user;}

    public void setAge()
    {
        System.out.println("Digite sua idade:\n=>");
        age = input.nextLine();
    }

    public String getAge() {return this.age;}

    public void setGender()
    {
        System.out.println("Digite seu gênero:\n=>");
        gender = input.nextLine();
    }

    public String getGender() {return this.gender;}

    public void setCpf()
    {
        System.out.println("Digite seu CPF:\n=>");
        cpf = input.nextLine();
    }

    public String getCpf() {return this.cpf;}

    public void setAdress()
    {
        System.out.println("Digite seu endereco:\n=>");
        adress = input.nextLine();
    }

    public String getAdress() {return this.adress;}

    public void setEmail()
    {
        System.out.println("Digite seu e-mail:\n=>");
        email = input.nextLine();
    }

    public String getEmail() {return this.email;}

    private void setPassword()
    {
        System.out.println("Digite sua senha:\n=>");
        password = input.nextLine();
    }

    public String getPassword() {return this.password;}



    public Product setProduto(ArrayList<Product> aux) {
        Product e = new Product(aux);
        myProduct.add(e);
        return e;
    }

    public ArrayList<Product> getMyproduto() {return this.myProduct;}

    public void setCart(Product e) {this.myCart.add(e);}
    public ArrayList<Product> getCart() {return this.myCart;}


    public void setRegister(ArrayList<Profile> accounts, Profile new_register)
    {
        setEmail();
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
        this.setProfile();
        accounts.add(new_register);
        System.out.println("Parabéns!!, agora você faz parte do nozamA.");

    }

}