package lv.venta.ServiceImpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.Repo.ITeamRepo;
import lv.venta.Service.IFilteringService;

import lv.venta.model.Team;

@Service
public class TeamCrudServiceImpl implements IFilteringService {
	@Autowired
	private ITeamRepo  teamRepo;

	@Override
	public void create(String name, double points) throws Exception {
		if(name == null ||points < 0 )
			throw new Exception("Problems with input parameters");
		// TODO Auto-generated method stub
		
		Team teamFromDB = teamRepo.findByName(name);
		// team exists inDB
		if(teamFromDB != null) {
			teamFromDB.setPoints(teamFromDB.getPoints()+ points); // will change only in 
			teamRepo.save(teamFromDB);
			
		}
		else {
			Team teamNew = new Team(name, points);
			teamRepo.save(teamNew);
			
		}
	}

	@Override
	public ArrayList<Team> retrieveAll() throws Exception {
		if(teamRepo.count() == 0) throw new Exception("team table is empty");
		ArrayList<Team> result = (ArrayList<Team>) teamRepo.findAll();
		// TODO Auto-generated method stub
		return result;
	
	}

	@Override
	public Team retrievById(long id) throws Exception {
		if(id <= 0) throw new Exception("Id should be positive");
		
		if(teamRepo.existsById(id)) return teamRepo.findById(id).get();
		// TODO Auto-generated method stub
		
		throw new Exception("Team with id ( " + id +  ") is not in the team table");
		

	

	}

	@Override
	public void updateById(long id, String name, double points) throws Exception {
		if(name == null|| points > 0 )
			throw new Exception("Problem with input paramaters");
		Team TeamForUpdating = retrievById(id);
		TeamForUpdating.setName(name);
		TeamForUpdating.setPoints(points);
	
		
		teamRepo.save(TeamForUpdating);
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(long id) throws Exception {
		Team TeamForDeleting = retrievById(id);
		teamRepo.delete(TeamForDeleting);
		// TODO Auto-generated method stub
		
	}
	
	
	

}
