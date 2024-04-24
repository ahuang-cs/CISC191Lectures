package edu.sdccd.cisc191.springjpajavafxdemo.repositories;

import edu.sdccd.cisc191.springjpajavafxdemo.model.Option;
import org.springframework.data.repository.CrudRepository;

public interface OptionRepository extends CrudRepository<Option, String> {
}
