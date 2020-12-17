package fr.maxime.facturation;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ProduitTest 
{
    @Test
    public void leProduitNeDoitPasAvoirLeNomChanger()
    {
        Produit produit = new Produit("Paquet de cookies", 500, "2AD9G", new CategorieProduit(25));
        assertEquals("Paquet de cookies", produit.getNom());
    }

    @Test
    public void leProduitNeDoitPasAvoirLePrixChanger()
    {
        Produit produit = new Produit("Paquet de cookies", 500, "2AD9G", new CategorieProduit(25));
        assertEquals(500, produit.getPrixHT());
    }

    @Test
    public void leProduitNeDoitPasAvoirLeCodeChanger()
    {
        Produit produit = new Produit("Paquet de cookies", 500, "2AD9G", new CategorieProduit(25));
        assertEquals("2AD9G", produit.getCode());
    }


}
