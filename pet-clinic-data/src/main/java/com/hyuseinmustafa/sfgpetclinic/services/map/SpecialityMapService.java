package com.hyuseinmustafa.sfgpetclinic.services.map;

import com.hyuseinmustafa.sfgpetclinic.model.Spetiality;
import com.hyuseinmustafa.sfgpetclinic.services.SpecialitiesService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class SpecialityMapService extends AbstractMapService<Spetiality, Long> implements SpecialitiesService {
    @Override
    public Set<Spetiality> findAll() {
        return super.findAll();
    }

    @Override
    public Spetiality findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Spetiality save(Spetiality object) {
        return super.save(object);
    }

    @Override
    public void delete(Spetiality object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
