# Projeto_software_2022.2
Repositório dedicado as aplicabilidades dadas na matéria de projeto de software no curso de engenharia de computação pela UFAL, professor: Baldoino 

###### Grupo:
  - **João Matheus Nascimento Dias** (jmnd@ic.ufal.br);
  - **Pedro de Carvalho Cedrim**     (pcc@ic.ufal.br);
  - **Thiago Lôbo Pereira Barros**    (tlpb@ic.ufal.br).

## Projeto

Nesta nova versão do projeto, foi requisitado o uso de alguns conceitos de Programação Orientada à Objeto. Estes podem ser identificados nas seguintes classes:
  
  - Herança: User.java (Superclasse), Profile.java e UserAdmin.java (Subclasses); 
  - Polimorfismo: todas as classe sao decladas em seu tipo de Produto específico, mas são guaradas e ultilizadas usando um ArrayList<Product>, atraves do toString() apresentamos dados completos da sub classes de Product, na hora de criar dados específicos são aciocionados a janela.
  - Classe Abstrata: Buy.java (Superclasse), BuyBoleto.java e BuyPix.java (Subclasses), Buy tem metodos que são abstratos e implementados nas classes BuyBoleto e BuyPix.
