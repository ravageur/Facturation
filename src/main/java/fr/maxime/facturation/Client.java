package fr.maxime.facturation;

public class Client 
{
    private String mail;
    private TypeClient typeClient;
    private String siret;
    
    /**
     * Ce constructeur permet d'initialiser un client de type particulier
     * @param mail
     * @param typeClient
     */
    public Client(String mail, TypeClient typeClient)
    {
        this.mail = mail;
        this.typeClient = typeClient;
    }

    /**
     * Ce constructeur permet d'initialiser un client de type entreprise.
     * @param mail
     * @param typeClient
     * @param siret
     */
    public Client(String mail, TypeClient typeClient, String siret)
    {
        this.mail = mail;
        this.typeClient = typeClient;
        if(typeClient.equals(TypeClient.ENTREPRISE))
        {
            this.siret = siret;
        }
    }

    public TypeClient getTypeClient()
    {
        return typeClient;
    }

    public String getSiret()
    {
        return siret;
    }
}
