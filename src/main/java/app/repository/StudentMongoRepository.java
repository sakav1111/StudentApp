package app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import app.model.Student;
import app.model.StudentMongo;

@Repository
public interface StudentMongoRepository extends MongoRepository<StudentMongo, Integer> {

	StudentMongo findBySno(int sno);
	void deleteByName(String name);
	
}
