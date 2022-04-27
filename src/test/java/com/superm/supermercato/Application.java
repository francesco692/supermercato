package com.superm.supermercato;

import org.junit.jupiter.api.Test;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
		prodotti.add( new Prodotto("argo", "biscotto", 3.13));
		prodotti.add( new Prodotto("varso", "formaggio", 5.00));
		prodotti.add( new Prodotto("nascondini", "biscotto", 1.15));
		prodotti.add( new Prodotto("manzo", "carne", 15.50));
		prodotti.add( new Prodotto("barilla", "pasta", 4.50));

		int scelta = 0;
		while (scelta != 999)
		{
			System.out.println(" ");
			System.out.println("1 -> visualizza tutti i prodotti");
			System.out.println("2 -> visualizza il valore totale della merce");
			System.out.println("3 -> ricerca prodotti per tipologia");
			System.out.println("4 -> ricerca prodotti per prezzo");
			System.out.println(" ");
			Scanner scanner = new Scanner(System.in);
			System.out.print("inserisci scelta -> ");
			scelta = scanner.nextInt();
			switch (scelta)
			{
				case 1:
					stampaProdotti();
				break;
				case 2:
					stampaValore();
				break;
				case 3:
					System.out.println("inserisci la tipologia del prodotto da ricercare -> ");
					scanner = new Scanner(System.in);
					String tipologia = scanner.nextLine();
					getProdotto(tipologia);
				break;
				case 4:
					System.out.println("inserisci il prezzo del prodotto da ricercare -> ");
					scanner = new Scanner(System.in);
					double prezzo = scanner.nextDouble();
					getPPrezzo(prezzo);
				break;
			}
		}
	}
	void stampaProdotti()
	{
		for(Prodotto item: prodotti)
		{
			System.out.println(item.getNome() + " prezzo: " + item.getPrezzo());
		}
	}
	void stampaValore()
	{
		double valore = 0;
		for(Prodotto item: prodotti)
		{
			valore = item.getPrezzo() + valore;
		}
		System.out.println(valore);
	}
	void getProdotto(String tipologia)
	{
		Stream<Prodotto> prodottoStream = prodotti.stream();
		ArrayList<Prodotto> prodottos = (ArrayList<Prodotto>) prodottoStream.filter(element -> element.getTipologia().equals(tipologia)).collect(Collectors.toList());
		prodottos.forEach(element -> System.out.println(element.getNome() + " " + element.getPrezzo()));
	}
	void getPPrezzo(double prezzo)
	{
		Stream<Prodotto> prodotto1Stream = prodotti.stream();
		ArrayList<Prodotto> prodottos1 = (ArrayList<Prodotto>) prodotto1Stream.filter(element -> element.getPrezzo() == prezzo).collect(Collectors.toList());
		prodottos1.forEach(element -> System.out.println(element.getNome() + " " + element.getTipologia()));
	}
}
