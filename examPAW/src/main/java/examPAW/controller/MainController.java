package examPAW.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import examPAW.entity.ItemEntity;
import examPAW.service.ItemsService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainController {
    @Autowired
    private final ItemsService itemsService;

    public MainController(ItemsService itemsService) {
        this.itemsService = itemsService;
    }

    @GetMapping("/hello2")
    public String hello2() {
        return "Hello World";
    }

    //
    /**
     * o sa folosim /lista pentru afișarea datelor din tabela SQL
     */
    @GetMapping("/lista")
    public ResponseEntity<List<ItemEntity>> afisareDate() {
        List<ItemEntity> itemEntities = itemsService.getAllItems();
        return ResponseEntity.ok(itemEntities);
    }

    /**
     * o sa folosim /update pentru inserarea datelor preluate din API-ul extern
     */
    @PostMapping("/update")
    public ResponseEntity<ItemEntity> inserareDate(@RequestBody ItemEntity itemEntity) {
        ItemEntity savedItem = itemsService.saveItem(itemEntity);
        return ResponseEntity.ok(savedItem);
    }

    /**
     * o sa folosim /item/{id} pentru furnizarea datelor corespunzătoare unei înregistrări din BD
     */
    @PostMapping("/item/{id}")
    public String furnizareDate() {
        return "Hello World";
    }
}
