import java.util.Scanner;
import java.util.ArrayList;

public class Product extends Profile{
    ArrayList<Integer> rate = new ArrayList<Integer>();
    ArrayList<String> comments = new ArrayList<String>();

    Scanner input = new Scanner(System.in);

    String name, description, categoria;
    float price;

    public Product(ArrayList<Product> e){
        System.out.printf("Qual o nome do seu produto: ");
        this.name = input.nextLine();

        System.out.printf("Qual a descricao do produto: ");
        this.description = input.nextLine();

        System.out.printf("Qual a categoria do seu produto: ");
        this.categoria = input.nextLine();

        System.out.printf("Qual o valor do produto: ");
        this.price = input.nextFloat();
        e.add(this);
    }
    public void setComments(){

        System.out.println("digite seu Comentario: ");
        String comente = input.nextLine();
        comments.add(comente);

        System.out.println("De sua avaliacao: ");
        int aux = input.nextInt();
        rate.add(aux);
        input.next();
    }
    public String rateStar(){
        float star = 0;

        for(int i=0; i<rate.size()-1; i++){
            star += rate.get(i);
        }
        star /= rate.size();


        return "" + star;
    }

    @Override
    public String toString() {
        return "Nome : "+this.name+"\n"+"Descricao: "+this.description+"\n"+"Categoria: "+this.categoria+"\n"+"Valor do produto: "+this.price;
    }
}