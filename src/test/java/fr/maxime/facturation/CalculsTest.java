package fr.maxime.facturation;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CalculsTest 
{
    @Test
    public void calculerPrixTotalHTAvecUnProduit()
    {
        Produit produit = new Produit("Paquet de cookies", 5, "PDC15", new CategorieProduit(20));
        Facture facture = new Facture("f48f4f6ze", "03-12-2020", new Client("giera.maxime@orange.fr", TypeClient.PARTICULIER));
        facture.ajouterProduit(produit, 100);

        int prixTotal = facture.calculerPrixTotalHT();

        assertEquals("Le prix total doit être de 500 centimes", 500, prixTotal);
    }

    @Test
    public void calculerPrixTotalHTAvecZeroProduits()
    {
        Produit produit = new Produit("Paquet de cookies", 5, "PDC15", new CategorieProduit(20));
        Facture facture = new Facture("f48f4f6ze", "03-12-2020", new Client("giera.maxime@orange.fr", TypeClient.PARTICULIER));
        facture.ajouterProduit(produit, 0);

        int prixTotal = facture.calculerPrixTotalHT();

        assertEquals("Le prix total doit être de 0 centimes", 0, prixTotal);
    }

    @Test
    public void calculerPrixTotalHTAvecZeroEuros()
    {
        Produit produit = new Produit("Paquet de cookies", 0, "PDC15", new CategorieProduit(20));
        Facture facture = new Facture("f48f4f6ze", "03-12-2020", new Client("giera.maxime@orange.fr", TypeClient.PARTICULIER));
        facture.ajouterProduit(produit, 100);

        int prixTotal = facture.calculerPrixTotalHT();

        assertEquals("Le prix total doit être de 0 centimes", 0, prixTotal);
    }

    @Test
    public void calculerPrixTotalHTAvecPlusieursProduits()
    {
        Produit produit = new Produit("Paquet de cookies", 5, "PDC15", new CategorieProduit(20));
        Facture facture = new Facture("f48f4f6ze", "03-12-2020", new Client("giera.maxime@orange.fr", TypeClient.PARTICULIER));
        facture.ajouterProduit(produit, 100);
        produit = new Produit("Telephone", 400, "T1", new CategorieProduit(20));
        facture.ajouterProduit(produit, 1);
        produit = new Produit("Paquet de cookies", 5, "PDC15", new CategorieProduit(20));

        int prixTotal = facture.calculerPrixTotalHT();

        assertEquals("Le prix total doit être de 900 centimes", 900, prixTotal);
    }

    @Test
    public void calculerPrixTotalTTCAvecUnProduit()
    {
        Produit produit = new Produit("Paquet de cookies", 5, "PDC15", new CategorieProduit(20));
        Facture facture = new Facture("f48f4f6ze", "03-12-2020", new Client("giera.maxime@orange.fr", TypeClient.PARTICULIER));
        facture.ajouterProduit(produit, 1);

        int prixTotal = facture.calculerPrixTotalTTC();

        assertEquals("Le prix total doit être de 6 centimes", 6, prixTotal);
    }

    @Test
    public void calculerPrixTotalTTCAvecPlusieursProduitsAvecUneSeuleTVA()
    {
        Facture facture = new Facture("f48f4f6ze", "03-12-2020", new Client("giera.maxime@orange.fr", TypeClient.PARTICULIER));
        facture.ajouterProduit(new Produit("Paquet de cookies", 5, "PDC15", new CategorieProduit(20)), 1);
        facture.ajouterProduit(new Produit("Telephone", 400, "T1", new CategorieProduit(20)), 1);
        facture.ajouterProduit(new Produit("Ours en peluche", 10, "T1", new CategorieProduit(20)), 88);

        int prixTotal = facture.calculerPrixTotalTTC();

        assertEquals("Le prix total doit être de 1542 centimes", 1542, prixTotal);
    }

    @Test
    public void calculerPrixTotalTTCAvecPlusieursProduitsAvecDifferentesTaxes()
    {
        Facture facture = new Facture("f48f4f6ze", "03-12-2020", new Client("giera.maxime@orange.fr", TypeClient.PARTICULIER));
        facture.ajouterProduit(new Produit("Paquet de cookies", 5, "PDC15", new CategorieProduit(15)), 1);
        facture.ajouterProduit(new Produit("Telephone", 400, "T1", new CategorieProduit(25)), 2);
        facture.ajouterProduit(new Produit("Ours en peluche", 10, "T1", new CategorieProduit(10)), 54);

        int prixTotal = facture.calculerPrixTotalTTC();

        assertEquals("Le prix total doit être de 1600 centimes", 1600, prixTotal);
    }
}
