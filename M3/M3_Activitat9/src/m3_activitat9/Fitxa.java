/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m3_activitat9;

public class Fitxa {

	private char tipo;
	private char color;
	private int fila;
	private int columna;

	public Fitxa(char tipo, char color, int fila, int columna) {
		this.tipo = tipo;
		this.color = color;
		this.fila = fila;
		this.columna = columna;
	}

	public char getTipo() {
		return tipo;
	}

	public char getColor() {
		return color;
	}

	public boolean MoureFitxa(int origenFila,int origenColumna, int destinoFila, int destinoColumna, char color,char tipo, Fitxa[][] tablero) {
            boolean movimentPosible = false;
            
		// peo blanc
		if(tipo == 'p') {


			if(((origenFila == destinoFila-1 && origenColumna == destinoColumna) || 
					(origenFila == 1 && origenFila == destinoFila - 2 && origenColumna == destinoColumna)) || 
					(origenColumna == destinoColumna-1 && (origenFila == destinoFila-1 || origenFila == destinoFila+1) 
					&& tablero[destinoFila][destinoColumna].getTipo() != '·' )) {				
				movimentPosible = true;				
			}


                // peo negre
		}else if(tipo == 'P') {
			if((origenFila == destinoFila + 1 && origenColumna == destinoColumna) || 
					(origenFila == 6 && origenFila == destinoFila + 2 && origenColumna == destinoColumna) || 
					(origenFila == destinoFila + 1 && (origenColumna == destinoColumna-1 || origenColumna == destinoColumna+1) 
					&& tablero[destinoFila][destinoColumna].getTipo() != '·')) {
                                movimentPosible = true;	
			}

		//cavall 	
		}else if(tipo == 'C' || tipo == 'c') {

			if((origenFila == destinoFila+2 || origenFila == destinoFila-2) && 
					(origenColumna == destinoColumna + 1 || origenColumna == destinoColumna -1)) {
				movimentPosible = true;	
			}

		//torre 
		}else if(tipo == 'T' || tipo == 't') {

			boolean movimientoTorre = true;
			if(origenFila == destinoFila) {
				if(origenColumna < destinoColumna) {
					while(origenColumna < destinoColumna) {

						origenColumna++;
						if(tablero[origenFila][origenColumna].getTipo() != '·') {
							movimientoTorre = false;
						}

						if(movimientoTorre) {
							movimentPosible = true;	
						}else {
							movimentPosible = false;	
						}


					}
				}else {
					while(origenColumna > destinoColumna) {

						origenColumna--;
						if(tablero[origenFila][origenColumna].getTipo() != '·') {
							movimientoTorre = false;
						}

						if(movimientoTorre) {
							movimentPosible = true;	
						}else {
							movimentPosible = false;	
						}


					}
				}

			}else if(origenColumna == destinoColumna) {
				if(origenFila < destinoFila) {
					while(origenFila < destinoFila) {

						origenFila++;
						if(tablero[origenFila][origenColumna].getTipo() != '·') {
							movimientoTorre = false;
						}

						if(movimientoTorre) {
							movimentPosible = true;	
						}else {
							movimentPosible = false;	
						}

					}
				}else {
					while(origenFila > destinoFila) {

						origenFila--;
						if(tablero[origenFila][origenColumna].getTipo() != '·') {
							movimientoTorre = false;
						}

						if(movimientoTorre) {
							movimentPosible = true;	
						}else {
							movimentPosible = true;	
						}

					}
				}

			}
		//alfils
		}else if(tipo == 'A' || tipo == 'a') {
			boolean movimientoAlfil = false;
			boolean fichaPosicion = false;

			if(origenFila > destinoFila && origenColumna > destinoColumna) {
				while(!movimientoAlfil) {
					origenFila--;
					origenColumna--;
					if(tablero[origenFila][origenColumna].getTipo() != '·') {
						fichaPosicion = true;
						movimentPosible = false;	
					}

					if(origenFila == destinoFila && origenColumna == destinoColumna) {
						movimientoAlfil = true;
					}
					if(!fichaPosicion && movimientoAlfil) {
						movimentPosible = true;	
					}

				}

			}else if(origenFila > destinoFila && origenColumna < destinoColumna) {
				while(!movimientoAlfil) {
					origenFila--;
					origenColumna++;
					if(tablero[origenFila][origenColumna].getTipo() != '·') {
						fichaPosicion = true;
						movimentPosible = false;	
					}

					if(origenFila == destinoFila && origenColumna == destinoColumna) {
						movimientoAlfil = true;
					}
					if(!fichaPosicion && movimientoAlfil) {
						movimentPosible = true;	
					}

				}

			}else if(origenFila < destinoFila && origenColumna > destinoColumna) {
				while(!movimientoAlfil) {
					origenFila++;
					origenColumna--;
					if(tablero[origenFila][origenColumna].getTipo() != '·') {
						fichaPosicion = true;
						movimentPosible = false;	
					}

					if(origenFila == destinoFila && origenColumna == destinoColumna) {
						movimientoAlfil = true;

					}
					if(!fichaPosicion && movimientoAlfil) {
						movimentPosible = true;	
					}

				}

			}else 	if(origenFila < destinoFila && origenColumna < destinoColumna) {
				while(!movimientoAlfil) {
					origenFila++;
					origenColumna++;
					if(tablero[origenFila][origenColumna].getTipo() != '·') {
						fichaPosicion = true;
						movimentPosible = false;	
					}
					if(origenFila == destinoFila && origenColumna == destinoColumna) {
						movimientoAlfil = true;
					}
					if(!fichaPosicion && movimientoAlfil) {
						movimentPosible = true;	
					}

				}

			}
		//Reina
		}else if(tipo == 'q' || tipo == 'Q') {

			boolean movimientoRecto = true;
			if(origenFila == destinoFila) {
				if(origenColumna < destinoColumna) {
					while(origenColumna < destinoColumna) {

						origenColumna++;
						if(tablero[origenFila][origenColumna].getTipo() != '·') {
							movimientoRecto = false;
						}

						if(movimientoRecto) {
							movimentPosible = true;	
						}else {
							movimentPosible = false;	
						}


					}
				}else{
					while(origenColumna > destinoColumna) {

						origenColumna--;
						if(tablero[origenFila][origenColumna].getTipo() != '·') {
							movimientoRecto = false;
						}

						if(movimientoRecto) {
							movimentPosible = true;	
						}else {
							movimentPosible = false;	
						}


					}
				}

			}else if(origenColumna == destinoColumna) {
				if(origenFila < destinoFila) {
					while(origenFila < destinoFila) {

						origenFila++;
						if(tablero[origenFila][origenColumna].getTipo() != '·') {
							movimientoRecto = false;
						}

						if(movimientoRecto) {
							movimentPosible = true;	
						}else {
							movimentPosible = false;	
						}

					}
				}else {
					while(origenFila > destinoFila) {

						origenFila--;
						if(tablero[origenFila][origenColumna].getTipo() != '·') {
							movimientoRecto = false;
						}

						if(movimientoRecto) {
							movimentPosible = true;	
						}else {
							movimentPosible = false;	
						}

					}
				}

				boolean movimientoAlfil = false;
				boolean fichaPosicion = false;

				if(origenFila > destinoFila && origenColumna > destinoColumna) {
					while(!movimientoAlfil) {
						origenFila--;
						origenColumna--;
						if(tablero[origenFila][origenColumna].getTipo() != '·') {
							fichaPosicion = true;
							movimentPosible = false;	
						}

						if(origenFila == destinoFila && origenColumna == destinoColumna) {
							movimientoAlfil = true;
						}
						if(!fichaPosicion && movimientoAlfil) {
							movimentPosible = true;	
						}

					}

				}else if(origenFila > destinoFila && origenColumna < destinoColumna) {
					while(!movimientoAlfil) {
						origenFila--;
						origenColumna++;
						if(tablero[origenFila][origenColumna].getTipo() != '·') {
							fichaPosicion = true;
							movimentPosible = false;	
						}

						if(origenFila == destinoFila && origenColumna == destinoColumna) {
							movimientoAlfil = true;
						}
						if(!fichaPosicion && movimientoAlfil) {
							movimentPosible = true;	
						}

					}

				}else if(origenFila < destinoFila && origenColumna > destinoColumna) {
					while(!movimientoAlfil) {
						origenFila++;
						origenColumna--;
						if(tablero[origenFila][origenColumna].getTipo() != '·') {
							fichaPosicion = true;
							movimentPosible = false;	
						}

						if(origenFila == destinoFila && origenColumna == destinoColumna) {
							movimientoAlfil = true;

						}
						if(!fichaPosicion && movimientoAlfil) {
							movimentPosible = true;	
						}

					}

				}else if(origenFila < destinoFila && origenColumna < destinoColumna) {
					while(!movimientoAlfil) {
						origenFila++;
						origenColumna++;
						if(tablero[origenFila][origenColumna].getTipo() != '·') {
							fichaPosicion = true;
							movimentPosible = false;	
						}
						if(origenFila == destinoFila && origenColumna == destinoColumna) {
							movimientoAlfil = true;
						}
						if(!fichaPosicion && movimientoAlfil) {
							movimentPosible = true;	
						}

					}

				}

			}

		//rei
		}else if(tipo == 'K' || tipo == 'k') {
			if((origenFila == destinoFila + 1 || origenFila == destinoFila - 1) || 
					(origenColumna == destinoColumna + 1 || origenColumna == destinoColumna - 1) ||
					(origenFila == destinoFila + 1 || (origenFila == destinoFila - 1) &&
					origenColumna == destinoColumna + 1 || origenColumna == destinoColumna - 1)){
				movimentPosible = true;	
			}



		}

		
        return movimentPosible;
        }
	

}

