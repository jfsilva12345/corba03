package s_gestion_usuarios.sop_corba;


/**
* s_gestion_usuarios/sop_corba/GestionPersonalIntPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from gusuarios.idl
* martes 22 de febrero de 2022 09:50:34 AM COT
*/

public abstract class GestionPersonalIntPOA extends org.omg.PortableServer.Servant
 implements s_gestion_usuarios.sop_corba.GestionPersonalIntOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("registrarPersonal", new java.lang.Integer (0));
    _methods.put ("consultarPersonal", new java.lang.Integer (1));
    _methods.put ("abrirSesion", new java.lang.Integer (2));
    _methods.put ("registrarCallback", new java.lang.Integer (3));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // sop_corba/GestionPersonalInt/registrarPersonal
       {
         s_gestion_usuarios.sop_corba.personalDTO objPersonal = s_gestion_usuarios.sop_corba.personalDTOHelper.read (in);
         this.registrarPersonal (objPersonal);
         out = $rh.createReply();
         break;
       }

       case 1:  // sop_corba/GestionPersonalInt/consultarPersonal
       {
         int id = in.read_long ();
         s_gestion_usuarios.sop_corba.personalDTOHolder objPersonal = new s_gestion_usuarios.sop_corba.personalDTOHolder ();
         boolean $result = false;
         $result = this.consultarPersonal (id, objPersonal);
         out = $rh.createReply();
         out.write_boolean ($result);
         s_gestion_usuarios.sop_corba.personalDTOHelper.write (out, objPersonal.value);
         break;
       }

       case 2:  // sop_corba/GestionPersonalInt/abrirSesion
       {
         s_gestion_usuarios.sop_corba.credencialDTO objCredencial = s_gestion_usuarios.sop_corba.credencialDTOHelper.read (in);
         int $result = (int)0;
         $result = this.abrirSesion (objCredencial);
         out = $rh.createReply();
         out.write_long ($result);
         break;
       }

       case 3:  // sop_corba/GestionPersonalInt/registrarCallback
       {
         s_gestion_usuarios.sop_corba.AdmCllbckInt objCllbck = s_gestion_usuarios.sop_corba.AdmCllbckIntHelper.read (in);
         this.registrarCallback (objCllbck);
         out = $rh.createReply();
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:sop_corba/GestionPersonalInt:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public GestionPersonalInt _this() 
  {
    return GestionPersonalIntHelper.narrow(
    super._this_object());
  }

  public GestionPersonalInt _this(org.omg.CORBA.ORB orb) 
  {
    return GestionPersonalIntHelper.narrow(
    super._this_object(orb));
  }


} // class GestionPersonalIntPOA
