/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestores;

import java.io.IOException;
import static java.lang.System.out;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Cliente;
public class Singleton {
  
private static Singleton instancia=null;

 private ArrayList<Cliente> clientes= new ArrayList<Cliente>();

public static Singleton laconstructora()
{
  if(instancia==null)
 instancia=new Singleton();

  return instancia;

}


public void agregarCliente(Cliente Paco)

{          
   
    for(int i =0;i<clientes.size();i++)
    {
        if(clientes.get(i).getId().equals(Paco.getId()))
        {
            
            JOptionPane.showMessageDialog(null,"ya existe");
        }
        else
        {
            clientes.add(Paco);
     
        }
    }
    
	
            
        
        
}





}
