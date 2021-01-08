package ru.job4j.accident.repository;

import org.springframework.stereotype.Component;
import ru.job4j.accident.model.Accident;

import java.util.*;

@Component
public class AccidentMem {
    private final HashMap<Integer, Accident> accidents;

    public AccidentMem() {
        this.accidents = new HashMap<>();
        for (int i = 0; i < 6; i++) {
            this.accidents.put(i, new Accident(i, "accident" + i, "text" + i, "address" + i));
        }
    }

    public Map<Integer, Accident> getAll() {
        return this.accidents;
    }

    public void add(Accident accident) {
        int newId = maxId() + 1;
        accident.setId(newId);
        this.accidents.put(newId, accident);
    }

    private Integer maxId() {
        return (new ArrayList<>(this.accidents.keySet())).stream()
                .max(Integer::compare)
                .orElse(0);
    }
}
