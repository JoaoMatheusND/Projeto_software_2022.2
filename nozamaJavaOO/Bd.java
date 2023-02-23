import java.util.ArrayList;

class Bd{

    /* Padrão Singlton pra criação de um banco de dados em tempo de execução */

    private static Bd instance; // Instância do nosso banco de dados.

    private void Bd(){}; // Construtor privado para evitar que mais de uma instancia seja criada.

    public static synchronized Bd getInstance(){ // Método estático pra conseguir seracessado pelas classes e iniciar a única instância.
        if(instance == null) instance = new Bd();
        return instance;
    }

    /*********************************************************************************/

    /* Atribudos do nosso banco de dados que poderam ser ultizados nas classes */

    private ArrayList<Product> products     = new ArrayList<Product>();  // Todos os produtos do nozamA.
    private ArrayList<Profile> users        = new ArrayList<Profile>();     // Todos os usuários do nozamA.
    private ArrayList<UserAdmin> userAdmins = new ArrayList<UserAdmin>();// Todos os funcionarios do nozamA.

    public ArrayList<Product>   getProducts()  {return this.products;}
    public ArraList<Profile>    getUsers()     {return this.users;}
    public ArrayList<UserAdmin> getUserAdmin() {return this.userAdmins;}

}