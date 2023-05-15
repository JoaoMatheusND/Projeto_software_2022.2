package nozama.users;

import nozama.app.*;
import nozama.payment.*;
import nozama.products.*;

import java.util.Iterator;
import java.util.Scanner;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Profile extends User{

    Bd bancoDados = Bd.getInstance();
    Scanner input = new Scanner(System.in);
    boolean comp = false;
    Iterator<Product> itrProducts;
    Iterator<Profile> itrProfiles;
    Iterator<Message> itrMessages;
    JDialog frame = this;

    public Profile(){
        super();
    }

    private void clearJDialog() {
        try {
            this.getContentPane().removeAll();
            this.revalidate();
            this.repaint();
            this.setModal(true);
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Err clearJDialog(),  Exception:\n"+ex.getCause(), "Exception", 0);
        }
    }
    
    @Override
    public void menu() {
        try {
            bancoDados.mainWindow.setVisible(false);
            clearJDialog();
            this.setTitle("Profile");
            this.setLayout(new BorderLayout());
            this.setResizable(false);
            this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            this.setModal(true);
    
            JPanel buttons = new JPanel(new GridLayout(7, 1));
    
            bancoDados.loginWindow.setVisible(false);
            JButton feed = new JButton("       Feed       ");
            JButton post = new JButton("Criar Produto");
            JButton cart = new JButton("    Carrinho    ");
            JButton product = new JButton("    Produtos    ");
            JButton message = new JButton("  Messagem  ");
            JButton edit = new JButton("       Perfil       ");
            JButton exit = new JButton("         Sair        ");
    
            JPanel feedPanel = new JPanel();
            JPanel postPanel = new JPanel();
            JPanel cartPanel = new JPanel();
            JPanel productPanel = new JPanel();
            JPanel messagePanel = new JPanel();
            JPanel editPanel = new JPanel();
            JPanel exitPanel = new JPanel();
    
            feedPanel.setBackground(new Color(51, 60, 76));
            postPanel.setBackground(new Color(51, 60, 76));
            cartPanel.setBackground(new Color(51, 60, 76));
            productPanel.setBackground(new Color(51, 60, 76));
            messagePanel.setBackground(new Color(51, 60, 76));
            editPanel.setBackground(new Color(51, 60, 76));
            exitPanel.setBackground(new Color(51, 60, 76));
    
            feed.setCursor(new Cursor(12));
            post.setCursor(new Cursor(12));
            cart.setCursor(new Cursor(12));
            product.setCursor(new Cursor(12));
            message.setCursor(new Cursor(12));
            edit.setCursor(new Cursor(12));
            exit.setCursor(new Cursor(12));
    
            feed.setBackground(new Color(225, 127, 17));
            post.setBackground(new Color(225, 127, 17));
            cart.setBackground(new Color(225, 127, 17));
            product.setBackground(new Color(225, 127, 17));
            message.setBackground(new Color(225, 127, 17));
            edit.setBackground(new Color(225, 127, 17));
            exit.setBackground(new Color(225, 127, 17));
    
            feedPanel.add(feed);
            postPanel.add(post);
            cartPanel.add(cart);
            productPanel.add(product);
            messagePanel.add(message);
            editPanel.add(edit);
            exitPanel.add(exit);
    
    
            buttons.add(feedPanel);
            buttons.add(postPanel);
            buttons.add(cartPanel);
            buttons.add(productPanel);
            buttons.add(messagePanel);
            buttons.add(editPanel);
            buttons.add(exitPanel);
    
            JTextArea dados = new JTextArea(this.toString());
            dados.setAutoscrolls(true);
            dados.setBackground(Color.lightGray);
            dados.setEditable(false);
    
            this.add(dados, BorderLayout.EAST);
            this.add(buttons, BorderLayout.WEST);
            this.pack();
            this.repaint();
    
            feed.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        if (bancoDados.getProducts().isEmpty()) {
                            JOptionPane.showMessageDialog(frame, "Não há produto no Feed!");
                        } else {
                            setVisible(false);
                            showFeed();
                            setVisible(true);
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            });

            post.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setVisible(false);
                    creatProduct();
                    setVisible(true);
                }
            });

            cart.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        if (bancoDados.getProducts().isEmpty()) {
                            JOptionPane.showMessageDialog(frame, "Não há produto no Carrinhoed!");
                        } else {
                            setVisible(false);
                            showCart();
                            setVisible(true);
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            });

            product.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        if (bancoDados.getProducts().isEmpty()) {
                            JOptionPane.showMessageDialog(frame, "Não há produtos criados por você.");
                        } else {
                            setVisible(false);
                            showMyProduct();
                            setVisible(true);
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            });

            message.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(getMessageBox().isEmpty()){
                        JOptionPane.showMessageDialog(frame, "Voce ainda não tem mensagens postados!");
                    }else{
                        itrMessages = getMessageBox().iterator();
    
                        while(itrMessages.hasNext()){
                            Message msm = itrMessages.next();
    
                            switch(msm.type){
                                case 0: respondMessage(msm); break;
                                case 1: JOptionPane.showMessageDialog(frame, msm.toString(), "New Product", 0);   break;
                                case 2: JOptionPane.showMessageDialog(frame, msm.toString(), "Admin message", 0); break;
                                case 3: JOptionPane.showMessageDialog(frame, msm.toString(), "Message", 0);       break;
                            }  
                        }
                    }
                }
            });

            edit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setVisible(false);
                    editUser();
                    setVisible(true);   
                } 
            }); 

            exit.addActionListener(e -> {
                this.setVisible(false);
                bancoDados.mainWindow.setVisible(true);
                dispose();
            });

            this.setVisible(true);

        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getCause(), "Exception", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void creatProduct() {
        JDialog frame = new JDialog(this, "Criando");
        frame.setLayout(new GridLayout(5, 1));
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(new Color(51, 60, 76));

        JButton casa = new JButton("    Casa    ");
        JButton comida = new JButton("  Comida  ");
        JButton eletric = new JButton("Eletronico");
        JButton roupa = new JButton("   Roupa   ");
        JButton cancelar = new JButton(" Cancelar ");

        JPanel casaPanel = new JPanel();
        JPanel comidaPanel = new JPanel();
        JPanel eletricPanel = new JPanel();
        JPanel roupaPanel = new JPanel();
        JPanel cancelarPanel = new JPanel();

        casaPanel.setBackground(new Color(51, 60, 76));
        comidaPanel.setBackground(new Color(51, 60, 76));
        eletricPanel.setBackground(new Color(51, 60, 76));
        roupaPanel.setBackground(new Color(51, 60, 76));
        cancelarPanel.setBackground(new Color(51, 60, 76));

        casa.setCursor(new Cursor(12));
        comida.setCursor(new Cursor(12));
        eletric.setCursor(new Cursor(12));
        roupa.setCursor(new Cursor(12));
        cancelar.setCursor(new Cursor(12));

        casa.setBackground(new Color(0, 200, 200));
        comida.setBackground(new Color(0, 200, 200));
        eletric.setBackground(new Color(0, 200, 200));
        roupa.setBackground(new Color(0, 200, 200));
        cancelar.setBackground(new Color(200, 80, 100));

        casa.setBackground(new Color(225, 127, 17));
        comida.setBackground(new Color(225, 127, 17));
        eletric.setBackground(new Color(225, 127, 17));
        roupa.setBackground(new Color(225, 127, 17));
        cancelar.setBackground(new Color(200, 80, 100));

        casaPanel.add(casa);
        comidaPanel.add(comida);
        eletricPanel.add(eletric);
        roupaPanel.add(roupa);
        cancelarPanel.add(cancelar);

        frame.add(casaPanel);
        frame.add(comidaPanel);
        frame.add(eletricPanel);
        frame.add(roupaPanel);
        frame.add(cancelarPanel);
        frame.pack();

        casa.addActionListener(e -> {
            try {
                Product product = new Casa(this);
                setMyProduct(product);
               
                if(product.getQtd() > 0){
                    bancoDados.getProducts().add(product);
                    notifyUsers(product);
                }
                this.aux = true;
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Janela encerrada incorretamente, objeto anulado", ""+ex.getCause(), 0);
            }
            
        });

        comida.addActionListener(e -> {
            try {
                Product product = new Comida(this);
                getMyProduct().add(product);
                if(product.getQtd() > 0){
                    bancoDados.getProducts().add(product);
                    notifyUsers(product);
               }else
                this.aux = true;
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Janela encerrada incorretamente, objeto anulado", ""+ex.getCause(), 0);
            }
        });

        eletric.addActionListener(e -> {
            try {
                Product product = new Eletrics(this);
                setMyProduct(product);

                if(product.getQtd() > 0){
                    bancoDados.getProducts().add(product);
                    notifyUsers(product);
               }

                this.aux = true;
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Janela encerrada incorretamente, objeto anulado", ""+ex.getCause(), 0);
            }
        });

        roupa.addActionListener(e -> {
            try {
                Product product = new Roupas(this);
                setMyProduct(product);

                if(product.getQtd() > 0){
                    bancoDados.getProducts().add(product);
                    notifyUsers(product);
               }
                this.aux = true;
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Janela encerrada incorretamente, objeto anulado", ""+ex.getCause(), 0);
            }
        });

        cancelar.addActionListener(e -> {
            try {
                frame.dispose();
            }catch(IllegalStateException ex){
                ex.printStackTrace();
            }
        });
        frame.setVisible(true);
    }

    private void notifyUsers(Product product){
        for (int i = 0; i < bancoDados.getUsers().size(); i++) {
            User perfil = bancoDados.getUsers().get(i);


            if (perfil.getFavorito().equals(product.getCategory())) {
                Message productMessage = new Message(this);
                productMessage.setMessage(this.getName(), product.getName(), 1);
                perfil.getMessageBox().add(productMessage);
            }
        }
    }        
               
    private void respondMessage(Message message){
        JDialog window = new JDialog(frame, "User Message", true); 
        window.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        window.setLayout(new BorderLayout());

        JPanel panel  = new JPanel(new GridLayout(2,1));
        JPanel panel2 = new JPanel(new GridLayout(1,2));

        JTextField msm = new JTextField(message.toString());
        msm.setEditable(false);

        JButton ok = new JButton("Continuar");
        JButton res = new JButton("Responder");

        ok.setCursor(new Cursor(12));
        res.setCursor(new Cursor(12));

        panel.add(msm);
        panel2.add(ok);
        panel2.add(res);

        window.add(panel, BorderLayout.CENTER);
        window.add(panel2, BorderLayout.SOUTH);

        window.pack();
        window.setResizable(false);
        window.setVisible(true);

        ok.addActionListener(e -> {
            window.dispose();
        });

        res.addActionListener(e -> {
            try {
                Message novaMensagem = new Message(this);
                novaMensagem.setMessage(txtUsername.getText(), JOptionPane.showInputDialog(this, "Qual mensagem quer enviar", "Respondendo mensagem", -1), 0);
                message.aux.getMessageBox().add(novaMensagem);
                JOptionPane.showMessageDialog(frame, "Messagem enviada com sucesso!");
            }catch(NullPointerException ex){
                JOptionPane.showMessageDialog(null, "Err em Adicionar ao configuar a mensagem.", "Aviso", 0);
            }finally{
                window.dispose();
            }
        });

    }

    Boolean pause;
    JDialog window;
    public void showFeed() throws Exception{
            window = new JDialog();
            window.setSize(400,450);
            window.getContentPane().setBackground(new Color(51,60,76));
            window.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            window.setLocationRelativeTo(null);
            window.setLayout(new BorderLayout());
            window.getContentPane().setBackground(new Color(51,60,76));
            JPanel pan_completo = new JPanel();
            pan_completo.setLayout(new GridLayout(0,1));

            for(int i = 0; i <bancoDados.getProducts().size();i++){
                Product product = bancoDados.getProducts().get(i);
                
                JPanel sub_panel = new JPanel();
                sub_panel.setLayout(new BorderLayout());
                JPanel panel = new JPanel();
                JTextArea dados = new JTextArea(product.toString());
                JTextArea productState = new JTextArea(product.state.getClass().getSimpleName());

                productState.setBackground(Color.lightGray);
                productState.setOpaque(true);
                productState.setForeground(new Color(51,60,76));
                productState.setEditable(false);

                dados.setBackground(Color.lightGray);
                dados.setOpaque(true);
                dados.setForeground(new Color(51,60,76));
                dados.setEditable(false);

                panel.add(dados);
                JPanel menu = new  JPanel(new GridLayout(1,3));

                JButton cancelar = new JButton("Cancelar");
                JButton add = new JButton("Carinho");
                

                cancelar.setCursor(new Cursor(12));
                add.setCursor(new Cursor(12));
            

                cancelar.setBackground(new Color(200,80,100));
                add.setBackground(new Color(225,127,17));
        

                menu.add(cancelar);
                menu.add(add);
            
                sub_panel.add(productState, BorderLayout.NORTH);
                sub_panel.add(panel, BorderLayout.CENTER);
                sub_panel.add(menu, BorderLayout.SOUTH);
                pan_completo.add(sub_panel);
            
                cancelar.addActionListener(e ->{
                    window.dispose();
                });

                add.addActionListener(e ->{
                    this.getMycart().add(product);
                    JOptionPane.showMessageDialog(this, "Produto adicionado ao seu carrinho.");
                    window.dispose();
                }); 
        }
        JScrollPane scroll = new JScrollPane(pan_completo);
        window.add(scroll, BorderLayout.CENTER);
        window.setModal(true);
        window.repaint();
        window.setVisible(true);
    }

    private void showCart() throws Exception{
        for(int i = 0; i< this.getMycart().size(); i++){
            this.aux = true;

            while(this.aux){
                Product produto = this.getMycart().get(i);
                this.pause = false;

                JDialog window = new JDialog(this, produto.getName());
                window.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                window.setModal(true);
                window.setLayout(new BorderLayout());
                window.getContentPane().setBackground(new Color(51,60,76));
                window.setBackground(new Color(51,60,76));

                JPanel panel = new JPanel();
                JPanel menu = new  JPanel(new GridLayout(1,3));

                JButton cancelar = new JButton("Cancelar");
                JButton comprar = new JButton("Comprar");
                JButton proximo = new JButton("Próximo");

                cancelar.setCursor(new Cursor(12));
                comprar.setCursor(new Cursor(12));
                proximo.setCursor(new Cursor(12));

                cancelar.setBackground(new Color(200,80,100));
                comprar.setBackground(new Color(225,127,17));
                proximo.setBackground(new Color(225,127,17));

                menu.add(cancelar);
                menu.add(comprar);
                menu.add(proximo);

                JTextArea dados = new JTextArea(produto.toString());
                dados.setEditable(false);
                dados.setAutoscrolls(true);
                dados.setBackground(Color.lightGray);
                panel.setBackground(Color.lightGray);
                panel.add(dados);

                window.add(panel, BorderLayout.CENTER);
                window.add(menu, BorderLayout.SOUTH);

                cancelar.addActionListener(e -> {
                    this.pause = true;
                    this.aux = false;
                    window.dispose();
                });

                proximo.addActionListener(e -> {
                    this.aux = false;
                    window.dispose();
                });

                comprar.addActionListener(e -> {
                    this.pause = false;

                    String[] l = {"Boleto", "Pix"};

                    JDialog pagamento = new JDialog();
                    pagamento.setLayout(new BorderLayout());

                    JPanel p  = new JPanel();
                    JPanel p2 = new JPanel();

                    p.setLayout(new BorderLayout());
                    p2.setLayout(new GridLayout(1,2));

                    pagamento.setTitle("Pagamento");

                    JLabel   forma      = new JLabel("Selecione a forma de pagamento: ");
                    JComboBox cp        = new JComboBox(l);
                    JButton   confirmar = new JButton("Confirmar");
                    
                    confirmar.addActionListener(a -> {
                    pagamento.dispose();
                    
                    if(cp.getSelectedItem() == "Boleto"){
                        Buy b = new BuyBoleto(this,produto.owner , produto);
                        produto.compra();
                    }else{
                        Buy b = new BuyPix(this,produto.owner , produto);
                        produto.compra();
                    }

                    //this.getMycart().remove(produto);
                    this.aux = false;
                    });

                    p2.add(forma);
                    p2.add(cp);
                    p.add(p2,BorderLayout.CENTER);
                    p.add(confirmar,BorderLayout.SOUTH);
                    pagamento.add(p,BorderLayout.CENTER);
                    pagamento.pack();
                    pagamento.setModal(true);
                    pagamento.setVisible(true);
                    window.repaint();
                    window.dispose();
                });
                if(produto.state.checkUnavailableState()) comprar.setEnabled(false);
                window.pack();
                window.setVisible(true);
            }
            if(this.pause) break;
        }
    }

    boolean aux;
    private void showMyProduct() throws Exception{
        for(int i=0; i<this.getMyProduct().size(); i++){
            Product product = this.getMyProduct().get(i);
            this.aux = true;

            while(this.aux){
                this.pause = false;

                JDialog window = new JDialog(this, product.getName());
                window.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                window.setModal(true);
                window.setLayout(new BorderLayout());
                window.getContentPane().setBackground(new Color(51,60,76));
                window.setTitle(product.getName());
                window.setResizable(false);

                JPanel panel = new JPanel();
                JPanel menu  = new  JPanel(new GridLayout(1,4));

                JButton cancelar = new JButton("Cancelar");
                JButton excluir  = new JButton("Excluir");
                JButton proximo  = new JButton("Próximo");
                JButton edit     = new JButton("Editar");

                cancelar.setCursor(new Cursor(12));
                excluir.setCursor(new Cursor(12));
                proximo.setCursor(new Cursor(12));
                edit.setCursor(new Cursor(12));

                cancelar.setBackground(new Color(200,80,100));
                excluir.setBackground(new Color(225,127,17));
                proximo.setBackground(new Color(225,127,17));
                edit.setBackground(new Color(225,127,17));

                menu.add(cancelar);
                menu.add(excluir);
                menu.add(edit);
                menu.add(proximo);

                JTextArea dados = new JTextArea(product.toString());
                dados.setEditable(false);
                dados.setBackground(Color.lightGray);
                panel.setBackground(Color.lightGray);
                panel.add(dados);

                JTextArea producState = new JTextArea();
                producState.setBackground(Color.lightGray);

                window.add(producState, BorderLayout.NORTH);
                window.add(panel, BorderLayout.CENTER);
                window.add(menu, BorderLayout.SOUTH);


                cancelar.addActionListener(e ->{
                    this.pause = true;
                    this.aux = false;
                    window.dispose();
                });

                excluir.addActionListener(e ->{
                    bancoDados.getProducts().remove(product);
                    this.getMyProduct().remove(product);
                    JOptionPane.showMessageDialog(this, "Produto removido!");
                    window.dispose();
                    this.aux = false;
                });

                edit.addActionListener(e ->{
                    product.editProduct();  
                    this.aux = false;
                });

                proximo.addActionListener(e ->{
                    this.aux = false;
                    window.dispose();
                });

                window.pack();
                window.setVisible(true);
            }
            if(this.pause) break;
        }
        this.pack();
    }
   
} 