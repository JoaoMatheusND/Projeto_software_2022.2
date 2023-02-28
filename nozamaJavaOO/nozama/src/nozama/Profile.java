package nozama;

import java.util.Iterator;
import java.util.Scanner;

class Profile extends User{

    Bd bancoDados = Bd.getInstance();
    Scanner input = new Scanner(System.in);

    public Profile(){
        super();
    }

    Iterator<Product> itrProducts;
    Iterator<Profile> itrProfiles;
    Iterator<Message> itrMessages;

    public void menuProfile(){
        boolean aux = true;
        int userChoise, choiseBuy, choiseProduct, choiseMessage, choiseCart;

        String menuUser = "\n1 - Ver feed;\n"+
                          "2 - Postar produto;\n"+
                          "3 - Ver meu carrinho;\n"+
                          "4 - Ver meu produtos;\n"+
                          "5 - Ver mensagens;\n"+
                          "6 - Editar perfil;\n"+
                          "7 - Sair.\n=>";
        
        String menuBuy = "\nGostaria de adicionar o produto ao seu carrinho?\n"+
                         "[1] - Sim\t[2] - Não\n=>";

        String menuCart = "\nAçoes:\n"+
                          "[1] - Comprar;\n"+
                          "[2] - Remover;\n"+
                          "[3] - Continuar.\n=>";

        String menuProduct = "\nAçoes:\n"+
                             "[1] - Editar;\n"+
                             "[2] - Remover;\n"+
                             "[3] - Continuar.\n=>";

        String menuMessage = "\nAçoes:\n"+
                             "[1] - Responder;\n"+
                             "[2] - Remover;\n"+
                             "[3] - Continuar.\n=>";



        while(aux){
            System.out.printf(super.toString()+menuUser);
            userChoise = input.nextInt();

            if(input.hasNextLine()) input.nextLine();

            switch(userChoise){

                case 1: if(!bancoDados.getProducts().isEmpty()){
                            itrProducts = bancoDados.getProducts().iterator();
                            while(itrProducts.hasNext()){
                                Product e = itrProducts.next();

                                System.out.printf(e.toString()+menuBuy);
                                choiseBuy = input.nextInt();

                                if(input.hasNextLine()) input.nextLine();

                                if(choiseBuy == 1){
                                    this.getMycart().add(e);
                                    System.out.printf("\nProducto adcionado com sucesso!!!\n");
                                } else System.out.printf("\nOk! continuaremos...\n");
                            }
                        }System.out.printf("\nNão existe nenhum produto no feed ainda.\n");
                        break;

                case 2: Product e = new Product(this);
                        this.setMyProduct(e);
                        bancoDados.getProducts().add(e);

                        Message messageProduct = new Message(this);
                                messageProduct.setMessageProduct(this.getUser(), e.toString());

                        itrProfiles = bancoDados.getUsers().iterator();

                        while(itrProfiles.hasNext()){
                            Profile p = itrProfiles.next();

                            if(p.getFavorito().equals(e.categoria.toString())) p.setMessageBox(messageProduct);
                        }
                        break;

                case 3: if(!this.getMycart().isEmpty()){
                            itrProducts = this.getMycart().iterator();

                            while(itrProducts.hasNext()){
                                Product p = itrProducts.next();

                                System.out.printf(p.toString()+menuCart);
                                choiseCart = input.nextInt(); 

                                if(input.hasNextLine()) input.nextLine();

                                if(choiseCart == 1){
                                    p.compra();
                                    Message messageCart = new Message(this);
                                    messageCart.setBuyProduct(this.getUser(), p.getName());
                                    p.owner.setMessageBox(messageCart);
                                } else{
                                    itrProducts.remove();
                                    System.out.printf("\nItem removido com sucesso!.\n");
                                }

                                System.out.printf("\n\t\tCONTINUANDO!\n");
                            }
                        }else System.out.printf("\n\tSeu carrinho estar vazio!\n");
                        break;

                case 4: if(!this.getMyProduct().isEmpty()){
                            itrProducts = this.getMyProduct().iterator();

                            while(itrProducts.hasNext()){
                                Product p = itrProducts.next();

                                System.out.printf(p.toString()+menuProduct);
                                choiseProduct = input.nextInt(); 

                                if(input.hasNextLine()) input.nextLine();

                                if(choiseProduct == 1) p.editProduct();
                                else{
                                    bancoDados.getProducts().remove(p);
                                    itrProducts.remove();

                                    System.out.printf("\n\tItem comprado com sucesso!\n");
                                }

                                System.out.printf("\n\t\tCONTINUANDO!\n");
                            }
                        }else System.out.printf("\nSeu carrinho estar vazio!\n");
                        break;
                    
                case 5: if(!this.getMessageBox().isEmpty()){
                            itrMessages = this.getMessageBox().iterator();

                            while(itrMessages.hasNext()){
                                Message messageBox = itrMessages.next();

                                System.out.printf(messageBox.toString()+menuMessage);
                                choiseMessage = input.nextInt(); 

                                if(input.hasNextLine()) input.nextLine();

                                if(choiseMessage == 1){
                                    Message res = new Message(this);
                                    res.setMessage(this.getUser());

                                    messageBox.aux.getMessageBox().add(res);

                                    System.out.printf("\nResposta enviada com sucesso!\n");

                                }else{
                                    itrMessages.remove();
                                    System.out.printf("\nMensagem removida com sucesso!\n");
                                }

                                System.out.printf("\n\tCONTINUANDO!!\n");
                            }

                        }else System.out.printf("\nVocê não tem mensagem em seus dados.\n");
                        break;

                case 6: this.editUser();  break;
                case 7: aux = false; break;
                default: System.out.printf("\nOpção inválida.\n");

            }
        }

    }
} 