package s_gestion_usuarios.sop_corba;

/**
* s_gestion_usuarios/sop_corba/AdmCllbckIntHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from gusuarios.idl
* martes 22 de febrero de 2022 09:50:34 AM COT
*/

public final class AdmCllbckIntHolder implements org.omg.CORBA.portable.Streamable
{
  public s_gestion_usuarios.sop_corba.AdmCllbckInt value = null;

  public AdmCllbckIntHolder ()
  {
  }

  public AdmCllbckIntHolder (s_gestion_usuarios.sop_corba.AdmCllbckInt initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = s_gestion_usuarios.sop_corba.AdmCllbckIntHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    s_gestion_usuarios.sop_corba.AdmCllbckIntHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return s_gestion_usuarios.sop_corba.AdmCllbckIntHelper.type ();
  }

}