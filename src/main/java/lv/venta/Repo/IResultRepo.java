package lv.venta.Repo;



import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import lv.venta.model.Result;

public interface IResultRepo extends CrudRepository<Result, Long> {

	ArrayList<javax.naming.spi.DirStateFactory.Result> findByLessTimeInMinutesForrunnerIdru(long id, int timeInMinutes);

}
