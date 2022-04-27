package com.superm.supermercato;

public class Spesa {
    private String nomeProdotto;
    private float costoProdotto;
    Spesa(String nomeProdotto, float costoProdotto)
    {
        this.nomeProdotto = nomeProdotto;
        this.costoProdotto = costoProdotto;
    }
    public String getNomeProdotto()
    {
        return nomeProdotto;
    }
    public float getCostoProdotto()
    {
        return costoProdotto;
    }

    public void setNomeProdotto(String nomeProdotto)
    {
        this.nomeProdotto = nomeProdotto;
    }
    public void setCostoProdotto(float costoProdotto)
    {
        this.costoProdotto = costoProdotto;
    }
}
