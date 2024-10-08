package iz.controller;

import iz.dto.RAMCompatibleDTO;
import iz.model.RAM;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import iz.service.RAMService;

@CrossOrigin
@RestController
@RequestMapping("/api/RAM")
public class RAMController {

    @Autowired
    private RAMService ramService;
    
    @GetMapping(value = "{title}", produces = MediaType.APPLICATION_JSON_VALUE)
    public RAM getOne(@PathVariable("title") String title){
        return ramService.getOne(title);
    }
    
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<RAM> getAll(){
        return ramService.getAll();
    }
    
    @PostMapping(value="compatible",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<RAM> getCompatibleRAM(@RequestBody RAMCompatibleDTO dto){
        return ramService.getCompatibleRAM(dto.getMoboTitle());
    }
}
