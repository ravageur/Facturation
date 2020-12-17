package fr.maxime.facturation;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FactureTest 
{
    @Test
    public void quelEstLeTypeDeClientSurLaFacture()
    {
        Facture facture = new Facture("f48f4f6ze", "03-12-2020", new Client("giera.maxime@orange.fr", TypeClient.PARTICULIER));
        assertEquals("Le client doit être un particulier mais n'en est pas un ...",TypeClient.PARTICULIER , facture.getTypeClient());
    }

    @Test
    public void estCeQueLeProduitAEteAjouter()
    {
        Facture facture = new Facture("f48f4f6ze", "03-12-2020", new Client("giera.maxime@orange.fr", TypeClient.PARTICULIER));
        assertEquals("Le produit n'a pas été correctement ajouté !", true, facture.ajouterProduit(new Produit("Paquet de cookies", 5, "PDC15", new CategorieProduit(20)), 1));
    }

    @Test
    public void estCeQueLeProduitAEteEnlever()
    {
        Facture facture = new Facture("f48f4f6ze", "03-12-2020", new Client("giera.maxime@orange.fr", TypeClient.PARTICULIER));
        Produit produit = new Produit("Paquet de cookies", 5, "PDC15", new CategorieProduit(20));
        facture.ajouterProduit(produit, 1);
        assertEquals("Le produit n'a pas été correctement ajouté !", true, facture.retirerProduit(produit, 1));
    }

    @Test
    public void estCeQueLeProduitASaQuantiteeCorrectementDiminuer()
    {
        Facture facture = new Facture("f48f4f6ze", "03-12-2020", new Client("giera.maxime@orange.fr", TypeClient.PARTICULIER));
        Produit produit = new Produit("Paquet de cookies", 5, "PDC15", new CategorieProduit(20));
        facture.ajouterProduit(produit, 80);
        assertEquals("Le produit n'a pas été correctement ajouté !", false, facture.retirerProduit(produit, 75));
    }
}
