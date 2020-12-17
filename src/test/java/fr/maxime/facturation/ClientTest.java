package fr.maxime.facturation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class ClientTest
{
    /**
     * On s'assure à ce que le client soit un particulier. Si le client n'est pas un 
     * particulier alors le test échouera.
     */
    @Test
    public void leClientEstUnParticulier()
    {
        Client client = new Client("giera.maxime@orange.fr", TypeClient.PARTICULIER);
        assertEquals("Le client n'est pas un particulier !", TypeClient.PARTICULIER, client.getTypeClient());
    }

    /**
     * On s'assure à ce que le client soit une entreprise. Si le client n'est pas une
     * entreprise alors le test échouera.
     */
    @Test
    public void leClientEstUneEntreprise()
    {
        Client client = new Client("giera.maxime@gmail.com", TypeClient.ENTREPRISE, "853563741");
        assertEquals("Le client n'est pas une entreprise !", TypeClient.ENTREPRISE, client.getTypeClient());
    }

    /**
     * On test si le constructeur prend en compte le fait que si le client n'est pas une 
     * entreprise qu'il ne doit pas possdéder un siret quelconque !
     */
    @Test
    public void leClientDoitOuNeDoitPasPossederUnSiret()
    {
        Client[] clients = 
        {
            new Client("giera.maxime@orange.fr", TypeClient.PARTICULIER),
            new Client("giera.maxime@orange.fr", TypeClient.ENTREPRISE, "853563741"),
            new Client("giera.maxime@gmail.com", TypeClient.PARTICULIER, "853563741")
        };
        for(int i = 0; i < clients.length; i++)
        {
            switch(clients[i].getTypeClient())
            {
                case ENTREPRISE:
                    if(clients[i].getSiret().equals(null) || clients[i].getSiret().equals(""))
                    {
                        assertFalse("Le siret n'a pas été défini pour le client qui est de type entreprise !", true);
                    }
                break;
                case PARTICULIER:
                    if(clients[i].getSiret() != null && !clients[i].getSiret().equals(""))
                    {
                        assertFalse("Le siret n'a pas été défini pour le client qui est de type particulier !", true);
                    }
                break;
                default:
                    assertFalse("Le type de client n'est pas définit !", true);
                break;
            }
        }
    }
}
