package kamysh.repository;

import kamysh.controller.FilterConfiguration;
import kamysh.entity.SpaceMarine;

import java.util.List;

public interface SpaceMarineRepositoryCustom {
    List<SpaceMarine> findAllByFilterConfiguration(FilterConfiguration filterConfiguration);
}
