package lv.venta.Service;

import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;

import lv.venta.model.Race;
import lv.venta.model.Runner;
import lv.venta.model.Team;

public interface ISportCRUDService {
	public abstract  ArrayList<Team> getAllTeamwithPointMorethan100(double points)throws Exception;
	
	public  abstract ArrayList<Race>getAllRaceswithMaxCount(int maxParticipants) throws Exception;

	public  abstract  ArrayList<Runner> getAllRunnerInATeam(String name) throws Exception;
	
	public abstract  ArrayList<Result>  getRunnerwithLessResult( long id, int timeInminutes) throws Exception;
	
	public  abstract void   createNewRunner(String name, String surname) throws Exception;
}
