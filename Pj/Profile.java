package nozama;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

class Profile {
    Scanner input = new Scanner(System.in);

    ArrayList<Message> messageBox = new ArrayList<Message>();
    ArrayList<User> prefer = new ArrayList<User>();

    public User user;
    
    public void menuUser(ArrayList<Product> product){
        boolean aux = true, aux2 = true;
        int userChoise, userChoiseCompra, userChoiseCart;
        String menuUser = "1 - Ver feed.\n"+
                          "2 - Postar produto.\n"+
                          "3 - Ver meu carrinho.\n"+
                          "4 - Ver meu produtos.\n"+
                          "5 - Ver mensagens.\n"+
                          "6 - Editar perfil.\n"+
                          "7 - Sair.\n=>";
        String menuCompra = "\nGostaria de adicionar ao carrinho? \n[1] - Sim\n[2] - Não\n=>";
        String menuCart = "\nAções: \n[1] - Comprar\n[2] - Remover\n[3]Voltar\n=>";
        while(aux){
            
            System.out.printf(this.user.toString()+"\n\n"+menuUser);
            userChoise = input.nextInt();

            switch(userChoise){
                case 1: if(!product.isEmpty()){ 
                            Iterator<Product> itrProduct = product.iterator();
                            while(itrProduct.hasNext()){
                                Product e = itrProduct.next();
                                System.out.println("\n"+e.toString()+menuCompra);
                                userChoiseCompra =  input.nextInt();

                                switch(userChoiseCompra){
                                    case 1:System.out.println(this.user.cpf);
                                        System.out.println(e.getName()); 
                                        System.out.println("Produto adicionadfo no carrinha!\n");
                                        this.user.setMyCart(e);
                                        break;
                        
                                    case 2: break;
                                    }
                            }
                        } else System.out.printf("\nNão existe produto nos feeds\n\n");
                    break;

                case 2: Product novoProduto = new Product(this);
                        this.user.setMyProduct(novoProduto);
                        product.add(novoProduto);

                        System.out.print("\nProduto adicionado com sucesso:\n"+novoProduto.toString()+"\n");
                        break;
                case 3: if(!this.user.getMycart().isEmpty()){
                            Iterator<Product> itrPro = this.user.getMycart().iterator();
                            while(itrPro.hasNext()){
                                Product i = itrPro.next();
                                System.out.println(i.toString()+menuCart);
                                userChoiseCart = input.nextInt();
                                switch(userChoiseCart){
                                    case 1: i.compra();
                                            i.setRate();
                                            Message novaMensagem = new Message(this);
                                            novaMensagem.sendMessageSend("Item comprado!!!\n\n"+this.user.toString());
                                            i.owner.messageBox.add(novaMensagem);
                                            if(i.qtdProduto == 0){
                                                product.remove(i);
                                            }
                                            this.user.favoritos.add(i.getCategory());
                                            itrPro.remove();
                                            break;
                                    case 2: itrPro.remove();
                                    case 3:break;
                                    }  
                            }
                        }else{
                            System.out.println("Carrinho Vazio!\n");
                        }
            
                break;
                case 4: if(this.user.getMyProduct().isEmpty()){ System.out.println("Sem produtos!\n");}
                else {
                    Iterator<Product> itrProd = this.user.getMyProduct().iterator(); 
                    while(itrProd.hasNext()){
                        Product i = itrProd.next();
                        System.out.println(i.toString()+"\nEditar produto?\n[1]sim\n[2]não\n=>");
                        userChoiseCart = input.nextInt();
                        if(userChoiseCart == 1){i.editProduct();}
                    } 
                    }
                    break;
                case 5:
                    if(this.messageBox.isEmpty()){
                        System.out.println("\nSem Mensagens!\n");
                    }else{
                        for(Message i : this.messageBox){
                            System.out.println(i.toString()+"\nOque quer fazer?\n[1]Responder\n[2]Deletar mensagem\n[3] - Voltar\n");
                            userChoiseCart = input.nextInt();
                            if(userChoiseCart == 1){
                                Message novaMensagem = new Message(this);
                                novaMensagem.setMessageSend();
                                i.origem.messageBox.add(novaMensagem);
                            }else if(userChoiseCart == 2){this.messageBox.remove(i);}
                        }
                    }
                    break;
                case 6: this.user.editUser();
                break;
                case 7: aux = false; break;
                default: break;
                }
            }
        }
}
