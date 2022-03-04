package s_gestion_usuarios.servidor;
import java.util.ArrayList;

import s_gestion_usuarios.sop_corba.*;

public class GestionPersonalImpl extends GestionPersonalIntPOA{

    private ArrayList<personalDTO> personal;
    private AdmCllbckInt objCllBck;


  
	public GestionPersonalImpl(){
		this.personal = new ArrayList<>();
		String tipoId = "CC";
        int id = 6536;
        String nombrecompleto = "Josefino Eusebio De las Nieves";
        String ocupacion = "Admin";
        String usuario = "admin12345";
        String clave = "12345678";
        personalDTO admin = new personalDTO(tipoId, id, nombrecompleto, ocupacion, usuario, clave);
        personal.add(admin);
	}

    
    @Override
    public void registrarPersonal(personalDTO objPersonal) {
        System.out.println("Entrando a registrar usuario");
		if(personal.size() < 3)
		{            
			personal.add(objPersonal);
			System.out.println("Usuario registrado: \n \t identificación: " + objPersonal.id + ",\n \t  nombres: " + objPersonal.nombreCompleto);
		}
        
    }

    @Override
    public boolean consultarPersonal(int id, personalDTOHolder objPersonal) {
        System.out.println("Entrando a consultar usuario");
		boolean respuesta = false;
		int contador = 0;
		personalDTO vacio = new personalDTO();
		while(contador<personal.size()){
			if(personal.get(contador).id==id){
				vacio=personal.get(contador);
				respuesta = true;
				break;
			}
			contador++;
		}

		objPersonal.value=vacio;
		return respuesta;
    }

    @Override
    public int abrirSesion(credencialDTO objCredencial) {
        personalDTO tmpNotificacion = ocupacionBuscadaCredenciales(objCredencial);
		String ocupacion = tmpNotificacion.ocupacion;
		switch(ocupacion){
			case "Admin":
				return 0;
			case "Personal de acondicionamiento fisico":
                objCllBck.notificar(tmpNotificacion.nombreCompleto, tmpNotificacion.id);
                System.out.println("ALGO");
				return 1;
			case "Secretaria":
                //objCllBck.notificar(tmpNotificacion.nombreCompleto, tmpNotificacion.id);
				return 2;
		}
		return -1;
    }

    public personalDTO ocupacionBuscadaCredenciales(credencialDTO objCredencial){
        if(!usuarioExiste(objCredencial)){
            return null;
        }
        String tmpUsuario=objCredencial.usuario;
        for (personalDTO personalDTO : personal) {
            if(personalDTO.usuario.equals(tmpUsuario)){
                personalDTO varPersonal=new personalDTO(personalDTO.tipo_id, personalDTO.id, personalDTO.nombreCompleto, personalDTO.ocupacion, personalDTO.usuario, personalDTO.clave);
                return varPersonal;
            }
        }
        return null;
    }

    public boolean usuarioExiste(credencialDTO objCredencial){
        String tmpUsuario=objCredencial.usuario;
        for (personalDTO personalDTO : personal) {
            if(personalDTO.usuario.equals(tmpUsuario)){
                return true;
            }
        }
        return false;
    }

    @Override
    public void registrarCallback(AdmCllbckInt objCllbck) {
        objCllBck=objCllbck;

        
    }
    
}
