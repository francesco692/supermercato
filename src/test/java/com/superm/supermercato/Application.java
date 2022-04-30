package com.superm.supermercato;

import org.junit.jupiter.api.Test;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class Application implements CommandLineRunner
{
	ArrayList<Prodotto> prodotti = new ArrayList<>();
	ArrayList<Spesa> spesa = new ArrayList<>();
	ArrayList<Spesa> carrello = new ArrayList<>();
	int sconto = 20;
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
			System.out.println("5 -> acquista un prodotto");
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
				case 5:
					System.out.println("vuoi acquistare un prodotto? si/no -> ");
					scanner = new Scanner(System.in);
					String risposta = scanner.nextLine();
					if (risposta.equals("si"))
					{
						System.out.println("possiedi una carta? si/no -> ");
						scanner = new Scanner(System.in);
						String carta = scanner.nextLine();
						if(carta.equals("si"))
						{
							while(!risposta.equals("no"))
							{
								System.out.println("inserisci il nome di un prodotto -> ");
								scanner = new Scanner(System.in);
								String nomeProdotto = scanner.nextLine();
								prodotti.forEach((element) ->
								{
									if (element.getNome().equals(nomeProdotto)) carrello.add(new Spesa(element.getNome(), element.getPrezzo()));
								});
								System.out.println("vuoi continuare ad acquistare? ->");
								scanner = new Scanner(System.in);
								risposta = scanner.nextLine();
							}
							pagamento(sconto);
						}
						else
						{
							while(!risposta.equals("no"))
							{
								System.out.println("inserisci il nome di un prodotto -> ");
								scanner = new Scanner(System.in);
								String nomeProdotto = scanner.nextLine();
								prodotti.forEach((element) ->
								{
									if (element.getNome().equals(nomeProdotto)) carrello.add(new Spesa(element.getNome(), element.getPrezzo()));
								});
								System.out.println("vuoi continuare ad acquistare? ->");
								scanner = new Scanner(System.in);
								risposta = scanner.nextLine();
							}
							pagamento(0);
						}
					}
					else
					{
						System.out.println("arrivederci");
					}
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
	void pagamento (int sconto)
	{
		double totale = 0;
		for (Spesa item: carrello)
		{
			totale += item.getCostoProdotto();
		}
		totale = totale - (totale * sconto ) / 100;
		DecimalFormat df = new DecimalFormat("####0.00");
		System.out.println();
		System.out.println(df.format(totale));
		carrello.clear();
	}
}
