package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.repositories.VetRepository;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class VetSDJpaService implements VetService {

    private final VetRepository vetReposiroty;

    public VetSDJpaService(VetRepository vetReposiroty) {
        this.vetReposiroty = vetReposiroty;
    }


    @Override
    public Set<Vet> findAll() {
        Set<Vet> vets = new HashSet<>();
        vetReposiroty.findAll().forEach(vets::add);
        return vets;
    }

    @Override
    public Vet findById(Long aLong) {
        return vetReposiroty.findById(aLong).orElse(null);
    }

    @Override
    public Vet save(Vet object) {
        return vetReposiroty.save(object);
    }

    @Override
    public void delete(Vet object) {
        vetReposiroty.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        vetReposiroty.deleteById(aLong);
    }
}
