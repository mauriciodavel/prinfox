
package br.com.infox.buscacep;

public class BuscaCep 
{

    public static void main(String[] args)
    {
        WebServiceCep webServiceCep = WebServiceCep.searchCep("29101-280");
                if (webServiceCep.wasSuccessful())
                        {
                            System.out.println("Rua: "+ webServiceCep.getLogradouro());
                            System.out.println("Bairro: "+ webServiceCep.getBairro());
                            System.out.println("Cidade: "+ webServiceCep.getCidade());
                            System.out.println("UF: "+ webServiceCep.getUf());
                        }
        
    }
}
