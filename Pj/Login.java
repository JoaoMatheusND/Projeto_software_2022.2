import java.util.ArrayList;
import java.util.Scanner;

public class Login
{
	public int checkLogin(ArrayList<Profile> accounts)
	{
        String email, password; boolean check = false; int index = 0;
        Scanner input = new Scanner(System.in); 

        String okay;
        
		if(accounts.isEmpty())
		{
			System.out.printf("\nSem cadastros.\n\n");
			return -1;
        }
        
		System.out.printf("\nEmail de usuario:\n=> ");
		email = input.nextLine();
		System.out.printf("Senha:\n=> ");
		password = input.nextLine(); 
		
		for(int i = 0; i < accounts.size(); i++)
		{
			if(email.intern() == (accounts.get(i).getEmail()).intern()
					&& password.intern() == (accounts.get(i).getPassword()).intern())
				{
					check = true; index = i; break;
				}
		}
		if(!check)
		{
			System.out.printf("Nome de usuario ou senha incorretos\n");
			System.out.printf("[1] Continue\n=> ");
			okay = input.nextLine();
			System.out.printf("\n");
			return -1;
		}
		else
			return index;
    }

    public void Menu(ArrayList<Profile> accounts, ArrayList<Product> produto,int index)
	{
        System.out.printf("\n");
		boolean active = true; int user_choice, aux;
        Scanner input = new Scanner(System.in);

        Profile user = accounts.get(index);

        String menu1 = "0 - Ver Feed\n1 - Meus produtos\n2 - Carrinho\n3 - Favoritos(nao tem)\n4 - Meu perfil\n10 - Sair";
        String menu2 = "";

        while(active){
            System.out.println(menu1);
            user_choice = input.nextInt();

            switch(user_choice){
                case 0: if(!produto.isEmpty())
                            for(Product e : produto){ System.out.println(e.toString()); } 
                        else System.out.println("Do not have any products yet;");    
                        System.out.println("Gostaria de comprar algum produto <1> sim, <2> nao");

                        aux = input.nextInt();

                        if(aux == 1){
                            System.out.println("Qual produto gostaria de comprar, considerando o primeiro produto como 0.");
                            aux = input.nextInt();
                            produto.get(aux).setComments();
                            user.setCart(produto.get(aux));
                            produto.remove(aux);
                        } else {
                            System.out.println("ok ate a proxima");
                        }
                        break;

                case 1: if(!user.getMyproduto().isEmpty())
                            for(Product e : accounts.get(index).getMyproduto()) System.out.println(e.toString());
                        else System.out.println("you do not have any product to sell yet, gostaria de criar um produto <1> sim , <2> nao");

                        aux = input.nextInt();

                        if(aux == 1){
                            user.setProduto(produto);
                        } else System.out.println("ok, ate a proxima;");

                        break;
                
                case 2: if(!user.getCart().isEmpty())
                            for(Product e : accounts.get(index).getCart()) System.out.println(e.toString());
                        else System.out.println("you do not have any product in your cart;");    
                        break;
                case 4: System.out.println(user.my_profile());
                        break;
            }   
        }
        

    }
           
}
    
