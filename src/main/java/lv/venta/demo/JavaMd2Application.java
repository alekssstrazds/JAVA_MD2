package lv.venta.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lv.venta.demo.model.Child;
import lv.venta.demo.model.ChildRating;
import lv.venta.demo.model.ChildrenGroup;
import lv.venta.demo.model.Teacher;
import lv.venta.demo.repo.IChildRatingRepo;
import lv.venta.demo.repo.IChildRepo;
import lv.venta.demo.repo.IChildrenGroupRepo;
import lv.venta.demo.repo.ITeacherRepo;

@SpringBootApplication
public class JavaMd2Application {

	public static void main(String[] args) {
		SpringApplication.run(JavaMd2Application.class, args);
	}
		@Bean //visur, kur šī annotācija, tiks izsukts automātiski
	public CommandLineRunner testdb(IChildRatingRepo ratingRepo, IChildRepo childRepo, IChildrenGroupRepo groupRepo, ITeacherRepo teacherRepo) {
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {	
				Teacher te1 = new Teacher("Karina", "Skirmante");
				Teacher te2 = new Teacher("Janis", "Berzins");
				teacherRepo.save(te1);
				teacherRepo.save(te2);
				ChildrenGroup chGr1 = new ChildrenGroup("Bitites", 2020);
				ChildrenGroup chGr2 = new ChildrenGroup("Marites", 2021);
		        groupRepo.save(chGr1);
				groupRepo.save(chGr2);
				Child ch1 = new Child("ola", "Kevins", "Labdaris");
				Child ch2 = new Child("", "Baiba", "Jauka");
				childRepo.save(ch1);
				childRepo.save(ch2);
				ChildRating chRat1 = new ChildRating("prot dejot", 1);
				ChildRating chRat2 = new ChildRating("prot dejot", 1);
				ratingRepo.save(chRat1);
				ratingRepo.save(chRat2);
			}
		};
	}

}
