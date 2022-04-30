package com.superm.supermercato;

public class Spesa {
    private String nomeProdotto;
    private double costoProdotto;
    Spesa(String nomeProdotto, double costoProdotto)
    {
        this.nomeProdotto = nomeProdotto;
        this.costoProdotto = costoProdotto;
    }
    public String getNomeProdotto()
    {
        return nomeProdotto;
    }
    public double getCostoProdotto()
    {
        return costoProdotto;
    }

    public void setNomeProdotto(String nomeProdotto)
    {
        this.nomeProdotto = nomeProdotto;
    }
    public void setCostoProdotto(double costoProdotto)
    {
        this.costoProdotto = costoProdotto;
    }
}
