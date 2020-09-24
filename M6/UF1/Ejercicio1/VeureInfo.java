
package veureinfo;

import java.io.File;

public class VeureInfo {

    public static void main(String[] args) {
        // TODO code application logic here    
       File f = new File(args[0]);
       String[] archivo = f.list();
       
            
        if (f.exists()) {
            System.out.println("¡¡Existeix l'archiu o directori cercat!!");
            if (f.isFile()){
              System.out.println("Es un fitxer");
              System.out.println("Nom del fitxer : "+f.getName());
              System.out.println("Ruta           : "+f.getPath());
              System.out.println("Ruta absoluta  : "+f.getAbsolutePath());
	      System.out.println("Es pot escriure: "+f.canRead());
              System.out.println("Es pot llegir  : "+f.canWrite());
	      System.out.println("Grandaria      : "+f.length());
              System.out.println("Es un directori: "+f.isDirectory());
              System.out.println("Es un fitxer   : "+f.isFile());

          }
          if (f.isDirectory())  {
              System.out.println("Es un directori");
              for (int i = 0; i<archivo.length; i++){
			 System.out.println(archivo[i]);
              }
          }
        }
        else {
            System.out.println("¡¡No existeix l'archiu o directori cercat!!");
        }


        if(f.isHidden()){
            System.out.println("L'arxiu esta ocult");
        }else {
            System.out.println("L'arxiu no esta ocult");
        }
        
        System.out.println("L'ultima modificacio va ser : " + (18528-( ( ( ( ( (f.lastModified()) /1000) /60) /60) /24) ) ) );
        
        if ((18528-( ( ( ( ( (f.lastModified()) /1000) /60) /60) /24) ) ) < 3) {
             System.out.println("Fa menys de 3 dies que s'ha modificat l'arxiu");
        }
    }
    
}
