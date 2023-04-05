package nozama;

import java.util.Iterator;
import java.util.Scanner;
import nozama.products.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class UserAdmin extends User{
    
    Bd bancoDados = Bd.getInstance();

    Scanner input = new Scanner(System.in);

    Iterator<Product> itrProducts;
    Iterator<Profile> itrProfiles;
    Iterator<Message> itrMessages;

    JDialog frame = this;


    //Método construtor para inicia
    public UserAdmin(String user, String cpf, String email, String password){
        this.user = user;
        this.cpf = cpf;
        this.email = email;
        this.password = email;

        this.txtUsername.setText(this.user);
        this.txtCpf.setText(this.cpf);
        this.txtEmail.setText(this.email);
        this.setPassword(this.password);
    }

    public UserAdmin(){
        super();
    }

    private void clearJDialog(){
        this.getContentPane().removeAll();
        this.revalidate();
        this.repaint();

    }
    
    //Método para administrar como um usuário administrador
    public void menuUserAdmin(){

        // Atributos locais
        clearJDialog();
        this.setTitle("Admin");
        this.setLayout(new GridLayout(6,1));
        this.setResizable(false);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setModal(false);
        this.setBackground(new Color(0,0,0));

        bancoDados.mainWindow.setVisible(false);
            
        JButton users   = new JButton("  Usuários  ");
        JButton product = new JButton("  produtos  ");
        JButton edit    = new JButton("      Perfil      ");
        JButton nAdmin  = new JButton("Novo Admin");
        JButton bonus   = new JButton("     Bônus    ");
        JButton exit    = new JButton("       Sair       ");

        users.setCursor(new Cursor(12));
        product.setCursor(new Cursor(12));
        edit.setCursor(new Cursor(12));
        nAdmin.setCursor(new Cursor(12));
        bonus.setCursor(new Cursor(12));
        exit.setCursor(new Cursor(12));

        users.setBackground(new Color(225,127,17));
        product.setBackground(new Color(225,127,17));
        edit.setBackground(new Color(225,127,17));
        nAdmin.setBackground(new Color(225,127,17));
        bonus.setBackground(new Color(225,127,17));
        exit.setBackground(new Color(200,80,100));

        JPanel usersPanel   = new JPanel();
        JPanel productPanel = new JPanel();
        JPanel editPanel    = new JPanel();
        JPanel nAdminPanel  = new JPanel();
        JPanel bonusPanel   = new JPanel();
        JPanel exitPanel    = new JPanel();

        usersPanel.setBackground(new Color(51,60,76));
        productPanel.setBackground(new Color(51,60,76));
        editPanel.setBackground(new Color(51,60,76));
        nAdminPanel.setBackground(new Color(51,60,76));
        bonusPanel.setBackground(new Color(51,60,76));
        exitPanel.setBackground(new Color(51,60,76));

        usersPanel.add(users);
        productPanel.add(product);
        editPanel.add(edit);
        nAdminPanel.add(nAdmin);
        bonusPanel.add(bonus);
        exitPanel.add(exit);

        this.add(usersPanel);
        this.add(productPanel);
        this.add(editPanel);
        this.add(nAdminPanel);
        this.add(bonusPanel);
        this.add(exitPanel);

        this.pack();
        this.repaint();

        users.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(bancoDados.getUsers().isEmpty()){
                    JOptionPane.showMessageDialog(frame, "Users at default setting.", "Aviso", -1);
                }else{
                    setVisible(false);
                    showUsers();
                    setVisible(true);
                }
            }
        });

        product.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(bancoDados.getProducts().isEmpty()){
                    JOptionPane.showMessageDialog(frame, "Não há produto postado.", "Aviso", -1);
                }else {
                    showProduct();
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

        nAdmin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Login l = new Login();
                JOptionPane.showMessageDialog(frame, l.setRegister(false), "Aviso", -1);
                setVisible(true);
            }
        });

        bonus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(frame, "Work In Progress", "Loading...", -1);
                //teste
            }
        });

        exit.addActionListener(e -> {
            bancoDados.mainWindow.setVisible(true);
            dispose();
        });

        this.setVisible(true);

    }

    Boolean pause;
    //Override para substituir o método toString() da class object para um padrão mais coerente a essa classe
    @Override
    public String toString() {
        return "\nUser: "+getUser()+"\nCPF: "+getCpf()+"\nE-mail: "+getEmail()+"\n";
    }

    private void showUsers(){
        for(int i = 0; i<bancoDados.getUsers().size(); i++){
            Profile profile = bancoDados.getUsers().get(i);
            this.aux = true;

            while(this.aux){
                this.pause = false;

                JDialog window = new JDialog(this);
                window.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                window.setModal(true);
                window.setLayout(new BorderLayout());
                window.getContentPane().setBackground(new Color(51,60,76));
                window.setTitle("Usuários");
                window.setResizable(false);

                JPanel panel = new JPanel();
                JPanel menu = new  JPanel(new GridLayout(1,4));

                JButton cancelar = new JButton("Cancelar");
                JButton mensagem = new JButton("Mensagem");
                JButton next     = new JButton("Próximo");
                JButton excluir  = new JButton("Excluir");

                cancelar.setCursor(new Cursor(12));
                mensagem.setCursor(new Cursor(12));
                next.setCursor(new Cursor(12));
                excluir.setCursor(new Cursor(12));

                cancelar.setBackground(new Color(200,80,100));
                mensagem.setBackground(new Color(225,127,17));
                next.setBackground(new Color(225,127,17));
                excluir.setBackground(new Color(250,50,50));

                menu.add(cancelar);
                menu.add(mensagem);
                menu.add(next);
                menu.add(excluir);

                JTextArea dados = new JTextArea(profile.toString());
                dados.setEditable(false);
                dados.setBackground(Color.lightGray);
                panel.setBackground(Color.lightGray);
                panel.add(dados);

                window.add(panel, BorderLayout.CENTER);
                window.add(menu, BorderLayout.SOUTH);


                cancelar.addActionListener(e ->{
                    this.pause = true;
                    this.aux = false;
                    window.dispose();
                });

                mensagem.addActionListener(e -> {
                    setVisible(false);
                    sendMessage(profile);
                    setVisible(true);
                });

                next.addActionListener(e ->{
                    this.aux = false;
                    window.dispose();
                });

                excluir.addActionListener(e ->{
                    itrProducts.remove();
                    JOptionPane.showMessageDialog(this, "Produto removido!");
                    window.dispose();
                    this.aux = false;
                });
                
                window.pack();
                window.setVisible(true);
            }
            if(this.pause) break;
        }
    }

    private void sendMessage(Profile perfil){
        String mensagem = JOptionPane.showInputDialog(this, "Qual sua mensagem?", "Admin mensagem", -1);
        if(mensagem != null && !mensagem.isEmpty()){
            Message msm = new Message();
            msm.setMessageAdmin(getName(), mensagem);
            perfil.getMessageBox().add(msm);
            JOptionPane.showMessageDialog(this, "Mensagem enviada com sucesso!", "Aviso!", -1);
        } else {
            JOptionPane.showMessageDialog(this, "Nenhuma mensagem foi inserida.", "Aviso!", -1);
        }
    }

    boolean aux;
    public void showProduct(){
        for(int i = 0; i<bancoDados.getProducts().size(); i++){
            this.aux = true;
            
            while(this.aux){
                Product product = bancoDados.getProducts().get(i);
                this.pause = false;

                JDialog window = new JDialog(this);
                window.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                window.setModal(true);
                window.setLayout(new BorderLayout());
                window.getContentPane().setBackground(new Color(51,60,76));
                window.setTitle("Produtos");
                window.setResizable(false);

                JPanel panel = new JPanel();
                JPanel menu = new JPanel(new GridLayout(1,3));

                JTextArea dados = new JTextArea(product.toString());
                dados.setEditable(false);
                dados.setOpaque(true);
                dados.setBackground(Color.lightGray);

                panel.add(dados);
                panel.setBackground(Color.lightGray);

                JButton cancelar = new JButton("Cancelar");
                JButton mensagem = new JButton("Mensagem");
                JButton next     = new JButton("Próximo");

                cancelar.setCursor(new Cursor(12));
                mensagem.setCursor(new Cursor(12));
                next.setCursor(new Cursor(12));

                cancelar.setBackground(new Color(200,80,100));
                mensagem.setBackground(new Color(225,127,17));
                next.setBackground(new Color(225,127,17));

                menu.add(cancelar);
                menu.add(mensagem);
                menu.add(next);

                window.add(panel, BorderLayout.CENTER);
                window.add(menu, BorderLayout.SOUTH);

                cancelar.addActionListener(e -> {
                    this.pause = true;
                    this.aux = false;
                    window.dispose();
                });

                mensagem.addActionListener(e -> {
                   sendMessage(product.owner);
                    this.aux = false;
                    window.dispose();
                });

                next.addActionListener(e -> {
                    this.aux = false;
                    window.dispose();
                });

                window.pack();
                window.setVisible(true);
            }
            if(this.pause) break;
        }
    }
}