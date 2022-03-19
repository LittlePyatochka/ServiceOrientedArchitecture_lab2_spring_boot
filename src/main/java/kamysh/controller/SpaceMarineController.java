package kamysh.controller;

import kamysh.dto.HealthCountDto;
import kamysh.dto.ResultListDto;
import kamysh.dto.SpaceMarineDto;
import kamysh.dto.SpaceMarineWithIdDto;
import kamysh.service.SpaceMarineService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringArrayPropertyEditor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Collections;

@RestController
@RequestMapping(
        path = "/api/space-marine",
        produces = MediaType.APPLICATION_XML_VALUE)
public class SpaceMarineController {

    private final SpaceMarineService spaceMarineService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(
                String[].class,
                new StringArrayPropertyEditor(null));
    }


    @Autowired
    public SpaceMarineController(SpaceMarineService spaceMarineService) {
        this.spaceMarineService = spaceMarineService;
    }

    @SneakyThrows
    @GetMapping
    public ResultListDto<SpaceMarineDto> get(@RequestParam(required = false) Integer count,
                                             @RequestParam(required = false) Integer page,
                                             @RequestParam(required = false) String[] order,
                                             @RequestParam(required = false) String[] filter) {
        ResultListDto<SpaceMarineDto> resultListDto = new ResultListDto<>();
        System.err.println("ORDER = " + Arrays.toString(order));
        resultListDto.setResults(spaceMarineService.findAll(
                FilterConfiguration
                        .builder()
                        .count(count)
                        .page(page)
                        .order(order == null ? Collections.emptyList() : Arrays.asList(order))
                        .filter(filter == null ? Collections.emptyList() : Arrays.asList(filter))
                        .build()));
        return resultListDto;
    }

    @GetMapping("/heartCount/min")
    public SpaceMarineDto getByMinHeartCount() {
        return spaceMarineService.getByMinHealthCount();
    }

    @GetMapping("/health/count")
    public HealthCountDto getHealthCountLessThen(@RequestParam Integer value) {
        return spaceMarineService.getHealthCountLessThen(value);
    }

    @GetMapping("/{id}")
    public SpaceMarineDto getById(@PathVariable Long id) {
        return spaceMarineService.findById(id);
    }

    @PostMapping
    public SpaceMarineDto create(@RequestBody SpaceMarineWithIdDto dto) {
        dto.setId(null);
        return spaceMarineService.saveOrUpdate(dto);
    }

    @PutMapping("/{id}")
    public SpaceMarineDto update(@PathVariable Long id, @RequestBody SpaceMarineWithIdDto dto) {
        System.out.println("id = " + id);
        dto.setId(id);
        return spaceMarineService.saveOrUpdate(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        spaceMarineService.delete(id);
    }

    @DeleteMapping("/loyal")
    public void deleteFirstByLoyal(@RequestParam Boolean value) {
        spaceMarineService.deleteFirstByLoyal(value);
    }
}
