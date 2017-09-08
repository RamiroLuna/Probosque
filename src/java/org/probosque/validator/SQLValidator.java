package org.probosque.validator;

public class SQLValidator {

public static  String  getMessageError(String sqlState, String messageException)
   {
    StringBuilder  message = new StringBuilder();
       switch(sqlState)
       {
           case "23505":
                     message.append(getMessageErrorCode23505(messageException));
                  break;
           case "22003":
                     message.append(getMessageErrorCode22003(messageException));
                  break;       
           default :  message.append(" OCURRIO UN ERROR AL PROCESAR LA INFORMACIÓN, CONTACTE A SU ADMINISTRADOR DE SISTEMA \n ").
                      append(" HAGA UNA CAPTURA DE SU PANTALLA Y HAGASELA LLEGAR \n").
                      append(" Detalle de error ").
                      append( messageException);
       
       }
     return message.toString();
   }


public static String getMessageErrorCode23505(String message)
    {
        StringBuilder messageError= new StringBuilder();
        if(message.contains("(predio)"))
          {
          messageError.append(" EL NOMBRE DE PREDIO YA EXISTE, NO PUEDE TENER DOS PREDIOS CON EL MISMO NOMBRE DE PREDIO  \n   ").
                  append(" AÚN CUANDO LAS CLAVES DE PREDIO SEAN DIFERENTES ");
          }
        else 
        {
        messageError.append(" YA EXISTEN DATOS CON LOS MISMOS VALORES, INTENTE CON DATOS DIFERENTES ");
        }
        return messageError.toString();
    }

public static  String getMessageErrorCode22003(String message)
    {
        StringBuilder messageError= new StringBuilder();
        if(message.contains("desbordamiento"))
          {
          messageError.append(" Los datos de tipo superficie estan acotados a   \n   ").
                  append(" 9 enteros y 3 decimales, verifique los datos que ha capturado  ");
          }
        else 
        {
        messageError.append(" La longitud de los datos es demasiado grande para el valor \n ").
                append(" con el que han sido configurados ").
                append(" verifique con su administrador de sistema el valor maximo para cada dato ");
        }
        return messageError.toString();
    }






    
}
