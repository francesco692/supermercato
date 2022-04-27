package com.superm.supermercato;

public class Prodotto {
    private String nome;
    private String tipologia;
    private String prezzo;
    Prodotto(String nome, String tipologia, String prezzo)
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
    public String getPrezzo()
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
    public void setPrezzo(String prezzo)
    {
        this.prezzo = prezzo;
    }
}
