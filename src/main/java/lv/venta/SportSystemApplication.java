package lv.venta;



import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lv.venta.Repo.IRaceRepo;
import lv.venta.Repo.IResultRepo;
import lv.venta.Repo.IRunnerRepo;
import lv.venta.Repo.ITeamRepo;
import lv.venta.model.Race;
import lv.venta.model.Result;
import lv.venta.model.Runner;
import lv.venta.model.Team;

@SpringBootApplication
public class SportSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(SportSystemApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner testDatabase(ITeamRepo teamRepo, IRunnerRepo runnerRepo, IRaceRepo raceRepo,IResultRepo resultRepo) {
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
				Team tm1 = new Team("Super Runners", 100.45);
				Team tm2 = new Team("Furious Runners", 60.45);
				teamRepo.save(tm1);
				teamRepo.save(tm2);
				
				
				Race Ra1 = new Race("Riga Marathong", 400);
				Race Ra2 = new Race("Ventspils Marathon", 200);
				
				raceRepo.save(Ra1);
				raceRepo.save(Ra2);
				
				Runner Ru1 = new Runner("Jhon", "Smith");
				Runner Ru2 = new Runner("Paul", "Micheal");
				Runner Ru3 = new Runner("Mike", "Moses");
				
				runnerRepo.save(Ru1);
				runnerRepo.save(Ru2);
				runnerRepo.save(Ru3);
				
				
				Result R1 = new Result(170);
				Result R2 = new Result(180);
				Result R3 = new Result(200);
				Result R4 = new Result(300);
				
				resultRepo.save(R1);
				resultRepo.save(R2);
				resultRepo.save(R3);
				resultRepo.save(R4);
				
				
			}
		};
	}
		
	
	

}
