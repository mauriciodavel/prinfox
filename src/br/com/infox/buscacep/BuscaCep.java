
package br.com.infox.buscacep;
import br.com.infox.buscacep.*;
import javax.swing.JOptionPane;

public class BuscaCep 
{

    public static void main(String[] args)
    {
        try {
            WebServiceCep webServiceCep = WebServiceCep.searchCep("29102037");
        
                if (webServiceCep.wasSuccessful())
                        {
                            System.out.println("Rua: "+ webServiceCep.getLogradouro());
                            System.out.println("Bairro: "+ webServiceCep.getBairro());
                            System.out.println("Cidade: "+ webServiceCep.getCidade());
                            System.out.println("UF: "+ webServiceCep.getUf());
                        } 
        
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            System.out.println(e);
        }
        
    }
}
