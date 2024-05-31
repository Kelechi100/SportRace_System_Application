package lv.venta.Repo;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import lv.venta.model.Runner;
import lv.venta.model.Team;


public interface ITeamRepo  extends CrudRepository<Team, Long>{



	Team findByName(String name);



	ArrayList<Team> findByPoint(double points);



	ArrayList<Team> findByMaxParticipants(int maxParticipants);



	void save(Runner runnerFromDB);

}
