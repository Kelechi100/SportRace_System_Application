package lv.venta.ServiceImpl;

import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.Repo.IRaceRepo;
import lv.venta.Repo.IResultRepo;
import lv.venta.Repo.IRunnerRepo;
import lv.venta.Repo.ITeamRepo;
import lv.venta.Service.ISportCRUDService;

import lv.venta.model.Race;
import lv.venta.model.Runner;
import lv.venta.model.Team;
@Service
public class SportServiceImpl  implements ISportCRUDService{

	@Autowired
	private IRunnerRepo runnerRepo;
	@Autowired
	private IResultRepo resultRepo;
	@Autowired
	private  IRaceRepo raceRepo;
	@Autowired
	private ITeamRepo teamRepo;

	@Override
	public void createNewRunner(String name, String surname) throws Exception {
		if(name == null ||surname == null )
			throw new Exception("Problems with input parameters");
		// TODO Auto-generated method stub
		
		Runner runnerFromDB = runnerRepo.findByName(surname);
		// team exists inDB
		if(runnerFromDB != null) {
			runnerFromDB.setSurname(runnerFromDB.getSurname()+ surname); // will change only in 
			teamRepo.save(runnerFromDB);
			
		}
		else {
			Runner R5 = new Runner(name, surname);
			runnerRepo.save(R5);
			
		}
	}
		
	@Override
	public ArrayList<Team> getAllTeamwithPointMorethan100(double points) throws Exception {
		if (points < 1) {
			throw new Exception("Id should be positive");
		}

		
		
	
		ArrayList<Team> result = teamRepo.findByPoint(points);
		if (result.isEmpty()) {
			throw new Exception("Team with points (" + points + ") is not in the system");
		}
		return result;

	}

		
	


	@Override
	public ArrayList<Race> getAllRaceswithMaxCount(int maxParticipants) throws Exception {
		if (maxParticipants < 1) {
			throw new Exception("Id should be positive");
		}

		
		
	
		ArrayList<Race> result = raceRepo.findByMaxParticipants(maxParticipants);
		if (result.isEmpty()) {
			throw new Exception("People with points (" + maxParticipants + ") is not in the system");
		}
		return result;
	}

	@Override
	public ArrayList<Runner> getAllRunnerInATeam(String name) throws Exception {
		if (name  == null) {
			throw new Exception("Id should be positive");
		}

		
		
	
		ArrayList<Runner> result = runnerRepo.findByname(name);
		if (result.isEmpty()) {
			throw new Exception("People with points (" +name+ ") is not in the system");
		}
		return result;	
	}

	@Override
	public ArrayList<Result> getRunnerwithLessResult( long  id  , int timeInMinutes) throws Exception {
		if (timeInMinutes > 1 || id > 0) {
			throw new Exception("Id should be positive");
		}

		
		
	
		ArrayList<Result> result = resultRepo.findByLessTimeInMinutesForrunnerIdru( id , timeInMinutes);
		if (result.isEmpty()) {
			throw new Exception("People with points ("  + timeInMinutes+ ") is not in the system");
		}
		return result;	
	}
	
}
