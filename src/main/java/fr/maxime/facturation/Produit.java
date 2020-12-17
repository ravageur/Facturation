package fr.maxime.facturation;

public class Produit 
{
    private String nom;
    private int prixHT; // en centimes !
    private String code;
    private CategorieProduit categorieProduit;

    public Produit(String nom, int prixHT, String code, CategorieProduit categorieProduit)
    {
        this.nom = nom;
        this.prixHT = prixHT;
        this.code = code;
        this.categorieProduit = categorieProduit;
    }

    public String getNom()
    {
        return nom;
    }

    public int getPrixHT()
    {
        return prixHT;
    }

    public String getCode()
    {
        return code;
    }

    public int calculerPrixTTC()
    {
        return (int) Math.round(prixHT * (1 + ((double) categorieProduit.getTVA() /  (double)100)));
    }
}
