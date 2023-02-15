package nozama;

import java.util.ArrayList;
import java.util.Scanner;

class Product {
    Scanner input = new Scanner(System.in);

    //Array para avaliações
    ArrayList<Integer> rate = new ArrayList<Integer>();

    //Usuário q postou
    Profile owner;

    //Atributos básicos
    private String name,
                   description,
                   price,
                   categoria = "[Edit_category]";
    public int qtdProduto;

    //Método construtor para criar produtos
    public Product(Profile e){
        this.setName();       System.out.println();
        this.setDescripton(); System.out.println();
        this.setPrice();      System.out.println();
        System.out.printf("\nQual a quantidade desse produto?\n=>");
        this.qtdProduto = input.nextInt();
        this.owner = e;

       
        System.out.println(qtdProduto);
    }

    //Método para editar alguns atributos dessa classe 
    public void editProduct(){
        int userChoise;
        boolean aux = true;
        String menuEdit = "Qual característica gostaria de editar?\n"+
                          "1 - Nome do produto;\n"+
                          "2 - Descrição do produto;\n"+
                          "3 - Preço do produto;\n"+
                          "4 - Sair.\n";
        do {
            System.out.println(this.toString());
            System.out.println(menuEdit);
            userChoise = input.nextInt();

            switch(userChoise){
                case 1:  setName();       break;
                case 2:  setDescripton(); break;  
                case 3:  setPrice();      break;
                case 4:  aux = false;     break;
                default: System.out.println("Insira um valor válido.\n"); break;
            }
        } while(aux);


    }

    //Override para substituir o método toString() da class object para um padrão mais coerente a essa classe
    @Override
    public String toString() { 
        return "Dono do produto: "+this.owner.user.getUser()+";\n"+
               "Nome do produto: "+getName()+";\n"+
               "Categoria: "+getCategory()+";\n"+
               "Descrição do produto: "+getDescription()+";\n"+
               "Preço do produto: "+getPrice()+";\n"+
               "Quantidade:"+qtdProduto+"\n"+
               "Avaliação: "+getRate();
    }

    //      getters and setters
    public void setName(){
     
        System.out.printf("Qual é o nome do produto?\n=>");
        this.name = input.nextLine();

        System.out.println(this.name.intern());
    }

    public String getName() {return this.name;}

    public void setDescripton(){
        System.out.printf("Descreva uma descrição do produto:\n=>");
        //input.next();
        
        this.description = input.nextLine();
    }

    public String getDescription() {return this.description;}

    public void setPrice(){
        System.out.printf("Qual é o preço do produto:=>");

        this.price = input.nextLine();
    }

    public String getPrice() {return this.price;}

    public void setCategory(){
        System.out.printf("\nQual a sua categoria?\n1 - Eletronicos\n2 - Roupas\n3 - outros\n=>");
        int choise = input.nextInt();

        boolean aux2 = true;

        while(aux2){
            switch(choise){
                case 1: this.categoria = "Eletronicos"; aux2 = false; break;
                case 2: this.categoria = "Roupas"; aux2 = false;      break;
                case 3: this.categoria = "Outros"; aux2 = false;      break;
                default: System.out.printf("\nOpção inválida.\n");    break;
            }
        }
    }

    public String getCategory() {return this.categoria;}

    public void setRate(){
        int aval;

        System.out.printf("Qual é sua avalação do produto:\n=>");
        aval = input.nextInt();
        System.out.println("Obrigado pela sua avaliação!\n");
        this.rate.add(aval);
    }

    public String getRate(){
        int size = this.rate.size()+1, star = 0;

        for(Integer i : this.rate) star += i;

        star /= size;

        return ""+star;
    }

    public void compra(){
        this.qtdProduto--;
    }
    

}
