package es.miw.persistence.models.daos.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import es.miw.persistence.models.daos.TemaDao;
import es.miw.persistence.models.entities.Tema;
import es.miw.persistence.models.entities.Voto;
import es.miw.persistence.models.utils.NivelEstudios;
 
public class TemaDaoJdbc extends GenericDaoJdbc<Tema, Integer> implements TemaDao {
	private Logger log = LogManager.getLogger(TemaDaoJdbc.class);
	private Tema create(ResultSet resultSet){
		Tema temaCreado = null;
		try{
			if(resultSet != null && resultSet.next()){
				temaCreado = new Tema(resultSet.getString(Tema.NOMBRE_TEMA),
						resultSet.getString(Tema.PREGUNTA));
			}
		}catch (SQLException e){
			log.error("read: " + e.getMessage());
		}
		return temaCreado;
	}

	private static final String SQL_INSERT = "INSERT INTO %s (%s,%s,%s) VALUES (%d,'%s','%s')";
	@Override
	public void create(Tema tema) {
		this.updateSql(String.format(SQL_INSERT, Tema.TABLE, Tema.ID, Tema.NOMBRE_TEMA,
                Tema.PREGUNTA, tema.getId(), tema.getNombre_tema(), tema.getPregunta()));
		
	}

	@Override
	public Tema read(Integer id) {
		ResultSet resultSet = this.query(String.format(SQL_SELECT_ID, Tema.TABLE, id));
        return this.create(resultSet);
	}
	
	private static final String SQL_UPDATE = "UPDATE %s SET %s='%s', %s='%s' WHERE ID=%d";

	@Override
	public void update(Tema tema) {
		this.updateSql(String.format(SQL_UPDATE, Tema.TABLE, Tema.NOMBRE_TEMA, tema.getNombre_tema(),
                Tema.PREGUNTA, tema.getPregunta(), tema.getId()));
		
	}

	@Override
	public void deleteById(Integer id) {
		this.updateSql(String.format(SQL_DELETE_ID, Tema.TABLE, id));
		
	}

	@Override
	public List<Tema> findAll() {
		List<Tema> list = new ArrayList<Tema>();
        ResultSet resultSet = this.query(String.format(SQL_SELECT_ALL, Tema.TABLE));
        Tema tema = this.create(resultSet);
        while (tema != null) {
            list.add(tema);
            tema = this.create(resultSet);
        }
        return list;
	}

	@Override
	public boolean existeTema(String nombre_tema) {
		List<Tema> list = this.findAll();
		for (Tema tema : list) {
			if(tema.getNombre_tema().equals(nombre_tema))
				return true;
		}
		return false;
	}

	@Override
	public HashMap<NivelEstudios, Double> mediasPorNivelEstudios(Integer id_tema) {
		Tema tema = this.read(id_tema);
		HashMap<NivelEstudios, Double> medias = new HashMap<NivelEstudios, Double>();
		/*for (Voto voto : tema.getVotos()) {
			int numVotosNivel = this.votosNivel(tema.getVotos(), voto.getNivel_estudios());
			
			if(voto.getNivel_estudios() == nivelEstudio){
				media += voto.getValoracion();
			}
		}*/
		return medias;
	}

}
