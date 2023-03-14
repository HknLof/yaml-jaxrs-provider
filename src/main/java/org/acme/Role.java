package org.acme;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jboss.logging.Logger;

import java.util.List;

public class Role {
    private static final Logger LOGGER = Logger.getLogger(Role.class);
    private final String name;
    private final List<String> strings;

    private Role(String name, List<String> strings) {
        this.name = name;
        this.strings = strings;
    }

    @JsonCreator
    static Role from(@JsonProperty(value = "name", required = true) String name,
                     @JsonProperty(value = "strings", required = true) List<String> strings) {
        LOGGER.info(String.format("Serializing role with name := %s", name));
        return new Role(name, strings);
    }

    public String getName() {
        return name;
    }

    public List<String> getStrings() {
        return strings;
    }
}
