package s_gestion_usuarios.sop_corba;


/**
* s_gestion_usuarios/sop_corba/_AdmCllbckIntStub.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from gusuarios.idl
* martes 22 de febrero de 2022 09:50:34 AM COT
*/

public class _AdmCllbckIntStub extends org.omg.CORBA.portable.ObjectImpl implements s_gestion_usuarios.sop_corba.AdmCllbckInt
{

  public void notificar (String nombreCompleto, int id)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("notificar", true);
                $out.write_string (nombreCompleto);
                $out.write_long (id);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                notificar (nombreCompleto, id        );
            } finally {
                _releaseReply ($in);
            }
  } // notificar

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:sop_corba/AdmCllbckInt:1.0"};

  public String[] _ids ()
  {
    return (String[])__ids.clone ();
  }

  private void readObject (java.io.ObjectInputStream s) throws java.io.IOException
  {
     String str = s.readUTF ();
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     org.omg.CORBA.Object obj = orb.string_to_object (str);
     org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl) obj)._get_delegate ();
     _set_delegate (delegate);
   } finally {
     orb.destroy() ;
   }
  }

  private void writeObject (java.io.ObjectOutputStream s) throws java.io.IOException
  {
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     String str = orb.object_to_string (this);
     s.writeUTF (str);
   } finally {
     orb.destroy() ;
   }
  }
} // class _AdmCllbckIntStub
