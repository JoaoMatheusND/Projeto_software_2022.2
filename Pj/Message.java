package nozama;

import java.util.Scanner;

class Message{
    Scanner input = new Scanner(System.in);

    private String message;
    Profile origem;
    String admin;

    public Message(Profile user) {
        this.origem = user;
        this.admin = this.origem.user.getUser();
    }
    public Message(String str) {this.admin = "admin: "+str+"\n";}

    public void setMessageSend(){
        System.out.printf("Qual a mensagem deseja enviar:\n=>");
        input.next();
        this.message = input.nextLine();
    }

    public void sendMessageSend(String message){
        this.message = message;
    }
    public String getMessage() {return this.message;}

    @Override
    public String toString() {
        return "Usuário: "+admin+"\n"+
               "Mensagem: "+getMessage()+"\n";
    }

}