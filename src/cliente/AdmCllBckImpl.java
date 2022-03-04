package cliente;
import s_gestion_usuarios.sop_corba.*;

public class AdmCllBckImpl extends AdmCllbckIntPOA{

    @Override
    public void notificar(String nombreCompleto, int id) {
        System.out.println("\n *** El usuario: "+nombreCompleto+" Identificado con ID: "+ id+" ingresó a la aplicación. *** \n");
        
    }
    
}
