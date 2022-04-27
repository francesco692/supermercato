package com.superm.supermercato;

import org.junit.jupiter.api.Test;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootApplication
public class Application implements CommandLineRunner
{
	ArrayList<Prodotto> prodotti = new ArrayList<>();
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	@Override
	public void run(String... args) throws Exception
	{
		prodotti.add( new Prodotto("argo", "biscotto", (float) 3.13));
		prodotti.add( new Prodotto("varso", "formaggio", (float) 5.00));
		prodotti.add( new Prodotto("nascondini", "biscotto", (float) 1.15));
		prodotti.add( new Prodotto("manzo", "carne", (float) 15.50));
		prodotti.add( new Prodotto("barilla", "pasta", (float) 4.50));
	}


}
