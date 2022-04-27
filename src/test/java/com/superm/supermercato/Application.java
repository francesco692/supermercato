package com.superm.supermercato;

import org.junit.jupiter.api.Test;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Scanner;

@SpringBootApplication
public class Application implements CommandLineRunner
{
	ArrayList<Prodotto> prodotti = new ArrayList<>();
	ArrayList<Spesa> spesa = new ArrayList<>();
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

		int scelta = 0;
		while (scelta != 999)
		{
			System.out.println(" ");
			System.out.println("1 -> visualizza tutti i prodotti");
			System.out.println(" ");
			Scanner scanner = new Scanner(System.in);
			System.out.print("inserisci scelta -> ");
			scelta = scanner.nextInt();
			switch (scelta)
			{
				case 1:
					for(Prodotto item: prodotti)
					{
						System.out.println(item.getNome() + " prezzo: " + item.getPrezzo());
					}
				break;
			}
		}
	}


}
