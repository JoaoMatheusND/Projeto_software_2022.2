import java.util.ArrayList;
import java.util.Scanner;

class Product {
    Scanner input = new Scanner(System.in);

    public enum Category{
        ELETRONICOS("Eletrônicos"), 
        ROUPAS("Roupas"),
        COMIDA("Comida"),
        CASA("Casa"), 
        DIVERSOS("Diversos"), 
        DEFAULT("Default");
    }

    //Array para avaliações
    ArrayList<Integer> rate = new ArrayList<Integer>();

    //Usuário q postou
    Profile owner;

    //Atributos básicos
    private String name,
                   description,
                   price;
    Category categoria = Category.DEFAULT;
    public int qtdProduto;


    //Método construtor para criar produtos, obrigando a inserir os dados relevantes.
    public Product(Profile e){
        this.setCategory();   System.out.println();
        this.setName();       System.out.println();
        this.setDescripton(); System.out.println();
        this.setPrice();      System.out.println();
        System.out.printf("\nQual a quantidade desse produto?\n=>");
        this.qtdProduto = input.nextInt();
        this.owner = e;
       
        System.out.println(qtdProduto);
    }

    //Método para editar alguns atributos dessa classe, individualmente.
    public void editProduct(){
        int userChoise;
        boolean aux = true;
        String menuEdit = "Qual característica gostaria de editar?\n"+
                          "1 - Nome do produto;\n"+
                          "2 - Descrição do produto;\n"+
                          "3 - Preço do produto;\n"+
                          "4 - Sair.\n";
        while(aux){            
            System.out.println(this.toString());
            System.out.println(menuEdit);
            userChoise = input.nextInt();
            
            switch(userChoise){
                // case 1: edita o nome do produto.
                case 1:  System.out.printf("Digite um novo nome:\n=>");   
                         input.nextLine();
                         this.name = input.nextLine();
                         break;

                // case 2: edita a descrição do produto.
                case 2:  System.out.printf("Digite uma nova descrição:\n=>");   
                         input.nextLine();
                         this.description = input.nextLine(); 
                         break;  

                // case 3: edita o preço do produto
                case 3:  System.out.printf("Digite um novo preço:\n=>");   
                          input.nextLine();
                          this.price = input.nextLine();     
                          break;
                // case 4: encerra a edição do produto
                case 4:   aux = false;     
                          break;
                default: System.out.println("Insira um valor válido.\n"); break;
            }
        }


    }

    //Override para substituir o método toString() da class object para um padrão mais coerente a essa classe
    @Override
    public String toString() { 
        return "Dono do produto: "+this.owner.user.getUser()+";\n"+
               "Nome do produto: "+getName()+";\n"+
               "Categoria: "+getCategory()+";\n"+
               "Descrição do produto: "+getDescription()+";\n"+
               "Preço do produto: "+getPrice()+";\n"+
               "Quantidade:"+this.qtdProduto+"\n"+
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

        this.description = input.nextLine();
    }

    public String getDescription() {return this.description;}

    public void setPrice(){
        System.out.printf("Qual é o preço do produto:\n=>");

        this.price = input.nextLine();
    }

    public String getPrice() {return this.price;}

    public void setCategory(){
        System.out.printf("\nQual a sua categoria?"+
                           "\n1 - Eletrônicos"+
                           "\n2 - Roupas"+
                           "\n3 - Comida"+
                           "\n4 - Casa"+
                           "\n5 - Diversos"+
                           "\n=>");
        int choise = input.nextInt();

        while(this.categoria == Category.Default){
            switch(choise){
                case 1: this.categoria = Category.ELETRONICOS;     break;
                case 2: this.categoria = Category.ROUPAS;          break;
                case 3: this.categoria = Category.COMIDA;          break;
                case 4: this.categoria = Category.CASA;            break;
                case 5: this.categoria = Category.DIVERSOS;        break;
                default: System.out.printf("\nOpção inválida.\n"); break;
            }
        }
    }

    public String getCategory() {return this.categoria.name();}

    // Insere uma nova avaliação no produto.
    public void setRate(){
        int aval;

        System.out.printf("Qual é sua avalação do produto:\n=>");
        aval = input.nextInt();
        System.out.println("Obrigado pela sua avaliação!\n");
        this.rate.add(aval);
    }

    // Calcula a média das avaliações.
    public String getRate(){
        int size = this.rate.size(), star = 0;

        for(Integer i : this.rate) star += i;

        if(size == 0) { return "Não há avaliações ainda.\n"; }
        star /= size;

        return ""+star;
    }

    // Reduz o número do produto(this) disponivel no feed
    public void compra(){
        this.qtdProduto--;
    }
    

}