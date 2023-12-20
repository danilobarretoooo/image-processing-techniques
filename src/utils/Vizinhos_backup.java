package utils;

import java.util.ArrayList;
import java.util.Collections;

import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class Vizinhos_backup {
	
	public static ArrayList<Double> vizinhosR = new ArrayList<Double>();
	public static ArrayList<Double> vizinhosG = new ArrayList<Double>();
	public static ArrayList<Double> vizinhosB = new ArrayList<Double>();
	private static double medianaPixels[];
	
	//	Retorna todos os vizinhos 3x3
	public static void retornaVizinhos(Image image, double posicaoX, double posicaoY) {
		
		try {
			int width = (int)image.getWidth();
			int height = (int)image.getHeight();
			
			PixelReader pr = image.getPixelReader();
			WritableImage wi = new WritableImage(width, height);
			PixelWriter pw = wi.getPixelWriter();
			
			// largura X
			for(int contX = 0; contX < width; contX++) {
				
				// altura Y
				for(int contY = 0; contY < height; contY++) {

					// checa se está no pixel informado
					if(contX == posicaoX && contY == posicaoY) {
										
						// percorre todos os vizinhos
						for(int z = 0; z < 9; z++) {
							
							if(z == 0) {
								Color corVizinho = pr.getColor(contX-1, contY+1);
								vizinhosR.add(corVizinho.getRed());
								vizinhosG.add(corVizinho.getGreen());
								vizinhosB.add(corVizinho.getBlue());
							}
							
							if(z == 1) { 
								Color corVizinho = pr.getColor(contX, contY-1);
								vizinhosR.add(corVizinho.getRed());
								vizinhosG.add(corVizinho.getGreen());
								vizinhosB.add(corVizinho.getBlue());
							}
							if(z == 2) { 
								Color corVizinho = pr.getColor(contX+1, contY+1);
								vizinhosR.add(corVizinho.getRed());
								vizinhosG.add(corVizinho.getGreen());
								vizinhosB.add(corVizinho.getBlue());
							}
							if(z == 3) { 
								Color corVizinho = pr.getColor(contX-1, contY);
								vizinhosR.add(corVizinho.getRed());
								vizinhosG.add(corVizinho.getGreen());
								vizinhosB.add(corVizinho.getBlue());
							}
							if(z == 4) { 
								Color corVizinho = pr.getColor(contX, contY);
								vizinhosR.add(corVizinho.getRed());
								vizinhosG.add(corVizinho.getGreen());
								vizinhosB.add(corVizinho.getBlue());
							}
							if(z == 5) { 
								Color corVizinho = pr.getColor(contX+1, contY);
								vizinhosR.add(corVizinho.getRed());
								vizinhosG.add(corVizinho.getGreen());
								vizinhosB.add(corVizinho.getBlue());
							}
							if(z == 6) { 
								Color corVizinho = pr.getColor(contX-1, contY-1);
								vizinhosR.add(corVizinho.getRed());
								vizinhosG.add(corVizinho.getGreen());
								vizinhosB.add(corVizinho.getBlue());
							}
							if(z == 7) { 
								Color corVizinho = pr.getColor(contX, contY-1);
								vizinhosR.add(corVizinho.getRed());
								vizinhosG.add(corVizinho.getGreen());
								vizinhosB.add(corVizinho.getBlue());
							}
							if(z == 8) { 
								Color corVizinho = pr.getColor(contX+1, contY-1);
								vizinhosR.add(corVizinho.getRed());
								vizinhosG.add(corVizinho.getGreen());
								vizinhosB.add(corVizinho.getBlue());
							}							
						}
						
						
						// obrigatório antes de calcular mediana
						ordenaListas();
						
						System.out.println("\n \n MEDIANA");
						listaVizinhos();
						
						System.out.println("\n \n MEDIANA");
						System.out.println("Mediana R" + mediana(vizinhosR));
						System.out.println("Mediana G" + mediana(vizinhosG));
						System.out.println("Mediana B" + mediana(vizinhosB));
						
						limpaListas();
					}
				}
			}		
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}		
	}
	
	//	Retorna os vizinhos para vizinhança em X - diagonais
	public static double[] retornaVizinhosX(Image image, double posicaoX, double posicaoY) {
		
		try {
			int width = (int)image.getWidth();
			int height = (int)image.getHeight();
			
			PixelReader pr = image.getPixelReader();
			WritableImage wi = new WritableImage(width, height);
			PixelWriter pw = wi.getPixelWriter();
			
			// largura X
			for(int contX = 0; contX < width; contX++) {
				
				// altura Y
				for(int contY = 0; contY < height; contY++) {

					// checa se está no pixel informado
					if(contX == posicaoX && contY == posicaoY) {
						
						double medianaPixels[] = null;
										
						// percorre todos os vizinhos
						for(int z = 0; z < 9; z++) {
							
							if(z == 0) {
								Color corVizinho = pr.getColor(contX-1, contY+1);
								vizinhosR.add(corVizinho.getRed());
								vizinhosG.add(corVizinho.getGreen());
								vizinhosB.add(corVizinho.getBlue());
							}		
							if(z == 2) { 
								Color corVizinho = pr.getColor(contX+1, contY+1);
								vizinhosR.add(corVizinho.getRed());
								vizinhosG.add(corVizinho.getGreen());
								vizinhosB.add(corVizinho.getBlue());
							}
							if(z == 4) { 
								Color corVizinho = pr.getColor(contX, contY);
								vizinhosR.add(corVizinho.getRed());
								vizinhosG.add(corVizinho.getGreen());
								vizinhosB.add(corVizinho.getBlue());
							}
							if(z == 6) { 
								Color corVizinho = pr.getColor(contX-1, contY-1);
								vizinhosR.add(corVizinho.getRed());
								vizinhosG.add(corVizinho.getGreen());
								vizinhosB.add(corVizinho.getBlue());
							}
							if(z == 8) { 
								Color corVizinho = pr.getColor(contX+1, contY-1);
								vizinhosR.add(corVizinho.getRed());
								vizinhosG.add(corVizinho.getGreen());
								vizinhosB.add(corVizinho.getBlue());
							}							
						}
						
						
						// obrigatório antes de calcular mediana
						ordenaListas();
										
						medianaPixels[0] = mediana(vizinhosR);
						medianaPixels[1] = mediana(vizinhosG);
						medianaPixels[2] = mediana(vizinhosB);
						
						// deixa lista vazia para receber novos cálculos
						limpaListas();
					}
				}
			}		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// retorna a mediana dos pixels na posição
		return medianaPixels;		
	}
	
	//	Retorna todos os vizinhos em cruz - T
	public static void retornaVizinhosCruz(Image image, double posicaoX, double posicaoY) {
		
		try {
			int width = (int)image.getWidth();
			int height = (int)image.getHeight();
			
			PixelReader pr = image.getPixelReader();
			WritableImage wi = new WritableImage(width, height);
			PixelWriter pw = wi.getPixelWriter();
			
			// largura X
			for(int contX = 0; contX < width; contX++) {
				
				// altura Y
				for(int contY = 0; contY < height; contY++) {

					// checa se está no pixel informado
					if(contX == posicaoX && contY == posicaoY) {
										
						// percorre todos os vizinhos
						for(int z = 0; z < 9; z++) {
												
							if(z == 1) { 
								Color corVizinho = pr.getColor(contX, contY-1);
								vizinhosR.add(corVizinho.getRed());
								vizinhosG.add(corVizinho.getGreen());
								vizinhosB.add(corVizinho.getBlue());
							}
							if(z == 3) { 
								Color corVizinho = pr.getColor(contX-1, contY);
								vizinhosR.add(corVizinho.getRed());
								vizinhosG.add(corVizinho.getGreen());
								vizinhosB.add(corVizinho.getBlue());
							}
							if(z == 4) { 
								Color corVizinho = pr.getColor(contX, contY);
								vizinhosR.add(corVizinho.getRed());
								vizinhosG.add(corVizinho.getGreen());
								vizinhosB.add(corVizinho.getBlue());
							}
							if(z == 5) { 
								Color corVizinho = pr.getColor(contX+1, contY);
								vizinhosR.add(corVizinho.getRed());
								vizinhosG.add(corVizinho.getGreen());
								vizinhosB.add(corVizinho.getBlue());
							}
							if(z == 7) { 
								Color corVizinho = pr.getColor(contX, contY-1);
								vizinhosR.add(corVizinho.getRed());
								vizinhosG.add(corVizinho.getGreen());
								vizinhosB.add(corVizinho.getBlue());
							}						
						}
						
						
						// obrigatório antes de calcular mediana
						ordenaListas();
						
						System.out.println("\n \n MEDIANA");
						listaVizinhos();
						
						System.out.println("\n \n MEDIANA");
						System.out.println("Mediana R" + mediana(vizinhosR));
						System.out.println("Mediana G" + mediana(vizinhosG));
						System.out.println("Mediana B" + mediana(vizinhosB));
						
						limpaListas();
					}
				}
			}		
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}		
	}
	
	public static void ordenaListas() {	
		Collections.sort(vizinhosR);
		Collections.sort(vizinhosG);
		Collections.sort(vizinhosB);
	}
	
	// calcula mediana de uma lista a ser informada
	public static Double mediana(ArrayList<Double> lista) {		

		int restoDivisao = lista.size() % 2;
		
		// tem número ao centro
        if(restoDivisao > 0) {
            return lista.get(Math.round(lista.size() / 2));
        } else {
        	// caso não exista número ao centro
            int menor = (lista.size() /2) -1;
            int maior = (lista.size() /2);

            return (lista.get(menor) + lista.get(maior)) /2;
        }
		
	}
		
	// debugger	
	public static void listaVizinhos() {
		for(int a = 0; a < vizinhosR.size(); a++) {
			System.out.println("R:" + vizinhosR.get(a).toString()
								+ " G:" + vizinhosG.get(a).toString()
								+ " B:" + vizinhosB.get(a).toString());
		}
	}
	
	public static void limpaListas() {
		vizinhosR.clear();
		vizinhosG.clear();
		vizinhosB.clear();
	}
}
