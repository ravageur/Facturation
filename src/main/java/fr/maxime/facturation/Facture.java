package fr.maxime.facturation;

import java.util.HashMap;
import java.util.Map;

public class Facture 
{
    private String id;
    private String date;
    private Client client;
    private HashMap<Produit,Integer> listeProduits = new HashMap<>();

    public Facture(String id, String date, Client client)
    {
        this.id = id;
        this.date = date;
        this.client = client;
    }
    
    public int calculerPrixTotalTTC()
    {
        int prixTotal = 0;
        for(Map.Entry<Produit,Integer> produit : listeProduits.entrySet())
        {
            prixTotal += produit.getKey().calculerPrixTTC() * produit.getValue();
        }
        return prixTotal;
    }

    public int calculerPrixTotalHT()
    {
        int prixTotalHT = 0;
        for(Map.Entry<Produit,Integer> produit : listeProduits.entrySet())
        {
            prixTotalHT += produit.getKey().getPrixHT() * produit.getValue();
        }
        return prixTotalHT;
    }

    public boolean ajouterProduit(Produit produit, int quantiteDuProduit)
    {
        listeProduits.put(produit, quantiteDuProduit);
        for(Map.Entry<Produit,Integer> leProduit : listeProduits.entrySet())
        {
            if(leProduit.getKey().equals(produit))
            {
                return true;
            }
        }
        return false;
    }

    public boolean retirerProduit(Produit produit, int quantiteAEnlever)
    {
        
        for(Map.Entry<Produit,Integer> leProduit : listeProduits.entrySet())
        {
            if(leProduit.getKey().equals(produit))
            {
                if(leProduit.getValue() <= quantiteAEnlever)
                {
                    listeProduits.remove(produit);
                }
            }
        }
        for(Map.Entry<Produit,Integer> leProduit : listeProduits.entrySet())
        {
            if(leProduit.getKey().equals(produit))
            {
                return false;
            }
        }
        return true;
    }

    public TypeClient getTypeClient()
    {
        return client.getTypeClient();
    }
}
