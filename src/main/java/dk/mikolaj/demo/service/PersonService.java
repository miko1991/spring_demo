package dk.mikolaj.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import dk.mikolaj.demo.dao.PersonDao;
import dk.mikolaj.demo.model.Person;

@Service
public class PersonService {
    private final PersonDao personDao;

    public int addPerson(Person person) {
        return personDao.insertPerson(person);
    }

    @Autowired
	public PersonService(@Qualifier("fakeDao") PersonDao personDao) {
		this.personDao = personDao;
    }
    
    public List<Person> getAllPeople() {
        return personDao.selectAllPeople();
    }

    public Optional<Person> getPersonById(UUID id) {
        return personDao.selectPersonById(id);
    }
}
