package nozama;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

class UserAdmin {
    
    
    //Arrays dos produtos e perfiesi já criados
    ArrayList<Product> products;
    ArrayList<Profile> users;

    Scanner input = new Scanner(System.in);

    //Atributos básicos 
    private String user     = "[edit_user]",
                   cpf      = "[edit_cpf]",
                   email    = "[edit_email]",
                   password = "[edit_password]";

    //Método construtor para iniciar e pegar os produtor e usuários já criados
    public UserAdmin(ArrayList<Product> product, ArrayList<Profile> users){
        this.products = product;
        this.users = users;

        setUser();
        setCpf();
        setEmail();
        setPassword();
    }

    public UserAdmin(ArrayList<Product> product, ArrayList<Profile> users, String user, String email, String password){
        this.products = product;
        this.users = users;
        this.user = user;
        this.email = email;
        this.password = password;
    }

    //Método para editar alguns atributos dessa classe 
    public void editUserAdmin(){
        int userChoise;
        boolean aux = true;
        String userAux;
        String menuEdit = "Qual caracteristiac gostaria de editar?\n"+
                          "1 - Nome de usuário;\n"+
                          "2 - Troca de e-mail;\n"+
                          "3 - Troca de senha;\n"+
                          "4 - Sair.\n";
        do{
            this.toString();
            System.out.println(menuEdit);
            userChoise = input.nextInt();

            switch(userChoise){
                case 1: setUser();  break;
                case 2: setEmail(); break;
                case 3: System.out.printf("Insira sua senha atual:\n=>");
                        userAux = input.nextLine();

                        if(userAux.equals(getPassword())) setPassword();
                        else System.out.println("Senha incorreta. Não foi possivel efetuar a troca de senha.\n");
                        break;
                case 4: aux = false; break;
                default: System.out.println("Insira um valor válido.\n"); break;
            }
        }while(aux);
    }
    
    //Método para administrar como um usuário administrador
    public void menuUserAdmin(ArrayList<UserAdmin> usersm, ArrayList<Product> products){
        boolean aux = true;
        int adminChoise;
        String menuUserAdmin = "1 - Ver Todos os usuários.\n"+
                               "2 - ver todos os produtos.\n"+
                               "3 - Editar perfil.\n"+
                               "4 - Adicionar novo ADMIN.\n"+
                               "5 - Dar bônus.\n"+
                               "6 - Sair.\n=>";
        String adminUserMsm = "\nOque gostari de fazer?\n1 - Mandar aviso.\n2 - deletar.\n3 - Continuar\n=>";
        String op = "\nOpção inválida.\n";

        while(aux){
            System.out.printf("\n"+menuUserAdmin);
            adminChoise = input.nextInt();

            switch(adminChoise){
                case 1: if(!users.isEmpty()){
                            Iterator<Profile> itrProfile = users.iterator();
                            while(itrProfile.hasNext()){
                                Profile auxItrProfile = itrProfile.next();
                                System.out.println(auxItrProfile.toString()+"\n"+adminUserMsm);
                                int choise = input.nextInt();
                                input.next();

                                switch(choise){
                                    case 1: Message message = new Message(""+this.getUser());
                                            message.setMessageSend();

                                            auxItrProfile.messageBox.add(message);
                                            break;
                                    case 2: users.remove(auxItrProfile);
                                            for (Product pro : auxItrProfile.user.myProduct) products.remove(pro);  
                                            auxItrProfile.user.getMyProduct().clear();                                       
                                            auxItrProfile.user.getMycart().clear();
                                            auxItrProfile.messageBox.clear();
                                            auxItrProfile.prefer.clear();

                                    case 3: break;
                                    default: System.out.print(op); break;
                                }
                            }
                        } else System.out.printf("\nNão exitem contas registradas ainda.\n");
                        break;

                case 2: if(!products.isEmpty()){
                            Iterator<Product> itrProduct = products.iterator();
                            while(itrProduct.hasNext()){
                                Product auxItrProduct = itrProduct.next();
                                System.out.print("\n"+auxItrProduct.toString()+"\n"+adminUserMsm);
                                int choise = input.nextInt();
                                input.next();

                                switch(choise){
                                    case 1: Message message = new Message(this.getUser());
                                            message.setMessageSend();

                                            auxItrProduct.owner.messageBox.add(message);
                                            break;
                                    case 2: products.remove(auxItrProduct);
                                            auxItrProduct.owner.user.getMyProduct().remove(auxItrProduct);
                                            break;
                                    case 3: break;
                                    default: System.out.print(op);
                                }
                            }
                        }else System.out.printf("\nNão exitem produtos registrados registradas ainda.\n");
                        break;
                case 3: this.editUserAdmin();
                        break;
                case 4: UserAdmin novoAdmin = new UserAdmin(products, users);
                        usersm.add(novoAdmin);

                        break;
                case 5: System.out.printf("\nWIP\n"); break;
                case 6: aux = false; break;
                default: System.out.print(op) ;      

            }
        }
    }
    


    //Override para substituir o método toString() da class object para um padrão mais coerente a essa classe
    @Override
    public String toString() {
        return "\nUser: "+getUser()+"\nCPF: "+getCpf()+"\nE-mail: "+getEmail()+"\n";
    }

    //      gets and sets
    public void setUser()
    {
        System.out.println("Digite seu nome:\n=>");
        user = input.nextLine();
    }

    public String getUser() {return this.user;}

    public void setCpf()
    {
        System.out.println("Digite seu CPF:\n=>");
        cpf = input.nextLine();
    }

    public String getCpf() {return this.cpf;}

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
}