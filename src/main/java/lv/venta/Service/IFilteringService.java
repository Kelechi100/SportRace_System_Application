package lv.venta.Service;

import java.util.ArrayList;

import lv.venta.model.Team;



public interface IFilteringService {
	//insert
	public abstract void create(String name,double points) throws Exception;
	
	// retrieve all
	public abstract ArrayList<Team> retrieveAll() throws Exception;
	
	// retrieve all
	public abstract Team retrievById( long id ) throws Exception;
	// update
	public abstract void updateById(long  id,String name,double points) throws Exception;
	
	// delete
	public abstract void deleteById(long id) throws Exception;


}
