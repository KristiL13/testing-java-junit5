package guru.springframework.sfgpetclinic.fauxspring;

import java.util.HashMap;
import java.util.Map;

// teeme käsitsi mock-objekti meie Model implementatsiooni jaoks
public class ModelMapImpl implements Model {
    Map<String, Object> map = new HashMap<>();

    @Override
    public void addAttribute(String key, Object o) {
        map.put(key, o);
    }

    @Override
    public void addAttribute(Object o) {
        // do nothing... kuna me ei kasuta seda
    }

    public Map<String, Object> getMap() {
        return map;
    }
}
