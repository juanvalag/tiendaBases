/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestores;

import java.io.IOException;
import static java.lang.System.out;
import java.util.ArrayList;
import model.Cliente;
public class Singleton {
  
private static Singleton instancia=null;



public static Singleton laconstructora()
{
  if(instancia==null)
 instancia=new Singleton();

  return instancia;

}


public void agregarCliente(Cliente Paco)

{          
    ArrayList<Cliente> Clientes= new ArrayList<Cliente>();
    
    
	Clientes.add(Paco);
       System.out.println("llegue aca bien");
            
        
        
}





}
