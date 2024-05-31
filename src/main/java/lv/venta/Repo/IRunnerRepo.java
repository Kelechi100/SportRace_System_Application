package lv.venta.Repo;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import lv.venta.model.Runner;
import lv.venta.model.Team;



public interface IRunnerRepo extends CrudRepository<Runner, Long> {

	ArrayList<Runner> findByname(String name);

	ArrayList<Runner> findByLessTimeInMinutes(int timeInminutes);

	Runner findByName(String name);



}
