package com.superm.supermercato;

public class Prodotto {
    private String nome;
    private String tipologia;
    private float prezzo;
    Prodotto(String nome, String tipologia, float prezzo)
    {
       this.nome = nome;
       this.tipologia = tipologia;
       this.prezzo = prezzo;
    }
    public String getNome()
    {
        return nome;
    }
    public String getTipologia()
    {
        return tipologia;
    }
    public float getPrezzo()
    {
        return prezzo;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }
    public void setTipologia(String tipologia)
    {
        this.tipologia = tipologia;
    }
    public void setPrezzo(float prezzo)
    {
        this.prezzo = prezzo;
    }
}
