package cotxes;

import java.io.Serializable;

public class Cotxes implements Serializable {
    
        private String marca;
        private String model;
        private String matricula;
        private int any;
        
        //constructor
        public Cotxes (String marca, String model, String matricula, int any) {
            this.marca = marca;
            this.model = model;
            this.matricula = matricula;
            this.any = any;
        }
        
        //constructor por si el coche esta vacio
        public Cotxes (){//constructor per defecte
		this.marca = null;
	}

        //per donar el valor als camps de variable private
	public void setMarca(String marca){
            this.marca = marca;
        }
	public void setModel(String model){
            this.model = model;
        }
        public void setMatricula(String matricula){
            this.matricula = matricula;
        }
        public void setAny(int any){
            this.any = any;
        }
        
	//per consultar el valor dels camps de variable private
	public String getMarca(){
            return marca;
        }
	public String getModel(){
            return model;
        }
        public String getMatricula(){
            return matricula;
        }
        public int getAny(){
            return any;
        }
}
