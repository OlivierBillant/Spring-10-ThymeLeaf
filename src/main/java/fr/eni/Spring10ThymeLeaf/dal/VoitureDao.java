package fr.eni.Spring10ThymeLeaf.dal;

import org.springframework.data.repository.CrudRepository;

import fr.eni.Spring10ThymeLeaf.bo.Voiture;

public interface VoitureDao extends CrudRepository<Voiture, Integer>{

}
