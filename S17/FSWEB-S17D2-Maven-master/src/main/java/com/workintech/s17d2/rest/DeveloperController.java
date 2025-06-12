package com.workintech.s17d2.rest;

import com.workintech.s17d2.dto.DeveloperResponse;
import com.workintech.s17d2.model.*;
import com.workintech.s17d2.tax.Taxable;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/developers")
public class DeveloperController {
    public Map<Integer, Developer> developers;

    private final Taxable taxable;

    // constructor-based dependency injection
    @Autowired
    public DeveloperController(@Qualifier("developerTax") Taxable taxable) {
        this.taxable = taxable;
    }

    @PostConstruct
    public void init() {
        developers = new HashMap<>();
        this.developers.put(1, new JuniorDeveloper(1,"Pelin Ozsezer",33000d));
    }

    @GetMapping
    public List<Developer> getAll() {
        return developers.values().stream().toList();
    }

    @GetMapping("/{id}")
    public DeveloperResponse getById(@PathVariable("id") Integer id) {
        Developer foundDeveloper = this.developers.get(id);
        if (foundDeveloper == null) {
            return new DeveloperResponse(
                    null,
                    HttpStatus.NOT_FOUND.value(),
                    id + " ile search yapıldığında kayıt bulunamadı"
            );
        }

        return new DeveloperResponse(
                foundDeveloper,
                HttpStatus.OK.value(),
                "id ile search başarılı"
        );

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DeveloperResponse save(@RequestBody Developer developer) {
        Developer createdDeveloper = DeveloperFactory.createDeveloper(developer, taxable);

        if (Objects.nonNull(createdDeveloper)) {
            developers.put(createdDeveloper.getId(), createdDeveloper);
        }

        return new DeveloperResponse(createdDeveloper, HttpStatus.CREATED.value(),"created");
    }


    @PutMapping("/{id}")
    public DeveloperResponse update(@PathVariable("id") int id,
                                    @RequestBody Developer developer) {
        developer.setId(id);

        Developer newDeveloper = DeveloperFactory.createDeveloper(developer, taxable);
        this.developers.put(id, newDeveloper);

        return new DeveloperResponse(
                newDeveloper,
                HttpStatus.OK.value(),
                "update başarılı"
        );
    }


    @DeleteMapping("/{id}")
    public DeveloperResponse delete(@PathVariable("id") int id) {
        Developer removedDeveloper = this.developers.get(id);
        this.developers.remove(id);

        return new DeveloperResponse(
                removedDeveloper,
                HttpStatus.NO_CONTENT.value(),
                "silme başarılı"
        );
    }




}
