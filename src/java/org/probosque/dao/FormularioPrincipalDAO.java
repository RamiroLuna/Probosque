package org.probosque.dao;

import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.probosque.dto.CatalogoDTO;
import org.probosque.dto.FormularioPrincipalDTO;
import org.probosque.dto.PredioDTO;
import org.probosque.dto.ResultBoolean;
import org.probosque.dto.ResultString;

public class FormularioPrincipalDAO {

    public List<PredioDTO> getPredio(String clavePredio) throws SQLException {

        DataSource ds = PoolDataSource.getDataSourceGeneral();
        QueryRunner qr = new QueryRunner(ds);
        StringBuilder sql = new StringBuilder();

        String[] arregloANP = new String[24];
        String[] arregloCuenca = new String[24];

        String catalogoANP = "SELECT id, descripcion FROM catalogos.anp";
        ResultSetHandler rsh = new BeanListHandler(CatalogoDTO.class);
        List<CatalogoDTO> anp = (List<CatalogoDTO>) qr.query(catalogoANP, rsh);

        String catalogoCuenca = "SELECT id, descripcion FROM catalogos.cuenca";
        rsh = new BeanListHandler(CatalogoDTO.class);
        List<CatalogoDTO> cuenca = (List<CatalogoDTO>) qr.query(catalogoCuenca, rsh);

        sql.append("SELECT * FROM formularios.sp_getpredio(?)");
        Object[] params = {clavePredio};
        rsh = new BeanListHandler(PredioDTO.class);
        List<PredioDTO> result = (List<PredioDTO>) qr.query(sql.toString(), rsh, params);

        for (PredioDTO dto : result) {

            StringBuilder descripcionANP = new StringBuilder();
            if (dto.getAnp().trim().equals("") || dto.getAnp() == null) {
                dto.setAnp(" ");
            } else {
                arregloANP = dto.getAnp().split(",");
                for (int i = 0; i < arregloANP.length; i++) {
                    descripcionANP.append(anp.get(Integer.parseInt(arregloANP[i]) - 1).getDescripcion());
                    if (i < arregloANP.length - 1) {
                        descripcionANP.append(", ");
                    }
                }
                dto.setAnp_descripcion(descripcionANP.toString());
            }

            StringBuilder descripcionCuenca = new StringBuilder();
            if (dto.getCuenca().trim().equals("") || dto.getCuenca() == null) {
                dto.setCuenca("");
            } else {
                arregloCuenca = dto.getCuenca().split(",");
                for (int x = 0; x < arregloCuenca.length; x++) {
                    descripcionCuenca.append(cuenca.get(Integer.parseInt(arregloCuenca[x]) - 1).getDescripcion());
                    if (x < arregloCuenca.length - 1) {
                        descripcionCuenca.append(", ");
                    }
                }
                dto.setCuenca_descripcion(descripcionCuenca.toString());
            }

        }
        return result;
    }

    public String InsertFormularioPrincipal(FormularioPrincipalDTO principal)
            throws SQLException {
        DataSource ds = PoolDataSource.getDataSourceGeneral();
        QueryRunner qr = new QueryRunner(ds);
        StringBuilder sql = new StringBuilder();

        sql.append(" SELECT sp_insertprincipal AS result FROM formularios.SP_InsertPrincipal(").append(principal.getRegion()).append(",").
                append(principal.getMunicipio()).append(",").
                append(principal.getLocalidad()).append(",").
                append(Integer.parseInt(principal.getSedemex())).append(",").
                append(" '").append(principal.getNombrePredio()).append("' ,").
                append(principal.getTipoTenenciaTierra()).append(", ").
                append(" '").append(principal.getDescripcionComoLlegarPredio()).append("' ,").
                append(principal.getLatitud()).append(", ").
                append(principal.getLongitud()).append(", ").
                append(principal.getSuperficieTotal()).append(", ").
                append(principal.getSuperficieCartografica()).append(", ").
                append(principal.getSuperficieArbolada()).append(", ").
                append(principal.getSuperficieOtrosUsos()).append(", ").
                append(" '").append(principal.getCuencaEspecifica()).append("' ,").
                append(" '").append(principal.getAreaNaturalProtegida()).append("' ,").
                append(principal.getEstatusPredio()).append(", ").
                append(" '").append(principal.getObservacionesPredio()).append("' ,").
                append(" '").append(principal.getRegistroForestalNacional()).append("' ,").
                append(principal.getPermisoAprovechamientoForestal()).append(")");

        ResultSetHandler rsh = new BeanHandler(ResultString.class);
        ResultString cup = (ResultString) qr.query(sql.toString(), rsh);
        return cup.getResult();
    }

    public void updateFormularioPrincipal(FormularioPrincipalDTO principal)
            throws SQLException {
        DataSource ds = PoolDataSource.getDataSourceGeneral();
        QueryRunner qr = new QueryRunner(ds);
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT  formularios.sp_UpdatePrincipal(").
                append(" '").append(principal.getClaveUnicaIdentificacion()).append("',").
                append(Integer.parseInt(principal.getSedemex())).append(", ").
                append(" '").append(principal.getNombrePredio()).append("' ,").
                append(principal.getTipoTenenciaTierra()).append(", ").
                append(" '").append(principal.getDescripcionComoLlegarPredio()).append("' ,").
                append(Integer.parseInt(principal.getLatitud())).append(", ").
                append(Integer.parseInt(principal.getLongitud())).append(", ").
                append(Float.parseFloat(principal.getSuperficieTotal())).append(", ").
                append(Float.parseFloat(principal.getSuperficieCartografica())).append(", ").
                append(Float.parseFloat(principal.getSuperficieArbolada())).append(", ").
                append(Float.parseFloat(principal.getSuperficieOtrosUsos())).append(", ").
                append(" '").append(principal.getCuencaEspecifica()).append("',").
                append(" '").append(principal.getAreaNaturalProtegida()).append("',").
                append(Integer.parseInt(principal.getEstatusPredio())).append(", ").
                append(" '").append(principal.getObservacionesPredio()).append("',").
                append(" '").append(principal.getRegistroForestalNacional()).append("',").
                append(principal.getPermisoAprovechamientoForestal()).append(") ");
        ResultSetHandler rsh = new BeanHandler(ResultString.class);
        ResultString string = (ResultString) qr.query(sql.toString(), rsh);
    }

    public void deleteFormularioPrincipal(String folio)
            throws SQLException {
        DataSource ds = PoolDataSource.getDataSourceGeneral();
        QueryRunner qr = new QueryRunner(ds);
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT  formularios.SP_DeletePrincipal(?)");
        Object[] params = {folio};
        ResultSetHandler rsh = new BeanHandler(ResultBoolean.class);
        ResultBoolean exito = (ResultBoolean) qr.query(sql.toString(), rsh, params);
    }
}
