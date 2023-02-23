import java.util.Scanner;

class Message{

    Scanner input = Scanner(System.in);

    Strign message, who;
    Profile aux;
    int type = -1; // 0 - mensagem enviado por usuário
                   // 1 - mensagem enviada pelo sistema de producot
                   // 2 - mensagem de admin
                   // 3 - mensagem anonima

    public void Message(Profile user){
        this.aux = user;
    }

    public void setMessage(String who){
        this.who = who;

        System.out.printf("\nQual a sua mensagem?\n=>");
        this.message = input.nextLine();
        this.type = 0;

    }

    public void setMessageProduct(String who, String productStr){
        this.who     = who;
        this.message = productStr;
        this.type = 1; 
    }

    public void setMessageAdmin(String who){
        this.setMessage(who);
        this.type = 2;
    }

    public void setMessage(){
        this.messaeg = input.nextLine();
        this.type = 3;
    }

    public void setBuyProduct(String who, String product){
        this.who = who;
        this.message = "\tItem "+product+" foi Comprado por " + who+"\n";
        this.type = 4;
    }

    @Override
    public String toString() {
        switch(this.type){
            case 0: return "\t\tUsuário: "+this.who+", enviou uma message.\nMessage: "+this.message+"\n"; break;
            case 1: return "\t\tVendedor: "+this.who+", postou um novo produto no feed.\nProduto:\n"+this.message+"\n"; break;
            case 2: return "\t\tAdmin: "+this.who+".\nMessage: "+message+"\n"; break;
            case 3: return "\t\tAnônimo\nMessage:"+this.message; break;
            case 4: return this.message; break;
            default: return "\nMessage: Algo de errado ocorreu com sua mensagem!\n";
        }
    }
}