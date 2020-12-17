package fr.maxime.facturation;

public class CategorieProduit 
{
    private int tva;

    public CategorieProduit(int tva)
    {
        this.tva = tva;
    }

    public int getTVA()
    {
        return tva;
    }
}
