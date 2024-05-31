package lv.venta.Repo;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import lv.venta.model.Race;



public interface IRaceRepo extends CrudRepository<Race, Long>{

	ArrayList<Race> findByMaxParticipants(int maxParticipants);

}
