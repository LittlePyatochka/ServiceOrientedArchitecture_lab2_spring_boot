package kamysh.controller;

import kamysh.dto.ChapterDto;
import kamysh.dto.ResultListDto;
import kamysh.service.ChapterService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/chapter", produces = MediaType.APPLICATION_XML_VALUE)
public class ChapterController {

    private final ChapterService chapterService;

    @Autowired
    public ChapterController(ChapterService chapterService) {
        this.chapterService = chapterService;
    }

    @SneakyThrows
    @GetMapping
    public ResultListDto<ChapterDto> get() {
        ResultListDto<ChapterDto> resultListDto = new ResultListDto<>();
        resultListDto.setResults(chapterService.findAll());
        return resultListDto;
    }

    @GetMapping("/{id}")
    public ChapterDto getById(@PathVariable Long id) {
        return chapterService.findById(id);
    }

    @PostMapping
    public ChapterDto create(@RequestBody ChapterDto dto) {
        return chapterService.save(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        chapterService.delete(id);
    }
}
