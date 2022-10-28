import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;

public abstract class InterfazDeUsuario {
    
    protected HashMap<String,String>  textos = new HashMap<>(); 
   
    InterfazDeUsuario(){
        obtenerTextos();
    }
    
    abstract String obtenerIdioma();
    
    protected void obtenerTextos(){
        File archivo = null;
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try{
            archivo = new File("./idiomas/" + obtenerIdioma() + ".txt");
            fileReader = new FileReader(archivo);
            bufferedReader = new BufferedReader(fileReader);
            String linea;
            while( (linea = bufferedReader.readLine() ) != null){
                String[] keyVal = linea.split("--");
                if(keyVal.length == 2){
                    textos.put(keyVal[0], keyVal[1]);
                }
            }
        } catch(Exception e){
            e.printStackTrace();
         }finally{
            try{                    
               if( null != fileReader ){   
                  fileReader.close();     
               }                  
            }catch (Exception e2){ 
               e2.printStackTrace();
            }
         }
    }

    protected void saludar(){
        System.out.println(textos.get("Saludo"));
    }

    protected void despedir(){
        System.out.println(textos.get("Despedida"));
    }

    protected void muestraOpciones(){
        System.out.println(textos.get("Opciones"));
    }

    protected void mostrarMenuPrincipal(){
        System.out.println(textos.get("MenuTexto"));
        System.out.println("1. "  + textos.get("OpcionCatalogo"));
        System.out.println("2. "  + textos.get("OpcionCompra"));
        System.out.println("3. "  + textos.get("OpcionSalir"));
    }

}
